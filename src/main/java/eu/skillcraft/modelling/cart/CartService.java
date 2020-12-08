package eu.skillcraft.modelling.cart;

public class CartService {

	private CartRepo cartRepo;
	private InventoryService inventoryService;
	private PricingService pricingService;

	void addItem(SKU sku,Integer quantity, CustomerId customerId) {

		AvailabilityInfo availability = inventoryService.getAvailability(sku);
		PriceInfo priceInfo = pricingService.getPrice(sku,customerId);

		ShoppingCart cart = cartRepo.load(customerId);
		cart.add(sku,quantity, priceInfo, availability);
		cartRepo.save(cart);
	}

	void deleteItem(SKU sku, CustomerId customerId) {
		ShoppingCart cart = cartRepo.load(customerId);
		cart.delete(sku);
	}

	void changeQuantity(SKU sku,Integer quantity, CustomerId customerId) {
		AvailabilityInfo availability = inventoryService.getAvailability(sku);
		ShoppingCart cart = cartRepo.load(customerId);
		cart.changeQuantity(sku,quantity, availability);
		cartRepo.save(cart);
	}


}
