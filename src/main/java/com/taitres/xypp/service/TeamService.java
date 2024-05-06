package com.taitres.xypp.service;

import com.taitres.xypp.model.domain.Team;
import com.baomidou.mybatisplus.extension.service.IService;
import com.taitres.xypp.model.domain.User;

/**
* @author Marlin
* @description 针对表【team(队伍)】的数据库操作Service
* @createDate 2024-05-06 16:39:34
*/
public interface TeamService extends IService<Team> {

    /**
     * 创建队伍
     *
     * @param team
     * @param loginUser
     * @return
     */
    long addTeam(Team team, User loginUser);

}
