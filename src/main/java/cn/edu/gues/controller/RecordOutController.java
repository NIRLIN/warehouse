package cn.edu.gues.controller;

import cn.edu.gues.pojo.Cargo;
import cn.edu.gues.pojo.Entrepot;
import cn.edu.gues.pojo.Record;
import cn.edu.gues.service.impl.CargoServiceImpl;
import cn.edu.gues.service.impl.EntrepotServiceImpl;
import cn.edu.gues.service.impl.RecordServiceImpl;
import com.alibaba.fastjson.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.UUID;

/**
 * @author NIRLIN
 * @version 1.0
 * @date 2020/7/15 17:02
 */

@Controller
public class RecordOutController {
    @Autowired
    private RecordServiceImpl recordService;
    @Autowired
    private EntrepotServiceImpl entrepotService;
    @Autowired
    private CargoServiceImpl cargoService;

    /**
     * 查看所有出库记录
     * @param model 传输数据
     * @return 进入所有出库记录
     */
    @RequestMapping(name = "all-out-ware.html", value = "all-out-ware.html")
    public String allOutWare(Model model) {
        List<Record> records = recordService.selectAllOutRecord();
        model.addAttribute("records", records);
        return "all-out-ware";
    }



    @RequestMapping(name = "lookRecordOutWare",value = "lookRecordOutWare.html")
    public String lookRecordOutWare(String id,Model model){
        Record record = recordService.selectRecordOutById(id);
        Cargo cargo = cargoService.selectCargoById(record.getCargoId());
        Entrepot entrepot = entrepotService.selectEntrepotById(record.getEntrepotId());
        model.addAttribute("record",record);
        model.addAttribute("cargo",cargo);
        model.addAttribute("entrepot",entrepot);
        return "look-out-ware";
    }

    @RequestMapping(name = "add-out-ware.html", value = "add-out-ware.html")
    public String addOutWare(Model model) {
        List<Entrepot> entrepots = entrepotService.selectAllEntrepot();
        List<Cargo> cargos = cargoService.selectAllCargo();
        List<Record> records = recordService.selectAllInRecord();
        model.addAttribute("cargos",cargos);
        model.addAttribute("entrepots",entrepots);
        model.addAttribute("records",records);
        return "add-out-ware";
    }
    @ResponseBody
    @RequestMapping(name = "selectTwoGet",value = "selectTwoGet.html")
    public String selectTwoGet(String entrepotId){
        System.out.println(entrepotId);
        List<Record> records = recordService.selectTwoGet(entrepotId);
        System.out.println(records.toString());
        JSONArray jsonArray=new JSONArray();
        HashSet<String> hashSet=new HashSet<>();
        for (Record record : records) {
            hashSet.add(record.getCargoId());
        }
        for (String s : hashSet) {
            Cargo cargo = cargoService.selectCargoById(s);
            jsonArray.add(cargo);
        }
        System.out.println(jsonArray);
        return jsonArray.toJSONString();
    }

    @RequestMapping(name = "addOutWarehouse",value = "addOutWarehouse.html")
    public String addOutWarehouse(String entrepotId,String cargoId,String number){
        Entrepot entrepot = entrepotService.selectEntrepotById(entrepotId);
        Cargo cargo = cargoService.selectCargoById(cargoId);
        Record record=new Record();
        record.setId(String.valueOf(UUID.randomUUID()));
        record.setCargoId(cargoId);
        record.setEntrepotId(entrepotId);
        record.setOperation("出库");
        record.setPrice(cargo.getPrice());
        record.setNumber(number);
        record.setSumPrice(cargo.getPrice()*Integer.parseInt(number));
        record.setCreateTime(new Date());
        int i1 = recordService.insertRecord(record);
        entrepot.setNumber(String.valueOf(Integer.parseInt(entrepot.getNumber())-Integer.parseInt(number)));
        int i = entrepotService.updateEntrepotById(entrepot);
        return "redirect:all-out-ware.html";
    }

}
