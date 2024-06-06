package com.sigrh.gestionressourceh.common.constant;

import java.util.stream.Stream;

import lombok.Getter;

@Getter
public enum TypeEducation {
    SCOLAIRE,
    FORMATION,
    PROFESSIONAL;
    
    private final String label = "";
    
    public static TypeEducation getTypeEducationByLabel(String label) {
    	return Stream.of(TypeEducation.values())
        .filter(t -> t.getLabel().equalsIgnoreCase(label))
        .findFirst()
        .orElseThrow(IllegalStateException::new);
    }
    
    @Override
    public String toString() {
    	return label.toString();
    }
}
