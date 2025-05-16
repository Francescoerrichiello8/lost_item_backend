package it.francescoerrichiello.LostItems.entities;
import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table (name = "lost_items")
@Getter @Setter @NoArgsConstructor @ToString
public class LostItem {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "name")
	private String name;
	
	@Column (name = "description")
	private String description;
	
	@Column
	private Date lost_date;
	
	@Column
	private String location;
	
	@Column(name = "found")
	private boolean found;
	
	@Column(nullable = true)
	private Date found_date;
	
	@Column(nullable = true)
	private String found_location;
}
