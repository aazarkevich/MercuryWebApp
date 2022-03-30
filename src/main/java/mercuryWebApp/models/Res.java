package mercuryWebApp.models;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "res", schema = "public", catalog = "mercury2022")
public class Res {

    private long id;
    private String name;

    @Id
    @Column(name = "id", nullable = false)
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

    public void setName(String values) {
        this.name = values;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Res res = (Res) o;
        return id == res.id &&
                Objects.equals(name, res.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
