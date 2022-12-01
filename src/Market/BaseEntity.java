package Market;

import java.util.Date;

public abstract class BaseEntity {
    private Long id;
    private String name;
    private boolean active;
    private Date addDate;

    public BaseEntity(Long id, String name, boolean active, Date addDate) {
        this.id = id;
        this.name = name;
        this.active = active;
        this.addDate = addDate;
    }

    public BaseEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Date getAddDate() {
        return addDate;
    }

    public void setAddDate(Date addDate) {
        this.addDate = addDate;
    }

    @Override
    public String toString() {
        return  "\nid = " + id +
                " | name = " + name +
                " | active =  " + active +
                " | addDate = " + addDate;
    }
}


