
public class Main {

	public static void main(String[] args) {
		User user = new User("Alex", 101);

        Cart cart1 = new Cart("Electronics");
        cart1.addProduct(new PhysicalProduct("ThinkPad X1", "Lenovo", 1299.99f, 1800f));
        cart1.addProduct(new DigitalProduct("MS Office", "Microsoft", 149.99f, "http://store.com/office"));

        user.addCart(cart1);

        Order order = new Order(user, user.getCarts());
        System.out.println(order);

        System.out.printf("Date: %s\n", order.getCreatedAt());
        System.out.printf("Order status: %s\n", order.getStatus());
        order.setStatus("Paid");
        System.out.printf("Order status: %s\n", order.getStatus());
        System.out.printf("Total price: %.2f\n", order.getTotalPrice());
        
        order.pay();
	}

}
