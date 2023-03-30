package com.afterlife.javafullstackweb.models;

import com.afterlife.javafullstackweb.enums.UOM;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "m_transferplants")
public class Transferplants {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String picIncharge;
    private String documentNo;
    private String quantity;
    @Enumerated(EnumType.STRING)
    private UOM uom;
    private String place;
    private String sendingDate;

}
