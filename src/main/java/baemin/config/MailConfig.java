package baemin.config;

import java.util.Properties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@Configuration
public class MailConfig {

    @Bean
    public JavaMailSender javaMailSender() {
        JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();
        javaMailSender.setHost("smtp.naver.com");
        javaMailSender.setUsername("ohi2262@naver.com");
        javaMailSender.setPassword("mongddang128213!");
        javaMailSender.setPort(465);
        javaMailSender.setDefaultEncoding("utf-8");
        javaMailSender.setJavaMailProperties(getMailProperties());

        return javaMailSender;
    }

    // 메일 인증서버 정보
    private Properties getMailProperties() {
        Properties properties = new Properties();
        properties.setProperty("mail.smtp.auth", "true"); //smtp 인증
        properties.setProperty("mail.transport.protocol", "smtp"); //프로토콜 설정
        properties.setProperty("mail.smtp.starttls.enable","true"); //smtp strattles 사용
        properties.setProperty("mail.debug", "true"); // 디버그 사용
        properties.setProperty("mail.smtp.ssl.trust", "smtp.naver.com"); // ssl 인증서버 (smtp 서버명)
        properties.setProperty("mail.smtp.ssl.enable", "true"); // ssl 사용
        properties.setProperty("mail.smtp.ssl.protocols", "TLSv1.2"); // TLS 버전 맞추기위해

        return properties;
    }


}
