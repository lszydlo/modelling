package eu.skillcraft.modelling.cart;

public interface InventoryService {
	AvailabilityInfo getAvailability(SKU sku);
}
