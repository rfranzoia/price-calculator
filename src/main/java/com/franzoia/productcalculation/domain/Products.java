package com.franzoia.productcalculation.domain;

import com.franzoia.productcalculation.util.DefaultEntity;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "products", uniqueConstraints = @UniqueConstraint(name = "uc_product_name", columnNames = { "name" }))
public class Products implements DefaultEntity {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long uuid;

	@Column(nullable = false)
	private String name;

	@Column(nullable = false)
	private Double price;

	public Products() {
	}


	public Products(Long uuid, String name, Double price) {
		this.uuid= uuid;
		this.name = name;
		this.price = price;
	}

	public Products(Long uuid) {
		this.uuid = uuid;
	}
	public Long getUuid() {
		return uuid;
	}

	public void setUuid(Long uuid) {
		this.uuid = uuid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Products products = (Products) o;
		return Objects.equals(getUuid(), products.getUuid());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getUuid());
	}

	@Override
	public String toString() {
		return "Products{" +
				"uuid=" + uuid +
				", name='" + name + '\'' +
				", price=" + price +
				'}';
	}
}
