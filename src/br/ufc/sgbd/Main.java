package br.ufc.sgbd;

import java.io.IOException;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		List<String> readText = null;

		DadosRWC dadosRWC = new DadosRWC();

		try {
			readText = dadosRWC.readSmallTextFile(DadosRWC.FILE_NAME);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		/*if (readText != null) {
			for (String text : readText) {
				System.out.println(text);

			}
		}*/
		
		WaitDie waitDie = new WaitDie(readText);
		waitDie.verifcaTransacao();

		try {

			dadosRWC.writeSmallTextFile(readText, DadosRWC.OUTPUT_FILE_NAME);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
