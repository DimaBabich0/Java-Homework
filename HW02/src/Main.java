
public class Main {

	public static void main(String[] args) {
        PhysicalProduct p1 = new PhysicalProduct("Chocolate", "Roshen", 3.50f, 500f);
        DigitalProduct p2 = new DigitalProduct("Windows 11 Activation Key", "Microsoft", 59.99f, "https://microsoft.com/key/m43mkgd4");

        for (int i = 0; i < 4; i++) {
        	try {
                Product result = OnlineStore.findProductById(i);
                System.out.printf("Found: %s", result);
            } catch (ProductNotFoundException e) {
                System.out.println(e.getMessage());
            }
		}

	}

}
