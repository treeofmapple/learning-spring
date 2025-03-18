package com.tom.first.library.service;

import org.springframework.stereotype.Service;

import com.tom.first.library.common.SystemUtils;
import com.tom.first.library.mapper.BookMapper;
import com.tom.first.library.repository.ItemRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ItemService extends SystemUtils {

	private final ItemRepository repository;
	private final BookMapper mapper;
	
	
	
	
	
	
	
	
	
	
}
