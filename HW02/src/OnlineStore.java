import java.util.ArrayList;
import java.util.List;

public class OnlineStore {
    private static List<User> users;

    static {
        users = new ArrayList<User>();
    }

    public static void addUser(User user) {
        users.add(user);
    }

    public static List<User> getUsers() {
        return users;
    }

    public static int getTotalProducts() {
        int total = 0;
        for (User user : users) {
            for (Cart cart : user.getCarts()) {
                total += cart.getProducts().size();
            }
        }
        return total;
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
