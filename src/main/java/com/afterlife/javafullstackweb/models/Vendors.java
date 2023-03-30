package com.afterlife.javafullstackweb.models;

import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
@Table(name = "m_vendors")
public class Vendors {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

}
