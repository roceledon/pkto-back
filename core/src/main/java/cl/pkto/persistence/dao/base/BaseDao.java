package cl.pkto.persistence.dao.base;

import cl.pkto.common.ms.domain.base.BaseDomain;
import cl.pkto.common.ms.enums.DBEnum;
import cl.pkto.persistence.exclusion.ExclusionStrategiesApp;
import cl.pkto.persistence.iface.base.IBaseDao;
import cl.pkto.persistence.util.MongoUtils;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Bennu on 27-11-2016.
 */
public class BaseDao<T extends BaseDomain> implements IBaseDao<T> {
    private static MongoDatabase DATABASE;
    private static MongoCollection<Document> COLLECTION;

    static Gson GSON = new GsonBuilder().setExclusionStrategies(new ExclusionStrategiesApp()).serializeNulls().create();

    static {
        DATABASE = MongoUtils.getDatabase(DBEnum.PKTO_DB);
    }

    private Class<T> domainClazz;
    private Class<?> daoClazz;

    public BaseDao() {
        this.domainClazz = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        daoClazz = this.getClass();

        COLLECTION = DATABASE.getCollection(domainClazz.getName());
    }

    private T buildT(Document d) {
        T type = GSON.fromJson(d.toJson(), domainClazz);
        type.setId((d.get("_id").toString()));

        return type;
    }

    @Override
    public List<T> getAll() {
        List<T> result = new ArrayList<>();
        FindIterable<Document> iterable = COLLECTION.find();
        for (Document document1 : iterable) {
            result.add(buildT(document1));
        }

        return result;
    }

    @Override
    public T getById(String id) {
        FindIterable<Document> iterable = COLLECTION.find(Filters.eq("_id", new ObjectId(id)));
        if (iterable.iterator().hasNext()) {
            return buildT(iterable.iterator().next());
        }

        return null;
    }

    @Override
    public T getByName(String name) {
        FindIterable<Document> iterable = COLLECTION.find(Filters.eq("name", name));
        if (iterable.iterator().hasNext()) {
            return buildT(iterable.iterator().next());
        }

        return null;
    }

    @Override
    public void save(T type) {
        if (type.getId() == null) {
            Document d = Document.parse(GSON.toJson(type));
            COLLECTION.insertOne(d);
            type.setId(d.get("_id").toString());
        } else {
            Document bson = Document.parse(GSON.toJson(type));
            COLLECTION.replaceOne(Filters.eq("_id", new ObjectId(type.getId())), bson);
        }
    }

    @Override
    public void delete(String id) {
        COLLECTION.deleteOne(Filters.eq("_id", new ObjectId(id)));
    }

    @Override
    public List<T> find(T type) {
        List<T> result = new ArrayList<>();

        Bson query = Filters.and(Filters.eq("_id", new ObjectId(type.getId()))
                //, Filters.eq("name", type.getName())
        );

        FindIterable<Document> iterable = COLLECTION.find(query);

        for (Document document1 : iterable) {
            result.add(GSON.fromJson(document1.toJson(), domainClazz));
        }

        return result;
    }
}
