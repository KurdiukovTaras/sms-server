package smsServer.repository;

import smsServer.model.Client;
import java.util.List;

/**
 * User: gkislin
 * Date: 22.08.2014
 */
public interface ClientRepository {
    Client save(Client client);

    // false if not found
    boolean delete(int id);

    // null if not found
    Client get(int id);

    // null if not found
    Client getByPhoneNumber(String phoneNumber);

    List<Client> getAll();
}
