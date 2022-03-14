package mercuryWebApp.service;

import mercuryWebApp.dao.DeviceDao;
import mercuryWebApp.models.Device;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeviceService {
    @Autowired
    private DeviceDao deviceDao;

    public void saveDevice(Device device) {
        deviceDao.save(device);
    }

    public Device readDevice(int id) {
        return deviceDao.read(id);
    }

    public void updateDevice(Device device) {
        deviceDao.update(device);
    }

    public void delete(Device device) {
        deviceDao.delete(device);
    }

    public List<Device> allDevice() {
        return deviceDao.allDevice();
    }
}
