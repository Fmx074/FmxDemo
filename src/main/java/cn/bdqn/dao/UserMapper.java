package cn.bdqn.dao;

import cn.bdqn.pojo.UserPojo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper {
    List<UserPojo> list();
    List<UserPojo> findLimit(@Param("username")String username,@Param("password")String password,@Param("currPageNo") Integer currPageNo, @Param("pageSize") Integer pageSize);
    Integer findTotal(@Param("username")String username,@Param("password")String password);

    void add(UserPojo userPojo);

    void update(UserPojo userPojo);

    void delete(Integer id);

    UserPojo toupdate(int id);
}
