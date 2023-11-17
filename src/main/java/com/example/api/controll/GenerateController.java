package com.example.api.controll;

import org.springframework.http.ResponseEntity;

public interface GenerateController<D, V> {

    ResponseEntity<Iterable<D>> get();

    ResponseEntity<D> post(D dto);

    ResponseEntity<D> get(V value);

    ResponseEntity<D> put(V value, D dto);

    ResponseEntity<D> delete(V value);
}