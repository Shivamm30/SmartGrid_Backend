package com.smartgrid.jwt.dao;

import com.smartgrid.jwt.entity.Device;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeviceRepository extends JpaRepository<Device, Long> {
}
