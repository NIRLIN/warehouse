package cn.edu.gues.controller;

import cn.edu.gues.pojo.Cargo;
import cn.edu.gues.pojo.Supplier;
import cn.edu.gues.service.impl.CargoServiceImpl;
import cn.edu.gues.service.impl.EntrepotServiceImpl;
import cn.edu.gues.service.impl.RecordServiceImpl;
import cn.edu.gues.service.impl.SupplierServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author NIRLIN
 * @version 1.0
 * @date 2020/7/16 22:11
 */
@Controller
public class CargoController {
    @Autowired
    private CargoServiceImpl cargoService;
    @Autowired
    private EntrepotServiceImpl entrepotService;
    @Autowired
    private SupplierServiceImpl supplierService;

    @Autowired
    private RecordServiceImpl recordService;

    @RequestMapping(name = "all-cargo",value = "all-cargo.html")
    public String allCargo(Model model){
        List<Cargo> cargos = cargoService.selectAllCargo();
        model.addAttribute("cargos",cargos);
        return "all-cargo";
    }
    @RequestMapping(name = "toAddCargoPage",value = "toAddCargoPage.html")
    public String toAddCargoPage(Model model){
        List<Supplier> suppliers = supplierService.selectAllSupplier();
        model.addAttribute("suppliers",suppliers);
        return "add-cargo";
    }
    @RequestMapping(name = "addCargoFun",value = "addCargoFun.html")
    public String addCargoFun(Cargo cargo){
        System.out.println(cargo.toString());
        int i = cargoService.insertCargo(cargo);
        return "redirect:all-cargo.html";
    }

    @RequestMapping(name = "toEditCargoPage",value = "toEditCargoPage.html")
    public String toEditCargoPage(String id,Model model){
        Cargo cargo = cargoService.selectCargoById(id);
        model.addAttribute("cargo",cargo);
        return "edit-cargo";
    }

    @RequestMapping(name = "editCargoFun",value = "editCargoFun.html")
    public String editCargoFun(Cargo cargo,Model model){
        System.out.println(cargo.toString());
        cargoService.updateCargoById(cargo);
        return "redirect:toEditCargoPage.html?id="+cargo.getId();
    }

    @RequestMapping(name = "deleteCargoFun",value = "deleteCargoFun.html")
    public String deleteCargoFun(String id,Model model){
        int i = recordService.ifCargoNum(id);
        if (i==0){
            cargoService.deleteCargoById(id);
            return "redirect:all-cargo.html";
        }else {
            model.addAttribute("error","商品数量不为0，禁止删除！");
            List<Cargo> cargos = cargoService.selectAllCargo();
            model.addAttribute("cargos",cargos);
            return "all-cargo";
        }
    }

}
