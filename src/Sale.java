import java.io.File;
import java.util.Scanner;
//import java.util.List;
//import java.util.ArrayList;

public class Sale {
	
	Scanner scan = new Scanner(System.in);
	
	private int sale_id;
	private int salesman_id;
	private double summ;
	//private  List<Products> productList;
	private double[] amount;
	
	//Get
	public int get_sale_id() 				{return this.sale_id;}
	public double get_amount(int i) 		{return this.amount[i];}
	public int get_salesman_id() 			{return this.salesman_id;}
	public double get_summ() 				{return this.summ;}
	//public  List<Products> get_productList() {return this.productList;}
	
	//Set
	public void set_sale_id(int sale_id) 			{this.sale_id = sale_id;}
	public void set_amount(double[] amount) 		{this.amount = amount;}
	public void set_salesman_id(int salesman_id) 	{this.salesman_id = salesman_id;}
	public void set_summ(double summ) 				{this.summ = summ;}
	//public void set_productList(List<Products> p) 	{this.productList=p;}
	
	public void newSale() {	
			
			Products p = new Products();
			//List<Products> temp = new ArrayList<Products>();
			
			// Barcode
			System.out.print("Barcode:");
			p.set_barcode(scan.next());
			
			// Find the product
			try {
            File file = new File("products.txt");
            Scanner scan = new Scanner(file);
            
            while(scan.hasNextLine()) {
            	String x = scan.next();
            	if(x.contains(p.get_barcode())) {
            		//System.out.println(x);
            		String[] parts = x.split(";");
            		p.set_barcode(parts[0]);
            		p.set_name(parts[1]);
            		p.set_price(Double.valueOf(parts[2]));
            	}            	
            }            
			}catch(Exception e){
            //System.err.println("Error: " + e.getMessage());
			}
			System.out.print(p.get_name()+"\t"+p.get_price());
		
		
		// Final order
		// Summ
		// Print LCD and Printer	
	}	
}
