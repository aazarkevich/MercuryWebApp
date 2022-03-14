package mercuryWebApp.models;


import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "data", schema = "public", catalog = "mercury2022")
public class Data {
    private long id;
    private String energyResetSum;
    private String powerSum;
    private String energyDayStart;
    private String energyDay;
    private String powerDay;
    private String error;
    private Date date;

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(generator= "data_id_seq")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "energy_reset_sum", nullable = true, length = 255)
    public String getEnergyResetSum() {
        return energyResetSum;
    }

    public void setEnergyResetSum(String energyResetSum) {
        this.energyResetSum = energyResetSum;
    }

    @Basic
    @Column(name = "power_sum", nullable = true, length = 255)
    public String getPowerSum() {
        return powerSum;
    }

    public void setPowerSum(String powerSum) {
        this.powerSum = powerSum;
    }

    @Basic
    @Column(name = "energy_day_start", nullable = true, length = 255)
    public String getEnergyDayStart() {
        return energyDayStart;
    }

    public void setEnergyDayStart(String energyDayStart) {
        this.energyDayStart = energyDayStart;
    }

    @Basic
    @Column(name = "energy_day", nullable = true, length = 255)
    public String getEnergyDay() {
        return energyDay;
    }

    public void setEnergyDay(String energyDay) {
        this.energyDay = energyDay;
    }

    @Basic
    @Column(name = "power_day", nullable = true, length = 255)
    public String getPowerDay() {
        return powerDay;
    }

    public void setPowerDay(String powerDay) {
        this.powerDay = powerDay;
    }

    @Basic
    @Column(name = "error", nullable = true, length = 255)
    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    @Basic
    @Column(name = "date", nullable = true)
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Data data = (Data) o;
        return id == data.id &&
                Objects.equals(energyResetSum, data.energyResetSum) &&
                Objects.equals(powerSum, data.powerSum) &&
                Objects.equals(energyDayStart, data.energyDayStart) &&
                Objects.equals(energyDay, data.energyDay) &&
                Objects.equals(powerDay, data.powerDay) &&
                Objects.equals(error, data.error) &&
                Objects.equals(date, data.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, energyResetSum, powerSum, energyDayStart, energyDay, powerDay, error, date);
    }
}
