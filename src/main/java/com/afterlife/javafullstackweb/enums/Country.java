package com.afterlife.javafullstackweb.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Country {

    INDONESIA ("Indonesia"),
    THAILAND ("Thailand"),

    AUSTRALIA("Australia");

    public final String tampilkanCountry;
}
