package com.afterlife.javafullstackweb.usecases;

import com.afterlife.javafullstackweb.models.Vendors;
import com.afterlife.javafullstackweb.repositories.VendorsRepository;
import com.afterlife.javafullstackweb.services.VendorsService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@Transactional
public class VendorsUsecase implements VendorsService {

    @Autowired
    private VendorsRepository repository;

    public Vendors saveVendors(Vendors vendors) {
        return repository.save(vendors);
    }

    public List<Vendors> getListVendors() {
        return repository.findAll();
    }

    public Optional<Vendors> findByIdVendors(Integer id) {
        return repository.findById(id);
    }

    public void deleteVendorsById(Integer id) {
    repository.deleteById(id);
    }
}
