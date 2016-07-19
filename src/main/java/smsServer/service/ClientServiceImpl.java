package smsServer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import smsServer.model.Client;
import smsServer.repository.ClientRepository;
import smsServer.util.exception.ExceptionUtil;
import smsServer.util.exception.NotFoundException;

import java.util.List;

/**
 * GKislin
 * 06.03.2015.
 */
@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientRepository repository;

    public Client save(Client client) {
        return repository.save(client);
    }

    public void delete(int id) {
        ExceptionUtil.checkNotFoundWithId(repository.delete(id), id);
    }

    public Client get(int id) throws NotFoundException {
        return ExceptionUtil.checkNotFoundWithId(repository.get(id), id);
    }

    public Client getByPhoneNumber(String phoneNumber) throws NotFoundException {
        return ExceptionUtil.checkNotFound(repository.getByPhoneNumber(phoneNumber), "phonenumber=" + phoneNumber);
    }

    public List<Client> getAll() {
        return repository.getAll();
    }

    public void update(Client client) {
        repository.save(client);
    }
}
