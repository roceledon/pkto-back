package cl.pkto.user.ms.controller;

import cl.pkto.common.ms.domain.User;
import cl.pkto.core.business.UserBusiness;
import cl.pkto.user.ms.api.UserApi;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by Bennu on 27-11-2016.
 */
@Controller
public class UserApiController implements UserApi {
    @Override
    public ResponseEntity<List<User>> getAll() {
        List<User> userList = UserBusiness.getInstance().getUserAll();
        return new ResponseEntity<>(userList, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<User> getById(@PathVariable("id") Long id) {
        User user = UserBusiness.getInstance().getUserById(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<User> update(@RequestBody User user) {
        UserBusiness.getInstance().saveUser(user);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<User> save(@RequestBody User user, HttpServletRequest request) {
        UserBusiness.getInstance().saveUser(user);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @Override
    public void delete(@PathVariable("id") Long id) {
        UserBusiness.getInstance().deleteUser(id);
    }
}
