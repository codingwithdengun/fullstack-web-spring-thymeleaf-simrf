package com.afterlife.javafullstackweb.usecases;

import com.afterlife.javafullstackweb.models.Returs;
import com.afterlife.javafullstackweb.repositories.RetursRepository;
import com.afterlife.javafullstackweb.services.RetursService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@Transactional
public class RetursUsecase implements RetursService {

    @Autowired
    private RetursRepository repo;
    public Returs saveReturs(Returs returs) {
        return repo.save(returs);
    }

    public List<Returs> getAllDataReturs() {
        return repo.findAll();
    }

    public Optional<Returs> getDataByIdReturs(Integer id) {
        return repo.findById(id);
    }

    public void deleteDataRetursById(Integer id) {
    repo.deleteById(id);
    }
}
