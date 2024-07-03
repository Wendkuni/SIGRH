package net.gestion.pgcongeabsence.common.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;
import java.util.stream.Stream;

import static java.util.Arrays.stream;
import static java.util.stream.Collectors.toList;
@AllArgsConstructor
@Getter
public enum TypeMinute {
	MIN_00("00","00mn"),
	MIN_01("01","01mn"),
	MIN_02("02","02mn"),
	MIN_03("03","03mn"),
	MIN_04("04","04mn"),
	MIN_05("05","05mn"),
	MIN_06("06","06mn"),
	MIN_07("07","07mn"),
	MIN_08("08","08mn"),
	MIN_09("09","09mn"),
	MIN_10("10","10mn"),
	MIN_11("11","11mn"),
	MIN_12("12","12mn"),
	MIN_13("13","13mn"),
	MIN_14("14","14mn"),
	MIN_15("15","15mn"),
	MIN_16("16","16mn"),
	MIN_17("17","17mn"),
	MIN_18("18","18mn"),
	MIN_19("19","19mn"),
	MIN_20("20","20mn"),
	MIN_21("21","21mn"),
	MIN_22("22","22mn"),
	MIN_23("23","23mn"),
	MIN_24("24","24mn"),
	MIN_25("25","25mn"),
	MIN_26("26","26mn"),
	MIN_27("27","27mn"),
	MIN_28("28","28mn"),
	MIN_29("29","29mn"),
	MIN_30("30","30mn"),
	MIN_31("31","31mn"),
	MIN_32("32","32mn"),
	MIN_33("33","33mn"),
	MIN_34("34","34mn"),
	MIN_35("35","35mn"),
	MIN_36("36","36mn"),
	MIN_37("37","37mn"),
	MIN_38("38","38mn"),
	MIN_39("39","39mn"),
	MIN_40("40","40mn"),
	MIN_41("41","41mn"),
	MIN_42("42","42mn"),
	MIN_43("43","43mn"),
	MIN_44("44","44mn"),
	MIN_45("45","45mn"),
	MIN_46("46","46mn"),
	MIN_47("47","47mn"),
	MIN_48("48","48mn"),
	MIN_49("49","49mn"),
	MIN_50("50","50mn"),
	MIN_51("51","51mn"),
	MIN_52("52","52mn"),
	MIN_53("53","53mn"),
	MIN_54("54","54mn"),
	MIN_55("55","55mn"),
	MIN_56("56","56mn"),
	MIN_57("57","57mn"),
	MIN_58("58","58mn"),
	MIN_59("59","59mn");
	
	private final String code;
    private final String label;
    
    public static List<TypeMinute> getMinutes() {
        return stream(TypeMinute.values()).collect(toList());
    }

    public static TypeMinute getTypeMinuteByCode(String code) {
        return Stream.of(TypeMinute.values())
                .filter(TypeMinute -> TypeMinute.getCode().equalsIgnoreCase(code))
                .findFirst()
                .orElseThrow(IllegalStateException::new);
    }
    
    public static TypeMinute getTypeMinuteByLabel(String label) {
        return Stream.of(TypeMinute.values())
                .filter(TypeMinute -> TypeMinute.getLabel().equalsIgnoreCase(label))
                .findFirst()
                .orElseThrow(IllegalStateException::new);
    }
    
    @Override
    public String toString() {
    	return label.toString();
    }
}