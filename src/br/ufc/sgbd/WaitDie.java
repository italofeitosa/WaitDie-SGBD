package br.ufc.sgbd;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class WaitDie {

	private List<String> listOfTransaction;
	private ArrayList<String> clasula = new ArrayList<String>();
	private ArrayList<String> listOfBackup = new ArrayList<String>();
	private boolean isFlagAbort = false;

	public WaitDie(ArrayList<String> listOfTransaction) {
		this.listOfTransaction = listOfTransaction;

		if (this.listOfTransaction != null) {
			for (String text : listOfTransaction) {
				// System.out.println(text);

			}
		}
	}

	/*
	 * public ArrayList<String> verifcaTransacao() { ArrayList<String> clasula =
	 * new ArrayList<String>(); if (this.listOfTransaction != null) { for
	 * (String t : listOfTransaction) { String transaction =
	 * t.substring(t.indexOf(":") + 1); clasula.add(transaction);
	 * System.out.println(transaction);
	 * 
	 * }
	 * 
	 * } return clasula;
	 * 
	 * }
	 */

	public ArrayList<String> verifcaTransacao() {
		 //clasula= new ArrayList<String>();
		clasula.add(listOfTransaction.get(0));
		for (int i = 1; i < listOfTransaction.size(); i++) {

			// Tratamento do Read

			if (listOfTransaction.get(i).substring(0, 1).equals("r")) {
				for (int j = 0; j < i; j++) {
					if (!listOfTransaction.get(i).substring(0, 1).equals(listOfTransaction.get(j).substring(0, 1))) {
						if (!listOfTransaction.get(i).substring(1, 2).equals(listOfTransaction.get(j).substring(1, 2))) {
							if (listOfTransaction.get(i).substring(3, 4).equals(listOfTransaction.get(j).substring(3, 4))) {
								int currentTime = Integer.parseInt(listOfTransaction.get(i).substring(1, 2));
								int compareTime = Integer.parseInt(listOfTransaction.get(j).substring(1, 2));
								if(currentTime < compareTime){						
										System.out.println("Wait T" + listOfTransaction.get(i).substring(1, 2));
										if(!clasula.contains(listOfTransaction.get(i))){
											clasula.add(listOfTransaction.get(i));
											//listOfTransaction.remove(i);
										}
										
										
										j = i;							
									}else{
										System.out.println("Abort T" + listOfTransaction.get(i).substring(1, 2));
										removeClausula(listOfTransaction.get(i).substring(1, 2));
										updatelistOfTransaction(listOfTransaction.get(i).substring(1, 2));
										j = i;
									}
							}else{	
								if(!clasula.contains(listOfTransaction.get(i))){
									clasula.add(listOfTransaction.get(i));
									//listOfTransaction.remove(i);
								}
							}
 
						}else{
							if(!clasula.contains(listOfTransaction.get(i))){
								clasula.add(listOfTransaction.get(i));
								//listOfTransaction.remove(i);
							}
						}

					}else{
						if(!clasula.contains(listOfTransaction.get(i))){
							clasula.add(listOfTransaction.get(i));
							//listOfTransaction.remove(i);
						}
					}
				}
			
			// Tratamento Write

			} else if (listOfTransaction.get(i).substring(0, 1).equals("w")) {
				for (int j = 0; j < i; j++) {
					if (!listOfTransaction.get(i).substring(1, 2).equals(listOfTransaction.get(j).substring(1, 2))) {
						if (listOfTransaction.get(i).substring(3, 4).equals(listOfTransaction.get(j).substring(3, 4))) {
							int currentTime = Integer.parseInt(listOfTransaction.get(i).substring(1, 2));
							int compareTime = Integer.parseInt(listOfTransaction.get(j).substring(1, 2));
							if(currentTime < compareTime){
								if(!clasula.contains(listOfTransaction.get(i))){
									clasula.add(listOfTransaction.get(i));
									//listOfTransaction.remove(i);
								}
								System.out.println("Wait T" + listOfTransaction.get(i).substring(1, 2));
								j = i;							
							}else{								
								System.out.println("Abort T" + listOfTransaction.get(i).substring(1, 2));
								removeClausula(listOfTransaction.get(i).substring(1, 2));
								updatelistOfTransaction(listOfTransaction.get(i).substring(1, 2));
								j = i;
							}
						}else{
							if(!clasula.contains(listOfTransaction.get(i))){								
								clasula.add(listOfTransaction.get(i));
								//listOfTransaction.remove(i);
							}
						}

					}else{
						if(!clasula.contains(listOfTransaction.get(i))){							
							clasula.add(listOfTransaction.get(i));
							//listOfTransaction.remove(i);
						}
					}

				}
				
			}

		}
		
		
		/*
			while (!listOfTransaction.isEmpty()) {
				listOfTransaction = new ArrayList<String>();
				for (int j = 0; j < clasula.size(); j++) {
					listOfTransaction.add(clasula.get(j));
					
				}
				verifcaTransacao();
				
			}*/
		
		
		
		System.out.println(clasula);
		return clasula;

	}

	public void comparaTransaction(ArrayList<String> clausulas) {

		ArrayList<String> arrayCompartor = new ArrayList<String>();
		String array[] = null;
		for (int i = 0; i < clausulas.size(); i++) {
			String transaction = clausulas.get(i).substring(
					clausulas.get(i).indexOf(":") + 1);
			array = transaction.split(" ");
			for (int j = 0; j < array.length; j++) {
				arrayCompartor.add(i + 1 + array[j]);
				System.out.println(i + 1 + array[j]);
			}
			System.out.println(arrayCompartor);

		}
		
	}
	
	private void updatelistOfTransaction(String numberTransaction){		
		for (int i = 0; i < listOfTransaction.size(); i++) {
			if(listOfTransaction.get(i).substring(1, 2).equals(numberTransaction)){
				listOfBackup.add(listOfTransaction.get(i));
				listOfTransaction.remove(i);
			}
			 
		}
		
		for (int i = 0; i < listOfBackup.size(); i++) {
			if(!clasula.contains(listOfBackup.get(i))){
				clasula.add(listOfBackup.get(i));
			}
		}
		
		//System.out.println(listOfTransaction);
	}
	
	private void removeClausula(String numberTransaction){
		for (int i = 0; i < clasula.size(); i++) {
			if(clasula.get(i).substring(1, 2).equals(numberTransaction)){
				clasula.remove(i);
			}
				
		}		
		
	}

}
