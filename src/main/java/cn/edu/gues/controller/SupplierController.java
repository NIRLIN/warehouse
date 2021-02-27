package cn.edu.gues.controller;

import cn.edu.gues.pojo.Cargo;
import cn.edu.gues.pojo.Supplier;
import cn.edu.gues.service.impl.CargoServiceImpl;
import cn.edu.gues.service.impl.SupplierServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author NIRLIN
 * @version 1.0
 * @date 2020/7/15 16:41
 */

@Controller
public class SupplierController {

    @Autowired
    private SupplierServiceImpl supplierService;
    @Autowired
    private CargoServiceImpl cargoService;


    /**
     * 查看所有供应商
     * @param model 传输数据
     * @return 所有供应商界面
     */
    @RequestMapping(name = "all-supplier.html", value = "all-supplier.html")
    public String allSupplier(Model model) {
        List<Supplier> suppliers = supplierService.selectAllSupplier();
        model.addAttribute("suppliers", suppliers);
        return "all-supplier";
    }

    /**
     * 跳转供应商添加界面
     * @return 供应商添加界面
     */
    @RequestMapping(name = "add-supplier.html", value = "add-supplier.html")
    public String addSupplier() {
        return "add-supplier.html";
    }

    /**
     * 添加仓库
     * @param supplier 供应商数据
     * @return 所有供应商界面
     */
    @RequestMapping(name = "addSupplierFun",value = "addSupplierFun.html")
    public String addSupplierFun(Supplier supplier){
        System.out.println(supplier);
        int i = supplierService.insertSupplier(supplier);
        return "redirect:all-supplier.html";
    }

    /**
     * 根据供应商id删除
     * @param id 供应商id
     * @return 跳转所有供应商界面
     */
    @RequestMapping(name = "deleteSupplierFun",value = "deleteSupplierFun.html")
    public String deleteSupplierFun(String id,Model model){
        List<Cargo> cargos = cargoService.selectCargoBySupplierId(id);
        if (cargos.size()==0){
            int i = supplierService.deleteSupplierById(id);
            return "redirect:all-supplier.html";
        }else {
            List<Supplier> suppliers = supplierService.selectAllSupplier();
            model.addAttribute("suppliers", suppliers);
            model.addAttribute("error","此供应商在仓库中存在商品，禁止删除！");
            return "all-supplier";
        }

    }

    /**
     * 查询供应商
     * @param model 传输数据
     * @param id 供应商id
     * @return 前往编辑界面
     */
    @RequestMapping(name = "editSupplierFun",value = "editSupplierFun.html")
    public String editSupplierFun(Model model,String id){
        Supplier supplier = supplierService.selectSupplierById(id);
        model.addAttribute("supplier",supplier);
        return "edit-supplier";
    }

    /**
     * 修改供应商信息
     * @param supplier 供应商信息
     * @return 根据id跳转供应商详情
     */
    @RequestMapping(name = "updateSupplierFun",value = "updateSupplierFun.html")
    public String updateSupplierFun(Supplier supplier){
        int i = supplierService.updateSupplierById(supplier);
        System.out.println(supplier.toString());
        return "redirect:editSupplierFun.html?id="+supplier.getId();
    }

}
