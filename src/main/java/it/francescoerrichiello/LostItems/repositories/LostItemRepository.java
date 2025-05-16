package it.francescoerrichiello.LostItems.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import it.francescoerrichiello.LostItems.entities.LostItem;


public interface LostItemRepository extends JpaRepository<LostItem, Long>{

	public List<LostItem> findByFound(Boolean found);
	
}