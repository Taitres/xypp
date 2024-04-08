package com.taitres.xypp.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.taitres.xypp.service.TeamService;
import generator.domain.Team;
import generator.mapper.TeamMapper;
import org.springframework.stereotype.Service;

/**
* @author Marlin
* @description 针对表【team(队伍)】的数据库操作Service实现
* @createDate 2024-04-01 21:06:00
*/
@Service
public class TeamServiceImpl extends ServiceImpl<TeamMapper, Team>
    implements TeamService {

}




