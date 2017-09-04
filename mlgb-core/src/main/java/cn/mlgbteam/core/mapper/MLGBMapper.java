package cn.mlgbteam.core.mapper;

import tk.mybatis.mapper.common.IdsMapper;
import tk.mybatis.mapper.common.Mapper;

public interface MLGBMapper<T> extends Mapper<T>, IdsMapper<T>, InsertListMapper<T>,
        InsertListSelectiveMapper<T> {
    
}
