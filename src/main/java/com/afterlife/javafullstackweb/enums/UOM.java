package com.afterlife.javafullstackweb.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum UOM {

    PCS ("Pcs"),
    KG("Kg"),
    GR("Gr"),
    ROLL("Roll"),
    PAIL("Pail");

    public final String displayUOM;

}
