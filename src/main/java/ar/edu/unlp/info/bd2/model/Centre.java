package ar.edu.unlp.info.bd2.model;
import java.util.Collection;
import javax.persistence.*;

@Entity
@Table ( name  = "centre")
public class Centre {
    @Id
    @GeneratedValue
    @Column( name = "id", nullable = false)
    private Integer id;

    @Column( name = "name")
    private String name;
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(
            name = "centre_personal",
            joinColumns = {@JoinColumn(name = "centreId")},
            inverseJoinColumns = {@JoinColumn(name = "personalId")}
    )
    private Collection<Personal> staff;

    public Centre() {
    }
    public Centre(String name) {
        this.name = name;
    }


    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getId() {
        return id;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Collection<Personal> getStaffs() {
        return staff;
    }

    public void setStaff(Collection<Personal> staff) {
        this.staff = staff;
    }

    public void addStaff(Personal staff) {
        this.staff.add(staff);
    }
}
