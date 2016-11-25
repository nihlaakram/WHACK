package entity;

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
public class Link {


    private String url;

    public void setScore() {
        this.score += 5;
    }

    private int score;
    private Enum product;

    public Enum getProduct() {
        return product;
    }


    public String getUrl() {
        return url;
    }

    public int getScore() {
        return score;
    }



    public Link(String url, Enum product) {
        this.url = url;
        this.score = 5;
        this.product = product;
    }
}
