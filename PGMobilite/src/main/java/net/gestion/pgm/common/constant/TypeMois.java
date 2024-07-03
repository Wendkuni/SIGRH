package net.gestion.pgm.common.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;
import java.util.stream.Stream;

import static java.util.Arrays.stream;
import static java.util.stream.Collectors.toList;
@AllArgsConstructor
@Getter
public enum TypeMois {
	JANVIER("01","Janvier"),
	FEVRIER("02","Février"),
	MARS("03","Mars"),
	AVRIL("04","Avril"),
	MAI("05","Mai"),
	JUIN("06","Juin"),
	JUILLET("07","Juillet"),
	AOUT("08","Aout"),
	SEPTEMBRE("09","Septembre"),
	OCTOBRE("10","Octobre"),
	NOVEMBRE("11","Novembre"),
	DECEMBRE("12","Décembre");
	
	private final String code;
    private final String label;
    
    public static List<TypeMois> getMois() {
        return stream(TypeMois.values()).collect(toList());
    }

    public static TypeMois getTypeMoisByCode(String code) {
        return Stream.of(TypeMois.values())
                .filter(TypeMois -> TypeMois.getCode().equalsIgnoreCase(code))
                .findFirst()
                .orElseThrow(IllegalStateException::new);
    }
    
    public static TypeMois getTypeMoisByLabel(String label) {
        return Stream.of(TypeMois.values())
                .filter(TypeMois -> TypeMois.getLabel().equalsIgnoreCase(label))
                .findFirst()
                .orElseThrow(IllegalStateException::new);
    }
    
    @Override
    public String toString() {
    	return label.toString();
    }

}