package com.afterlife.javafullstackweb.services;

import com.afterlife.javafullstackweb.models.Returs;

import java.util.List;
import java.util.Optional;

public interface RetursService {

    // tambah data
    Returs saveReturs(Returs returs);
    // get all data
    List<Returs> getAllDataReturs();
    // get data by id
    Optional<Returs> getDataByIdReturs(Integer id);
    // delete data
    void deleteDataRetursById(Integer id);
}
