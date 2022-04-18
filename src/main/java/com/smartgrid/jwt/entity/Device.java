package com.smartgrid.jwt.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Device {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name="device_name")
    private String deviceName;
    @Column(name="device_status")
    private String deviceStatus;


    public Device() {

    }


    public Device(int id, String deviceName, String deviceStatus) {
        super();
        this.id = id;
        this.deviceName = deviceName;
        this.deviceStatus = deviceStatus;
    }
    public long getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getDeviceName() {
        return deviceName;
    }
    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }
    public String getDeviceStatus() {
        return deviceStatus;
    }
    public void setDeviceStatus(String deviceStatus) {
        this.deviceStatus = deviceStatus;
    }

}
