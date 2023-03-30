package com.afterlife.javafullstackweb.services;

import com.afterlife.javafullstackweb.models.Frozens;

import java.util.List;
import java.util.Optional;

public interface FrozensService {

    // tambah data
    Frozens saveFrozen(Frozens frozens);
    // get all data
    List<Frozens> getAllDataFrozens();
    // get data by id
    Optional<Frozens> getDataById(Integer id);
    // delete data by id
    void deleteDataFrozenById(Integer id);
}
