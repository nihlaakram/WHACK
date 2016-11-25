package linkReader;

import controllers.LinkScoreController;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SQL_LinkReader extends AbstractLinkReader{
	static List<String> sql_lst = new ArrayList<String>();
	//give the path of the LC file


	public static void readPageVisit() {
		BufferedReader reader;
		BufferedReader reader1;
		try {
			reader = new BufferedReader(new FileReader("/home/fathima/WHACK/rawData/SQL_PageVisit_Report_2015.csv"));
			LinkScoreController.addLink(read(sql_lst,reader));
			reader1 = new BufferedReader(new FileReader("/home/fathima/WHACK/rawData/RL_PageVisit_Report_2015.csv"));
			LinkScoreController.addLink(read(sql_lst,reader1));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static void readSQL() {

		BufferedReader reader = null;
		BufferedReader reader1 = null;
		boolean flag = true;
		try {
			reader = new BufferedReader(new FileReader("/home/fathima/WHACK/rawData/3 years of funnel data_SQL_20150901.csv"));

			// read file line by line
			String line = null;
			Scanner scanner = null;


			int index = 0;
			double sum = 0;
			while ((line = reader.readLine()) != null) {


				scanner = new Scanner(line);
				scanner.useDelimiter(",");

				if(flag){
					scanner.nextLine();
					flag = false;
				}

				while (scanner.hasNext() ) {

					String data = scanner.next();
					if (index == 4 && !sql_lst.contains(data)) {
						//System.out.print(data+"\n");
						sql_lst.add(data);
					}

					index++;
				}
				index = 0;

				//inputHandler.send(new Object[]{windspeed});
			}
			//close reader
			reader.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
