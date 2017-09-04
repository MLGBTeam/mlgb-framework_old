package cn.mlgbteam.authorization.api.dao;

import cn.mlgbteam.authorization.api.entity.User;
import cn.mlgbteam.core.mapper.MLGBMapper;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends MLGBMapper<User> {

}
