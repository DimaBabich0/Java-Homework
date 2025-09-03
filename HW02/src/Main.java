
public class Main {

	public static void main(String[] args) {
		Product p1 = new Product("MacBook Air M2", "Apple", 1199.99f);
		Product p2 = new Product("XPS 13", "Dell", 999.50f);
		Product p3 = new Product("ThinkPad X1 Carbon", "Lenovo", 1299.00f);
		Product p4 = new Product("ZenBook 14", "Asus", 899.99f);
		Product p5 = new Product("Spectre x360", "HP", 1099.49f);

        Cart c1 = new Cart();
        c1.addProduct(p1);
        c1.addProduct(p2);

        Cart c2 = new Cart("My wishlist");
        c2.addProduct(p3);
        
        Cart c3 = new Cart();
        c3.addProduct(p4);
        c3.addProduct(p5);
        
        User u1 = new User("Dima", 1);
        u1.addCart(c1);

        User u2 = new User("Alex", 2);
        u2.addCart(c2);
        u2.addCart(c3);
        
        
        OnlineStore.addUser(u1);
        OnlineStore.addUser(u2);

        System.out.println("\tPrint product:\n" + p1);
        System.out.println("\tPrint cart:\n" + c2);
        System.out.println("\tPrint user:\n" + u2);
        System.out.println("------------------------------");
        System.out.println("Total products in all carts: " + OnlineStore.getTotalProducts());
	}

}
