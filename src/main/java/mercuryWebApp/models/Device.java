package mercuryWebApp.models;


import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "device", schema = "public", catalog = "mercury2022")
public class Device {
    private long id;
    private String ip;
    private int port;
    private int serialNumber;
    private Integer networkAdress;
    private Res res;
    private Podstation podstation;

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(generator = "device_id_seq")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "ip", nullable = false, length = 15)
    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    @Basic
    @Column(name = "port", nullable = false)
    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    @Basic
    @Column(name = "serial_number", nullable = false)
    public int getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(int serialNumber) {
        this.serialNumber = serialNumber;
    }

    @Basic
    @Column(name = "network_adress", nullable = true)
    public Integer getNetworkAdress() {
        return networkAdress;
    }

    public void setNetworkAdress(Integer networkAdress) {
        this.networkAdress = networkAdress;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Device device = (Device) o;
        return id == device.id &&
                port == device.port &&
                serialNumber == device.serialNumber &&
                Objects.equals(ip, device.ip) &&
                Objects.equals(networkAdress, device.networkAdress);
    }


    @Override
    public int hashCode() {
        return Objects.hash(id, ip, port, serialNumber, networkAdress);
    }

    @ManyToOne
    @JoinColumn(name = "res_id", referencedColumnName = "id")
    public Res getRes() {
        return res;
    }

    public void setRes(Res res) {
        this.res = res;
    }

    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "podstation_id", referencedColumnName = "id")
    public Podstation getPodstation() {
        return podstation;
    }

    public void setPodstation(Podstation podstation) {
        this.podstation = podstation;
    }

    @Override
    public String toString() {
        return "Device{" +
                "id=" + id +
                ", ip='" + ip + '\'' +
                ", port=" + port +
                ", serialNumber=" + serialNumber +
                ", networkAdress=" + networkAdress +
                '}';
    }

}
