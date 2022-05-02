package ar.edu.unlp.info.bd2.model;
import java.util.Collection;

public class Centre {
    private String name;
    private Collection<Personal> staff;


    public void setId(Interger id) {
        this.id = id;
    }

    public Centre(String name, Collection<Personal> staff) {
        this.name = name;
        this.staff = staff;
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
