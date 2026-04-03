package top.dingyy.week05.entity;

import java.time.LocalDateTime;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import jakarta.validation.constraints.NotBlank;

/**
 * @author dingyy
 */
@Data
@TableName("t_user")
public class User {
    @Schema(description="主键")
    private Long id;

    @NotBlank(message = "用户名不能为空")
    @Schema(description="用户名", required = true)
    @TableField("username")  // ← 添加这一行
    private String userName;

    @NotBlank(message = "密码不能为空")
    @Schema(description="密码", required = true)
    private String password;

    @Schema(description="年龄")
    private Integer age;

    @Schema(description="邮箱")
    private String email;

    @Schema(description="创建时间")
    private LocalDateTime createTime;
}