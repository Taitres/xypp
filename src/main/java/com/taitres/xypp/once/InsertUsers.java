package com.taitres.xypp.once;



import com.taitres.xypp.model.domain.User;
import com.taitres.xypp.service.UserService;
import jakarta.annotation.Resource;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;


/**
 * 导入用户任务
 *
 */
@Component
public class InsertUsers {

    @Resource
    private UserService userService;

    /**
     * 批量插入用户
     */
//    @Scheduled(initialDelay = 5000, fixedRate = Long.MAX_VALUE)
//    public void insertUsers() {
//        StopWatch stopWatch = new StopWatch();
//        stopWatch.start();
//        final int INSERT_NUM = 100000;
//        List<User> userList = new ArrayList<>();
//        int batchSize = 10000;
//        for (int i = 0; i < INSERT_NUM; i++) {
//            User user = new User();
//            user.setUserName("faker" + i);
//            user.setUserAccount("" + i);
//            user.setAvatarUrl("https://123213.com/123.png");
//            user.setGender(0);
//            user.setUserPassword("dc8701a0f05e92481c536d911c5c6fa9");
//            user.setPhone("123");
//            user.setEmail("123@qq.com");
//            user.setTags("[]");
//            user.setUserStatus(0);
//            user.setUserRole(0);
//            user.setStudentId("11111111");
//            userList.add(user);
//        }
//        userService.saveBatch(userList, batchSize);
//        stopWatch.stop();
//        System.out.println(stopWatch.getTotalTimeMillis());
//    }

    /**
     * 并发批量插入用户
     */
    private ExecutorService executorService = new ThreadPoolExecutor(50, 1000, 10000, TimeUnit.MINUTES, new ArrayBlockingQueue<>(10000));
    //@Scheduled(initialDelay = 2000, fixedRate = Long.MAX_VALUE)
    public void doConcurrencyInsertUsers() {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        int batchSize = 1000;
        int j = 0;
        List<CompletableFuture<Void>> futureList = new ArrayList<>();
        // 分多组
        for (int i = 0; i < 100; i++) {
            List<User> userList = new ArrayList<>();
            while (true) {
                j++;
                User user = new User();
                user.setUserName("faker" + j);
                user.setUserAccount("" + j);
                user.setAvatarUrl("https://123213.com/123.png");
                user.setGender(0);
                user.setUserPassword("dc8701a0f05e92481c536d911c5c6fa9");
                user.setPhone("123");
                user.setEmail("123@qq.com");
                user.setTags("[]");
                user.setUserStatus(0);
                user.setUserRole(0);
                user.setStudentId("11111111");
                userList.add(user);
                userList.add(user);
                if (j % batchSize == 0) {
                    break;
                }
            }
            // 异步执行
            CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
                System.out.println("threadName: " + Thread.currentThread().getName());
                userService.saveBatch(userList, batchSize);
            }, executorService);
            futureList.add(future);
        }
        CompletableFuture.allOf(futureList.toArray(new CompletableFuture[]{})).join();
        stopWatch.stop();
        System.out.println(stopWatch.getTotalTimeMillis());

    }

}