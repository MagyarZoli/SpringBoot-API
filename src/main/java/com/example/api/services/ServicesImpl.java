package com.example.api.services;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@AllArgsConstructor(onConstructor_ = {@Autowired})
@Service
public abstract class ServicesImpl<E, D, ID, R extends ListCrudRepository<E, ID>> {

    private R repository;

    protected abstract D mapToDto(E entity);

    protected abstract E mapToEntity(D dto);

    protected abstract E mapToEntity(D dto, ID id);

    public D postEntity(D dto) {
        return mapToDto(repository.save(mapToEntity(dto)));
    }

    public Iterable<D> getAllEntity() {
        return repository.findAll().stream()
                .map(this::mapToDto).collect(Collectors.toList());
    }

    public D getEntityById(ID id) {
        return mapToDto(repository.findById(id).orElseThrow(
                () -> new RuntimeException(id.getClass().getName() + " could not be found!")));
    }

    public D putEntity(D dto, ID id) {
        repository.findById(id).orElseThrow(
                () -> new RuntimeException(id.getClass().getName() + "could not be update!"));
        return mapToDto(repository.save(mapToEntity(dto, id)));
    }

    public void deleteEntity(ID id) {
        repository.delete(repository.findById(id).orElseThrow(
                () -> new RuntimeException(id.getClass().getName() + " could not be deleted!")));
    }
}