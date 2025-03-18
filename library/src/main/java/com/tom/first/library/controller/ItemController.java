package com.tom.first.library.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tom.first.library.service.ItemService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/item")
@RequiredArgsConstructor
public class ItemController {

	private final ItemService service;
	
	
	@GetMapping(value = "/get", produces = MediaType.APPLICATION_JSON_VALUE)
	
	
	
	@PostMapping(value = "/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	
	
	
	@PutMapping(value = "/update", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	
	
	
	@DeleteMapping(value = "/delete", produces = MediaType.TEXT_PLAIN_VALUE)
	
	
	
	
}
