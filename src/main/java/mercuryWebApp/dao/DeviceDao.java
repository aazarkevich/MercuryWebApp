package mercuryWebApp.dao;

import mercuryWebApp.models.Device;

import java.util.List;

public interface DeviceDao {
    void save(Device device);

    Device read(int id);

    void update(Device device);

    void delete(Device device);

    List<Device> allDevice();

}
