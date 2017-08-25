package cn.mlgbteam.starter;

import cn.mlgbteam.authorization.api.entity.User;
import cn.mlgbteam.authorization.api.service.UserService;
import com.github.pagehelper.Page;
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
    public void testInsert() {
        User user = new User();
        //user.setId(UUID.randomUUID().toString());
        user.setName("李四");
        user.setAge(23);
        userService.insertUser(user);
        System.out.println(user.toString());
    }

    @Test
    public void testSelect() {
        Page<User> userPage = userService.listUser();

        for (User user : userPage) {
            System.out.println(user.toString());
        }

        System.out.println(userPage.getTotal());
        System.out.println(userPage.toString());

    }

}
