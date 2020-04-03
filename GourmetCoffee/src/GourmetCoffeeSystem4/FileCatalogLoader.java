package GourmetCoffeeSystem4;
import java.io.BufferedReader; 
import java.io.FileNotFoundException; 
import java.io.FileReader; 
import java.io.IOException; 

import GourmetCoffeeSystem1.Coffee; 
import GourmetCoffeeSystem1.CoffeeBrewer; 
import GourmetCoffeeSystem1.Product; 
import GourmetCoffeeSystem2.Catalog; 

public class FileCatalogLoader implements CatalogLoader { 	
	private Product readProduct(String line) throws DataFormatException { 		
		String[] s = line.split("_"); 
		double price = 0.0;
		
		//Data format exception handling.(If it doesn't have the expected number of tokens.)
		if(s.length !=4) { 			
			throw new DataFormatException("It doesn't have the expected number of tokens."); 		
		}
		//Data format exception handling.(If the token that should contain a double does not.)
		try { 			
			price = Double.parseDouble(s[3]); 		 
		}
		catch(NumberFormatException a) { 			
			throw new DataFormatException("The token that should contain a double does not."); 		
		} 		 		
		Product product = new Product(s[1],s[2],price); 		 		
		return product; 	
	}
	private Coffee readCoffee(String line) throws DataFormatException {
		String[] s = line.split("_"); 
		double price = 0.0;
		
		//Data format exception handling.(If it doesn't have the expected number of tokens.)
		if(s.length !=10) { 			
			throw new DataFormatException("It doesn't have the expected number of tokens."); 		
		}
		//Data format exception handling.(If the token that should contain a double does not.)
		try { 			
			price = Double.parseDouble(s[3]); 		 
		}
		catch(NumberFormatException a) { 			
			throw new DataFormatException("The token that should contain a double does not."); 		
		} 		 		
		Coffee coffee = new Coffee(s[1],s[2],price,s[4],s[5],s[6],s[7],s[8],s[9]); 		 		
		return coffee; 	
	}
	private CoffeeBrewer readCoffeeBrewer(String line) throws DataFormatException {
		String[] s = line.split("_"); 
		double price = 0.0;
		int numberOfCups=0;
		
		//Data format exception handling.(If it doesn't have the expected number of tokens.)
		if(s.length !=7) { 			
			throw new DataFormatException("It doesn't have the expected number of tokens."); 		
		}
		//Data format exception handling.(If the token that should contain a double does not.)
		try { 			
			price = Double.parseDouble(s[3]); 
			numberOfCups=Integer.parseInt(s[6]);
		}
		catch(NumberFormatException a) { 			
			throw new DataFormatException("The token that should contain a double does not."); 		
		} 		 		
		CoffeeBrewer coffeeBrewer = new CoffeeBrewer(s[1],s[2],price,s[4],s[5],numberOfCups); 		 		
		return coffeeBrewer; 	
	}
	public Catalog loadCatalog(String filename) throws FileNotFoundException,IOException,DataFormatException{
		Catalog catalog=new Catalog();
		BufferedReader bufferedReader=null;
		try {
			bufferedReader=new BufferedReader(new FileReader(filename));
			String line=null;
			while((line=bufferedReader.readLine())!=null) {
				if(line.startsWith("Product")) {
					catalog.addProduct(readProduct(line));
				}
				else if(line.startsWith("Coffee")){
					catalog.addProduct(readCoffee(line));
				}
				else if(line.startsWith("Brewer")){
					catalog.addProduct(readCoffeeBrewer(line));
				}
			}
		}
		catch(FileNotFoundException a) {
			throw new FileNotFoundException("The specified file doesn't exist.");
		}
		catch(IOException a) {
			throw new IOException("There is an error reading the information in the specified file.");
		}
		catch(DataFormatException a) {
			throw a;
		}
		finally {
			try {
				bufferedReader.close();
			}
			catch(IOException a) {
				throw new IOException("Failure of resource closure.");
			}
		}
		return catalog;
	}
}
