package cl.pkto.common.ms.controller.iface;

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
public interface ICrud<T> {
    String BASE_URI = "";

    @RequestMapping(value = BASE_URI, produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
    ResponseEntity<List<T>> getAll();

    @RequestMapping(value = BASE_URI + "/{id}", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
    ResponseEntity<T> get(@PathVariable("id") Long id);

    @RequestMapping(value = BASE_URI, produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
    void save(@RequestBody T type);

    @RequestMapping(value = BASE_URI + "/{id}", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.DELETE)
    void delete(@PathVariable("id") Long id);

    @RequestMapping(value = BASE_URI + "/{o}", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
    ResponseEntity<List<T>> find(@RequestBody T type);
}
