package net.gestion.pgm.common.constant;

import lombok.Getter;

import java.util.stream.Stream;

@Getter
public enum TypeEducation {

	AUCUN("aucun"),
	SCOLAIRE("Scolaire"),
	FORMATION("Formation"),
	PROFESSIONNEL("Professionnel");

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

}
