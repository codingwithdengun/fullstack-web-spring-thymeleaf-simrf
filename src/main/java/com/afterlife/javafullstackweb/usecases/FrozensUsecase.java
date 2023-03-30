package com.afterlife.javafullstackweb.usecases;

import com.afterlife.javafullstackweb.models.Frozens;
import com.afterlife.javafullstackweb.repositories.FrozensRepository;
import com.afterlife.javafullstackweb.services.FrozensService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@Transactional
public class FrozensUsecase implements FrozensService {

    @Autowired
    private FrozensRepository frozensRepository;

    public Frozens saveFrozen(Frozens frozens) {
        return frozensRepository.save(frozens);
    }

    public List<Frozens> getAllDataFrozens() {
        return frozensRepository.findAll();
    }

    public Optional<Frozens> getDataById(Integer id) {
        return frozensRepository.findById(id);
    }

    public void deleteDataFrozenById(Integer id) {
        frozensRepository.deleteById(id);
    }
}
