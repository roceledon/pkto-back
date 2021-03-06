package cl.pkto.user.ms.controller;

import cl.pkto.common.ms.domain.User;
import cl.pkto.core.business.UserBusiness;
import cl.pkto.user.ms.api.UserApi;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Bennu on 27-11-2016.
 */
@RequestMapping("${api.version.url}/${api.path}")
@RestController
public class UserApiController implements UserApi {
    @Override
    public ResponseEntity<List<User>> getAll() {
        List<User> userList = UserBusiness.getInstance().getAll();
        return new ResponseEntity<>(userList, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<User> getById(@PathVariable("id") Long id) {
        User user = UserBusiness.getInstance().getById(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<User> update(@RequestBody User user) {
        UserBusiness.getInstance().update(user);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<User> save(@RequestBody User user) {
        return new ResponseEntity<>(UserBusiness.getInstance().save(user), HttpStatus.OK);
    }

    @Override
    public ResponseEntity delete(@PathVariable("id") Long id) {
        UserBusiness.getInstance().delete(id);
        return new ResponseEntity<>(HttpStatus.OK.value(),HttpStatus.OK);
    }
}
