import java.util.ArrayList;
import java.util.List;

import org.approvaltests.combinations.CombinationApprovals;
import org.approvaltests.legacycode.Range;
import org.junit.Test;

public class GildedRoseTest {

	@Test
	public void updateQuality() {
		String[] names = { GildedRose.NAME_BRIE, GildedRose.NAME_BACKSTAGE,
				GildedRose.NAME_SULFURAS, GildedRose.NAME_ELIXIR };
		Integer[] sellins = Range.get(-1, 100);
		Integer[] qualities = Range.get(-1, 100);

		CombinationApprovals.verifyAllCombinations(this::doUpdateQuality, names,
				 sellins, qualities);
	}

	private Item doUpdateQuality(String name, int sellIn, int quality) {
		List<Item> items = new ArrayList<Item>();
		items.add(new Item(name, sellIn, quality));
		GildedRose app = new GildedRose(items);
		app.updateItems();
		Item item = app.getItems().get(0);
		return item;
	}

}
