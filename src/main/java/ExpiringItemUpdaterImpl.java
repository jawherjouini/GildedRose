
public class ExpiringItemUpdaterImpl extends ItemUpdaterImpl {

	@Override
	public void updateQuality(Item item) {
		item.setQuality(increaseQualityIfNotMax(item.getQuality()));
		if (item.getSellIn() <= 10) {
			item.setQuality(increaseQualityIfNotMax(item.getQuality()));
		}
		if (item.getSellIn() <= 5) {
			item.setQuality(increaseQualityIfNotMax(item.getQuality()));
		}
		if (item.getSellIn() <= 0) {
			item.setQuality(0);
		}
	}

}
