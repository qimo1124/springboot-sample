package top.dingyy.springbootweek03.config;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "app")
@Data
public class AppConfig {
    private String appName;
    private String version;
    private String description;
}
