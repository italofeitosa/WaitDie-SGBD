package br.ufc.sgbd;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class ReadFile {

	public ArrayList<String> readFile() throws BiffException, IOException {

		ArrayList<String> clausulas = new ArrayList<String>();
		Workbook workbook = Workbook.getWorkbook(new File("entrada.xls"));

		Sheet sheet = workbook.getSheet(0);

		int linhas = sheet.getRows();
		int colunas = sheet.getColumns();

		for (int i = 0; i < colunas; i++) {
			int count = 1;

			for (int j = 0; j < linhas; j++) {

				Cell celula = sheet.getCell(i, j);

				String transaction = celula.getContents().substring(
						celula.getContents().indexOf(":") + 1);

				if (!celula.getContents().equals("T" + count + ":")
						&& !celula.getContents().equals("")) {
					String um = transaction.substring(0, 1);
					String dois = String.valueOf(j + 1);
					String tres = transaction
							.substring(1, transaction.length());
					String ordenada = um + dois + tres;

					clausulas.add(ordenada);
				}
				count++;
				//System.out.println("" + celula.getContents());
			}

		}
		System.out.println("" + clausulas);

		return clausulas;
	}

}
