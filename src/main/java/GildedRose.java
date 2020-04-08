import java.util.ArrayList;
import java.util.List;

public class GildedRose {
	
	public static final String NAME_BRIE = "Aged Brie";
	public static final String NAME_ELIXIR = "Elixir of the Mongoose";
	public static final String NAME_BACKSTAGE = "Backstage passes to a TAFKAL80ETC concert";
	public static final String NAME_SULFURAS = "Sulfuras, Hand of Ragnaros";
	public static final String NAME_CONJURED = "Conjured Mana Cake";

	private List<Item> items = null;

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	public GildedRose(Item item) {
		this.items = new ArrayList<Item>();
		this.items.add(item);
	}

	public GildedRose(List<Item> items) {
		this.items = items;
	}

	public void updateItems() {
		for (Item item : items) {
			updateItemQuality(item);
			updateSellIn(item);
		}
	}

	private void updateSellIn(Item item) {
		if (item.getName().equals(NAME_SULFURAS)) {
			// LEGENDARY ITEM DOES NOT CHANGE
		} else {
			item.setSellIn(item.getSellIn() - 1);
		}
	}

	private void updateItemQuality(Item item) {
		ItemUpdater updater = getItemUpdater(item);
		updater.updateQuality(item);
	}

	private ItemUpdater getItemUpdater(Item item) {
		ItemUpdater itemUpdater = null;
		switch (item.getName()) {
		case NAME_BRIE:
			itemUpdater = new CustomItemUpdaterImpl();
			break;
		case NAME_BACKSTAGE:
			itemUpdater = new ExpiringItemUpdaterImpl();
			break;
		case NAME_SULFURAS:
			itemUpdater = new UnchangingItemUpdaterImpl();
			break;
		case NAME_CONJURED:
			itemUpdater = new NewItemUpdaterImpl();
			break;
		default:
			itemUpdater = new ItemUpdaterImpl();
			break;
		}
		return itemUpdater;
	}

}