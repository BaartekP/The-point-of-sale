import java.io.File;
import java.io.FileWriter;
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
	public Vector<Double> get_amount()		{return this.amount;}
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
			List<Products> list = new ArrayList<Products>();
			//int choice = 0;
			int counter =0;
			
			do {
			Products p = new Products();
			
			System.out.print("Barcode:");
			String barcode = scan.next();
			barcode = barcode.replace(barcode.substring(0, 1), 
									  barcode.substring(0, 1).toUpperCase());
			
			if(barcode.contains("Exit")) break;
			else if(barcode.contains("Add")) add_product();
			else {
			
				p.set_barcode(barcode);
					
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
				
				list.add(p);
				
				//String format
				System.out.print(p.get_name()+"\t"+p.get_price());
				
				System.out.print("\nQuantity: ");
				set_amount(scan.nextDouble());
				set_summ(get_summ()+list.get(counter).get_price()*get_amount(counter));
				counter++;
				
				//System.out.print("Continue[0] or Exit[1]?");
			}
				}while(true);
				
				//System.out.print(get_amount(0));
				
				//Podsumowanie
				
				summary(list,get_amount());

				System.out.print("\nSumm: "+get_summ());
				
				scan.close();
			
			
			//dodawanie nowych produktów
			//logowanie przez salesman
	}	
	
	public void summary(List<Products> list, Vector<Double> amount) {
		
		System.out.println("Summary:");
		int counter = 0;
		for(Products p : list)
			System.out.println(String.format("%1$"+10 +"s",p.get_name()
					+"\t"+amount.get(counter++)+"\t"+p.get_price()));
			
		
	}
	
	public void add_product() {
		
		String name="", price="";
		String category = "";
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Name and Price");
		name = scan.next();
		price = scan.next();
		
		try{
            File file1 = new File("categories.txt");
            File file2 = new File("products.txt");
            
            FileWriter fileWrite = new FileWriter(file2,true);
           // BufferedWriter bw = new BufferedWriter(fileWrite);
           //PrintWriter pw = new PrintWriter(bw);
            
            Scanner scan1 = new Scanner(file1);
            Scanner scan2 = new Scanner(file2);
            
            //fileWrite.write(x);
            try {
            while(scan1.hasNextLine()) {
            	String x = scan1.next(); 
            	String[] parts = x.split(";");
            	System.out.println(String.format("%1$"+20 +"s",parts[0]+" "+parts[1]));
            }
            }catch (Exception e) {
				// TODO: handle exception
			}
            
            System.out.print("Category barcode: ");
    		category = scan.next();
    		
    		int i=0;
    		String a = "";
    		
    		try {
    		while(scan2.hasNextLine()) {
            	String x = scan2.next();
    			if(x.contains(category)) {
            		//System.out.println(x);
            		i++;           		
            	}    			
            }
    		}catch (Exception e) {
				// TODO: handle exception
			}
    		i++;
    		if(i<10) a = "0"+i;
    		else a = String.valueOf(i);
    		String product = "\n"+category+a+";"+name+";"+price;
    		//nie wpisuje :(
    		fileWrite.write(product);
    		fileWrite.close();
    		System.out.println("Added "+name);
    		
    		scan2.close();
    		scan1.close();
    		fileWrite.close();
    		
    		
            
            //scan1.close();
			}catch(Exception e){
				//System.err.println("Error: " + e.getMessage());
			}
		
		
		
		
	}
	
	
}
