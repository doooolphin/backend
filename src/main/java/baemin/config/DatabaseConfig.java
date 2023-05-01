package baemin.config;

import com.zaxxer.hikari.HikariDataSource;
import javax.sql.DataSource;
import org.modelmapper.ModelMapper;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "entityManagerFactory",
    transactionManagerRef = "transactionManager",
    basePackages = {"baemin.repository"}
)
public class DatabaseConfig {

    @ConfigurationProperties(prefix="spring.datasource")
    @Bean
    public DataSource dataSource() throws Exception { //hikariConfig를 이용하여 데이터베이스와 연결하는 DataSource를 생성합니다.
        return DataSourceBuilder.create().type(HikariDataSource.class).build();
    }

    @Bean
    public DataSourceTransactionManager transactionManager() throws Exception {
        return new DataSourceTransactionManager(dataSource());
    }

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}