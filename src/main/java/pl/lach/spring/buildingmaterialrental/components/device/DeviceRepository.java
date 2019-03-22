package pl.lach.spring.buildingmaterialrental.components.device;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DeviceRepository extends JpaRepository<Device, Long> {

    List<Device> findAllByNameContainingIgnoreCase(String name);
}
