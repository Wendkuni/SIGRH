
package net.gestion.pgrecrutement.common.constant;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.List;
import java.util.stream.Stream;

import static java.util.Arrays.stream;
import static java.util.stream.Collectors.toList;

@AllArgsConstructor
@Getter
@ToString
public enum TypeColor {
	MediumVioletRed("#C71585","MediumVioletRed"),
	DarkGreen("#006400","DarkGreen"),
	Red("#FF0000","Red"),
	Teal("#008080","Teal"),
	DarkTurquoise("#00CED1","DarkTurquoise"),
	DarkBlue("#00008B","DarkBlue"),
	Brown("#A52A2A","Brown"),
	OrangeRed("#FF4500","OrangeRed"),
	Crimson("#DC143C","Crimson"),
	Turquoise("#40E0D0","Turquoise"),
	Fuchsia("#FF00FF","Fuchsia"),
	Blue("#0000FF","Blue"),
	White("#FFFFFF","White");
	
    private final String code;
    private final String label;

    public static List<TypeColor> getColors() {
        return stream(TypeColor.values()).collect(toList());
    }

    public static TypeColor getTypeColorByCode(String code) {
        return Stream.of(TypeColor.values())
                .filter(TypeColor -> TypeColor.getCode().equalsIgnoreCase(code))
                .findFirst()
                .orElseThrow(IllegalStateException::new);
    }
    
    public static TypeColor getTypeColorByLabel(String label) {
        return Stream.of(TypeColor.values())
                .filter(TypeColor -> TypeColor.getLabel().equalsIgnoreCase(label))
                .findFirst()
                .orElseThrow(IllegalStateException::new);
    }
    
}
