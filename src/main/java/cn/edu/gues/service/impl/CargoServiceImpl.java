package cn.edu.gues.service.impl;

import cn.edu.gues.mapper.CargoMapper;
import cn.edu.gues.pojo.Cargo;
import cn.edu.gues.service.CargoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * @author NIRLIN
 * @version 1.0
 * @date 2020/7/13 15:43
 */

@Service
public class CargoServiceImpl implements CargoService {
    @Autowired
    private CargoMapper cargoMapper;

    @Override
    public List<Cargo> selectAllCargo() {
        return cargoMapper.selectAllCargo();
    }

    @Override
    public Cargo selectCargoById(String id) {
        return cargoMapper.selectCargoById(id);
    }

    @Override
    public int insertCargo(Cargo cargo) {
        cargo.setId(String.valueOf(UUID.randomUUID()));
        return cargoMapper.insertCargo(cargo);
    }

    @Override
    public int updateCargoById(Cargo cargo) {
        return cargoMapper.updateCargoById(cargo);
    }

    @Override
    public int deleteCargoById(String id) {
        return cargoMapper.deleteCargoById(id);
    }

    @Override
    public List<Cargo> selectCargoBySupplierId(String supplierId) {
        return cargoMapper.selectCargoBySupplierId(supplierId);
    }
}
