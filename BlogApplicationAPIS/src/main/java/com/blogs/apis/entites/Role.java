package com.blogs.apis.entites;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Data
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
}
