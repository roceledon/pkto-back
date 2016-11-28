package cl.pkto.common.ms.domain;

import cl.pkto.common.ms.domain.base.BaseDomain;

/**
 * Created by Bennu on 27-11-2016.
 */
public class User extends BaseDomain {
    private String nick;
    private String friendCode;

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
}
