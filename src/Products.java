
public class Products {

	private String name;
	private String barcode;
	private float price;	
	
	//Get
	public String get_name() {
		return this.name;
	}
	public String get_barcode() {
		return this.barcode;
	}
	public float get_price() {
		return this.price;
	}
	//Set
	public void set_name(String name) {
		this.name = name;
	}
	public void set_barcode(String barcode) {
		this.barcode = barcode;
	}
	public void set_price(float price) {
		this.price = price;
	}
	
}
