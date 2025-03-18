package com.tom.first.library.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tom.first.library.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

	boolean existsByTitle(String title);

	boolean existsByAuthor(String author);
	
	List<Book> findByLaunchYear(LocalDate launchYear); // make it look for a range
	
	Optional <Book> findByTitle(String title);
	
	List<Book> findByAuthor(String author);
}
