package top.dingyy.week05.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.dingyy.week05.entity.User;
import top.dingyy.week05.mapper.UserMapper;

/**
 * @author dingy
 */
@Service
@RequiredArgsConstructor
public class UserTxService {
    private final UserMapper userMapper;

    @Transactional
    public void addTwoUsers(User user1,User user2){
        userMapper.insert(user1);
        if (user2.getUserName() == null || user2.getUserName().isEmpty()) {
            throw new RuntimeException("用户2姓名不能为空，事务回滚");
        }
        userMapper.insert(user2);
    }
}
