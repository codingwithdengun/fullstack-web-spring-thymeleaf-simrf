package com.afterlife.javafullstackweb.services;

import com.afterlife.javafullstackweb.models.Transferplants;

import java.util.List;
import java.util.Optional;

public interface TransferplantService {

    // tambah data
    Transferplants saveTransferplant(Transferplants transferplants);
    // get all data
    List<Transferplants> getAllDataTransferplant();
    // get data by id
    Optional<Transferplants> getDataTransferplantById(Integer id);
    // delete data by id
    void deleteDataTransferplantById(Integer id);
}
