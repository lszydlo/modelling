package eu.skillcraft.modelling.cart;

import java.util.List;

public class ShoppingCart {

	private static final int ITEM_LIMIT = 100;
	private List<CartItem> items;

	public void add(SKU sku, Integer quantity, PriceInfo priceInfo, AvailabilityInfo availability) {
		if(cartItemLimitIsExceeded()) {
			throw new RuntimeException("...");
		}
		if (availability.isLessThen(quantity)) {
			throw new RuntimeException("...");
		}

		items.add(new CartItem(sku,quantity,priceInfo));
	}



	private boolean cartItemLimitIsExceeded() {
		return items.size() == ITEM_LIMIT;
	}

	public void delete(SKU sku) {
		items.removeIf(cartItem -> cartItem.isFor(sku));
	}

	public void changeQuantity(SKU sku, Integer quantity, AvailabilityInfo availability) {
		if (availability.isLessThen(quantity)) {
			throw new RuntimeException("...");
		}
		items.stream()
				.filter(cartItem -> cartItem.isFor(sku))
				.findAny()
				.ifPresent(cartItem -> cartItem.updateQuantity(quantity));
	}
}
