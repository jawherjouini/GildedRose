
public class CustomItemUpdaterImpl extends ItemUpdaterImpl {

	@Override
	public void updateQuality(Item item) {
		item.setQuality(increaseQualityIfNotMax(item.getQuality()));
		if (item.getSellIn() <= 0) {
			item.setQuality(increaseQualityIfNotMax(item.getQuality()));
		}
	}

}
