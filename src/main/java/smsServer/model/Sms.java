package smsServer.model;


import java.sql.Timestamp;

public class Sms
{
    private Client client;
    private int id;
    private Timestamp datetime;
    private String message;
    private Boolean isNew;

    public Sms(){}
    public Sms(Client client,int id,Timestamp datetime,String message,boolean isNew)
    {
        this.client=client;
        this.id=id;
        this.datetime=datetime;
        this.message=message;
        this.isNew=isNew;
    }

    //Геттеры и сеттеры
    public Client getClient() {return client;}
    public int getId() {return id;}
    public Timestamp getDatetime() {return datetime;}
    public String getMessage() {return message;}
    public boolean isIsNew() {return isNew;}
    public void setClient(Client client) {this.client = client;}
    public void setId(int id) {this.id = id;}
    public void setDatetime(Timestamp datetime) {this.datetime = datetime;}
    public void setMessage(String message) {this.message = message;}
    public void setIsNew(boolean aNew) {isNew = aNew;}

}
