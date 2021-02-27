package cn.edu.gues.controller;

import cn.edu.gues.pojo.Cargo;
import cn.edu.gues.pojo.Entrepot;
import cn.edu.gues.pojo.Record;
import cn.edu.gues.service.impl.CargoServiceImpl;
import cn.edu.gues.service.impl.EntrepotServiceImpl;
import cn.edu.gues.service.impl.RecordServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author NIRLIN
 * @version 1.0
 * @date 2020/7/15 17:02
 */

@Controller
public class RecordInController {
    @Autowired
    private RecordServiceImpl recordService;
    @Autowired
    private EntrepotServiceImpl entrepotService;
    @Autowired
    private CargoServiceImpl cargoService;
    
    /**
     * 查询所有入库
     * @param model 传递参数
     * @return 跳转展示所有入库界面
     */
    @RequestMapping(name = "all-in-ware.html", value = "all-in-ware.html")
    public String allInWare(Model model) {
        List<Record> records = recordService.selectAllInRecord();
        model.addAttribute("records", records);
        return "all-in-ware";
    }

    /**
     * @param  model 传输数据
     * @return 进入添加入库界面
     */
    @RequestMapping(name = "add-in-ware.html", value = "add-in-ware.html")
    public String addInWare(Model model) {
        List<Entrepot> entrepots = entrepotService.selectAllEntrepot();
        List<Cargo> cargos = cargoService.selectAllCargo();
        model.addAttribute("cargos",cargos);
        model.addAttribute("entrepots",entrepots);
        return "add-in-ware";
    }
    
    /**
     * 增加入库
     * @param record 表单传入参数，入库信息
     * @param model 传递参数
     * @param session 利用session取出用户工号
     * @return 重定向到所有入库界面
     */
    @RequestMapping(name = "addRecordFun",value = "addRecordFun.html")
    public String addRecordFun(Record record, Model model, HttpSession session){
        Cargo cargo = cargoService.selectCargoById(record.getCargoId());
        record.setSumPrice(cargo.getPrice()*(Integer.parseInt(record.getNumber())));
        record.setOperation("入库");
        record.setPrice(cargo.getPrice());
        Entrepot entrepot = entrepotService.selectEntrepotById(record.getEntrepotId());
        entrepot.setNumber(String.valueOf(Integer.parseInt(entrepot.getNumber())+Integer.parseInt(record.getNumber())));
        entrepotService.updateEntrepotById(entrepot);
        int i = recordService.insertRecord(record);
        return "redirect:all-in-ware.html";
    }

    /**
     * 删除入库 通过id
     * @param id 入库id
     * @return 跳转所有入库界面
     */
    @RequestMapping(name = "deleteRecordFun" ,value = "deleteRecordFun.html")
    public String deleteRecordFun(String id){
        int i = recordService.deleteRecordById(id);
        return "redirect:all-in-ware.html";
    }

    /**
     *从所有入库进入查询某一个入库，然后渲染上页面
     * @param id 入库id
     * @param model 参数传递
     * @return 前往编辑入库界面
     */
    @RequestMapping(name = "editRecordFun",value = "editRecordFun.html")
    public String editNotionFun(String id,Model model){
        Record record = recordService.selectRecordInById(id);
        model.addAttribute("record",record);
        return "edit-in-ware";
    }

    /**
     * 获取入库信息，然后修改
     * @param record 入库信息
     * @param model 传递参数
     * @param session 获取用户session
     * @return 前往某一个入库编辑界面
     */
    @RequestMapping(name = "updateRecordFun",value = "updateRecordFun.html")
    public String updateRecordFun(Record record, Model model, HttpSession session){
        int i = recordService.updateRecordById(record);
        System.out.println(record.toString());
        return "redirect:editRecordFun.html?id="+record.getId();
    }

    @RequestMapping(name = "lookRecordInWare",value = "lookRecordInWare.html")
    public String lookRecordInWare(String id,Model model){
        Record record = recordService.selectRecordInById(id);
        Cargo cargo = cargoService.selectCargoById(record.getCargoId());
        Entrepot entrepot = entrepotService.selectEntrepotById(record.getEntrepotId());
        model.addAttribute("record",record);
        model.addAttribute("cargo",cargo);
        model.addAttribute("entrepot",entrepot);
        return "look-in-ware";
    }
}
