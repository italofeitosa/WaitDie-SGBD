package br.ufc.sgbd;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jxl.read.biff.BiffException;

public class Main {

	public static void main(String[] args) {
		ArrayList<String> clausulasTransaction = null;

		DadosRWC dadosRWC = new DadosRWC();
		ReadFile readFile = new ReadFile();
		
		try {
			clausulasTransaction = readFile.readFile();
		} catch (BiffException | IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}		

		/*if (readText != null) {
			for (String text : readText) {
				System.out.println(text);

			}
		}*/
		if(clausulasTransaction != null){
			WaitDie waitDie = new WaitDie(clausulasTransaction);
			waitDie.verifcaTransacao();
			
		}
		
		//waitDie.comparaTransaction(waitDie.verifcaTransacao());

	/*	try {

			dadosRWC.writeSmallTextFile(readText, DadosRWC.OUTPUT_FILE_NAME);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/

	}

}
