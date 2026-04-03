package top.dingyy.springbootweek04.entity;


import lombok.Data;

import java.time.LocalDateTime;

@Data
public class User {
    //用户ID
    private Long id;
    private String username;
    private LocalDateTime createTime;
}
