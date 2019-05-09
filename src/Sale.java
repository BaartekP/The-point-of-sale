import java.io.File;
import java.util.Scanner;
import java.util.Vector;
import java.util.List;
import java.util.ArrayList;

public class Sale {
	
	Scanner scan = new Scanner(System.in);
	
	private int sale_id;
	private int salesman_id;
	private double summ = 0;
	private List<Products> productList;
	private Vector<Double> amount;
	
	//Get
	public int get_sale_id() 				{return this.sale_id;}
	public double get_amount(int i)			{return this.amount.get(i);}
	public int get_salesman_id() 			{return this.salesman_id;}
	public double get_summ() 				{return this.summ;}
	public List<Products> get_productList() {return this.productList;}
	
	//Set
	public void set_sale_id(int sale_id) 			{this.sale_id = sale_id;}
	public void set_amount(double amount) 			{this.amount.add(amount);}
	public void set_salesman_id(int salesman_id) 	{this.salesman_id = salesman_id;}
	public void set_summ(double summ) 				{this.summ = summ;}
	public void set_productList(Products p) 		{this.productList.add(p);}
	
	public void newSale() {	
		
			this.amount = new Vector<Double>();
			List<Products> temp = new ArrayList<Products>();
			//int choice = 0;
			int counter =0;
			
			do {
			Products p = new Products();
			
			System.out.print("Barcode:");
			String barcode = scan.next();
			if(barcode.contains("exit")) break;
			else p.set_barcode(barcode);
			
			// Find the product
			try{
            File file = new File("products.txt");
            Scanner scan1 = new Scanner(file);
            
            while(scan1.hasNextLine()) {
            	String x = scan1.next();
            	//System.out.println(x);
            	if(x.contains(p.get_barcode())) {
            		//System.out.println(x);
            		String[] parts = x.split(";");
            		p.set_barcode(parts[0]);
            		p.set_name(parts[1]);
            		p.set_price(Double.valueOf(parts[2]));
            		
            	}            	
            }
            scan1.close();
			}catch(Exception e){
				//System.err.println("Error: " + e.getMessage());
			}
			
			temp.add(p);
			
			System.out.print(p.get_name()+"\t"+p.get_price());
			
			System.out.print("\nQuantity: ");
			set_amount(scan.nextDouble());
			set_summ(get_summ()+temp.get(counter).get_price()*get_amount(counter));
			counter++;
			
			//System.out.print("Continue[0] or Exit[1]?");
			
			}while(true);
			
			//System.out.print(get_amount(0));
			
			
			
			System.out.print("\nSumm: "+get_summ());
			
			scan.close();
			
			
			//dodawanie nowych produktów
			//logowanie przez salesman
	}	
}
