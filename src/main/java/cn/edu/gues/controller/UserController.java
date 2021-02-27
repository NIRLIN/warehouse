package cn.edu.gues.controller;

import cn.edu.gues.pojo.User;
import cn.edu.gues.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author NIRLIN
 * @version 1.0
 * @date 2020/7/15 16:51
 */

@Controller
public class UserController {
    @Autowired
    private UserServiceImpl userService;

    /**
     * 进入所有员工界面
     * @param model 传输数据
     * @return 进入所有员工界面
     */
    @RequestMapping(name = "all-employee.html", value = "all-employee.html")
    public String allEmployee(Model model) {
        List<User> users = userService.selectAllUser();
        model.addAttribute("users", users);
        return "all-employee";
    }

    /**
     * 进入添加员工界面
     * @return 添加员工界面
     */
    @RequestMapping(name = "add-employee.html", value = "add-employee.html")
    public String addEmployee() {
        return "add-employee";
    }


    /**
     * 添加员工
     * @param user 员工数据
     * @return 所有员工界面
     */
    @RequestMapping(name = "addEmployeeFun",value = "addEmployeeFun.html")
    public String addEmployeeFun(User user){
        System.out.println(user);
        int i = userService.insertUser(user);
        return "redirect:all-employee.html";
    }

    /**
     * 根据员工id删除
     * @param id 员工id
     * @return 跳转所有员工界面
     */
    @RequestMapping(name = "deleteEmployeeFun",value = "deleteEmployeeFun.html")
    public String deleteEmployeeFun(String id){
        int i = userService.deleteUserById(id);
        return "redirect:all-employee.html";
    }

    /**
     * 查询员工
     * @param model 传输数据
     * @param id 员工id
     * @return 前往编辑界面
     */
    @RequestMapping(name = "editEmployeeFun",value = "editUserEmployee.html")
    public String editEmployeeFun(Model model,String id){
        User user = userService.selectUserById(id);
        model.addAttribute("user",user);
        return "edit-employee";
    }

    /**
     * 修改员工信息
     * @param user 员工信息
     * @return 根据id跳转员工详情
     */
    @RequestMapping(name = "updateEmployeeFun",value = "updateEmployeeFun.html")
    public String updateEmployeeFun(User user){
        int i = userService.updateUserById(user);
        System.out.println(user.toString());
        return "redirect:editUserEmployee.html?id="+user.getId();
    }

    /**
     * 用户登录
     * @param jobNo 职工号
     * @param password 密码
     * @param model 传输数据
     * @param session 存储用户信息
     * @return 成功前往首页，失败前往登录页
     */
    @RequestMapping(name = "loginFunction",value = "loginFunction.html")
    public String loginFunction(String jobNo, String password , Model model, HttpSession session){
        User user = userService.loginFunction(jobNo, password);
        if (user==null){
            model.addAttribute("error","账号或密码错误！");

            return "login";
        }else {
            session.setAttribute("jobNo",user.getJobNo());
            session.setAttribute("id",user.getId());
            session.setAttribute("name",user.getName());
            session.setAttribute("role",user.getRole());
            return "redirect:index.html";
        }
    }

    @RequestMapping(name = "userChangeInfo" ,value = "userChangeInfo.html")
    public String userChangeInfo(Model model,HttpSession session){
        String id = (String) session.getAttribute("id");
        User user = userService.selectUserById(id);
        model.addAttribute("user",user);
        return "edit-myinfo";
    }
    /**
     * 修改员工信息
     * @param user 员工信息
     * @return 根据id跳转员工详情
     */
    @RequestMapping(name = "updateUserInfo",value = "updateUserInfo.html")
    public String updateUserInfo(User user){
        int i = userService.updateUserById(user);
        System.out.println(user.toString());
        return "redirect:userChangeInfo.html";
    }

}
