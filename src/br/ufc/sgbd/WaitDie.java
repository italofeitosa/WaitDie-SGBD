package br.ufc.sgbd;

import java.util.ArrayList;
import java.util.List;

public class WaitDie {

	private List<String> listOfTransaction;

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
		ArrayList<String> clasula = new ArrayList<String>();
		clasula.add(listOfTransaction.get(1));
		for (int i = 1; i < listOfTransaction.size(); i++) {

			// Tratamento do Read

			if (listOfTransaction.get(i).substring(0, 1).equals("r")) {
				for (int j = 0; j < i; j++) {
					if (!listOfTransaction.get(i).substring(0, 1).equals(listOfTransaction.get(j).substring(0, 1))) {
						if (!listOfTransaction.get(i).substring(1, 2).equals(listOfTransaction.get(j).substring(1, 2))) {
							if (listOfTransaction.get(i).substring(3, 4).equals(listOfTransaction.get(j).substring(3, 4))) {
								// Abort							
								System.out.println("Abort T"+ listOfTransaction.get(i).substring(1,	2));
								j = i;
							}

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
							// Abort							
								System.out.println("Wait T" + listOfTransaction.get(i).substring(1, 2));
								j = i;							
							}else{
								System.out.println("Abort T" + listOfTransaction.get(i).substring(1, 2));
								j = i;
							}
						}

					}

				}
				// Tratamento do Commit
			} else if (listOfTransaction.get(i).substring(0, 1).equals("c")) {
				for (int j = 0; j < i; j++) {
					if (!listOfTransaction.get(i).substring(0, 1).equals(listOfTransaction.get(j).substring(0, 1))) {
						if (!listOfTransaction.get(i).substring(1, 2).equals(listOfTransaction.get(j).substring(1, 2))) {
							if (listOfTransaction.get(i).substring(3, 4).equals(listOfTransaction.get(j).substring(3, 4))) {
								// Abort
								
								System.out.println("Abort T"+ listOfTransaction.get(i).substring(1,	2));
								j = i;
							}

						}

					}
				}
			}

		}
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

		for (int i = 0; i < arrayCompartor.size(); i++) {
			// String teste = arrayCompartor.get(i).substring(1).equals("1");
			/*
			 * if(arrayCompartor.get(i).e){ System.out.println("teste"); }
			 */
		}

		/*
		 * for (String string : clausulas) { String transaction =
		 * string.substring(string.indexOf(":") + 1); array =
		 * transaction.split(" ");
		 * 
		 * }
		 * 
		 * for (int i = 0; i < array.length; i++) {
		 * 
		 * }
		 */
	}

}
