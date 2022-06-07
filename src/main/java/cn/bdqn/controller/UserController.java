package cn.bdqn.controller;

import cn.bdqn.pojo.PageBean;
import cn.bdqn.pojo.UserPojo;
import cn.bdqn.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@Controller
public class UserController {
    @Resource
    private UserService userService;

//    @RequestMapping("list")
//    public String list(Model model){
//        List<UserPojo> list = userService.list();
//        model.addAttribute("list",list);
//        return "list";
//    }

    @RequestMapping(value = "list",method = RequestMethod.GET)
    public String findUser(@RequestParam(value = "username",required = false) String username,
                           @RequestParam(value = "password",required = false)String password,
                           @RequestParam(value = "currPageNo",defaultValue = "1",required = false)
                                                   int currPageNo, Model model, HttpSession session){
        if(username != null){
            session.setAttribute("username",username);
        }else {
            username = (String) session.getAttribute("username");
        }
        if(password != null){
            session.setAttribute("password",password);
        }else {
            password = (String) session.getAttribute("password");
        }
        PageBean<UserPojo> pageBean = userService.findLimit(username,password,currPageNo,5);
        model.addAttribute("page",pageBean);
        return "list";
    }
    @RequestMapping("toadd")
    public String toadd(){
        return "add";
    }
    @RequestMapping("add")
    public String add(UserPojo userPojo){
        userService.add(userPojo);
        return "redirect:list";
    }
    @RequestMapping("toupdate")
    public String toupdate(Model model,int id){
        UserPojo userPojo = userService.toupdate(id);
        model.addAttribute("userPojo",userPojo);
        return "update";
    }
    @RequestMapping("update")
    public String update(UserPojo userPojo){
        userService.update(userPojo);
        return "redirect:list";
    }
    @RequestMapping("delete")
    public String delete(Integer id){
        userService.delete(id);
        return "redirect:list";
    }
    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
