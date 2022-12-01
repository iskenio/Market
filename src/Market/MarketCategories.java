package Market;

import org.postgresql.replication.LogSequenceNumber;

public class MarketCategories {
    private Long id;
    private boolean active;
    private Long marketTbId;
    private Long categoriesTbId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Long getMarketTbId() {
        return marketTbId;
    }

    public void setMarketTbId(Long marketTbId) {
        this.marketTbId = marketTbId;
    }

    public Long getCategoriesTbId() {
        return categoriesTbId;
    }

    public void setCategoriesTbId(Long categoriesTbId) {
        this.categoriesTbId = categoriesTbId;
    }

    public void setMarketTbId(String string) {
    }

    public void setCategoriesTbId(String string) {
    }

    @Override
    public String toString() {
        return  "\nid = " + id +
                " |  active = " + active +
                " |  marketTbId = " + marketTbId +
                " |  categoriesTbId = " + categoriesTbId;
    }
}
