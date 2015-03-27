package models.entities;

import models.entities.technical.AbstractEntity;

import javax.persistence.*;

@Entity

@NamedQueries({
        @NamedQuery(name = StoredFile.FIND_BY_STORED_NAME, query = "where " + StoredFile.COL_NAME + " = :" + StoredFile.PARAM_NAME)
})
public class StoredFile extends AbstractEntity {

	private static final long serialVersionUID = 1L;

    //request
	public static final String FIND_BY_STORED_NAME = "StoredFile.findByStoredName";
    //param
    public static final String PARAM_NAME = "storedName";
    //column
    public static final String COL_NAME = "storedName";

    @Column(nullable = false)
    private String originalName;

    @Column(name = COL_NAME,nullable = false)
    private String storedName;

    @Column
    private Integer size;

    @ManyToOne(optional = false)
    private Account account;


    public StoredFile() {
    }

    public StoredFile(String originalName, String storedName, Integer size, Account account) {
        this.originalName = originalName;
        this.storedName = storedName;
        this.size = size;
        this.account = account;
    }

    public String getOriginalName() {
        return originalName;
    }

    public void setOriginalName(String originalName) {
        this.originalName = originalName;
    }

    public String getStoredName() {
        return storedName;
    }

    public void setStoredName(String storedName) {
        this.storedName = storedName;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    @Override
    public String toString() {
        return "StoredFile{" +
                super.toString()+
                "originalName='" + originalName + '\'' +
                ", storedName='" + storedName + '\'' +
                ", size=" + size +
                ", account=" + account +
                '}';
    }
}
