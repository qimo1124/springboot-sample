package top.dingyy.hellosample.comtroller;

// HelloController.java
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.dingyy.hellosample.vo.ResultVO;

@RestController
@RequestMapping("/api")
public class HelloController {

    /**
     * 欢迎接口
     * @return 统一格式的响应结果
     */
    @GetMapping("/hello")
    public ResultVO<String> hello() {
        return new ResultVO<>
                (200, "success", "Hello Spring Boot");
    }
}

