package cl.pkto.user.ms.controller;

import cl.pkto.common.ms.domain.User;
import cl.pkto.core.business.PktoBusiness;
import cl.pkto.user.ms.api.UserApi;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by Bennu on 27-11-2016.
 */
public class UserApiController implements UserApi {
    @Override
    public ResponseEntity<List<User>> getAll() {
        List<User> userList = PktoBusiness.getInstance().getUserAll();
        return new ResponseEntity<>(userList, HttpStatus.OK);
    }

    @Override
    public void delete(@PathVariable("id") String id) {
        PktoBusiness.getInstance().deleteUser(id);
    }

    @Override
    public ResponseEntity<User> getById(@PathVariable("id") String id) {
        User user = PktoBusiness.getInstance().getUserById(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<User> update(@RequestBody User user) {
        PktoBusiness.getInstance().saveUser(user);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<User> save(@RequestBody User user, HttpServletRequest request) {
        PktoBusiness.getInstance().saveUser(user);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
}
