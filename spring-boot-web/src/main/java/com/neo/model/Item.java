package com.neo.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Item implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false, unique = true)
	private String itemName;
	@Column(nullable = false)
	private String itemCode;

	public Item() {
		super();
	}
	public Item(String itemName, String itemCode) {
		super();
		this.itemName = itemName;
		this.itemCode = itemCode;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getItemCode() {
		return itemCode;
	}

	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}
}