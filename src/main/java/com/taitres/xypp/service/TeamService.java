package com.taitres.xypp.service;

import com.taitres.xypp.model.domain.Team;
import com.baomidou.mybatisplus.extension.service.IService;
import com.taitres.xypp.model.domain.User;
import com.taitres.xypp.model.dto.TeamQuery;
import com.taitres.xypp.model.request.TeamJoinRequest;
import com.taitres.xypp.model.request.TeamUpdateRequest;
import com.taitres.xypp.model.vo.TeamUserVO;
import jakarta.servlet.http.HttpServletRequest;

import java.util.List;

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

    /**
    * 查询队伍列表
     * @param teamQuery
     * @param isAdmin
     * @return
     */
    List<TeamUserVO> listTeams(TeamQuery teamQuery, boolean isAdmin);

    /**
     * 更新队伍
     *
     * @param teamUpdateRequest
     * @param request
     * @return
     */
    boolean updateTeam(TeamUpdateRequest teamUpdateRequest, HttpServletRequest request);

    /**
     * 加入队伍
     * @param teamJoinRequest
     * @param loginUser
     * @return
     */
    boolean joinTeam(TeamJoinRequest teamJoinRequest, User loginUser);

}
