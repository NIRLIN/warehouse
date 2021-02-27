package cn.edu.gues.controller;

import cn.edu.gues.pojo.Notice;
import cn.edu.gues.service.impl.NoticeServiceImpl;
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
 * @date 2020/7/15 15:39
 */
@Controller
public class NoticeController {
    @Autowired
    private NoticeServiceImpl noticeService;
    @Autowired
    private UserServiceImpl userService;

    /**
     * 查询所有通知
     * @param model 传递参数
     * @return 跳转展示所有通知界面
     */
    @RequestMapping(name = "all-notice.html", value = "all-notice.html")
    public String allNotice(Model model) {
        List<Notice> notices = noticeService.selectAllNotice();
        model.addAttribute("notices", notices);
        return "all-notice";
    }

    /**
     * @return 进入添加通知界面
     */
    @RequestMapping(name = "add-notice.html", value = "add-notice.html")
    public String addNotice() {
        return "add-notice";
    }

    /**
     * 增加通知
     * @param notice 表单传入参数，通知信息
     * @param model 传递参数
     * @param session 利用session取出用户工号
     * @return 重定向到所有通知界面
     */
    @RequestMapping(name = "addNoticeFun",value = "addNoticeFun.html")
    public String addNoticeFun(Notice notice, Model model, HttpSession session){
        String jobNo = (String) session.getAttribute("jobNo");
        notice.setUserId(jobNo);
        int i = noticeService.insertNotice(notice);
        return "redirect:all-notice.html";
    }

    /**
     * 删除通知 通过id
     * @param id 通知id
     * @return 跳转所有通知界面
     */
    @RequestMapping(name = "deleteNotionFun" ,value = "deleteNotionFun.html")
    public String deleteNotionFun(String id){
        int i = noticeService.deleteNoticeById(id);
        return "redirect:all-notice.html";
    }

    /**
     *从所有通知进入查询某一个通知，然后渲染上页面
     * @param id 通知id
     * @param model 参数传递
     * @return 前往编辑通知界面
     */
    @RequestMapping(name = "editNotionFun",value = "editNotionFun.html")
    public String editNotionFun(String id,Model model){
        Notice notice = noticeService.selectNoticeById(id);
        model.addAttribute("notice",notice);
        return "edit-notice";
    }

    /**
     * 获取通知信息，然后修改
     * @param notice 通知信息
     * @param model 传递参数
     * @param session 获取用户session
     * @return 前往某一个通知编辑界面
     */
    @RequestMapping(name = "updateNoticeFun",value = "updateNoticeFun.html")
    public String updateNoticeFun(Notice notice, Model model, HttpSession session){
        String jobNo = (String) session.getAttribute("jobNo");
        notice.setUserId(jobNo);
        int i = noticeService.updateNoticeById(notice);
        System.out.println(notice.toString());
        return "redirect:editNotionFun.html?id="+notice.getId();
    }

    /**
     *从所有通知进入查询某一个通知，然后渲染上页面
     * @param id 通知id
     * @param model 参数传递
     * @return 前往查看通知界面
     */
    @RequestMapping(name = "lookNotionFun",value = "lookNotionFun.html")
    public String lookNotionFun(String id,Model model){
        Notice notice = noticeService.selectNoticeById(id);
        model.addAttribute("notice",notice);
        return "look-notice";
    }
}
