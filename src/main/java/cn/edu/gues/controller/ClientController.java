package cn.edu.gues.controller;

import cn.edu.gues.pojo.Client;
import cn.edu.gues.service.impl.ClientServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author NIRLIN
 * @version 1.0
 * @date 2020/7/15 16:48
 */

@Controller
public class ClientController {
    @Autowired
    private ClientServiceImpl clientService;

    /**
     * 查看所有客户
     * @param model 传输数据
     * @return 跳转所有客户界面
     */
    @RequestMapping(name = "all-client.html", value = "all-client.html")
    public String allClient(Model model) {
        List<Client> clients = clientService.selectAllClient();
        model.addAttribute("clients", clients);
        return "all-client";
    }

    /**
     * 前往添加客户界面
     * @return 加客户界面
     */
    @RequestMapping(name = "add-client.html", value = "add-client.html")
    public String addClient() {
        return "add-client";
    }

    /**
     * 添加客户
     * @param client 客户数据
     * @return 所有客户界面
     */
    @RequestMapping(name = "addClientFun",value = "addClientFun.html")
    public String addClientFun(Client client){
        System.out.println(client);
        int i = clientService.insertClient(client);
        return "redirect:all-client.html";
    }

    /**
     * 根据客户id删除
     * @param id 客户id
     * @return 跳转所有客户界面
     */
    @RequestMapping(name = "deleteClientFun",value = "deleteClientFun.html")
    public String deleteClientFun(String id){
        int i = clientService.deleteClientById(id);
        return "redirect:all-client.html";
    }

    /**
     * 查询客户
     * @param model 传输数据
     * @param id 客户id
     * @return 前往编辑界面
     */
    @RequestMapping(name = "editClientFun",value = "editClientFun.html")
    public String editSupplierFun(Model model,String id){
        Client client = clientService.selectClientById(id);
        model.addAttribute("client",client);
        return "edit-client";
    }

    /**
     * 修改客户信息
     * @param client 客户信息
     * @return 根据id跳转客户详情
     */
    @RequestMapping(name = "updateClientFun",value = "updateClientFun.html")
    public String updateSupplierFun(Client client){
        int i = clientService.updateClientById(client);
        System.out.println(client.toString());
        return "redirect:editClientFun.html?id="+client.getId();
    }
    
}
