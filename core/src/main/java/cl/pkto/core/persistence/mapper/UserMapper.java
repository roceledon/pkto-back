package cl.pkto.core.persistence.mapper;

import cl.pkto.common.ms.domain.User;
import cl.pkto.core.persistence.mapper.base.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * Created by Bennu on 27-11-2016.
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
}
