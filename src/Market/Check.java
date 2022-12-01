package Market;

import java.util.Date;

public class Check {
    private Long id;
    private Date addDate;
    private int totalSum;

    public Check(Long id, Date addDate, int totalSum) {
        this.id = id;
        this.addDate = addDate;
        this.totalSum = totalSum;
    }

    public Check() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getAddDate() {
        return addDate;
    }

    public void setAddDate(Date addDate) {
        this.addDate = addDate;
    }

    public int getTotalSum() {
        return totalSum;
    }

    public void setTotalSum(int totalSum) {
        this.totalSum = totalSum;
    }

    @Override
    public String toString() {
        return
                "\nid = " + id +
                " |  addDate = " + addDate +
                " |  totalSum = " + totalSum;
    }
}
