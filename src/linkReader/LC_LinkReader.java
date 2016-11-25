package linkReader;

import controllers.LinkScoreController;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
* Copyright (c) 2014, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
* http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/
public class LC_LinkReader extends AbstractLinkReader{

    static List<String> lc_lst = new ArrayList<String>();
    //give the path of the LC file


    public static void readPageVisit() {
        BufferedReader reader;
        BufferedReader reader1;
        try {
            reader = new BufferedReader(new FileReader("/home/amjadh/Downloads/rawData/SQL_PageVisit_Report_2015.csv"));
            LinkScoreController.addLink(read(lc_lst,reader));
            reader1 = new BufferedReader(new FileReader("/home/amjadh/Downloads/rawData/RL_PageVisit_Report_2015.csv"));
            LinkScoreController.addLink(read(lc_lst,reader1));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void readLC() {

        BufferedReader reader = null;
        BufferedReader reader1 = null;
        boolean flag = true;
        try {
            reader = new BufferedReader(new FileReader("/home/amjadh/Downloads/rawData/lifeTime.csv"));

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
                    if (index == 1) {

                        if(data.contains("ZZZ:LOST--")){
                            data = data.substring(10);


                        } else if(data.contains("ZZZ:LOST-2")){
                            data = data.substring(20);


                        } else if(data.contains("ZZZ:LOST- ")){
                            data = data.substring(9);


                        } else if(data.contains("ZZZ LOST:")){
                            data = data.substring(10);



                        }else if(data.contains("ZZZ: LOST:")){
                            data = data.substring(10);



                        }
                        //System.out.print(data+"\n");
                        lc_lst.add(data);
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


    //read company, and save

    //open SQL/RL

    //Find customer

    //Identify product

    //add to c
}
