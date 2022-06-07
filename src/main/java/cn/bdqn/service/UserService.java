package cn.bdqn.service;

import cn.bdqn.pojo.PageBean;
import cn.bdqn.pojo.UserPojo;

import java.util.List;

public interface UserService {
    //List<UserPojo> list();
    PageBean<UserPojo> findLimit(String username, String password, int currPageNo, int pageSize);
    Integer findTotal(String username,String password);

    void add(UserPojo userPojo);

    void update(UserPojo userPojo);

    void delete(Integer id);

    UserPojo toupdate(int id);


}
