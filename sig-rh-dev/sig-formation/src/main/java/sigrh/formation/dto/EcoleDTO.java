package sigrh.formation.dto;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EcoleDTO {	
	private Integer idEcole;
	@Column(unique = true)
   private  String codeEcole;
    private String nomEcole;
    private String contact;
   private String adresse;
    private String email;
    private List<String> roles;

}
