package client;

import java.io.Serializable;

public class Client implements Serializable {
    private String username;
    private int id;
    private int pin;
    private long cashSize;

    public Client(){}
    public Client(String username, int pin, int id){
        this.username = username;
        this.pin = pin;
        this.id = id;
    }
    public Client(String username, int pin, int id, long cashSize){
        this.username = username;
        this.pin = pin;
        this.id = id;
        this.cashSize = cashSize;
    }

    public String getUsername() {
        return username;
    }
    public long getPin() {
        return pin;
    }
    public long getCashSize() {
        return cashSize;
    }
    public int getId() {
        return id;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    public void setPin(int pin) {
        this.pin = pin;
    }
    public void setCashSize(long cashSize) {
        this.cashSize = cashSize;
    }
}
