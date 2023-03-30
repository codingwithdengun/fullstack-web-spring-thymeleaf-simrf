package com.afterlife.javafullstackweb.services;

import com.afterlife.javafullstackweb.models.Vendors;

import java.util.List;
import java.util.Optional;

public interface VendorsService {

    // untuk tambah data
    Vendors saveVendors(Vendors vendors);
    // untuk get all data
    List<Vendors> getListVendors();
    // untuk find by id data
    Optional<Vendors> findByIdVendors(Integer id);
    // untuk delete data
    void deleteVendorsById(Integer id);
}
