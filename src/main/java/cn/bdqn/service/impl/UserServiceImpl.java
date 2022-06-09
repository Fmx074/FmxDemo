package cn.bdqn.service.impl;

import cn.bdqn.dao.UserMapper;
import cn.bdqn.pojo.PageBean;
import cn.bdqn.pojo.UserPojo;
import cn.bdqn.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;

//    @Override
//    public List<UserPojoddasdafasdasdcal> list() {
//        return userMapper.list();
//    }



    @Override
    public void add(UserPojo userPojo) {
        userMapper.add(userPojo);
    }

    @Override
    public void update(UserPojo userPojo) {
        userMapper.update(userPojo);
    }

    @Override
    public void delete(Integer id) {
        userMapper.delete(id);
    }

    @Override
    public UserPojo toupdate(int id) {
        return userMapper.toupdate(id);
    }

    @Override
    public PageBean<UserPojo> findLimit(String username, String password, int currPageNo, int pageSize) {
        PageBean<UserPojo> pageBean = new PageBean<UserPojo>();
        pageBean.setCurrPageNo(currPageNo);
        pageBean.setPageSize(pageSize);
        Integer total = userMapper.findTotal(username,password);
        pageBean.setTotalCount(total);
        Integer totalPageCount = total % pageSize == 0 ? total/pageSize:total/pageSize+1;
        pageBean.setTotalPageCount(totalPageCount);
        List<UserPojo> list = userMapper.findLimit(username,password,(currPageNo-1)*pageSize,pageSize);
        pageBean.setLists(list);
        return pageBean;
    }

    @Override
    public Integer findTotal(String username, String password) {
        return userMapper.findTotal(username,password);
    }

    public UserMapper getUserMapper() {
        return userMapper;
    }

    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }


}
