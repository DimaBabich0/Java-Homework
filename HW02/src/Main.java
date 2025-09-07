
public class Main {

	public static void main(String[] args) {
		PhysicalProduct p1 = new PhysicalProduct("XPS 13", "Dell", 999.99f, 2750f);
        PhysicalProduct p2 = new PhysicalProduct("Chocolate", "Roshen", 3.50f, 500f);
        DigitalProduct p3 = new DigitalProduct("Windows 11 Activation Key", "Microsoft", 59.99f, "https://microsoft.com/key/m43mkgd4");
        
        Cart cart = new Cart("");  
        cart.addProduct(p1);
        cart.addProduct(p2);
        cart.addProduct(p3);

        OnlineStore.purchaseAll(cart.getProducts().toArray(new Purchasable[0]));
	}

}
