import java.io.File;
import java.util.Scanner;

public class Sale {
	
	Scanner scan = new Scanner(System.in);
	
	private int sale_id;
	private int salesman_id;
	private double summ;
	
	public int get_sale_id() 		{return this.sale_id;}
	public int get_salesman_id() 	{return this.salesman_id;}
	public double get_summ() 		{return this.summ;}
	
	public void set_sale_id(int sale_id) 			{this.sale_id = sale_id;}
	public void set_salesman_id(int salesman_id) 	{this.salesman_id = salesman_id;}
	public void set_summ(double summ) 				{this.summ = summ;}
	
	public void newSale() {
		try{
			
			Products p = new Products();
			
			// wpisz kod
			System.out.print("Barcode:");
			p.set_barcode(scan.next());
			
			// znajdz produkt w pliku	
            File file = new File("products.txt");
            Scanner scan = new Scanner(file);
            
            while(scan.hasNextLine()) {
            	String x = scan.next();
            	if(x.contains(p.get_barcode())) {
            		System.out.println(x);
            		String[] parts = x.split(";");
            		for(int i = 0;i<parts.length;i++)
            			p.set_product(i);
            			
            			
            	}
            	
            }
            
        }catch(Exception e){
            System.err.println("Error: " + e.getMessage());
        } 
		
		
		// wczytaj dane
		// dodaj do og�lnego zam�wienia
		// zlicz sume
		// wydrukuj na LCD
		
		
	}
	
}