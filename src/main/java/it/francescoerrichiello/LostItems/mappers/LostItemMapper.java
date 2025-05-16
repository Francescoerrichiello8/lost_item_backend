package it.francescoerrichiello.LostItems.mappers;

import it.francescoerrichiello.LostItems.dto.LostItemRequestDTO;
import it.francescoerrichiello.LostItems.dto.LostItemRequestPutDTO;
import it.francescoerrichiello.LostItems.entities.LostItem;
import it.francescoerrichiello.LostItems.entities.PutItem;
import jakarta.validation.Valid;

public class LostItemMapper {

	public static LostItem dtoToEntity(@Valid LostItemRequestDTO lostItemRequestDTO) {
		LostItem lostItem = new LostItem();
		
		lostItem.setName(lostItemRequestDTO.getName());
		lostItem.setDescription(lostItemRequestDTO.getDescription());
		lostItem.setLost_date(lostItemRequestDTO.getLost_date());
		lostItem.setLocation(lostItemRequestDTO.getLocation());
		lostItem.setFound(lostItemRequestDTO.isFound());
		lostItem.setFound_date(lostItemRequestDTO.getFound_date());
		lostItem.setFound_location(lostItemRequestDTO.getFound_location());
		
		return lostItem;
	}
	public static LostItem dtoToEntityUpdate(@Valid LostItemRequestDTO lostItemRequestDTO, Long id) {
		LostItem lostItem = dtoToEntity(lostItemRequestDTO);
		lostItem.setId(id);
		return lostItem;
		
	}

	

	public static PutItem dtoToEntity(@Valid LostItemRequestPutDTO lostItemRequestPutDTO) {
		PutItem putItem = new PutItem();
		
		putItem.setName(lostItemRequestPutDTO.getName());
		putItem.setFound(lostItemRequestPutDTO.isFound());
		putItem.setFound_date(lostItemRequestPutDTO.getFound_date());
		putItem.setFound_location(lostItemRequestPutDTO.getFound_location());
		
		return putItem;
	}
	public static PutItem dtoToEntityUpdate(@Valid LostItemRequestPutDTO lostItemRequestPutDTO, Long id) {
		PutItem putItem = dtoToEntity(lostItemRequestPutDTO);
		putItem.setId(id);
		return putItem;
		
	}

}
