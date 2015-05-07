package be.flo.project.model.entities;

import be.flo.project.model.entities.technical.AbstractEntity;

import javax.persistence.*;

/**
 * Created by florian on 3/05/15.
 */
@Entity
public class FacebookCredential extends AbstractEntity {

    @OneToOne(optional = false,cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    private Account account;

    @Basic(optional = false)
    @Column(unique = true)
    private Long userId;

    public FacebookCredential() {
    }

    public FacebookCredential(Account account, Long userId) {
        this.account = account;
        this.userId = userId;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "FacebookCredential{" +
                "account=" + account +
                ", userId='" + userId + '\'' +
                '}';
    }
}
