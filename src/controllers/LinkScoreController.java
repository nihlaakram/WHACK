package controllers;

import entity.Link;
import entity.Product;

import java.util.*;

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
public class LinkScoreController {

    static List<String> temp = new ArrayList<String>();
    public static Map <String, Link> link_map = new HashMap <String, Link>();

    public static void addLink(List<String> arr){
        temp = arr;
        processLink(arr);



    }

    private static void processLink(List<String> arr) {

        for (int i=0; i<arr.size(); i++){
            //identify the product
            //getProduct(arr.get(i));
            //create object
            Link link = new Link(arr.get(i), getProduct(arr.get(i)));
            //if in map update
            //if not in map create
            if(link_map.containsKey(link.getUrl())){
                link_map.get(link.getUrl()).setScore();

            } else {
                link_map.put(link.getUrl(), link);
            }


        }
    }

    public static Enum getProduct(String link) {

        if(link.contains("application-server")){
            return Product.AS;
        }
        if(link.contains("api")){
            return Product.APIM;
        }
        if(link.contains("esb")){
            return Product.ESB;
        }
        if(link.contains("stratos")){
            return Product.Stratos;
        }
        if(link.contains("identity-server")){
            return Product.IS;
        }
        if(link.contains("carbon")){
            return Product.Carbon;
        }

        return Product.Other;
    }
}
