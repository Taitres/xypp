package com.taitres.xypp.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.taitres.xypp.model.domain.UserTeam;
import com.taitres.xypp.service.UserTeamService;
import com.taitres.xypp.mapper.UserTeamMapper;
import org.springframework.stereotype.Service;

/**
* @author Marlin
* @description 针对表【user_team(用户队伍关系)】的数据库操作Service实现
* @createDate 2024-05-06 16:39:38
*/
@Service
public class UserTeamServiceImpl extends ServiceImpl<UserTeamMapper, UserTeam>
    implements UserTeamService{

}




