package com.taitres.xypp.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.taitres.xypp.model.domain.User;
import generator.domain.User;

/**
* @author Marlin
* @description 针对表【user(用户)】的数据库操作Mapper
* @createDate 2024-04-01 21:06:00
* @Entity generator.domain.User
*/
public interface UserMapper extends BaseMapper<User> {

    long selectCount(QueryWrapper<User> queryWrapper);
}




