package cn.mlgbteam.persistence.datasource.druid;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(DruidSettings.class)
public class DruidDataSourceConfig {

  @Autowired private DruidSettings druidSettings;

  @Bean
  @ConfigurationProperties("spring.datasource")
  public DruidDataSource dataSource(final DataSourceProperties properties) throws Exception {
    final DruidDataSource dataSource = new DruidDataSource();

    dataSource.setDriverClassName(this.druidSettings.getDriverClassName());
    dataSource.setUrl(this.druidSettings.getUrl());
    dataSource.setUsername(this.druidSettings.getUsername());
    dataSource.setPassword(this.druidSettings.getPassword());

    return dataSource;
  }
}
