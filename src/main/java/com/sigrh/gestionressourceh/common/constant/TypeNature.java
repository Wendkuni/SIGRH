package com.sigrh.gestionressourceh.common.constant;

import lombok.Getter;

import java.util.stream.Stream;

@Getter
public enum TypeNature {
    PERMUTATION("permutation"),
    PERSONNEL("personnel"),
    NOMINATION("nomination"),
    NECESSITE("necessite");

    private final String label;

    TypeNature(String string) {
        this.label = string;
    }

    public static TypeNature getNatureByLabel(String label) {
        return Stream.of(TypeNature.values()).filter(t -> t.getLabel().equalsIgnoreCase(label)).findFirst()
                .orElseThrow(IllegalStateException::new);
    }

    @Override
    public String toString() {
        return label;
    }
}
