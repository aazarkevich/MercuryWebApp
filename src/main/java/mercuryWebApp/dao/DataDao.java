package mercuryWebApp.dao;

import mercuryWebApp.models.Data;

import java.sql.Date;
import java.util.List;

public interface DataDao {
    void save(Data data);

    Data read(int id);

    void update(Data data);

    void delete(Data data);

    List<Data> valuesToDay();

    List<Data> valuesChoiseDay(Date date);


}
