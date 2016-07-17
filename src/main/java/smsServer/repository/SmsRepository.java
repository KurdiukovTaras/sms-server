package smsServer.repository;

import smsServer.model.Sms;
import java.util.Collection;

/**
 * GKislin
 * 06.03.2015.
 */
public interface SmsRepository {
    // null if updated sms do not belong to clientId
    Sms save(Sms sms, int clientId);

    // false if sms do not belong to clientId
    boolean delete(int id, int clientId);

    // null if sms do not belong to clientId
    Sms get(int id, int clientId);

    // ORDERED dateTime
    Collection<Sms> getAll(int clientId);

    // ORDERED dateTime
//    Collection<Sms> getBetween(LocalDateTime startDate, LocalDateTime endDate, int clientId);
}
