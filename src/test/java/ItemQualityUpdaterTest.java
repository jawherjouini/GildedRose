import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class ItemQualityUpdaterTest {

    @Test
    public void should_increase_quality_when_brie_ages() {
        ItemUpdater brieUpdater = new CustomItemUpdaterImpl();
        Item cheese = new Item(GildedRose.NAME_BRIE, 4, 5);

        brieUpdater.updateQuality(cheese);

        assertEquals(6, cheese.getQuality());
    }

	@Test
	public void should_have_best_quality_when_expired() {
		ItemUpdater brieUpdater = new CustomItemUpdaterImpl();
		Item cheese = new Item(GildedRose.NAME_BRIE, 0, 5);

		brieUpdater.updateQuality(cheese);

		assertEquals(7, cheese.getQuality());
	}
	
	@Test
	public void should_be_decreasing_quality_twice() {
		ItemUpdater conjuredUpdater = new NewItemUpdaterImpl();
		Item conjured = new Item(GildedRose.NAME_CONJURED, 3, 5);

		conjuredUpdater.updateQuality(conjured);

		assertEquals(3, conjured.getQuality());
	}

	@ParameterizedTest
	@CsvSource({ "12, 3, 4", "7, 3, 5", "2, 3, 6", "0, 3, 0" })
	public void should_keep_increasing_quality_until_expiration(int sellIn, int originalQuality, int qualityAfterUpdate) {
		ItemUpdater expiringItemUpdater = new ExpiringItemUpdaterImpl();
		Item backstagePass = new Item(GildedRose.NAME_BACKSTAGE, sellIn, originalQuality);
		
		expiringItemUpdater.updateQuality(backstagePass);

		assertEquals(qualityAfterUpdate, backstagePass.getQuality());

	}
}