package mercuryWebApp.service;

import mercuryWebApp.dao.DataDao;
import mercuryWebApp.models.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
public class DataService {
    @Autowired
    private DataDao dataDao;

    public void saveData(Data data) {
        dataDao.save(data);
    }

    public Data readData(int id) {
        return dataDao.read(id);
    }

    public void updateData(Data data) {
        dataDao.update(data);
    }

    public void deleteData(Data data) {
        dataDao.delete(data);
    }

    public List<Data> valuesToDay() {
        return dataDao.valuesToDay();
    }

    public List<Data> valuesChoiseDay(Date date) {
        return dataDao.valuesChoiseDay(date);
    }

}
