package cn.edu.gues.service;

import cn.edu.gues.pojo.Cargo;

import java.util.List;

/**
 * @author NIRLIN
 * @version 1.0
 * @date 2020/7/13 15:43
 */

public interface CargoService {
    /**
     * 功能：查询所有商品
     * 异常：为SQL异常
     *
     * @return List<Cargo>
     */
    List<Cargo> selectAllCargo();

    /**
     * 功能：根据id查询商品
     * 异常：SQL异常
     *
     * @param id Cargo的id
     * @return Cargo
     */
    Cargo selectCargoById(String id);

    /**
     * 功能：商品插入数据库
     * 异常：SQL异常
     *
     * @param cargo Cargo
     * @return int
     */
    int insertCargo(Cargo cargo);

    /**
     * 功能：据商品id修改商品信息
     * 异常：SQL异常
     *
     * @param cargo Cargo
     * @return int
     */
    int updateCargoById(Cargo cargo);

    /**
     * 功能：根据id删除商品
     * 异常：SQL异常
     *
     * @param id Cargo的id
     * @return int
     */
    int deleteCargoById(String id);

    /**
     * 查询对应供应商是否有商品存在
     * @param supplierId 供应商id
     * @return 商品
     */
    List<Cargo> selectCargoBySupplierId(String supplierId);
}
