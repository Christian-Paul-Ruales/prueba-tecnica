package com.ntt.data.mcsv_personacliente.domain.service;

import org.springframework.data.crossstore.ChangeSetPersister;

import java.util.List;

public interface IAbstractService<T, ID> {

    List<T> getAll();

    T getById(ID id) throws ChangeSetPersister.NotFoundException;

    T save(T o);

    T update(T o);

    T delete(T o);

}
