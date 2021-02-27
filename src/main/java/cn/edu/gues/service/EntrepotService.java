package cn.edu.gues.service;

import cn.edu.gues.pojo.Entrepot;

import java.util.List;

/**
 * @author NIRLIN
 * @version 1.0
 * @date 2020/7/13 15:43
 */

public interface EntrepotService {
    /**
     * 功能：查询所有仓库
     * 异常：为SQL异常
     *
     * @return List<Entrepot>
     */
    List<Entrepot> selectAllEntrepot();

    /**
     * 功能：根据id查询仓库
     * 异常：SQL异常
     *
     * @param id Entrepot的id
     * @return Entrepot
     */
    Entrepot selectEntrepotById(String id);

    /**
     * 功能：仓库插入数据库
     * 异常：SQL异常
     *
     * @param entrepot Entrepot
     * @return int
     */
    int insertEntrepot(Entrepot entrepot);

    /**
     * 功能：据仓库id修改仓库信息
     * 异常：SQL异常
     *
     * @param entrepot Entrepot
     * @return int
     */
    int updateEntrepotById(Entrepot entrepot);

    /**
     * 功能：根据id删除仓库
     * 异常：SQL异常
     *
     * @param id Entrepot的id
     * @return int
     */
    int deleteEntrepotById(String id);
}
