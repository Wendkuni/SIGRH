package com.sigrh.gestionressourceh.common.constant;

import java.util.stream.Stream;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
public enum TypeEducation {
	AUCUN, SCOLAIRE, FORMATION, PROFESSIONAL;

	/*AUCUN("aucun"), SCOLAIRE("Scolaire"), FORMATION("Formation"), PROFESSIONAL("Professional");

	private final String label;

	TypeEducation(String string) {
		this.label = string;
	}

	public static TypeEducation getTypeEducationByLabel(String label) {
		return Stream.of(TypeEducation.values()).filter(t -> t.getLabel().equalsIgnoreCase(label)).findFirst()
				.orElseThrow(IllegalStateException::new);
	}

	@Override
	public String toString() {
		return label.toString();
	}
*/
}
