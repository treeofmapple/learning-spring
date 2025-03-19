package com.tom.first.library.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tom.first.library.model.BookItem;
import com.tom.first.library.model.enums.Status;

@Repository
public interface ItemRepository extends JpaRepository<BookItem, Long> {

	int countByUserIdAndBookIdAndStatus(UUID userId, Long bookId, Status Status);
	
	List<BookItem> findByUser(UUID userId);
	
}
