package cn.edu.gues.service.impl;

import cn.edu.gues.mapper.RecordMapper;
import cn.edu.gues.pojo.Record;
import cn.edu.gues.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @author NIRLIN
 * @version 1.0
 * @date 2020/7/13 15:44
 */

@Service
public class RecordServiceImpl implements RecordService {
    @Autowired
    private RecordMapper recordMapper;


    @Override
    public List<Record> selectAllInRecord() {
        return recordMapper.selectAllInRecord();
    }
    @Override
    public List<Record> selectAllOutRecord() {
        return recordMapper.selectAllOutRecord();
    }

    @Override
    public Record selectRecordInById(String id) {
        return recordMapper.selectRecordInById(id);
    }

    @Override
    public Record selectRecordOutById(String id) {
        return recordMapper.selectRecordOutById(id);
    }

    @Override
    public int insertRecord(Record record) {
        record.setId(String.valueOf(UUID.randomUUID()));
        record.setCreateTime(new Date());
        return recordMapper.insertRecord(record);
    }

    @Override
    public int updateRecordById(Record record) {
        return recordMapper.updateRecordById(record);
    }

    @Override
    public int deleteRecordById(String id) {
        return recordMapper.deleteRecordById(id);
    }

    @Override
    public int ifCargoNum(String cargoId) {
        List<Record> records = recordMapper.ifCargoNum(cargoId);
        int a=0;
        int b=0;
        for (Record record : records) {
            if ("入库".equals(record.getOperation())){
                a=a+Integer.parseInt(record.getNumber());
            }
            if ("出库".equals(record.getOperation())){
                b=b+Integer.parseInt(record.getNumber());
            }
        }
        return a-b;
    }

    @Override
    public List<Record> selectTwoGet(String entrepotId) {
        return recordMapper.selectTwoGet(entrepotId);
    }
}
