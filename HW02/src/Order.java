import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class Order {
    private final int id;
    private final User user;
    private final List<Cart> carts;
    private float totalPrice;
    private String status;
    private LocalDateTime createdAt;

    private static class IdGenerator {
        private static int counter = 1;
        public static int nextId() {
            return counter++;
        }
    }

    public Order(User user, List<Cart> carts) {
        this.id = IdGenerator.nextId();
        this.user = user;
        this.carts = carts;
        this.createdAt = LocalDateTime.now();
        this.status = "Created";
        this.totalPrice = calculateTotalPrice();
    }

    private float calculateTotalPrice() {
        float sum = 0;
        for (Cart cart : carts) {
            for (Product p : cart.getProducts()) {
                sum += p.getPrice();
            }
        }
        return sum;
    }

    public void pay() {
        if (status == "Paid") {
            System.out.println("Order #" + id + " is already paid.");
            return;
        }

        this.status = "Paid";
        System.out.println("Order #" + id + " paid successfully. Total: " + totalPrice + "$");
        for (Cart cart : carts) {
            for (Product p : cart.getProducts()) {
                p.purchase();
            }
        }
    }

    @Override
    public String toString() {
        return String.format("Order #%d for user %s (status: %s, total: %.2f$, created: %s)",
                id, user.getName(), status, totalPrice, createdAt);
    }
}
