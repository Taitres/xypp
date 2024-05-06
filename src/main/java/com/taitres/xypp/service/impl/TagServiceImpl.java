package com.taitres.xypp.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.taitres.xypp.model.domain.Tag;
import com.taitres.xypp.service.TagService;
import com.taitres.xypp.mapper.TagMapper;
import org.springframework.stereotype.Service;

/**
* @author Marlin
* @description 针对表【tag(标签)】的数据库操作Service实现
* @createDate 2024-05-06 16:39:23
*/
@Service
public class TagServiceImpl extends ServiceImpl<TagMapper, Tag>
    implements TagService{

}




