package smsServer.service;
import smsServer.model.Client;
import smsServer.util.exception.NotFoundException;
import java.io.NotActiveException;
import java.util.List;

public interface ClientService {
    Client save(Client client);

    void delete(int id) throws NotFoundException;

    Client get(int id) throws NotFoundException;

    Client getByEmail(String email) throws NotFoundException;

    List<Client> getAll();

    void update(Client client);
}
