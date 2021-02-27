package cn.edu.gues.mapper;

import cn.edu.gues.pojo.Supplier;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author NIRLIN
 * @version 1.0
 * @date 2020/7/13 15:41
 */

@Mapper
@Repository
public interface SupplierMapper {
    /**
     * 功能：查询所有供应商
     * 异常：为SQL异常
     *
     * @return List<Supplier>
     */
    List<Supplier> selectAllSupplier();

    /**
     * 功能：根据id查询供应商
     * 异常：SQL异常
     *
     * @param id Supplier的id
     * @return Supplier
     */
    Supplier selectSupplierById(String id);

    /**
     * 功能：供应商插入数据库
     * 异常：SQL异常
     *
     * @param supplier Supplier
     * @return int
     */
    int insertSupplier(Supplier supplier);

    /**
     * 功能：据供应商id修改供应商信息
     * 异常：SQL异常
     *
     * @param supplier Supplier
     * @return int
     */
    int updateSupplierById(Supplier supplier);

    /**
     * 功能：根据id删除供应商
     * 异常：SQL异常
     *
     * @param id Supplier的id
     * @return int
     */
    int deleteSupplierById(String id);
}
