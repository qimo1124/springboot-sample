package top.dingyy.week05.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import top.dingyy.week05.entity.User;
import top.dingyy.week05.mapper.UserMapper;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author dingy
 */

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserMapper userMapper;

    public int add(User user){
        int result = userMapper.insert(user);
        user.setCreateTime(LocalDateTime.now());
        System.out.println(user);
        return result;
    }

    public User getById(Long id){
        return userMapper.selectByPrimaryKey(id);
    }

    public List<User> list(){
        return userMapper.selectList();
    }

    public int update(User user){
        return userMapper.updateByPrimaryKey(user);
    }

    public int delete(Long id){
        return userMapper.deleteByPrimaryKey(id);
    }

    public List<User> search(String username, Integer minAge) {
        User param = new User();
        param.setUserName(username);
        param.setAge(minAge);
        return userMapper.selectByCondition(param);
    }
}
