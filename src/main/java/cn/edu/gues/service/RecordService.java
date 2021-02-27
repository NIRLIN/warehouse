package cn.edu.gues.service;

import cn.edu.gues.pojo.Record;

import java.util.List;

/**
 * @author NIRLIN
 * @version 1.0
 * @date 2020/7/13 15:44
 */
public interface RecordService {
    /**
     * 功能：查询所有入库通知
     * 异常：为SQL异常
     *
     * @return List<Record>
     */
    List<Record> selectAllInRecord();

    /**
     * 功能：查询所有出库通知
     * 异常：为SQL异常
     *
     * @return List<Record>
     */
    List<Record> selectAllOutRecord();

    /**
     * 功能：根据id查询通知入库
     * 异常：SQL异常
     *
     * @param id Record的id
     * @return Record
     */
    Record selectRecordInById(String id);

    /**
     * 功能：根据id查询出库
     * 异常：SQL异常
     *
     * @param id Record的id
     * @return Record
     */
    Record selectRecordOutById(String id);
    /**
     * 功能：通知插入数据库
     * 异常：SQL异常
     *
     * @param record Record
     * @return int
     */
    int insertRecord(Record record);

    /**
     * 功能：据通知id修改通知信息
     * 异常：SQL异常
     *
     * @param record Record
     * @return int
     */
    int updateRecordById(Record record);

    /**
     * 功能：根据id删除通知
     * 异常：SQL异常
     *
     * @param id Record的id
     * @return int
     */
    int deleteRecordById(String id);

    /**
     * 查询商品出入库平衡
     * @param cargoId 商品id
     * @return 出入库记录
     */
    int ifCargoNum(String cargoId);

    List<Record> selectTwoGet(String entrepotId);


}
