package Market;

import java.util.Date;

public class Market extends BaseEntity{
    public Market(Long id, String name, boolean active, Date addDate) {
        super(id, name, active, addDate);
    }

    public Market() {
    }


}

