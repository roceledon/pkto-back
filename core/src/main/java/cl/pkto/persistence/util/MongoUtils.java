package cl.pkto.persistence.util;

import cl.pkto.common.ms.enums.DBEnum;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;

/**
 * Created by Bennu on 27-11-2016.
 */
public class MongoUtils {
    private static final String HOST = "mongo";
    private static final int PORT = 27017;

    public static MongoDatabase getDatabase(DBEnum dbEnum) {
        MongoClient client = new MongoClient(HOST, PORT);
        return client.getDatabase(dbEnum.getName());
    }
}
