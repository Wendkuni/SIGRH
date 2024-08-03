package net.gestion.pgm.common.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;
import java.util.stream.Stream;

import static java.util.Arrays.stream;
import static java.util.stream.Collectors.toList;
@AllArgsConstructor
@Getter
public enum TypeTrimestre {
	_1T(1,"Premier Trimestre"),
	_2T(2,"Second Trimestre"),
	_3T(3,"Troisième Trimestre"),
	_4T(4,"Quatrième Trimestre");
	
	private final Integer code;
    private final String label;
    
    public static List<TypeTrimestre> getTrimestres() {
        return stream(TypeTrimestre.values()).collect(toList());
    }

    public static TypeTrimestre getTypeTrimestreByCode(String code) {
        return Stream.of(TypeTrimestre.values())
                .filter(TypeTrimestre -> TypeTrimestre.getCode().equals(code))
                .findFirst()
                .orElseThrow(IllegalStateException::new);
    }
    
    public static TypeTrimestre getTypeTrimestreByLabel(String label) {
        return Stream.of(TypeTrimestre.values())
                .filter(TypeTrimestre -> TypeTrimestre.getLabel().equalsIgnoreCase(label))
                .findFirst()
                .orElseThrow(IllegalStateException::new);
    }
    
    @Override
    public String toString() {
    	return label.toString();
    }

}