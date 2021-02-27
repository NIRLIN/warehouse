package cn.edu.gues.service.impl;

import cn.edu.gues.mapper.SupplierMapper;
import cn.edu.gues.pojo.Supplier;
import cn.edu.gues.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * @author NIRLIN
 * @version 1.0
 * @date 2020/7/13 15:44
 */
@Service
public class SupplierServiceImpl implements SupplierService {
    @Autowired
    private SupplierMapper supplierMapper;
    @Override
    public List<Supplier> selectAllSupplier() {
        return supplierMapper.selectAllSupplier();
    }

    @Override
    public Supplier selectSupplierById(String id) {
        return supplierMapper.selectSupplierById(id);
    }

    @Override
    public int insertSupplier(Supplier supplier) {
        supplier.setId(String.valueOf(UUID.randomUUID()));
        return supplierMapper.insertSupplier(supplier);
    }

    @Override
    public int updateSupplierById(Supplier supplier) {
        return supplierMapper.updateSupplierById(supplier);
    }

    @Override
    public int deleteSupplierById(String id) {
        return supplierMapper.deleteSupplierById(id);
    }
}
