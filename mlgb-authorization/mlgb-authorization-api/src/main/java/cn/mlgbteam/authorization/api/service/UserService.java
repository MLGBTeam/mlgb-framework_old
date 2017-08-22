package cn.mlgbteam.authorization.api.service;

import cn.mlgbteam.authorization.api.dao.UserDao;
import cn.mlgbteam.authorization.api.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserDao userDao;

    @Autowired
    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public Integer insertUser(User user) {
        return userDao.insertUser(user);
    }
}
