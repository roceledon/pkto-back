package cl.pkto.persistence.exclusion;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;

/**
 * Created by Bennu on 27-11-2016.
 */
public class ExclusionStrategiesApp implements ExclusionStrategy {
    public boolean shouldSkipClass(Class<?> arg0) {
        return false;
    }

    public boolean shouldSkipField(FieldAttributes f) {
        return (f.getName().equals("id"));
    }
}
