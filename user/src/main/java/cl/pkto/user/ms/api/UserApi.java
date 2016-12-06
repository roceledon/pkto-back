package cl.pkto.user.ms.api;

import cl.pkto.common.ms.domain.User;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by Bennu on 27-11-2016.
 */
public interface UserApi {
    @RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
    ResponseEntity<List<User>> getAll();

    @RequestMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.DELETE)
    ResponseEntity delete(@PathVariable("id") Long id);

    @RequestMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
    ResponseEntity<User> getById(@PathVariable("id") Long id);

    @RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.PUT)
    ResponseEntity<User> update(@RequestBody User user);

    @RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
    ResponseEntity<User> save(@RequestBody User user);
}
