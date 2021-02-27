package cn.edu.gues.mapper;

import cn.edu.gues.pojo.Client;
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
public interface ClientMapper {
    /**
     * 功能：查询所有客户
     * 异常：为SQL异常
     *
     * @return List<Client>
     */
    List<Client> selectAllClient();

    /**
     * 功能：根据id查询商品
     * 异常：SQL异常
     *
     * @param id Client的id
     * @return Client
     */
    Client selectClientById(String id);

    /**
     * 功能：商品插入数据库
     * 异常：SQL异常
     *
     * @param client Client
     * @return int
     */
    int insertClient(Client client);

    /**
     * 功能：据商品id修改商品信息
     * 异常：SQL异常
     *
     * @param client Client
     * @return int
     */
    int updateClientById(Client client);

    /**
     * 功能：根据id删除商品
     * 异常：SQL异常
     *
     * @param id Client的id
     * @return int
     */
    int deleteClientById(String id);
}
