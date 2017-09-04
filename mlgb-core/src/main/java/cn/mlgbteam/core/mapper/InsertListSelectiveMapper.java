package cn.mlgbteam.core.mapper;

import cn.mlgbteam.core.mapper.provider.MLGBProvider;
import java.util.List;
import org.apache.ibatis.annotations.InsertProvider;

public interface InsertListSelectiveMapper<T> {

    /**
     * 批量插入，方法参数必须包含完整的主键属性,null的属性不会保存，会使用数据库默认值
     *
     * @param recordList 需要插入的对象List，size()必须大于0
     * @return 成功插入的条数
     */
    @InsertProvider(type = MLGBProvider.class, method = "dynamicSQL")
    int insertListSelective(List<T> recordList);

}
