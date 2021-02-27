package cn.edu.gues.service.impl;

import cn.edu.gues.mapper.ClientMapper;
import cn.edu.gues.pojo.Client;
import cn.edu.gues.service.ClientService;
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
public class ClientServiceImpl implements ClientService {
    @Autowired
    private ClientMapper clientMapper;
    @Override
    public List<Client> selectAllClient() {
        return clientMapper.selectAllClient();
    }

    @Override
    public Client selectClientById(String id) {
        return clientMapper.selectClientById(id);
    }

    @Override
    public int insertClient(Client client) {
        client.setId(String.valueOf(UUID.randomUUID()));
        return clientMapper.insertClient(client);
    }

    @Override
    public int updateClientById(Client client) {
        return clientMapper.updateClientById(client);
    }

    @Override
    public int deleteClientById(String id) {
        return clientMapper.deleteClientById(id);
    }
}
