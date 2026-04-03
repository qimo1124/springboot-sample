package top.dingyy.week05.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.dingyy.week05.common.Result;
import top.dingyy.week05.entity.User;
import top.dingyy.week05.service.UserTxService;

import java.util.Map;

/**
 * @author dingy
 */
@RestController
@RequestMapping
@RequiredArgsConstructor
public class UserTxController {
    private final UserTxService userTxService;

    @PostMapping("/addTwo")
    public Result<String> addTwo(@RequestBody Map<String, User> map){
        User user1 = map.get("user1");
        User user2 = map.get("user2");
        userTxService.addTwoUsers(user1,user2);
        return Result.success("两个用户均增加成功");
    }
}
