package cn.mlgbteam.authorization.api.dao;

import cn.mlgbteam.authorization.api.entity.User;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

@Repository
public interface UserDao extends Mapper<User>, MySqlMapper<User> {

}
