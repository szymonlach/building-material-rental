package pl.lach.spring.buildingmaterialrental.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.lach.spring.buildingmaterialrental.model.Device;

@Repository
public interface DeviceRepository extends JpaRepository<Device, Long> {
}
