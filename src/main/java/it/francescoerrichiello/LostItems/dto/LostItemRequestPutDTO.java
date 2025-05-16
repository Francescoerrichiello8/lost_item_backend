package it.francescoerrichiello.LostItems.dto;

import java.sql.Date;

import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter @Getter @AllArgsConstructor @ToString
public class LostItemRequestPutDTO {
	
	@NotBlank(message= "inserire un oggetto ritrovato!")
	private String name;
	
	@AssertTrue(message="inserire un oggetto ritrovato!")
	private boolean found;
	
	private Date found_date;
	
	private String found_location;
}
