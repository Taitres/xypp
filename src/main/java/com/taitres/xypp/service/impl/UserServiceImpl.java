package com.taitres.xypp.service.impl;



import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.taitres.xypp.common.ErrorCode;
import com.taitres.xypp.exception.BusinessException;
import com.taitres.xypp.mapper.UserMapper;
import com.taitres.xypp.model.domain.User;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * 用户服务实现类
 *
 */
@Service
@Slf4j
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
        implements UserService {



}




