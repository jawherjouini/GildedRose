
public class ItemUpdaterImpl implements ItemUpdater {
	
	protected Integer decreaseQualityIfNotMin(Integer quality) {
		if (quality > 0) {
			quality = quality - 1;
		}
		return quality;
	}

	protected Integer increaseQualityIfNotMax(Integer quality) {
		if (quality < 50) {
			quality = quality + 1;
		}
		return quality;
	}

	@Override
	public void updateQuality(Item item) {
		item.setQuality(decreaseQualityIfNotMin(item.getQuality()));
        if (item.getSellIn() <= 0) {
    		item.setQuality(decreaseQualityIfNotMin(item.getQuality()));
        }
	}

}
