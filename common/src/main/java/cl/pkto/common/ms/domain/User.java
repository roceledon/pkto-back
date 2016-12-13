package cl.pkto.common.ms.domain;

import cl.pkto.common.ms.domain.base.BaseDomain;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Date;
import java.util.List;

/**
 * Created by Bennu on 27-11-2016.
 */
public class User extends BaseDomain {
    private String email;
    private String nick;
    private String friendCode;
    private String password;
    private List authoritiesList;
    private Boolean enabled;
    private Date lastPasswordResetDate;

    public User(){}

    public User(Long id, String email, String nick, String friendCode, String password, List authoritiesList, Boolean enabled, Date lastPasswordResetDate) {
        setId(id);
        this.email = email;
        this.nick = nick;
        this.friendCode = friendCode;
        this.password = password;
        this.authoritiesList = authoritiesList;
        this.enabled = enabled;
        this.lastPasswordResetDate = lastPasswordResetDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getFriendCode() {
        return friendCode;
    }

    public void setFriendCode(String friendCode) {
        this.friendCode = friendCode;
    }

    @JsonIgnore
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List getAuthoritiesList() {
        return authoritiesList;
    }

    public void setAuthoritiesList(List authoritiesList) {
        this.authoritiesList = authoritiesList;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public Date getLastPasswordResetDate() {
        return lastPasswordResetDate;
    }

    public void setLastPasswordResetDate(Date lastPasswordResetDate) {
        this.lastPasswordResetDate = lastPasswordResetDate;
    }
}
