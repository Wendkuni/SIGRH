package com.sigrh.gestionressourceh.common.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import static java.util.Arrays.stream;
import static java.util.stream.Collectors.toList;

import java.util.List;
import java.util.stream.Stream;
@AllArgsConstructor
@Getter
public enum TypeJour {
	LUNDI("01","Lundi"),
	MARDI("02","Mardi"),
	MERCREDI("03","Mercredi"),
	JEUDI("04","Jeudi"),
	VENDREDI("05","Vendredi"),
	SAMEDI("06","Samedi"),
	DIMANCHE("07","Dimanche");
	
	private final String code;
    private final String label;

    public static List<TypeJour> getJour() {
        return stream(TypeJour.values()).collect(toList());
    }

    public static TypeJour getTypeJourByCode(String code) {
        return Stream.of(TypeJour.values())
                .filter(TypeJour -> TypeJour.getCode().equalsIgnoreCase(code))
                .findFirst()
                .orElseThrow(IllegalStateException::new);
    }
    
    public static TypeJour getTypeJourByLabel(String label) {
        return Stream.of(TypeJour.values())
                .filter(TypeJour -> TypeJour.getLabel().equalsIgnoreCase(label))
                .findFirst()
                .orElseThrow(IllegalStateException::new);
    }
    
    @Override
    public String toString() {
    	return label.toString();
    }

}
