
public class NewItemUpdaterImpl extends ItemUpdaterImpl {

	@Override
	public void updateQuality(Item item) {
		item.setQuality(decreaseQualityIfNotMin(item.getQuality()));
		item.setQuality(decreaseQualityIfNotMin(item.getQuality()));
	}

}
