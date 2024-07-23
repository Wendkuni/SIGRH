package com.sigrh.gestionressourceh.common.constant;

import lombok.Getter;

import java.util.stream.Stream;

@Getter
public enum TypeDistinction {

    NATIONALE("national"),
    REGIONALE("regionale"),
    DEPARTEMENTALE("departementale");


    private final String label;

    TypeDistinction(String string) {
        this.label = string;
    }

    public static TypeDistinction getDistinctionByLabel(String label) {
        return Stream.of(TypeDistinction.values()).filter(t -> t.getLabel().equalsIgnoreCase(label)).findFirst()
                .orElseThrow(IllegalStateException::new);
    }

    @Override
    public String toString() {
        return label.toString();
    }
}