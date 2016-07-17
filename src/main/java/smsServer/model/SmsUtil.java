package smsServer.model;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class SmsUtil {
    static Client client1=new Client(100001,"Lol","Good","+3804535345",0);
    static Client client2=new Client(100002,"Lol2","Good","+380234234",0);
    static Timestamp dateTime;
    static DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    //заполнение списка тестовыми данными
    public static final List<Sms> SMS_LIST = Arrays.asList(
            new Sms(client1,100003,doTime(dateFormat),"Hello1",true),
            new Sms(client2,100004,doTime(dateFormat),"Hello2",true)
    );
    public static final List<Client> CLIENT_LIST = Arrays.asList(
            client1,
            client2
    );


// инициализация ТаймШтамп
   static Timestamp doTime(DateFormat dateFormat)
    {
        Date date = null;
        try {
            date = dateFormat.parse("2007-09-23");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        long time = date.getTime();
        return new Timestamp(time);
    }

}
