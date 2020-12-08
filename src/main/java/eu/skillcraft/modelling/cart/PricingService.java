package eu.skillcraft.modelling.cart;

public interface PricingService {
	PriceInfo getPrice(SKU sku, CustomerId customerId);
}
