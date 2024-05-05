package com.taitres.xypp.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.taitres.xypp.model.domain.User;
import jakarta.servlet.http.HttpServletRequest;

import java.util.List;

/**
* @author Marlin
* @description 针对表【user(用户)】的数据库操作Service
* @createDate 2024-05-02 15:44:42
*/
public interface UserService extends IService<User> {

    /**
     * 用户注册
     *
     * @param userAccount   用户账户
     * @param userPassword  用户密码
     * @param checkPassword 校验密码
     * @return 新用户 id
     */
    long userRegister(String userAccount, String userPassword, String checkPassword, String studentId);


    /**
     * 用户登录
     *
     * @param userAccount  用户账户
     * @param userPassword 用户密码
     * @param request
     * @return 脱敏后的用户信息
     */
    User userLogin(String userAccount, String userPassword, HttpServletRequest request);


    /**
     * 用户脱敏
     *
     * @param originUser
     * @return
     */
    User getSafetyUser(User originUser);


    /**
     * 判断是否为管理员
     *
     * @param request
     * @return
     */
    boolean isAdmin(HttpServletRequest request);


    /**
     * 用户注销
     *
     * @param request
     * @return
     */
    int userLogout(HttpServletRequest request);

    /**
     * 根据标签搜索用户
     *
     * @param tagNameList
     * @return
     */
    List<User> searchUsersByTags(List<String> tagNameList);


    /**
     * 更新用户信息
     *
     * @param user
     * @param request
     * @return
     */
    int updataUser(User user,HttpServletRequest request);

    /**
     * 获取当前登录用户信息
     *
     * @return
     */
    User getLoginUser(HttpServletRequest request);

    /**
     * 首页推荐用户
     *
     * @param pageSize
     * @param pageNum
     * @param request
     * @return
     */
    Page<User> recommendUsers(long pageSize, long pageNum, HttpServletRequest request);
}
