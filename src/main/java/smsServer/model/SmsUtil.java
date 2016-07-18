package smsServer.model;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class SmsUtil {
     Client client1=new Client(100001,"David","Good","+3804535345",0);
     Client client2=new Client(100002,"Maxim","Good","+380234234",0);
     Timestamp dateTime;
     DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    //заполнение списка тестовыми данными
    public  Map<Integer,Sms> SMS_LIST = new ConcurrentHashMap<Integer, Sms>();
    private  AtomicInteger counter = new AtomicInteger(0);
    {
        save(new Sms(client1, 100003, doTime(dateFormat), "Hello1 My name is David", true));
        save(new Sms(client2, 100004, doTime(dateFormat), "Hello2 my darling", true));
        save(new Sms(client1, 100003, doTime(dateFormat), "Its my second sms, where are you?", true));
        save(new Sms(client2, 100004, doTime(dateFormat), "Fuck off, you little bitch!", true));
    }
    public  Sms save(Sms sms){
        return SMS_LIST.put(counter.incrementAndGet(),sms);
    }
    public  List<Client> CLIENT_LIST = Arrays.asList(
            client1,
            client2
    );


// инициализация ТаймШтамп
   static Timestamp doTime(DateFormat dateFormat)
    {
        Date date = null;

        try {
            date = dateFormat.parse("2007-09-23 12:43:29");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        long time = date.getTime();
        return new Timestamp(time);
    }
    public List<Sms> getById(Map<Integer,Sms> list,int id)
    {
        List<Sms> list2=new ArrayList<Sms>();
        for (Map.Entry<Integer,Sms> map: list.entrySet()) {
            if (map.getValue().getClient().getId() == id) {
                list2.add(map.getValue());
            }
        }
        return list2;
    }
    public Client getByClientId(List<Client> list,int id)
    {
        Client clientById=null;
        for (Client client:list) {
            if (client.getId() == id) {
              clientById=client;
            }
        }
        return clientById;
    }

    public List<Sms> addSms(String message,int clientId)
    {
        Sms sms=new Sms(getByClientId(CLIENT_LIST,clientId),clientId,new Timestamp(new Date().getTime()),message,true);
        save(sms);
        return getById(SMS_LIST,clientId);
    }

    public List<Sms> getAll(Map<Integer,Sms> map)
    {
        List<Sms> list=new ArrayList<Sms>();
        for (Map.Entry<Integer,Sms> map1:map.entrySet()) {
            list.add(map1.getValue());
        }
        return list;
    }

}
