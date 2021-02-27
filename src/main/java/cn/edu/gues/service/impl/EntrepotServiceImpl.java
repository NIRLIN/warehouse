package cn.edu.gues.service.impl;

import cn.edu.gues.mapper.EntrepotMapper;
import cn.edu.gues.pojo.Entrepot;
import cn.edu.gues.service.EntrepotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @author NIRLIN
 * @version 1.0
 * @date 2020/7/13 15:43
 */

@Service
public class EntrepotServiceImpl implements EntrepotService {

    @Autowired
    private EntrepotMapper entrepotMapper;
    @Override
    public List<Entrepot> selectAllEntrepot() {
        return entrepotMapper.selectAllEntrepot();
    }

    @Override
    public Entrepot selectEntrepotById(String id) {
        return entrepotMapper.selectEntrepotById(id);
    }

    @Override
    public int insertEntrepot(Entrepot entrepot) {
        entrepot.setCreateTime(new Date());
        entrepot.setId(String.valueOf(UUID.randomUUID()));
        entrepot.setNumber("0");
        return entrepotMapper.insertEntrepot(entrepot);
    }

    @Override
    public int updateEntrepotById(Entrepot entrepot) {
        entrepot.setCreateTime(new Date());
        return entrepotMapper.updateEntrepotById(entrepot);
    }

    @Override
    public int deleteEntrepotById(String id) {
        return entrepotMapper.deleteEntrepotById(id);
    }
}
