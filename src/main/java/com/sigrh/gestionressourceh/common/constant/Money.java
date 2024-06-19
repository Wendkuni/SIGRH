package com.sigrh.gestionressourceh.common.constant;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.stream.Stream;
@AllArgsConstructor
@Getter
@ToString
public enum Money {
	 // Initialize the elements from Constructor.
	   // The element is always final, static
	   ZERO(0, "Zero"), 
	   UN(1, "Un"), 
	   DEUX(2, "Deux"),
	   TROIS(3, "Trois"), 
	   QUATRE(4, "Quatre"),
	   CINQ(5, "Cinq"), 
	   SIX(6, "Six"),
	   SEPT(7, "Sept"), 
	   HUIT(8, "Huit"),
	   NEUF(9, "Neuf"), 
	   DIX(10, "Dix"),
	   ONZE(11, "Onze"),
	   DOUZE(12, "Douze"),
	   TREIZE(13, "Treize"),
	   QUATORZE(14, "Quatorze"),
	   QUINZE(15, "Quinze"),
	   SEIZE(16, "Seize"),
	   DIXSEPT(17, "Dix Sept"),
	   DIXHUIT(18, "Dix Huit"),
	   DIXNEUF(19, "Dix Neuf"),
	   VINGT(20, "Vingt"),
	   TRENTE(30, "Trente"),
	   QUARANTE(40, "Quarante"),
	   CINQUANTE(50, "Cinquante"),
	   SOIXANTE(60, "Soixante"),
	   SOIXANTEDIX(70, "Soixante Dix"),
	   QUATREVINGT(80, "Quatre vingt"),
	   QUATREVINGTDIX(90, "Quatre vingt Dix"),
	   CENT(100, "Cent"),
	   MILLE(1000, "Mille"),
	   MILLION(1000, "Million"),
	   MILLIARD(1000, "Milliard");
	 
	   private Integer code;
	   private String text;
	 

	 
	   // Static method return Gender by code.
	   public static Money getGenderByCode(Integer code) {
	       return Stream.of(Money.values())
           .filter(Money -> Money.getCode().equals(code))
           .findFirst()
           .orElseThrow(IllegalStateException::new);
	   }

	   public void setCode(Integer code) {
	       this.code = code;
	   }

	   public void setText(String text) {
	       this.text = text;
	   }
}
