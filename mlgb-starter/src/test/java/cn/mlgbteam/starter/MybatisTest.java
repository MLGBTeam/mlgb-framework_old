package cn.mlgbteam.starter;

import cn.mlgbteam.authorization.api.entity.User;
import cn.mlgbteam.authorization.api.service.UserService;
import java.util.UUID;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MybatisTest {

    @Autowired
    private UserService userService;

    @Test
    public void test() {

        User user = new User();
        user.setId(UUID.randomUUID().toString());
        user.setName("abc");
        user.setAge(22);

        userService.insertUser(user);

    }
}
