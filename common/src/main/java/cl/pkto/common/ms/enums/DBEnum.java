package cl.pkto.common.ms.enums;

/**
 * Created by Bennu on 27-11-2016.
 */
public enum DBEnum {
    MONGO_LABS(1L, "mondodb-labs")
    , PKTO_DB(2L, "pkto-db");

    private Long id;
    private String name;


    DBEnum(Long id, String name) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public Long getId() {
        return id;
    }
}
