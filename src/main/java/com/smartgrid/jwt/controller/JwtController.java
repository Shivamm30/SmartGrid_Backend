package com.smartgrid.jwt.controller;

import com.smartgrid.jwt.dao.DeviceRepository;
import com.smartgrid.jwt.entity.Device;
import com.smartgrid.jwt.entity.JwtRequest;
import com.smartgrid.jwt.entity.JwtResponse;
import com.smartgrid.jwt.service.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class JwtController {

    @Autowired
    DeviceRepository deviceRepository;

    @Autowired
    private JwtService jwtService;

    @PostMapping({"/authenticate"})
    public JwtResponse createJwtToken(@RequestBody JwtRequest jwtRequest) throws Exception {
        return jwtService.createJwtToken(jwtRequest);
    }

    // Get All Devices

    @GetMapping("/devices")
    public List<Device> message() {
        return deviceRepository.findAll();
    }

    // Insert New devices
    @PostMapping("/devices")
    public Device addDevice(@RequestBody Device dev) {
        Device getDev = deviceRepository.save(dev);
        return getDev;
    }

    // get device by id
    @GetMapping("/devices/{id}")
    public ResponseEntity<Device> getDeviceById(@PathVariable Long id){
        Device getDev =   deviceRepository.getOne(id);
        return ResponseEntity.ok().body(getDev);
    }

    // UPdate devices
    @PutMapping("/devices/{id}")
    public ResponseEntity<Device> updateDeviceById(@PathVariable Long id,
                                                   @RequestBody Device device){
        Device getDev =   deviceRepository.getOne(id);
        getDev.setDeviceName(device.getDeviceName());
        getDev.setDeviceStatus(device.getDeviceStatus());

        Device updateDev = deviceRepository.save(getDev);
        return ResponseEntity.ok().body(updateDev);
    }

    // Delete Device by id
    @DeleteMapping("/devices/{id}")
    public String deleteDeviceById(@PathVariable Long id){
        Device getDev =   deviceRepository.getOne(id);
        deviceRepository.delete(getDev);
        return "Record Deleted";
    }



}
