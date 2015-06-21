package br.ufc.sgbd;

import java.util.ArrayList;
import java.util.List;

public class WaitDie {

	private List<String> listOfTransaction;

	public WaitDie(List<String> listOfTransaction) {
		this.listOfTransaction = listOfTransaction;

		if (this.listOfTransaction != null) {
			for (String text : listOfTransaction) {
				//System.out.println(text);

			}
		}
	}
	
	
	public ArrayList<String> verifcaTransacao(){
		ArrayList<String> clasula = new ArrayList<String>();
		if (this.listOfTransaction != null) {
			for (String t : listOfTransaction) {
					String transaction = t.substring(t.indexOf(":")+1);
					clasula.add(transaction);
					/*String array[] = transaction.split(" ");
					for (int i = 0; i < array.length; i++) {
						clasula.add(array[i]);
					}*/
					System.out.println(transaction);
				
			}		
						
		}
		return clasula;
		
	}
	
	public void comparaTransaction(ArrayList<String> clausulas){
		for (int i = 0; i < clausulas.size(); i++) {
			
				
			
		}
	}

}
