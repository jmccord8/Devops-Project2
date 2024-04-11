package edu.westga.devops.project2.test.model.item;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import edu.westga.devops.project2.model.Item;

public class TestConstructor {
	@Test
	void testValidNameConstructor() {
		Item item = new Item("Apple");

		assertAll(() -> {
			assertEquals("Apple", item.getName());
		}, () -> {
			assertEquals(1, item.getQuantity());
		});
	}

	@Test
	void testValidNameQuantityConstructor() {
		Item item = new Item("Apple", 5);

		assertAll(() -> {
			assertEquals("Apple", item.getName());
		}, () -> {
			assertEquals(5, item.getQuantity());
		});
	}
	
	@Test
	void testEmptyNameConstructor() {

		assertThrows(IllegalArgumentException.class, () -> {
			new Item("");
		});
	}
	
	@Test
	void testEmptyNameWithQuantityConstructor() {

		assertThrows(IllegalArgumentException.class, () -> {
			new Item("", 1);
		});
	}

	@Test
	void testInvalidQuantityAt0Constructor() {

		assertThrows(IllegalArgumentException.class, () -> {
			new Item("Apple", 0);
		});
	}
	
	@Test
	void testInvalidQuantityBelow0Constructor() {

		assertThrows(IllegalArgumentException.class, () -> {
			new Item("Apple", 0);
		});
	}
}
