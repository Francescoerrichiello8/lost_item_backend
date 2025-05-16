package it.francescoerrichiello.LostItems.dto;

import java.sql.Date;

import jakarta.validation.constraints.AssertFalse;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter @Getter @AllArgsConstructor @ToString
public class LostItemRequestDTO {
	
	@NotBlank(message= "Campo 'nome' obbligatorio")
	private String name;
	
	private String description;
	
	private Date lost_date;
	
	@NotBlank(message="Campo 'location' obbligatorio")
	private String location;
	
	@AssertFalse(message="inserire un oggetto perso!")
	private boolean found;
	
	private Date found_date;
	
	private String found_location;
}
