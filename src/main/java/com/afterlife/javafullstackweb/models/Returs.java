package com.afterlife.javafullstackweb.models;

import com.afterlife.javafullstackweb.enums.Country;
import com.afterlife.javafullstackweb.enums.UOM;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Entity
@Table(name = "m_returs")
public class Returs {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(length = 50)
    private String codeGoods;
    @Column(length = 50)
    private String nameGoods;
    private String description;
    private String amountRetur;
    private String productionDate;
    @Enumerated(EnumType.STRING)
    private UOM uom;
    @Enumerated(EnumType.STRING)
    private Country country;

    private String returDate;
}
