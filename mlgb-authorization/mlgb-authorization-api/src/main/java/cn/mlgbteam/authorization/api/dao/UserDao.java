package cn.mlgbteam.authorization.api.dao;

import cn.mlgbteam.authorization.api.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao {

    @Insert(" INSERT INTO `user` (`id`, `name`, `age`) VALUES (#{id}, #{name}, #{age}) ")
    Integer insertUser(User user);

}
