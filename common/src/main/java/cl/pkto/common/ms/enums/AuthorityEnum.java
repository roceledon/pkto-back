package cl.pkto.common.ms.enums;

import java.io.ObjectStreamException;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

/**
 * Created by Bennu on 05-12-2016.
 */
public class AuthorityEnum implements Serializable, Comparable {
    private final transient String m_name;
    private final transient Long m_id;
    private final int m_ordinalPosition;
    private static transient int s_maxCount = 0;
    private final transient int m_count;
    private static transient int s_nextOrdinalPosition = 0;

    private AuthorityEnum( Long p_id, String p_name ) {
        m_name = p_name;
        m_id = p_id;
        m_ordinalPosition = s_nextOrdinalPosition++;
        m_count = s_maxCount++;
    }

    public static final AuthorityEnum ROLE_USER = new AuthorityEnum( new Long(1), "ROLE_USER" );
    public static final AuthorityEnum ROLE_ADMIN = new AuthorityEnum( new Long(2), "ROLE_ADMIN" );

    private static final AuthorityEnum[] s_values = new AuthorityEnum[] { ROLE_USER, ROLE_ADMIN};
    private static final Collection s_valuesSet = Collections.unmodifiableCollection(Arrays.asList( s_values ));

    public int getCount() { return m_count; }

    public AuthorityEnum getElementByPosition( int p_position ) {
        return s_values[ p_position ];
    }

    public String getName() { return m_name; }

    public Long getId() { return m_id; }

    public int getOrdinalPosition() { return m_ordinalPosition; }

    public String toString() { return m_name; }

    public static AuthorityEnum valueOf( Long p_id ) {
        for (Object aS_valuesSet : s_valuesSet) {
            AuthorityEnum t_account = (AuthorityEnum) aS_valuesSet;
            if (t_account.getId().equals(p_id))
                return t_account;
        }
        throw new IllegalArgumentException( p_id + " cannot be translated to enum." );
    }

    public static AuthorityEnum valueOf( String p_name ) {
        for (Object aS_valuesSet : s_valuesSet) {
            AuthorityEnum t_account = (AuthorityEnum) aS_valuesSet;
            if (t_account.getName().equals(p_name))
                return t_account;
        }
        throw new IllegalArgumentException( p_name + " cannot be translated to enum." );
    }

    public int compareTo( Object p_object ) {
        return getOrdinalPosition() - ((AuthorityEnum) p_object).getOrdinalPosition();
    }

    public static Collection values(){
        return s_valuesSet;
    }
    private Object readResolve() throws ObjectStreamException {
        return s_values[ m_ordinalPosition ];
    }
}
