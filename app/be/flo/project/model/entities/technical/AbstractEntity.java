package be.flo.project.model.entities.technical;

import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import play.Play;
import play.api.mvc.Session;
import play.mvc.Http;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by florian on 10/11/14.
 */
@MappedSuperclass
public abstract class AbstractEntity implements Serializable {

    public static final String TEST_USER = "TEST_USER";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    @Column
    protected Date creationDate;

    protected String creationUser;

    @Column
    @Version
    protected Date lastUpdate;

    protected String lastUpdateUser;

    @PrePersist
    public void prePersist() {
        String currentUser = getCurrentUser();
        if (StringUtils.isBlank(currentUser)) {
            currentUser = "TECHNICAL";
        }
        creationDate = new Date();
        creationUser = getCurrentUser();
        lastUpdate = new Date();
        lastUpdateUser = getCurrentUser();
    }

    @PreUpdate
    public void preUpdate() {
        if(id==null){
            prePersist();
        }
        else{
            lastUpdate = new Date();
            lastUpdateUser = getCurrentUser();
        }
    }

    private static String getCurrentUser() {
        if (Play.application().isTest()) {
            return TEST_USER;
        }
        if (Http.Context.current.get() == null) {
            return "TECHNICAL";
        }

        Http.Session session = Http.Context.current().session();
        return session.get("identifier");
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "AuditedAbstractEntity{" +
                "id=" + id +
                ", creationDate=" + creationDate +
                ", lastUpdate=" + lastUpdate +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o.getClass().equals(this.getClass()))) return false;
        if (!super.equals(o)) return false;

        AbstractEntity that = (AbstractEntity) o;

        if (!id.equals(that.id)) return false;

        return true;
    }



}

