package com.example.api.controll;


import com.example.api.services.ServicesImpl;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@AllArgsConstructor(onConstructor_ = {@Autowired})
@RestController
public class CController<E, D, ID,
        S extends ServicesImpl<E, D, ID, R>,
        R extends ListCrudRepository<E, ID>>
        implements GenerateController<D, ID> {

    private S services;

    @Override
    @GetMapping("/")
    public ResponseEntity<Iterable<D>> get() {
        return ResponseEntity.ok(services.getAllEntity());
    }

    @Override
    @PostMapping("/post")
    @ResponseStatus(CREATED)
    public ResponseEntity<D> post(@RequestBody D dto) {
        return new ResponseEntity<>(services.postEntity(dto), CREATED);
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<D> get(@PathVariable("id") ID value) {
        return ResponseEntity.ok(services.getEntityById(value));
    }

    @Override
    @PutMapping("/{id}")
    public ResponseEntity<D> put(@PathVariable("id") ID value, @RequestBody D dto) {
        return new ResponseEntity<>(services.putEntity(dto, value), OK);
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<D> delete(@PathVariable("id") ID value) {
        D toString = services.getEntityById(value);
        services.deleteEntity(value);
        return new ResponseEntity<>(toString, OK);
    }
}