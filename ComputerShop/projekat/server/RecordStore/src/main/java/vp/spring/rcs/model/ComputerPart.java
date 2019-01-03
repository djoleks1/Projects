package vp.spring.rcs.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class ComputerPart {

	@Id
	@GeneratedValue
	private Long id;

	@ManyToOne
	private Brand brand;

	private String name;
	private String price;

	public ComputerPart() {
		super();
	}

	public ComputerPart(Long id, Brand brand, String name, String price) {
		super();
		this.id = id;
		this.brand = brand;
		this.name = name;
		this.price = price;
	}

	public Brand getBrand() {
		return brand;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getPrice() {
		return price;
	}

	public void setBrand(Brand brand) {
		this.brand = brand;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPrice(String price) {
		this.price = price;
	}

}
