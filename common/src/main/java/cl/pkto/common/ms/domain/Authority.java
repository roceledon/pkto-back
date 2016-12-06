package cl.pkto.common.ms.domain;

import cl.pkto.common.ms.domain.base.BaseDomain;

/**
 * Created by Bennu on 05-12-2016.
 */
public class Authority extends BaseDomain {
    String name;

    public Authority(){}

    public Authority(Long id,String name) {
        setId(id);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
