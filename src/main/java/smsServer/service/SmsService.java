package smsServer.service;


import smsServer.model.Sms;
import smsServer.util.exception.NotFoundException;


import java.util.Collection;

/**
 * GKislin
 * 15.06.2015.
 */
public interface SmsService {
    Sms get(int id, int clientId) throws NotFoundException;

    void delete(int id, int userId) throws NotFoundException;

    Collection<Sms> getAll(int clientId);

    Sms update(Sms sms, int clientId) throws NotFoundException;

    Sms save(Sms sms, int clientId);
}
