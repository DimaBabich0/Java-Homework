
public class DigitalProduct extends Product {
    protected String downloadUrl;
    
	//constructor
    public DigitalProduct(String title, String brand, float price, String downloadUrl) {
        super(title, brand, price);
        this.downloadUrl = downloadUrl;
    }
    
    //getter
    public String getdownloadUrl() { return downloadUrl; }
    
    //setter
    public void setDownloadUrl(String downloadUrl) { this.downloadUrl = downloadUrl; }
    
    //override
    @Override
    public void purchase() {
		String pTitle = super.getTitle();
		String pBrandName = super.getBrandName();
		
		System.out.printf("Successful purchase %s. Here URL: %s\n",
				pTitle,
				downloadUrl);
    }
}
