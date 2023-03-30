package com.afterlife.javafullstackweb.models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "m_assets")
public class Assets {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String type;
    private String price;
    private String numberAssets;
    private String dateIn;
}
