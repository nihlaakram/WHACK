package linkReader;/*
 *  Licensed to the Apache Software Foundation (ASF) under one
 *  or more contributor license agreements.  See the NOTICE file *  distributed with this work for additional information
 *  regarding copyright ownership.  The ASF licenses this file
 *  to you under the Apache License, Version 2.0 (the
 *  "License"); you may not use this file except in compliance
 *  with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing,
 *  software distributed under the License is distributed on an
 *   * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *  KIND, either express or implied.  See the License for the
 *  specific language governing permissions and limitations
 *  under the License.
 */

import controllers.LinkScoreController;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public abstract class AbstractLinkReader {

	protected static List<String> read(List com_lst, BufferedReader reader){
		List<String> temp_link_lst = new ArrayList<String>();
		boolean flag = true;
		try {

			// read file line by line
			String line = null;
			Scanner scanner = null;


			int index = 0;
			double sum = 0;
			boolean flag2 = false;
			int compIndex = 0;
			while ((line = reader.readLine()) != null) {


				scanner = new Scanner(line);
				scanner.useDelimiter(",");

				if(flag){
					scanner.nextLine();
					flag = false;
				}

				while (scanner.hasNext()) {

					String data = scanner.next();
					if(data.equals("")){
						break;
					}
					if(index==4){

						for(int i=0; i<com_lst.size(); i++){
							//System.out.println(data+"\t"+lc_lst.get(i));
							if(data.equals(com_lst.get(i))){
								//System.out.println("-------------");
								flag2 =true;
								compIndex = i;
								break;
							} else {
								flag2 = false;
							}

						}
					}


					if (index == 8 && flag2) {

						//System.out.print(lc_lst.get(compIndex)+"\t"+data+"\n");
						temp_link_lst.add(data);
						//Pass to controller

					}

					index++;

				}
				index = 0;

				//inputHandler.send(new Object[]{windspeed});
			}
			//close reader
			reader.close();

//			LinkScoreController.addLink(link_lst);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return temp_link_lst;
	}

}
