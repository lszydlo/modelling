package eu.skillcraft.modelling.cart;

public interface CartRepo {
	ShoppingCart load(CustomerId customerId);

	void save(ShoppingCart cart);
}
