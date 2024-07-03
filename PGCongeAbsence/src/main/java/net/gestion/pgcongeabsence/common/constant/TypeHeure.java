
package net.gestion.pgcongeabsence.common.constant;


import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;
import java.util.stream.Stream;

import static java.util.Arrays.stream;
import static java.util.stream.Collectors.toList;
@AllArgsConstructor
@Getter
public enum TypeHeure {
	HEURE_00("00","0H"),
	HEURE_01("01","1H"),
	HEURE_02("02","2H"),
	HEURE_03("03","3H"),
	HEURE_04("04","4H"),
	HEURE_05("05","5H"),
	HEURE_06("06","6H"),
	HEURE_07("07","7H"),
	HEURE_08("08","8H"),
	HEURE_09("09","9H"),
	HEURE_10("10","10H"),
	HEURE_11("11","11H"),
	HEURE_12("12","12H"),
	HEURE_13("13","13H"),
	HEURE_14("14","14H"),
	HEURE_15("15","15H"),
	HEURE_16("16","16H"),
	HEURE_17("17","17H"),
	HEURE_18("18","18H"),
	HEURE_19("19","19H"),
	HEURE_20("20","20H"),
	HEURE_21("21","21H"),
	HEURE_22("22","22H"),
	HEURE_23("23","23H");
	

    private final String code;
    private final String label;

    public static List<TypeHeure> getHeures() {
        return stream(TypeHeure.values()).collect(toList());
    }

    public static TypeHeure getTypeHeureByCode(String code) {
        return Stream.of(TypeHeure.values())
                .filter(TypeHeure -> TypeHeure.getCode().equalsIgnoreCase(code))
                .findFirst()
                .orElseThrow(IllegalStateException::new);
    }
    
    public static TypeHeure getTypeHeureByLabel(String label) {
        return Stream.of(TypeHeure.values())
                .filter(TypeHeure -> TypeHeure.getLabel().equalsIgnoreCase(label))
                .findFirst()
                .orElseThrow(IllegalStateException::new);
    }
    
    @Override
    public String toString() {
    	return label.toString();
    }
}