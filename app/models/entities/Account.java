package models.entities;

import models.entities.technical.AbstractEntity;
import play.i18n.Lang;

import javax.persistence.*;

/**
 * Created by florian on 10/11/14.
 */
@Entity
@NamedQueries({
        @NamedQuery(name = Account.FIND_BY_ID, query = "where " + AbstractEntity.COL_ID + " = :" + AbstractEntity.PARAM_ID),
        @NamedQuery(name = Account.FIND_BY_AUTHENTICATION_KEY, query = "where " + Account.COL_AUTHENTICATION_KEY + " = :" + Account.PARAM_AUTHENTICATION_KEY),
        @NamedQuery(name = Account.FIND_BY_EMAIL, query = "where " + Account.COL_EMAIL + " = :" + Account.PARAM_EMAIL),
})
public class Account extends AbstractEntity {

    //request
    public static final String FIND_BY_EMAIL = "Account_FIND_BY_EMAIL";
    public static final String FIND_BY_ID = "Account_FIND_BY_ID";
    public static final String FIND_BY_AUTHENTICATION_KEY = "Account_FIND_BY_AUTHENTICATION_KEY";

    //columns
    public static final String COL_EMAIL = "email";
    public static final String PARAM_EMAIL = COL_EMAIL;
    public static final String COL_AUTHENTICATION_KEY = "authenticationKey";
    public static final String PARAM_AUTHENTICATION_KEY = COL_AUTHENTICATION_KEY;

    @Column(nullable = false)
    private Boolean male;

    @Column(nullable = false)
    private String firstname;

    @Column(nullable = false)
    private String lastname;

    @Column(nullable = false, unique = true, name = COL_EMAIL)
    private String email;

    /**
     * used to authentication
     * For the application and for the cookie into for the web site
     */
    @Column(name = COL_AUTHENTICATION_KEY)
    private String authenticationKey;

    @Column(nullable = false)
    private String language;

    @Column
    private boolean keepSessionOpen;

    /**
     * used for connection and for reactivation for the application
     */
    @Column(nullable = false)
    private String password;

    @Column(nullable = false,columnDefinition = "boolean default false")
    private Boolean isAdmin = false;

    @Column(nullable = false,columnDefinition = "boolean default false")
    private Boolean isSuperAdmin = false;


    public Account() {
    }

    public Boolean getMale() {
        return male;
    }

    public void setMale(Boolean male) {
        this.male = male;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAuthenticationKey() {
        return authenticationKey;
    }

    public void setAuthenticationKey(String authenticationKey) {
        this.authenticationKey = authenticationKey;
    }

    public Lang getLanguage() {
        return Lang.forCode(language);
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public boolean isKeepSessionOpen() {
        return keepSessionOpen;
    }

    public void setKeepSessionOpen(boolean keepSessionOpen) {
        this.keepSessionOpen = keepSessionOpen;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(Boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

    public Boolean getIsSuperAdmin() {
        return isSuperAdmin;
    }

    public void setIsSuperAdmin(Boolean isSuperAdmin) {
        this.isSuperAdmin = isSuperAdmin;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Account account = (Account) o;

        if (!email.equals(account.email)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + email.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Account{" +
                "male=" + male +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", email='" + email + '\'' +
                ", authenticationKey='" + authenticationKey + '\'' +
                ", language='" + language + '\'' +
                ", keepSessionOpen=" + keepSessionOpen +
                ", password='" + password + '\'' +
                ", isAdmin=" + isAdmin +
                ", isSuperAdmin=" + isSuperAdmin +
                '}';
    }
}
