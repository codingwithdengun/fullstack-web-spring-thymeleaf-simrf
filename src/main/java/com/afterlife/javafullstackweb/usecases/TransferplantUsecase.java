package com.afterlife.javafullstackweb.usecases;

import com.afterlife.javafullstackweb.models.Transferplants;
import com.afterlife.javafullstackweb.repositories.TransferplantsRepository;
import com.afterlife.javafullstackweb.services.TransferplantService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@Transactional
public class TransferplantUsecase implements TransferplantService {

    @Autowired
    private TransferplantsRepository repo;

    public Transferplants saveTransferplant(Transferplants transferplants) {
        return repo.save(transferplants);
    }

    public List<Transferplants> getAllDataTransferplant() {
        return repo.findAll();
    }

    public Optional<Transferplants> getDataTransferplantById(Integer id) {
        return repo.findById(id);
    }

    public void deleteDataTransferplantById(Integer id) {
        repo.deleteById(id);
    }
}
