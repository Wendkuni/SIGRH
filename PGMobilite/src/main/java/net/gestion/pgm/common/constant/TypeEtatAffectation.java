package net.gestion.pgm.common.constant;

import lombok.Getter;

import java.util.stream.Stream;

@Getter
public enum TypeEtatAffectation {
    VALIDATION_AGENT("validation_agent"),
    VALIDATION_COMITE("validation_comite"),
    REJECT_AGENT("reject_agent"),
    ENCOURS("encours"),
    REJECT_COMITE("reject_comite");

    private final String label;

    TypeEtatAffectation(String string) {
        this.label = string;
    }

    public static TypeEtatAffectation getTypeEtatAffectationByLabel(String label) {
        return Stream.of(TypeEtatAffectation.values()).filter(t -> t.getLabel().equalsIgnoreCase(label)).findFirst()
                .orElseThrow(IllegalStateException::new);
    }

    @Override
    public String toString() {
        return label;
    }


}
