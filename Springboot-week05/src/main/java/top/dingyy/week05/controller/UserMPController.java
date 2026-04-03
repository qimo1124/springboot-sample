package top.dingyy.week05.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import top.dingyy.week05.common.Result;
import top.dingyy.week05.entity.User;
import top.dingyy.week05.mapper.UserMPMapper;
import top.dingyy.week05.service.UserMPService;
import top.dingyy.week05.service.UserService;

/**
 * @author dingy
 */
@RestController
@RequestMapping("/api/user/mp")
@RequiredArgsConstructor
public class UserMPController {
    private final UserMPMapper userMPMapper;
    private final UserService userService;
    private final UserMPService userMPService;

    @GetMapping("/page")
    public Result<Page<User>> page(
            @RequestParam(defaultValue = "1") Integer pageNum,
            @RequestParam(defaultValue = "10") Integer pageSize,
            @RequestParam(required = false) String username) {
        return Result.success(userMPService.page(username,pageNum,pageSize));
    }

    @PostMapping
    public Result<String> add(@RequestBody User user){
        int row = userService.add(user);
        if(row <= 0) {
            return Result.error("MP 新增失败");
        }
        return Result.success("MP 新增成功");
    }

    @DeleteMapping("/{id}")
    public Result<String> delete(@PathVariable Long id) {
        int row = userMPService.delete(id);
        if (row <= 0) {
            return Result.error("MP 删除失败");
        }
        return Result.success("MP 删除成功 ");
    }
}
