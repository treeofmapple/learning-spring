package com.tom.first.library.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.tom.first.library.common.SystemUtils;
import com.tom.first.library.dto.ItemRequest;
import com.tom.first.library.dto.ItemRequest.bookItemRequest;
import com.tom.first.library.dto.ItemResponse;
import com.tom.first.library.dto.ItemResponse.ItemBookResponse;
import com.tom.first.library.dto.UserRequest.NameRequest;
import com.tom.first.library.mapper.BookMapper;
import com.tom.first.library.repository.ItemRepository;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ItemService extends SystemUtils {

	private final ItemRepository repository;
	private final BookMapper mapper;

	public List<ItemResponse> findAll() {
		return null;
	}
	
	public List<ItemBookResponse> findItemByUser(@Valid NameRequest request) {
		return null;
	}
	
	public ItemBookResponse createItem(@Valid ItemRequest request) {
		return null;
	}
	
	public ItemBookResponse updateItem(NameRequest name, bookItemRequest request) {
		return null;
	}
	
	public ItemBookResponse startRent(NameRequest name, bookItemRequest request) {
		return null;		
	}
	
	public void deleteItem(NameRequest name, bookItemRequest request) {
		
	}
	
	
}
