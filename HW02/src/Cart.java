import java.util.ArrayList;
import java.util.List;

public class Cart {
	private String name;
	private List<Product> products;

    //constructors
    public Cart(String name, List<Product> products) {
    	this.name = name;
        this.products = products;
    }
    
	public Cart(String name) {
        this(name, new ArrayList<Product>());
	}
	
    public Cart(List<Product> products) {
        this("", products);
    }

    public Cart() {
        this("", new ArrayList<Product>());
    }

    //methods
    public void addProduct(Product product) {
        products.add(product);
    }

    public void deleteProduct(Product product) {
        products.remove(product);
    }

    //getters
    public List<Product> getProducts() { return products; }
    public String getName() { return name; }
    
    //setters
    public void setProducts(List<Product> products) { this.products = products; }
    public void setName(String name) { this.name = name; }
    
    //override
    @Override
    public String toString() {
    	String strList = String.join("\n",
    			products.stream().map(Product::toString).toList()
    	    );
        return String.format("\t%s (%d):\n%s",
        		(name.isEmpty() ? "Cart" : name),
        		products.size(),
        		strList);
    }
}
