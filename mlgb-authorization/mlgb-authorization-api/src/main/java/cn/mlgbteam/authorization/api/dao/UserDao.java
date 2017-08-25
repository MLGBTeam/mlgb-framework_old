package cn.mlgbteam.authorization.api.dao;

import cn.mlgbteam.authorization.api.entity.User;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

@Repository
public interface UserDao extends Mapper<User> {


}
