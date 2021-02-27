package cn.edu.gues.controller;

import cn.edu.gues.pojo.Entrepot;
import cn.edu.gues.service.impl.EntrepotServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author NIRLIN
 * @version 1.0
 * @date 2020/7/15 16:32
 */

@Controller
public class EntrepotController {
    /**
     * 自动装配
     */
    @Autowired
    private EntrepotServiceImpl entrepotService;

    /**
     * 查询所有仓库
     * @param model 数据传输
     * @return 跳转所有仓库界面
     */
    @RequestMapping(name = "all-warehouse.html", value = "all-warehouse.html")
    public String allWarehouse(Model model) {
        List<Entrepot> entrepots = entrepotService.selectAllEntrepot();
        model.addAttribute("entrepots", entrepots);
        return "all-warehouse";
    }

    /**
     * 跳转添加仓库界面
     * @return 跳转添加仓库界面
     */
    @RequestMapping(name = "add-warehouse.html", value = "add-warehouse.html")
    public String addWarehouse() {
        return "add-warehouse";
    }

    /**
     * 添加仓库
     * @param entrepot 仓库数据
     * @return 所有仓库界面
     */
    @RequestMapping(name = "addWarehouseFun",value = "addWarehouseFun.html")
    public String addWarehouseFun(Entrepot entrepot){
        int i = entrepotService.insertEntrepot(entrepot);
        return "redirect:all-warehouse.html";
    }

    /**
     * 根据仓库id删除
     * @param id 仓库id
     * @return 跳转所有仓库界面
     */
    @RequestMapping(name = "deleteWarehouseFun",value = "deleteWarehouseFun.html")
    public String deleteWarehouseFun(String id){
        int i = entrepotService.deleteEntrepotById(id);
        return "redirect:all-warehouse.html";
    }

    /**
     * 查询仓库
     * @param model 传输数据
     * @param id 仓库id
     * @return 前往编辑界面
     */
    @RequestMapping(name = "editWarehouseFun",value = "editWarehouseFun.html")
    public String editWarehouseFun(Model model,String id){
        Entrepot entrepot = entrepotService.selectEntrepotById(id);
        model.addAttribute("entrepot",entrepot);
        return "edit-warehouse";
    }

    /**
     * 修改仓库信息
     * @param entrepot 仓库信息
     * @return 根据id跳转仓库详情
     */
    @RequestMapping(name = "updateWarehouseFun",value = "updateWarehouseFun.html")
    public String updateWarehouseFun(Entrepot entrepot){
        int i = entrepotService.updateEntrepotById(entrepot);
        return "redirect:editWarehouseFun.html?id="+entrepot.getId();
    }
}
