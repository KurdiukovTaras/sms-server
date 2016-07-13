package smsServer.model;

import java.security.Timestamp;

public class Sms
{
    public Sms(){}
    private Client client;
    private int id;
    private Timestamp datetime;
    private String message;
    private boolean isNew;
}
