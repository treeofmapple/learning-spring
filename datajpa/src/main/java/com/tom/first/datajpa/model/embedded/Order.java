package com.tom.first.datajpa.model.embedded;

import jakarta.persistence.Embedded;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "_order")
public class Order {

	@EmbeddedId
	private OrderId id;
	
	@Embedded
	private Address address;
	
	private String orderInfo;
	
	private String anotherField;
	
}
