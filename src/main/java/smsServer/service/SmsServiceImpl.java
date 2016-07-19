package smsServer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import smsServer.model.Sms;
import smsServer.repository.SmsRepository;
import smsServer.util.exception.ExceptionUtil;
import java.util.Collection;

/**
 * GKislin
 * 06.03.2015.
 */
@Service
public class SmsServiceImpl implements SmsService {

    @Autowired
    private SmsRepository repository;


    public Sms get(int id, int userId) {
        return ExceptionUtil.checkNotFoundWithId(repository.get(id, userId), id);
    }


    public void delete(int id, int clientId) {
        ExceptionUtil.checkNotFoundWithId(repository.delete(id, clientId), id);
    }

    public Collection<Sms> getAll(int clientId) {
        return repository.getAll(clientId);
    }

    public Sms update(Sms sms, int userId) {
        return ExceptionUtil.checkNotFoundWithId(repository.save(sms, userId), sms.getId());
    }

    public Sms save(Sms sms, int clientId) {
        return repository.save(sms, clientId);
    }
}
