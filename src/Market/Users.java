package Market;

import java.util.Date;

public class Users extends BaseEntity{
    private String login;
    private String password;
    private Long marketId;

    public Users(Long id, String name, boolean active, Date addDate, String login, String password, Long marketId) {
        super(id, name, active, addDate);
        this.login = login;
        this.password = password;
        this.marketId = marketId;
    }

    public Users() {
    }

    public Long getMarketId() {
        return marketId;
    }

    public void setMarketId(Long marketId) {
        this.marketId = marketId;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return super.toString() +
                " |  login= " + login +
                " |  password= " + password +
                " |  marketId= " + marketId;
    }
}
