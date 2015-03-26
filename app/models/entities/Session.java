package models.entities;

import models.entities.technical.AbstractEntity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by florian on 4/12/14.
 */
@Entity
public class Session extends AbstractEntity {

    @ManyToOne(optional = false)
    private Account account;

    @Column
    private Date connectionDate;

    @Column
    private Boolean fromAndroid;

    public Session() {
    }

    public Session(Account account, boolean fromAndroid) {
        this.account = account;
        this.fromAndroid = fromAndroid;
        connectionDate = new Date();
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Date getConnectionDate() {
        return connectionDate;
    }

    public void setConnectionDate(Date connectionDate) {
        this.connectionDate = connectionDate;
    }

    public Boolean getFromAndroid() {
        return fromAndroid;
    }

    public void setFromAndroid(Boolean fromAndroid) {
        this.fromAndroid = fromAndroid;
    }

    @Override
    public String toString() {
        return "Session{" +
                "account=" + account +
                ", connectionDate=" + connectionDate +
                ", fromAndroid=" + fromAndroid +
                '}';
    }
}
