package com.tom.first.library.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.tom.first.library.common.SystemUtils;
import com.tom.first.library.dto.ItemRequest;
import com.tom.first.library.dto.ItemRequest.bookItemRequest;
import com.tom.first.library.dto.ItemResponse;
import com.tom.first.library.dto.ItemResponse.ItemBookResponse;
import com.tom.first.library.dto.UserRequest.NameRequest;
import com.tom.first.library.exception.LimitException;
import com.tom.first.library.exception.NotFoundException;
import com.tom.first.library.mapper.BookMapper;
import com.tom.first.library.model.BookItem;
import com.tom.first.library.model.User;
import com.tom.first.library.model.enums.Status;
import com.tom.first.library.repository.BookRepository;
import com.tom.first.library.repository.ItemRepository;
import com.tom.first.library.repository.UserRepository;

import br.tekk.system.library.exception.BookItemNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ItemService extends SystemUtils {

	@Value("${application.limit.books}")
	private final static int MAX_BOOKS = 4;

	private final ItemRepository itemRepository;
	private final UserRepository userRepository;
	private final BookRepository bookRepository;
	private final BookMapper mapper;

	public List<ItemResponse> findAll() {
		List<BookItem> bookItems = itemRepository.findAll();
		if (bookItems.isEmpty()) {
			throw new NotFoundException("No books items found");
		}
		return bookItems.stream().map(mapper::fromBookItem).collect(Collectors.toList());
	}

	public List<ItemBookResponse> findItemByUser(NameRequest request) {
		User user = userRepository.findByName(request.username()).orElseThrow(
				() -> new NotFoundException(String.format("User with name %s was not found.", request.username())));

		List<BookItem> items = itemRepository.findByUser(user.getId());
		if (items.isEmpty()) {
			throw new NotFoundException(String.format("No book items found for user: %s.", request.username()));
		}
		return items.stream().map(mapper::fromBookItemUser).collect(Collectors.toList());
	}

	@Transactional
	public ItemBookResponse createItem(ItemRequest request) {

		var book = bookRepository.findByTitle(request.bookName())
				.orElseThrow(() -> new NotFoundException("Book not found with ID: " + request.bookName()));

		var user = userRepository.findByName(request.username())
				.orElseThrow(() -> new NotFoundException("User not found with ID: " + request.username()));

		if (itemRepository.countByUserIdAndBookIdAndStatus(user.getId(), book.getId(), Status.RENT) > MAX_BOOKS) {
			throw new LimitException("User reached max rent limit for book ID: " + book.getTitle());
		}

		var itemBook = mapper.toBookItem(book, user);
		itemBook.setStatus(Status.AVAILABLE);
		itemRepository.save(itemBook);
		return mapper.fromBookItemUser(itemBook);
	}

	@Transactional
	public ItemBookResponse updateItem(bookItemRequest request) {
		var itemBook = itemRepository.findByName(bookItemId).orElseThrow(() -> new BookItemNotFoundException(
				String.format("Cannot update BookItem, no bookItem found with the provide ID:: %s", bookItemId)));
		itemBook.setStatus(Status.AVAILABLE);
		mergeItem(book, request);
		
		bookItemRepository.save(book);
	}

	@Transactional
	public ItemBookResponse startRent(NameRequest name, bookItemRequest request) {
		itemBook.setStatus(Status.RENT);
		itemBook.set
		return null;
	}

	@Transactional
	public void deleteItem(NameRequest name, bookItemRequest request) {
		if (!itemRepository.existsById(bookItemId)) {
			throw new BookItemNotFoundException("Book not found with ID:: " + bookItemId);
		}
		itemRepository.deleteById(bookItemId);
	}

}
