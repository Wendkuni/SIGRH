package com.sigrh.gestionressourceh.common.constant;

import lombok.Getter;

import java.util.stream.Stream;
@Getter
public enum TypeAssurance {
	AUCUN("aucun"),
	ASSURANCE_SANTE("Assurance santé"),
	ASSURANCE_VIE("Assurance vie"),
	ASSURANCE_CHOMAGE("Assurance chômage"),
	ASSURANCE_RETRAITE("Assurance retraite"),
	ASSURANCE_INVALIDITE_DE_LONGUE_DUREE("Assurance invalidité de longue durée"),
	ASSURANCE_RESPONSABILITE_CIVILE("Assurance responsabilité civile"),
	ASSURANCE_VOYAGE("Assurance voyage"),
	ASSURANCE_PROTECTION_JURIDIQUE("Assurance de protection juridique"),
	ASSURANCE_ACCIDENT_TRAVAIL_MALADIES_PROFESSIONNELLES("Assurance accident du travail et maladies professionnelles");

	private final String label;

	TypeAssurance(String string) {
		this.label = string;
	}

	public static TypeAssurance getTypeAssuranceByLabel(String label) {
		return Stream.of(TypeAssurance.values()).filter(t -> t.getLabel().equalsIgnoreCase(label)).findFirst()
				.orElseThrow(IllegalStateException::new);
	}

	@Override
	public String toString() {
		return label;
	}
}
