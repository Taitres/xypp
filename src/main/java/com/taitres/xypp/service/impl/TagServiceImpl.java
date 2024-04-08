package com.taitres.xypp.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.taitres.xypp.service.TagService;
import generator.domain.Tag;
import generator.mapper.TagMapper;
import org.springframework.stereotype.Service;

/**
* @author Marlin
* @description 针对表【tag(标签)】的数据库操作Service实现
* @createDate 2024-04-01 21:06:00
*/
@Service
public class TagServiceImpl extends ServiceImpl<TagMapper, Tag>
    implements TagService {

}




