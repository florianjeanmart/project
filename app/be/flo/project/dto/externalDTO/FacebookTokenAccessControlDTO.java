package be.flo.project.dto.externalDTO;

import be.flo.project.dto.technical.DTO;

import java.util.Date;
import java.util.List;

/**
 * Created by florian on 3/05/15.
 */
public class FacebookTokenAccessControlDTO extends DTO {


    private FacebookTokenAccessControlDataDTO data;

    public FacebookTokenAccessControlDataDTO getData() {
        return data;
    }

    public void setData(FacebookTokenAccessControlDataDTO data) {
        this.data = data;
    }

    public static class FacebookTokenAccessControlDataDTO {

        private String app_id;
        private String application;
        private Date expires_at;
        private boolean is_valid;
        private Date issued_at;
        private List<String> scopes;
        private Long user_id;

        public String getApp_id() {
            return app_id;
        }

        public void setApp_id(String app_id) {
            this.app_id = app_id;
        }

        public String getApplication() {
            return application;
        }

        public void setApplication(String application) {
            this.application = application;
        }

        public Date getExpires_at() {
            return expires_at;
        }

        public void setExpires_at(Date expires_at) {
            this.expires_at = expires_at;
        }

        public boolean isIs_valid() {
            return is_valid;
        }

        public void setIs_valid(boolean is_valid) {
            this.is_valid = is_valid;
        }

        public Date getIssued_at() {
            return issued_at;
        }

        public void setIssued_at(Date issued_at) {
            this.issued_at = issued_at;
        }

        public List<String> getScopes() {
            return scopes;
        }

        public void setScopes(List<String> scopes) {
            this.scopes = scopes;
        }

        public Long getUser_id() {
            return user_id;
        }

        public void setUser_id(Long user_id) {
            this.user_id = user_id;
        }

        @Override
        public String toString() {
            return "FacebookTokenAccessControlDataDTO{" +
                    "app_id='" + app_id + '\'' +
                    ", application='" + application + '\'' +
                    ", expires_at=" + expires_at +
                    ", is_valid=" + is_valid +
                    ", issued_at=" + issued_at +
                    ", scopes=" + scopes +
                    ", user_id=" + user_id +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "FacebookTokenAccessControlDTO{" +
                "data=" + data +
                '}';
    }
}
