package com.company;

public class MobilePhone extends Product {
    private int ram;
    private int storage;
    private double screenSize;
    private int batterySize;
    private String color;

    public MobilePhone(){}
    public MobilePhone(int id, double price, double discount, int stock, String name, Brand brand, int ram, int storage, double screenSize, int batterySize, String color) {
        super(id, price, discount, stock, name, brand);
        this.ram = ram;
        this.storage = storage;
        this.screenSize = screenSize;
        this.batterySize = batterySize;
        this.color = color;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public int getStorage() {
        return storage;
    }

    public void setStorage(int storage) {
        this.storage = storage;
    }

    public double getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(double screenSize) {
        this.screenSize = screenSize;
    }

    public int getBatterySize() {
        return batterySize;
    }

    public void setBatterySize(int batterySize) {
        this.batterySize = batterySize;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
