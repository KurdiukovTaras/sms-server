package smsServer.model;


public class Client {

    private Integer id;
    private String name;
    private String description;
    private String phoneNumber;
    private int numberOfSms;

    public Client(){}
    public Client(int id,String name,String description,String phoneNumber, int numberOfSms)
    {
        this.id=id;
        this.name=name;
        this.description=description;
        this.phoneNumber=phoneNumber;
        this.numberOfSms=numberOfSms;
    }

    @Override
    public String toString() {
        return getName();
    }
    //getter i setter
    public int getId() {return id;}
    public String getName() {return name;}
    public String getDescription() {return description;}
    public String getPhoneNumber() {return phoneNumber;}
    public int getNumberOfSms() {return numberOfSms;}
    public void setId(int id) {this.id = id;}
    public boolean isNew() {return (this.id == null);}
    public void setName(String name) {this.name = name;}
    public void setDescription(String description) {this.description = description;}
    public void setPhoneNumber(String phoneNumber) {this.phoneNumber = phoneNumber;}
    public void setNumberOfSms(int numberOfSms) {this.numberOfSms = numberOfSms;}
}
