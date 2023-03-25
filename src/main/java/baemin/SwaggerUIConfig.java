package baemin;

import org.springdoc.core.models.GroupedOpenApi;
import org.springdoc.core.properties.SwaggerUiConfigProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerUIConfig {
    @Bean
    public SwaggerUiConfigProperties swaggerUiConfig(SwaggerUiConfigProperties config) {
        config.setShowCommonExtensions(true);
        config.setQueryConfigEnabled(true); // 레퍼런스 확인 결과 xss 보안문제가 있어서 4.1.12? 버전 이상부터는 막혀있는데 이전 버전에서는 비활성화하는걸로 권장해서 제거함, 쿼리 파라미터로 스웨거 관련 설정하는데 사용되는 정보임
        config.setEnabled(false);
        config.setDisableSwaggerDefaultUrl(true); // 기본경로 '/swagger-ui/index.html' 경로 막음
        config.setUseRootPath(false);
        return config;
    }

    @Bean
    public GroupedOpenApi addApi() {
        return GroupedOpenApi.builder()
            .group("Dooolphin's Project")
            .pathsToMatch("/**")
            .build();
    }
}
