package com.afterlife.javafullstackweb.repositories;

import com.afterlife.javafullstackweb.models.Vendors;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VendorsRepository extends JpaRepository<Vendors, Integer> {
}
