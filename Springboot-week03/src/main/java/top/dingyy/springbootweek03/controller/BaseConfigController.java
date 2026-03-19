package top.dingyy.springbootweek03.controller;

import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.dingyy.springbootweek03.config.AppConfig;

import java.io.Serializable;
import java.util.Map;

@RestController
@RequestMapping("/config")
public class BaseConfigController {
    @Value("${server.port}")
    private Integer port;

    @GetMapping("/port")
    public String getPort() {
        return "当前服务器端口号" + port;
    }

    @Value("${server.servlet.context-path}")
    private String  contextPath ;

    @Value("${spring.application.name}")
    private String applicationName ;

    @Value("${app.app-name}")
    private String appName ;

    @Value("${app.version:1.0.0}")
    private String version ;

    @Value("${app.description}")
    private String appDescription ;


    @Resource
    private AppConfig appConfig;


    @GetMapping("/info")
    public Map<String, Object> getConfigInfo() {
        return Map.of(
                "port",port,
                "contextPath",contextPath,
                "applicationName",applicationName,
                "appName",appName,
                "version",version,
                "description",appDescription
        );
    }

    @GetMapping("/info2")
    public Map<String, Object> getConfigInfo2() {
        return Map.of(
                "appName",appConfig.getAppName(),
                "version",appConfig.getVersion(),
                "description",appConfig.getDescription()
        );
    }
}
