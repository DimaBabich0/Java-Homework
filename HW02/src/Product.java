
public abstract class Product implements Purchasable {
	private int id;
	private String title;
	private String brandName;
	private float price;
	
	private static class IdGenerator {
        private static int counter = 1;
        public static int nextId() {
            return counter++;
        }
    }
	
	//constructors
	public Product(String title, String brandName, float price)
	{
		OnlineStore.addProduct(this);
        this.id = IdGenerator.nextId();
		this.title = title;
		this.brandName = brandName;
		this.price = price;
	}
	
	public Product(String title, String brandName) {
        this(title, brandName, 0f);
    }
	
	public Product(String title) {
        this(title, "Unknown", 0f);
    }

	//getters
    public int getId() { return id; }
	public String getTitle() { return title; }
    public String getBrandName() { return brandName; }
    public float getPrice() { return price; }
    
    //setters
    public void setTitle(String title) { this.title = title; }
    public void setBrandName(String brandName) { this.brandName = brandName; }
    public void setPrice(float price) { this.price = price; }
    
    //overrides
    @Override
    public String toString() {
    	String priceStr;
        if (price == (int) price) {
            priceStr = String.format("%d", (int) price); // for whole number
        } else {
            priceStr = String.format("%.2f", price); // for two decimal
        }
        return String.format("%s (%s) - %s$ [%d]\n",
        		title,
        		brandName,
        		priceStr,
        		id);
    }
    
    @Override
    protected void finalize() throws Throwable {
        System.out.printf("Product %s (%s) deleted from memory",
        		title,
        		brandName);
        super.finalize();
    }
    
}
