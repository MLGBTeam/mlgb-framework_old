package cn.mlgbteam.starter;

import cn.mlgbteam.authorization.api.entity.User;
import cn.mlgbteam.authorization.api.service.UserService;
import com.github.pagehelper.Page;
import java.util.ArrayList;
import java.util.List;
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
    public void testInsert() {
        final User user = new User();
        //user.setId(UUID.randomUUID().toString());
        user.setName("李四");
        user.setAge(23);
        this.userService.insertUser(user);
        System.out.println(user.toString());
    }

    @Test
    public void testSelect() {
        final Page<User> userPage = this.userService.listUser();

        for (final User user : userPage) {
            System.out.println(user.toString());
        }

        System.out.println(userPage.getTotal());
        System.out.println(userPage.toString());

    }

    @Test
    public void testInsertList() {
        final List<User> userList = new ArrayList<>();
        final User user1 = new User();
        user1.setId(UUID.randomUUID().toString());
        user1.setName("李四");
        user1.setAge(23);
        final User user2 = new User();
        user2.setId(UUID.randomUUID().toString());
        user2.setName("王五");
        user2.setAge(24);
        userList.add(user1);
        userList.add(user2);

        this.userService.insertUserList(userList);

        for (final User user : userList) {
            System.out.println(user.toString());
        }
    }

}
