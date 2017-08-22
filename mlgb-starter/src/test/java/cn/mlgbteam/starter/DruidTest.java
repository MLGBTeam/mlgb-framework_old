package cn.mlgbteam.starter;

import com.alibaba.druid.filter.config.ConfigTools;
import org.junit.Test;

public class DruidTest {

    @Test
    public void decrypt() {
        String[] args = {"mlgbTeam@666"};
        try {
            ConfigTools.main(args);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
