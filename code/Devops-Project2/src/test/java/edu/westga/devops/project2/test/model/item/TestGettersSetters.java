package edu.westga.devops.project2.test.model.item;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import edu.westga.devops.project2.model.Item;

public class TestGettersSetters {
	
	@Test
	void testSetName() {
		Item item = new Item("Apple");
		
		item.setName("Orange");
		
		assertEquals("Orange", item.getName());
	}
	
	@Test
	void testSetQuantity() {
		Item item = new Item("Apple");
		
		item.setQuantity(6);
		
		assertEquals(6, item.getQuantity());
	}

	@Test
	void testSetEmptyName() {
		Item item = new Item("Apple");

		assertThrows(IllegalArgumentException.class, () -> {
			item.setName("");
		});
	}
	
	@Test
	void testSetInvalidQuantity() {
		Item item = new Item("Apple");

		assertThrows(IllegalArgumentException.class, () -> {
			item.setQuantity(0);
		});
	}
}
