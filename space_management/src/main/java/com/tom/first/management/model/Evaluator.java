package com.tom.first.management.model;

import java.util.Set;

import com.tom.first.management.model.enums.Profile;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "evaluator")
public class Evaluator {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
    @ManyToOne
    @JoinColumn(name = "id_evaluator", nullable = false)
    private User evaluator;
    
	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(
	    name = "profile",
	    joinColumns = @JoinColumn(name = "id_user")
	)
	@Column(name = "profile")
	@Enumerated(EnumType.STRING)
    private Set<Profile> perfis;
	
}
