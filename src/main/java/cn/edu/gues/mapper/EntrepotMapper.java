package cn.edu.gues.mapper;

import cn.edu.gues.pojo.Entrepot;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author NIRLIN
 * @version 1.0
 * @date 2020/7/13 15:40
 */

@Mapper
@Repository
public interface EntrepotMapper {
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
