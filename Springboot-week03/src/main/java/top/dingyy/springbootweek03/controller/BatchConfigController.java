package top.dingyy.springbootweek03.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.dingyy.springbootweek03.common.Restult;
import top.dingyy.springbootweek03.config.AppConfig;

@RestController
@RequestMapping("/config/batch")
@RequiredArgsConstructor
public class BatchConfigController {
    private final AppConfig appConfig;

//    @GetMapping()
//    public Restult <AppConfig> getConfigInfoBatch() {
//        return Restult.success(appConfig);
//    }
}

