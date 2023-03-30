package com.afterlife.javafullstackweb.repositories;

import com.afterlife.javafullstackweb.models.Frozens;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FrozensRepository extends JpaRepository<Frozens, Integer> {
}
