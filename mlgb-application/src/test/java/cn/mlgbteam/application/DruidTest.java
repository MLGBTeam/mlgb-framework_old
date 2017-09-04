package cn.mlgbteam.application;

import com.alibaba.druid.filter.config.ConfigTools;
import org.junit.Test;

public class DruidTest {

    @Test
    public void decrypt() {
        final String[] args = {"mlgbTeam@666"};
        try {
            ConfigTools.main(args);
        } catch (final Exception e) {
            e.printStackTrace();
        }
    }
}
