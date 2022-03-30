package mercuryWebApp.models;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "podstation", schema = "public", catalog = "mercury2022")
public class Podstation {
    @Column(nullable = false)
    private long id;
    private String name;
    private char typeConnection;
    private Long parentId;
    private Device device;
    private Res resByResId;
    private Podstation parent;

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(generator= "podstation_id_seq")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name", nullable = true, length = -1)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "type_connection", nullable = true, length = -1)
    public char getTypeConnection() {
        return typeConnection;
    }

    public void setTypeConnection(char typeConnection) {
        this.typeConnection = typeConnection;
    }

    @Basic
    @Column(name = "parent_id", nullable = true)
    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Podstation that = (Podstation) o;
        return id == that.id &&
                Objects.equals(name, that.name) &&
                Objects.equals(typeConnection, that.typeConnection) &&
                Objects.equals(parentId, that.parentId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, typeConnection, parentId);
    }

    @ManyToOne
    @JoinColumn(name = "device_id", referencedColumnName = "id")
    public Device getDevice() {
        return device;
    }

    public void setDevice(Device device) {
        this.device = device;
    }

    @ManyToOne
    @JoinColumn(name = "res_id", referencedColumnName = "id")
    public Res getResByResId() {
        return resByResId;
    }

    public void setResByResId(Res resByResId) {
        this.resByResId = resByResId;
    }

    @ManyToOne(optional = false)
    @JoinColumn(name = "parent_id", referencedColumnName = "id", insertable = false, updatable = false)
    public Podstation getParent() {
        return parent;
    }

    public void setParent(Podstation parent) {
        this.parent = parent;
    }

    @Override
    public String toString() {
        return "Podstation{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", typeConnection=" + typeConnection +
                ", parentId=" + parentId +
                ", device=" + device +
                ", resByResId=" + resByResId +
                '}';
    }
}
