package top.dingyy.week05.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import top.dingyy.week05.entity.User;

/**
 * @author dingy
 */
@Mapper
public interface UserMPMapper extends BaseMapper<User> {
}
