import java.util.ArrayList;
import java.util.List;

public class User {
    private String name;
    private int userId;
    private List<Cart> carts;

    //constructors
    public User(String name, int userId, List<Cart> carts) {
        this.name = name;
        this.userId = userId;
        this.carts = carts;
    }

    public User(String name, int userId) {
        this(name, userId, new ArrayList<Cart>());
    }

    //methods
    public void addCart(Cart cart) {
        carts.add(cart);
    }
    
    public void deleteCartByName(String cartName) {
    	for (Cart cart : carts) {
            if (cart.getName().equals(cartName)) {
                carts.remove(cart);
                System.out.println("Cart deleted");
                return;
            }
        }
    	System.out.println("Specific cart not found");
    }
    
    public Cart getCartByName(String cartName) {
        for (Cart cart : carts) {
            if (cart.getName().equals(cartName)) {
                return cart;
            }
        }
        return null;
    }
    
    //getters
    public String getName() { return name; }
    public int getUserId() { return userId; }
    public List<Cart> getCarts() { return carts; }

    //setters
    public void setName(String name) { this.name = name; }
    public void setUserId(int userId) { this.userId = userId; }
    public void setCarts(List<Cart> carts) { this.carts = carts; }

    //override
    @Override
    public String toString() {
    	int cartsSize = 0;
        for (Cart cart : carts) {
        	cartsSize += cart.getProducts().size();
        }
        return String.format("User: %s (ID: %d);\nTotal carts: %d\nTotal products in user carts: %d", 
        		name,
        		userId,
        		carts.size(),
        		cartsSize);
    }
}
