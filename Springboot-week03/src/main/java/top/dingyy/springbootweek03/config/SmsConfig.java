package top.dingyy.springbootweek03.config;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "sms.ccp")
public class SmsConfig {
    private String serverIp;
    private String port;
    private String accountSId;
    private String accountToken;
    private String appId;
    private String templateId;
}
