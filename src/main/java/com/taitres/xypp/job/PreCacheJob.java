package com.taitres.xypp.job;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import com.taitres.xypp.model.domain.User;
import com.taitres.xypp.service.UserService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;


import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static com.taitres.xypp.constant.SystermConstant.SYSTEM_ID;

/**
 * 缓存预热任务
 *
 */
@Component
@Slf4j
public class PreCacheJob {

    @Resource
    private UserService userService;

    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    @Resource
    private RedissonClient redissonClient;


    // 重点用户
    private final List<Long> mainUserList = List.of(1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L, 10L);

    // 每天执行，预热推荐用户
    @Scheduled(cron = "30 5 16 * * *")
    public void doCacheRecommendUser() {
        RLock lock = redissonClient.getLock(String.format("%s:precachejob:docache:lock",SYSTEM_ID));
        try {
            //看门狗机制-1 续期
            if(lock.tryLock(0, -1, TimeUnit.MILLISECONDS)){
                System.out.println("getLock: " + Thread.currentThread().getId());
                for (Long userId : mainUserList) {
                    QueryWrapper<User> queryWrapper = new QueryWrapper<>();
                    Page<User> userPage = userService.page(new Page<>(1, 20), queryWrapper);
                    String redisKey = String.format("%s:user:recommend:%s", SYSTEM_ID,userId);
                    ValueOperations<String, Object> valueOperations = redisTemplate.opsForValue();
                    // 写缓存
                    try {
                        valueOperations.set(redisKey, userPage, 30000, TimeUnit.MILLISECONDS);
                    } catch (Exception e) {
                        log.error("redis set key error", e);
                    }
                }
            }
        } catch (InterruptedException e) {
            log.error("doCacheRecommendUser error", e);
        }finally {
            // 释放锁
            if(lock.isHeldByCurrentThread()){
                System.out.println("unLock: " + Thread.currentThread().getId());
                lock.unlock();
            }
        }

    }


}
