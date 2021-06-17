package testall.tradedata.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import testall.tradedata.dao.MaTradeDataDao;
import testall.tradedata.dao.MaTradeDataDaoImpl;
import testall.tradedata.service.MaLongformService;
import testall.tradedata.service.MaLongformServiceImpl;

import javax.sql.DataSource;

@Configuration
public class Config {

    @Bean
    DataSource dataSource() {
        DataSource dataSource = new DriverManagerDataSource(
                "jdbc:h2:mem:testdb;Mode=Oracle",
                "sa",
                "sa"
        );
        return dataSource;
    }

    @Bean
    JdbcTemplate jdbcTemplate() {
        return new JdbcTemplate(dataSource());
    }

    @Bean
    MaTradeDataDao maTradeDataDao() {
        return new MaTradeDataDaoImpl(jdbcTemplate());
    }

    @Bean
    MaLongformService maLongformService() {
        return new MaLongformServiceImpl(maTradeDataDao());
    }
}
