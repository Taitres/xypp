package com.taitres.xypp.service;

import com.taitres.xypp.model.domain.User;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

@SpringBootTest
public class RedisTest {

    @Resource
    private RedisTemplate redisTemplate;

    @Test
    void test() {
        ValueOperations valueOperations = redisTemplate.opsForValue();
        // 增
        valueOperations.set("String", "s");
        valueOperations.set("Int", 1);
        valueOperations.set("Double", 2.0);
        User user = new User();
        user.setId(1L);
        user.setUserName("name");
        valueOperations.set("User", user);
        // 查
        Object obj = valueOperations.get("String");
        Assertions.assertTrue("s".equals((String) obj));
        obj = valueOperations.get("Int");
        Assertions.assertTrue(1 == (Integer) obj);
        obj = valueOperations.get("Double");
        Assertions.assertTrue(2.0 == (Double) obj);
        System.out.println(valueOperations.get("User"));
        valueOperations.set("String1", "s1");
        redisTemplate.delete("String1");
    }
}