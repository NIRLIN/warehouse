package cn.edu.gues.controller;

import cn.edu.gues.pojo.Notice;
import cn.edu.gues.service.impl.NoticeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author NIRLIN
 * @version 1.0
 * @date 2020/7/16 16:27
 */
@Controller
public class IndexController {
    @Autowired
    private NoticeServiceImpl noticeService;
    @RequestMapping(name = "index.html",value = "index.html")
    public String index(Model model){
        List<Notice> notices = noticeService.selectAllNotice();
        model.addAttribute("notices",notices);
        return "index";
    }
}
