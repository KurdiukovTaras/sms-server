package smsServer.model;


import java.sql.Timestamp;

public class Sms
{
    private Client client;
    private Integer id;
    private Timestamp datetime;
    private String message;
    private Boolean readed;

    public Sms(){}
    public Sms(Client client,int id,Timestamp datetime,String message,boolean readed)
    {
        this.client=client;
        this.id=id;
        this.datetime=datetime;
        this.message=message;
        this.readed=readed;
    }

    //Геттеры и сеттеры
    public Client getClient() {return client;}
    public int getId() {return id;}
    public Timestamp getDatetime() {return datetime;}
    public String getMessage() {return message;}
    public boolean isNew() {return (this.id == null);}
    public void setClient(Client client) {this.client = client;}
    public void setId(int id) {this.id = id;}
    public void setDatetime(Timestamp datetime) {this.datetime = datetime;}
    public void setMessage(String message) {this.message = message;}
    public void setReaded(Boolean readed) {this.readed = readed;}
    public Boolean getReaded() {return readed;}

}
