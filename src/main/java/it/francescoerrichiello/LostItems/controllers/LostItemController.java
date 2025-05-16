package it.francescoerrichiello.LostItems.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import it.francescoerrichiello.LostItems.dto.LostItemRequestDTO;
import it.francescoerrichiello.LostItems.dto.LostItemRequestPutDTO;
import it.francescoerrichiello.LostItems.entities.LostItem;
import it.francescoerrichiello.LostItems.mappers.LostItemMapper;
import it.francescoerrichiello.LostItems.repositories.LostItemRepository;
import jakarta.validation.Valid;

@RestController
@CrossOrigin
public class LostItemController {
	private LostItemRepository lostItemRepository;
	
	public LostItemController(LostItemRepository lostItemRepository) {
		this.lostItemRepository = lostItemRepository;
	}
	
	@GetMapping("/lostItems")
	public ResponseEntity<List<LostItem>> index()
	{
		List<LostItem> lostItems = this.lostItemRepository.findAll();
		return ResponseEntity.status(HttpStatus.OK).body(lostItems);
	}
	
	@GetMapping("/lostItems/{id}")
	public ResponseEntity<?> show(@PathVariable Long id)
	{
		Optional<LostItem> optionalLostItem = this.lostItemRepository.findById(id);
		if(optionalLostItem.isEmpty()) 
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("oggetto sconosciuto.");
		}
		else
		{
			return ResponseEntity.status(HttpStatus.OK).body(optionalLostItem.get());
		}
	}
	
	@GetMapping("/lostItems/found/{found}")
	public ResponseEntity<?> showFound(@PathVariable Boolean found)
	{
		List<LostItem> lostItems = this.lostItemRepository.findByFound(found);
		return ResponseEntity.status(HttpStatus.OK).body(lostItems);
	}
	
	@PostMapping("/lostItems")
	public ResponseEntity<?> store(
			@Valid @RequestBody LostItemRequestDTO lostItemRequestDTO,
			BindingResult result
		){
		if(result.hasErrors()) {
			Map<String, String> errors = new HashMap<String , String>();
			result.getFieldErrors().forEach( error -> errors.put(error.getField(), error.getDefaultMessage()));
			System.out.println(errors);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
		}
		
		LostItem lostItem = LostItemMapper.dtoToEntity(lostItemRequestDTO);
		LostItem lostItemInserted = this.lostItemRepository.save(lostItem);
		return ResponseEntity.status(HttpStatus.CREATED).body(lostItemInserted);
	}
	
	@DeleteMapping("/lostItems/{id}")
	public ResponseEntity<?> destroy(@PathVariable Long id){
		Optional<LostItem> optionalLostItem = this.lostItemRepository.findById(id);
		if(optionalLostItem.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("oggetto sconosciuto");
		}
		else {
			this.lostItemRepository.deleteById(id);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
		}
	}
	
//	@PutMapping("/lostItems/{id}")
//	public ResponseEntity<?> modify(
//			@Valid @RequestBody LostItemRequestPutDTO lostItemRequestPutDTO,
//			@PathVariable Long id,
//			BindingResult result
//		){
//		if(result.hasErrors()) {
//			Map<String, String> errors = new HashMap<String , String>();
//			result.getFieldErrors().forEach( error -> errors.put(error.getField(), error.getDefaultMessage()));
//			System.out.println(errors);
//			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
//		}
//		PutItem putItem = LostItemMapper.dtoToEntity(lostItemRequestPutDTO);
//		PutItem putItemInserted = this.lostItemRepository.save(putItem);
//		return ResponseEntity.status(HttpStatus.OK).body(putItemInserted);
//	}
	
	@PutMapping("/lostItems/{id}")
	public ResponseEntity<?> modify(
	        @Valid @RequestBody LostItemRequestPutDTO lostItemRequestPutDTO,
	        @PathVariable Long id,
	        BindingResult result
	) {
	    if (result.hasErrors()) {
	        Map<String, String> errors = new HashMap<>();
	        result.getFieldErrors().forEach(error -> errors.put(error.getField(), error.getDefaultMessage()));
	        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
	    }

	    Optional<LostItem> optionalItem = lostItemRepository.findById(id);
	    if (optionalItem.isEmpty()) {
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Oggetto con ID " + id + " non trovato.");
	    }

	    LostItem existingItem = optionalItem.get();

	    
	    existingItem.setFound(lostItemRequestPutDTO.isFound());
	    existingItem.setFound_date(lostItemRequestPutDTO.getFound_date());
	    existingItem.setFound_location(lostItemRequestPutDTO.getFound_location());

	    LostItem updatedItem = lostItemRepository.save(existingItem);

	    return ResponseEntity.ok(updatedItem);
	}
}
