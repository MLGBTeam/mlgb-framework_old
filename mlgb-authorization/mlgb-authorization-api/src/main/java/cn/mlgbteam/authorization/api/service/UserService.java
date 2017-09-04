package cn.mlgbteam.authorization.api.service;

import cn.mlgbteam.authorization.api.dao.UserDao;
import cn.mlgbteam.authorization.api.entity.User;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserDao userDao;

    @Autowired
    public UserService(final UserDao userDao) {
        this.userDao = userDao;
    }

    public Integer insertUser(final User user) {
        return this.userDao.insert(user);
    }

    public Page<User> listUser() {
        PageHelper.startPage(1, 10);
        return (Page<User>) this.userDao.selectAll();
    }

    public int insertUserList(final List<User> userList) {
        return this.userDao.insertListSelective(userList);
    }

}
