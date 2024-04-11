package edu.westga.devops.project2.model;

public class Item {
	private final String NAME_EMPTY = "Name cannot be empty";
	private final String INVALID_QUANTITY = "Quantity cannot be less than 1";
	private String name;
	private int quantity;

	public Item(String name) {
		if (name.isEmpty()) {
			throw new IllegalArgumentException(NAME_EMPTY);
		}

		this.name = name;
		this.quantity = 1;
	}

	public Item(String name, int quantity) {
		if (name.isEmpty()) {
			throw new IllegalArgumentException(NAME_EMPTY);
		}
		if (quantity < 1) {
			throw new IllegalArgumentException(INVALID_QUANTITY);
		}
		this.name = name;
		this.quantity = quantity;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		if (name.isEmpty()) {
			throw new IllegalArgumentException(NAME_EMPTY);
		}

		this.name = name;
	}

	public int getQuantity() {
		return this.quantity;
	}

	public void setQuantity(int quantity) {
		if (quantity < 1) {
			throw new IllegalArgumentException(INVALID_QUANTITY);
		}
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		if(this.quantity > 1) {
			return this.name + " (" + this.quantity + ")";
		}
		return this.name ;
	}
}
