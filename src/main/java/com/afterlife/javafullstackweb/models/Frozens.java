package com.afterlife.javafullstackweb.models;

import com.afterlife.javafullstackweb.enums.Country;
import com.afterlife.javafullstackweb.enums.UOM;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "m_frozens")
public class Frozens {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String code;
    private String description;
    @Enumerated(EnumType.STRING)
    private UOM uom;

    @Enumerated(EnumType.STRING)
    private Country country;

    private String dateIn;

}
