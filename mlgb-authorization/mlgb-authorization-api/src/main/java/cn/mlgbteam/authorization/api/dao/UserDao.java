package cn.mlgbteam.authorization.api.dao;

import cn.mlgbteam.authorization.api.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.springframework.stereotype.Component;

@Component
public interface UserDao {

    @Insert(" INSERT INTO `user` (`id`, `name`, `age`) VALUES (#{id}, #{name}, #{age) ")
    public Integer insertUser(User user);
    
}
