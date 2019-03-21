package pl.lach.spring.buildingmaterialrental.repository;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.lach.spring.buildingmaterialrental.model.Device;

@Transactional
@Repository
public class DeviceDao extends GenericDao<Device, Long> {
}
