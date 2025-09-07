
public class PhysicalProduct extends Product {
	protected float weight;
	
	//constructor
	public PhysicalProduct(String title, String brand, float price, float weight) {
        super(title, brand, price);
        this.weight = weight;
    }
	
	//getter
    public float getWeight() { return weight; }

    //setter
    public void setWeight(float weight) { this.weight = weight; }

    //override
	@Override
	public void purchase() {
		String pTitle = super.getTitle();
		String pBrandName = super.getBrandName();
		String strWeight = weight < 1000 ?
						String.format("%d gramm", (int) weight) :
						String.format("%.1f kilogramm", weight / 1000.0f);
		
		System.out.printf("Successful purchase %s (%s). It weights %s\n",
				pTitle,
				pBrandName,
				strWeight);
	}
    
}
