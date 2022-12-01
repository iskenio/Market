package Market;

import java.util.Date;

public class Categories extends BaseEntity{
    public Categories(Long id, String name, boolean active, Date addDate) {
        super(id, name, active, addDate);
    }

    public Categories() {
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
