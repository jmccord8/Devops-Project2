package edu.westga.devops.project2.test.model.item;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import edu.westga.devops.project2.model.Item;
import edu.westga.devops.project2.model.ItemManager;
import javafx.collections.ObservableList;

public class TestItemManager {

	@Test
	void testValidItemManager() {
		ItemManager im = new ItemManager();

		assertEquals(0, im.getSize());
	}

	@Test
	void testAddItem() {
		ItemManager im = new ItemManager();

		im.addItem(new Item("Apple"));

		assertEquals(1, im.getSize());
	}

	@Test
	void testAddNullItem() {
		ItemManager im = new ItemManager();

		assertThrows(IllegalArgumentException.class, () -> {
			im.addItem(null);
		});
	}

	@Test
	void testRemoveItem() {
		ItemManager im = new ItemManager();
		Item item = new Item("Apple");
		im.addItem(item);
		assertEquals(1, im.getSize());

		im.removeItem(item);

		assertEquals(0, im.getSize());
	}

	@Test
	void testRemoveNullItem() {
		ItemManager im = new ItemManager();

		assertThrows(IllegalArgumentException.class, () -> {
			im.removeItem(null);
		});
	}
	
	@Test
	void testGetItems() {
		ItemManager im = new ItemManager();
		im.addItem(new Item("Apple"));
		im.addItem(new Item("Orange"));
		im.addItem(new Item("Banana"));
		
		ObservableList<Item> result = im.getItems();
		
		assertEquals(3, result.size());
		assertEquals("Apple", result.get(0).getName());
		assertEquals("Orange", result.get(1).getName());
		assertEquals("Banana", result.get(2).getName());
	}

}
