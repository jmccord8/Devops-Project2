package edu.westga.devops.project2.test.model.item;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.devops.project2.model.Item;

public class TestToString {

	@Test
	void testToString1Quantity() {
		Item item = new Item("Apple");
		
		assertEquals("Apple", item.toString());
	}
	
	@Test
	void testToStringMoreThan1Quantity() {
		Item item = new Item("Apple", 5);
		
		assertEquals("Apple (5)", item.toString());
	}
}
