import java.util.ArrayList;
import java.util.List;

public class OnlineStore {
    private static List<User> users;
    private static List<Product> products;

    static {
        users = new ArrayList<User>();
        products = new ArrayList<Product>();
    }
    
    public static void addUser(User user) {
        users.add(user);
    }
    
    public static void addProduct(Product product) {
    	products.add(product);
    }

    public static List<User> getUsers() {
        return users;
    }
    public static List<Product> getProducts() {
        return products;
    }

    public static int getTotalAddedProducts() {
        int total = 0;
        for (User user : users) {
            for (Cart cart : user.getCarts()) {
                total += cart.getProducts().size();
            }
        }
        return total;
    }
    
    public static Product findProductById(int id) throws ProductNotFoundException {
    	for (Product p : products) {
            if (p.getId() == id) {
                return p;
            }
        }
        throw new ProductNotFoundException(String.format("Product with id %d not found", id));
    }
    
    public static void purchaseUserCarts(User user) {
    	for (Cart cart : user.getCarts()) {
            for (Product product : cart.getProducts()) {
           	 product.purchase();
            }
        }
   }
    
    public static void purchaseAll(Purchasable[] listProducts) {
    	 for (Purchasable purchasable : listProducts) {
			purchasable.purchase();
		}
    }
}
