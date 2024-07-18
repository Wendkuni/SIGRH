package net.gestion.pgm;

import net.gestion.pgm.common.constant.TypeDistinction;
import net.gestion.pgm.domains.personnel.CritereAffectation;
import net.gestion.pgm.domains.personnel.PersonnelAffectationModel;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class PgmApplication {

	public static void main(String[] args) {
		SpringApplication.run(PgmApplication.class, args);
	}

}
