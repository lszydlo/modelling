package eu.skillcraft.modelling.cart;

public class CartItem {
	private final SKU sku;
	private Integer quantity;
	private PriceInfo priceInfo;

	public CartItem(SKU sku, Integer quantity, PriceInfo priceInfo) {
		this.sku = sku;
		this.quantity = quantity;
		this.priceInfo = priceInfo;
	}

	public boolean isFor(SKU sku) {
		return this.sku.equals(sku);
	}

	public void updateQuantity(Integer quantity) {
		this.quantity = quantity;
	}
}
