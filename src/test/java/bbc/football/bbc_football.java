package bbc.football;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class bbc_football {

    String url = "https://v6.exchangerate-api.com/v6/1fc80820c72b0163bc9c7536/latest/USD";

    @Test
    public void test1(){

        Response response = RestAssured.get(url);

        System.out.println(response.statusCode());

        Assertions.assertEquals(200,response.statusCode());

        System.out.println("GBP = " + response.path("conversion_rates.GBP"));

        Assertions.assertTrue(response.body().asString().contains("GBP"));

        Map<String,Object> jsonMap = response.as(Map.class);

        //System.out.println(jsonMap);

        //System.out.println("All rates = " + jsonMap.get("conversion_rates"));

        String conversion_rates = jsonMap.get("conversion_rates").toString();

        String  each = conversion_rates.replace("{","").replace("}","");

        //System.out.println(each);

        String [] eachCurrency = each.split(",");

        int totalNumberOfCurrency =0;

        for(String eachElement : eachCurrency){
            totalNumberOfCurrency++;
            System.out.println("Today currency for = " +eachElement);
        }

        System.out.println("Total number of currency = " + totalNumberOfCurrency);


//        int count = 0;
//
//        for(String eachElement : each){
//            count++;
//            System.out.println(eachElement);
//        }
//        System.out.println(count);


    }




}
