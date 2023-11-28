import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URLEncoder;
import java.net.URL;
import java.util.HashMap;  
import java.util.Map;
import java.util.ArrayList;  
import java.util.Date;
import java.time.Instant;
import javafx.scene.image.Image;
import com.google.gson.*;
import java.net.URLConnection;
import java.io.*;  
import java.net.*;  

public class StockModel {

    //API 1 for the stock data
    // You must register for your own access token.
    private final String API_KEY = "17fc3175femsh07dddd4b17f5b5bp14877ejsn81b611b97ab8";
    private JsonElement jse;
    
    //API 2 for the chart
    private final String API_KEYX = "17fc3175femsh07dddd4b17f5b5bp14877ejsn81b611b97ab8";
    private JsonElement jsex;
    
    //API 3 for 1 day chart
    private final String API_KEYZ = "17fc3175femsh07dddd4b17f5b5bp14877ejsn81b611b97ab8";
    private JsonElement jsexs;
    
    //api 4 for 5 day chart
    private final String API_KEYW = "17fc3175femsh07dddd4b17f5b5bp14877ejsn81b611b97ab8";
    private JsonElement jsex2;
    
    //api 5 for 1 month chart
    private final String API_KEY2 = "17fc3175femsh07dddd4b17f5b5bp14877ejsn81b611b97ab8";
    private JsonElement jsex3;
    
    //api 6 for 3 month chart
    private final String API_KEY3 = "17fc3175femsh07dddd4b17f5b5bp14877ejsn81b611b97ab8";
    private JsonElement jsex4;
    
    //api 7 for 6 month chart
    private final String API_KEY4 = "17fc3175femsh07dddd4b17f5b5bp14877ejsn81b611b97ab8";
    private JsonElement jsex5;
    
    //api 8 for 1 year chart
    private final String API_KEY5 = "17fc3175femsh07dddd4b17f5b5bp14877ejsn81b611b97ab8";
    private JsonElement jsex6;
    
    //api 9 for 2 year chart
    private final String API_KEY6 = "17fc3175femsh07dddd4b17f5b5bp14877ejsn81b611b97ab8";
    private JsonElement jsex7;
    
    //api 10 for 5 year chart
    private final String API_KEY7 = "17fc3175femsh07dddd4b17f5b5bp14877ejsn81b611b97ab8";
    private JsonElement jsex8;
    
    //api 11 for 10 year chart
    private final String API_KEY8 = "17fc3175femsh07dddd4b17f5b5bp14877ejsn81b611b97ab8";
    private JsonElement jsex9;
    
    //API 11 for the stock data #2
    // You must register for your own access token.
    private final String API_KEY9 = "17fc3175femsh07dddd4b17f5b5bp14877ejsn81b611b97ab8";
    private JsonElement jse2;

   
    // first api connection test
    public boolean getStock(String stockSymb) {

        try {

            // Construct YH Finance API URL

            URL yhFinanceURL = new URL("https://apidojo-yahoo-finance-v1.p.rapidapi.com/market/v2/get-quotes?region=US&symbols=" 
                + stockSymb );
                
            URLConnection urlCon = yhFinanceURL.openConnection();
            
            // neccessary headers for the url connection
            urlCon.setRequestProperty("X-RapidAPI-Host", "apidojo-yahoo-finance-v1.p.rapidapi.com");
            urlCon.setRequestProperty("X-RapidAPI-Key", API_KEY);
            
            // Open the URL Connection
            BufferedReader br = new BufferedReader(new InputStreamReader (urlCon.getInputStream()));   
            
            // Read the result into a JSON Element
            jse = new JsonParser().parse(br);


            // Close the connection
            br.close();          
              
        } catch (java.io.UnsupportedEncodingException uee) {
            uee.printStackTrace();
        } catch (java.net.MalformedURLException mue) {
            mue.printStackTrace();
        } catch (java.io.IOException ioe) {
            System.out.println("ERROR: Something went wrong with the connection");
        }
            
        // check to see if the url and stock ticker was valid
        return isValid();
    }
    
    
    //2ND API connection
    public boolean getStockGraph(String stockSymb) {

        try {

            // Construct YH Finance Chart API URL

            URL yhFinanceGraphURL = new URL("https://yh-finance.p.rapidapi.com/stock/v3/get-chart?interval=1d&symbol=" 
                                            + stockSymb + "&range=1y&region=US&includePrePost=false&useYfid=true&includeAdjustedClose=true&events=capitalGain,div,split");
            //making a url connection   
            URLConnection urlCon = yhFinanceGraphURL.openConnection();
             
            // neccessary headers for the url connection    
            urlCon.setRequestProperty("X-RapidAPI-Host", "yh-finance.p.rapidapi.com");
            urlCon.setRequestProperty("X-RapidAPI-Key", API_KEYX);
            
            // Open the URL Connection

            BufferedReader br = new BufferedReader(new InputStreamReader (urlCon.getInputStream()));   
            
            // Read the result into a JSON Element
            jsex = new JsonParser().parse(br);

            // Close the connection so we could pull data out later
            br.close();          
              
        } catch (java.io.UnsupportedEncodingException uee) {
            uee.printStackTrace();
        } catch (java.net.MalformedURLException mue) {
            mue.printStackTrace();
        } catch (java.io.IOException ioe) {
            System.out.println("ERROR: The Stock Symbol You Have Entered is not Valid");
        }
            
        // check to see if the url and stock ticker was valid
        return isValidX();
    }
        
    //3rd API connection for 1 day chart with 5 min interval
    public boolean getStockGraphRange1D(String stockSymb, String historyRange) {

        try {

            // Construct YH Finance Chart API URL

            URL yhFinanceGraphURL = new URL("https://yh-finance.p.rapidapi.com/stock/v3/get-chart?interval=5m&symbol=" 
                                            + stockSymb + "&range=" + historyRange + "&region=US&includePrePost=false&useYfid=true&includeAdjustedClose=true&events=capitalGain,div,split");
            //making a url connection   
            URLConnection urlCon = yhFinanceGraphURL.openConnection();
             
            // neccessary headers for the url connection    
            urlCon.setRequestProperty("X-RapidAPI-Host", "yh-finance.p.rapidapi.com");
            urlCon.setRequestProperty("X-RapidAPI-Key", API_KEYZ);
            
            // Open the URL Connection

            BufferedReader br = new BufferedReader(new InputStreamReader (urlCon.getInputStream()));   
            
            // Read the result into a JSON Element
            jsex = new JsonParser().parse(br);

            // Close the connection so we could pull data out later
            br.close();          
              
        } catch (java.io.UnsupportedEncodingException uee) {
            uee.printStackTrace();
        } catch (java.net.MalformedURLException mue) {
            mue.printStackTrace();
        } catch (java.io.IOException ioe) {
            System.out.println("ERROR: The Stock Symbol You Have Entered is not Valid");
        }
            
        // check to see if the url and stock ticker was valid
        return isValidX();
    }
    
    //4th API connection for 5 day chart with 30 min interval
    public boolean getStockGraphRange5D(String stockSymb, String historyRange) {

        try {

            // Construct YH Finance Chart API URL

            URL yhFinanceGraphURL = new URL("https://yh-finance.p.rapidapi.com/stock/v3/get-chart?interval=30m&symbol=" 
                                            + stockSymb + "&range=" + historyRange + "&region=US&includePrePost=false&useYfid=true&includeAdjustedClose=true&events=capitalGain,div,split");
            //making a url connection   
            URLConnection urlCon = yhFinanceGraphURL.openConnection();
             
            // neccessary headers for the url connection    
            urlCon.setRequestProperty("X-RapidAPI-Host", "yh-finance.p.rapidapi.com");
            urlCon.setRequestProperty("X-RapidAPI-Key", API_KEYW);
            
            // Open the URL Connection

            BufferedReader br = new BufferedReader(new InputStreamReader (urlCon.getInputStream()));   
            
            // Read the result into a JSON Element
            jsex2 = new JsonParser().parse(br);

            // Close the connection so we could pull data out later
            br.close();          
              
        } catch (java.io.UnsupportedEncodingException uee) {
            uee.printStackTrace();
        } catch (java.net.MalformedURLException mue) {
            mue.printStackTrace();
        } catch (java.io.IOException ioe) {
            System.out.println("ERROR: The Stock Symbol You Have Entered is not Valid");
        }
            
        // check to see if the url and stock ticker was valid
        return isValidW();
    }
    
    //5th API connection for 1 month chart with 1 day interval
    public boolean getStockGraphRange1Mo(String stockSymb, String historyRange) {

    try {

            // Construct YH Finance Chart API URL

            URL yhFinanceGraphURL = new URL("https://yh-finance.p.rapidapi.com/stock/v3/get-chart?interval=1d&symbol=" 
                                            + stockSymb + "&range=" + historyRange + "&region=US&includePrePost=false&useYfid=true&includeAdjustedClose=true&events=capitalGain,div,split");
            //making a url connection   
            URLConnection urlCon = yhFinanceGraphURL.openConnection();
             
            // neccessary headers for the url connection    
            urlCon.setRequestProperty("X-RapidAPI-Host", "yh-finance.p.rapidapi.com");
            urlCon.setRequestProperty("X-RapidAPI-Key", API_KEY2);
            
            // Open the URL Connection

            BufferedReader br = new BufferedReader(new InputStreamReader (urlCon.getInputStream()));   
            
            // Read the result into a JSON Element
            jsex3 = new JsonParser().parse(br);

            // Close the connection so we could pull data out later
            br.close();          
              
        } catch (java.io.UnsupportedEncodingException uee) {
            uee.printStackTrace();
        } catch (java.net.MalformedURLException mue) {
            mue.printStackTrace();
        } catch (java.io.IOException ioe) {
            System.out.println("ERROR: The Stock Symbol You Have Entered is not Valid");
        }
            
        // check to see if the url and stock ticker was valid
        return isValid2();
    }

    //6th API connection for 3 month chart with 1 day interval
    public boolean getStockGraphRange3Mo(String stockSymb, String historyRange) {

    try {

            // Construct YH Finance Chart API URL

            URL yhFinanceGraphURL = new URL("https://yh-finance.p.rapidapi.com/stock/v3/get-chart?interval=1d&symbol=" 
                                            + stockSymb + "&range=" + historyRange + "&region=US&includePrePost=false&useYfid=true&includeAdjustedClose=true&events=capitalGain,div,split");
            //making a url connection   
            URLConnection urlCon = yhFinanceGraphURL.openConnection();
             
            // neccessary headers for the url connection    
            urlCon.setRequestProperty("X-RapidAPI-Host", "yh-finance.p.rapidapi.com");
            urlCon.setRequestProperty("X-RapidAPI-Key", API_KEY3);
            
            // Open the URL Connection

            BufferedReader br = new BufferedReader(new InputStreamReader (urlCon.getInputStream()));   
            
            // Read the result into a JSON Element
            jsex4 = new JsonParser().parse(br);

            // Close the connection so we could pull data out later
            br.close();          
              
        } catch (java.io.UnsupportedEncodingException uee) {
            uee.printStackTrace();
        } catch (java.net.MalformedURLException mue) {
            mue.printStackTrace();
        } catch (java.io.IOException ioe) {
            System.out.println("ERROR: The Stock Symbol You Have Entered is not Valid");
        }
            
        // check to see if the url and stock ticker was valid
        return isValid3();
    }

    //7th API connection for 6 month chart with 1 day interval
    public boolean getStockGraphRange6Mo(String stockSymb, String historyRange) {

    try {

            // Construct YH Finance Chart API URL

            URL yhFinanceGraphURL = new URL("https://yh-finance.p.rapidapi.com/stock/v3/get-chart?interval=1d&symbol=" 
                                            + stockSymb + "&range=" + historyRange + "&region=US&includePrePost=false&useYfid=true&includeAdjustedClose=true&events=capitalGain,div,split");
            //making a url connection   
            URLConnection urlCon = yhFinanceGraphURL.openConnection();
             
            // neccessary headers for the url connection    
            urlCon.setRequestProperty("X-RapidAPI-Host", "yh-finance.p.rapidapi.com");
            urlCon.setRequestProperty("X-RapidAPI-Key", API_KEY4);
            
            // Open the URL Connection

            BufferedReader br = new BufferedReader(new InputStreamReader (urlCon.getInputStream()));   
            
            // Read the result into a JSON Element
            jsex5 = new JsonParser().parse(br);

            // Close the connection so we could pull data out later
            br.close();          
              
        } catch (java.io.UnsupportedEncodingException uee) {
            uee.printStackTrace();
        } catch (java.net.MalformedURLException mue) {
            mue.printStackTrace();
        } catch (java.io.IOException ioe) {
            System.out.println("ERROR: The Stock Symbol You Have Entered is not Valid");
        }
            
        // check to see if the url and stock ticker was valid
        return isValid4();
    }
    
    //8th API connection for 1 year chart with 1 day interval
    public boolean getStockGraphRange1Yr(String stockSymb, String historyRange) {

    try {

            // Construct YH Finance Chart API URL

            URL yhFinanceGraphURL = new URL("https://yh-finance.p.rapidapi.com/stock/v3/get-chart?interval=1d&symbol=" 
                                            + stockSymb + "&range=" + historyRange + "&region=US&includePrePost=false&useYfid=true&includeAdjustedClose=true&events=capitalGain,div,split");
            //making a url connection   
            URLConnection urlCon = yhFinanceGraphURL.openConnection();
             
            // neccessary headers for the url connection    
            urlCon.setRequestProperty("X-RapidAPI-Host", "yh-finance.p.rapidapi.com");
            urlCon.setRequestProperty("X-RapidAPI-Key", API_KEY5);
            
            // Open the URL Connection

            BufferedReader br = new BufferedReader(new InputStreamReader (urlCon.getInputStream()));   
            
            // Read the result into a JSON Element
            jsex6 = new JsonParser().parse(br);

            // Close the connection so we could pull data out later
            br.close();          
              
        } catch (java.io.UnsupportedEncodingException uee) {
            uee.printStackTrace();
        } catch (java.net.MalformedURLException mue) {
            mue.printStackTrace();
        } catch (java.io.IOException ioe) {
            System.out.println("ERROR: The Stock Symbol You Have Entered is not Valid");
        }
            
        // check to see if the url and stock ticker was valid
        return isValid5();
    }

    //9th API connection for 2 year chart with 1 day interval
    public boolean getStockGraphRange2Yr(String stockSymb, String historyRange) {

    try {

            // Construct YH Finance Chart API URL

            URL yhFinanceGraphURL = new URL("https://yh-finance.p.rapidapi.com/stock/v3/get-chart?interval=1d&symbol=" 
                                            + stockSymb + "&range=" + historyRange + "&region=US&includePrePost=false&useYfid=true&includeAdjustedClose=true&events=capitalGain,div,split");
            //making a url connection   
            URLConnection urlCon = yhFinanceGraphURL.openConnection();
             
            // neccessary headers for the url connection    
            urlCon.setRequestProperty("X-RapidAPI-Host", "yh-finance.p.rapidapi.com");
            urlCon.setRequestProperty("X-RapidAPI-Key", API_KEY6);
            
            // Open the URL Connection

            BufferedReader br = new BufferedReader(new InputStreamReader (urlCon.getInputStream()));   
            
            // Read the result into a JSON Element
            jsex7 = new JsonParser().parse(br);

            // Close the connection so we could pull data out later
            br.close();          
              
        } catch (java.io.UnsupportedEncodingException uee) {
            uee.printStackTrace();
        } catch (java.net.MalformedURLException mue) {
            mue.printStackTrace();
        } catch (java.io.IOException ioe) {
            System.out.println("ERROR: The Stock Symbol You Have Entered is not Valid");
        }
            
        // check to see if the url and stock ticker was valid
        return isValid6();
    }
    
    //10th API connection for 5 year chart with 1 week interval
    public boolean getStockGraphRange5Yr(String stockSymb, String historyRange) {

    try {

            // Construct YH Finance Chart API URL

            URL yhFinanceGraphURL = new URL("https://yh-finance.p.rapidapi.com/stock/v3/get-chart?interval=1wk&symbol=" 
                                            + stockSymb + "&range=" + historyRange + "&region=US&includePrePost=false&useYfid=true&includeAdjustedClose=true&events=capitalGain,div,split");
            //making a url connection   
            URLConnection urlCon = yhFinanceGraphURL.openConnection();
             
            // neccessary headers for the url connection    
            urlCon.setRequestProperty("X-RapidAPI-Host", "yh-finance.p.rapidapi.com");
            urlCon.setRequestProperty("X-RapidAPI-Key", API_KEY7);
            
            // Open the URL Connection

            BufferedReader br = new BufferedReader(new InputStreamReader (urlCon.getInputStream()));   
            
            // Read the result into a JSON Element
            jsex8 = new JsonParser().parse(br);

            // Close the connection so we could pull data out later
            br.close();          
              
        } catch (java.io.UnsupportedEncodingException uee) {
            uee.printStackTrace();
        } catch (java.net.MalformedURLException mue) {
            mue.printStackTrace();
        } catch (java.io.IOException ioe) {
            System.out.println("ERROR: The Stock Symbol You Have Entered is not Valid");
        }
            
        // check to see if the url and stock ticker was valid
        return isValid7();
    }
    
    //11th API connection for 10 year chart with 1 month interval
    public boolean getStockGraphRange10Yr(String stockSymb, String historyRange) {

    try {

            // Construct YH Finance Chart API URL

            URL yhFinanceGraphURL = new URL("https://yh-finance.p.rapidapi.com/stock/v3/get-chart?interval=1mo&symbol=" 
                                            + stockSymb + "&range=" + historyRange + "&region=US&includePrePost=false&useYfid=true&includeAdjustedClose=true&events=capitalGain,div,split");
            //making a url connection   
            URLConnection urlCon = yhFinanceGraphURL.openConnection();
             
            // neccessary headers for the url connection    
            urlCon.setRequestProperty("X-RapidAPI-Host", "yh-finance.p.rapidapi.com");
            urlCon.setRequestProperty("X-RapidAPI-Key", API_KEY8);
            
            // Open the URL Connection

            BufferedReader br = new BufferedReader(new InputStreamReader (urlCon.getInputStream()));   
            
            // Read the result into a JSON Element
            jsex9 = new JsonParser().parse(br);

            // Close the connection so we could pull data out later
            br.close();          
              
        } catch (java.io.UnsupportedEncodingException uee) {
            uee.printStackTrace();
        } catch (java.net.MalformedURLException mue) {
            mue.printStackTrace();
        } catch (java.io.IOException ioe) {
            System.out.println("ERROR: The Stock Symbol You Have Entered is not Valid");
        }
            
        // check to see if the url and stock ticker was valid
        return isValid8();
    }
    
    //12th API connection for other stock info
    public boolean getStockInfo(String stockSymb) {

    try {

            // Construct YH Finance Chart API URL

            URL yhFinanceGraphURL = new URL("https://yh-finance.p.rapidapi.com/stock/v2/get-summary?symbol="
                + stockSymb);
            URLConnection urlCon = yhFinanceGraphURL.openConnection();
             
            // neccessary headers for the url connection    
            urlCon.setRequestProperty("X-RapidAPI-Host", "yh-finance.p.rapidapi.com");
            urlCon.setRequestProperty("X-RapidAPI-Key", API_KEY9);
            
            // Open the URL Connection

            BufferedReader br = new BufferedReader(new InputStreamReader (urlCon.getInputStream()));   
            
            // Read the result into a JSON Element
            jse2 = new JsonParser().parse(br);

            // Close the connection so we could pull data out later
            br.close();          
              
        } catch (java.io.UnsupportedEncodingException uee) {
            uee.printStackTrace();
        } catch (java.net.MalformedURLException mue) {
            mue.printStackTrace();
        } catch (java.io.IOException ioe) {
            System.out.println("ERROR: The Stock Symbol You Have Entered is not Valid");
        }
            
        // check to see if the url and stock ticker was valid
        return isValid9();
    }



        
    public boolean isValid() {
            
        // if the stock ticker is valid we will get an error field in the JSON
        try {
            String error = jse.getAsJsonObject().get("quoteResponse")
                             .getAsJsonObject().get("result")
                             .getAsJsonArray().get(0)
                             .getAsJsonObject().get("region").getAsString();
            return true;
            
        } catch (Exception e) {
            
            // no err description so this is a stock symbol
            return false;
            
        }
    }
    
        public boolean isValidX() {
            
        // if the stock ticker is valid we will get an error field in the JSON
        try {
            String error = jsex.getAsJsonObject().get("chart")
                             .getAsJsonObject().get("result")
                             .getAsJsonArray().get(0)
                             .getAsJsonObject().get("indicators")
                             .getAsJsonObject().get("quote")
                             .getAsJsonArray().get(0)
                             .getAsJsonObject().get("close")
                             .getAsJsonArray().get(0).getAsString();
            return true;
            
        } catch (Exception e) {
            
            // no err description so this is a stock symbol
            return false;

        }

    }
    
        public boolean isValidW() {
            
        // if the stock ticker is valid we will get an error field in the JSON
        try {
            String error = jsex2.getAsJsonObject().get("chart")
                             .getAsJsonObject().get("result")
                             .getAsJsonArray().get(0)
                             .getAsJsonObject().get("indicators")
                             .getAsJsonObject().get("quote")
                             .getAsJsonArray().get(0)
                             .getAsJsonObject().get("close")
                             .getAsJsonArray().get(0).getAsString();
            return true;
            
        } catch (Exception e) {
            
            // no err description so this is a stock symbol
            return false;

        }
    }
    
    public boolean isValid2() {
            
        // if the stock ticker is valid we will get an error field in the JSON
        try {
            String error = jsex3.getAsJsonObject().get("chart")
                             .getAsJsonObject().get("result")
                             .getAsJsonArray().get(0)
                             .getAsJsonObject().get("indicators")
                             .getAsJsonObject().get("quote")
                             .getAsJsonArray().get(0)
                             .getAsJsonObject().get("close")
                             .getAsJsonArray().get(0).getAsString();
            return true;
            
        } catch (Exception e) {
            
            // no err description so this is a stock symbol
            return false;

        }
    }
    
    public boolean isValid3() {
            
        // if the stock ticker is valid we will get an error field in the JSON
        try {
            String error = jsex4.getAsJsonObject().get("chart")
                             .getAsJsonObject().get("result")
                             .getAsJsonArray().get(0)
                             .getAsJsonObject().get("indicators")
                             .getAsJsonObject().get("quote")
                             .getAsJsonArray().get(0)
                             .getAsJsonObject().get("close")
                             .getAsJsonArray().get(0).getAsString();
            return true;
            
        } catch (Exception e) {
            
            // no err description so this is a stock symbol
            return false;

        }
    }

    public boolean isValid4() {
            
        // if the stock ticker is valid we will get an error field in the JSON
        try {
            String error = jsex5.getAsJsonObject().get("chart")
                             .getAsJsonObject().get("result")
                             .getAsJsonArray().get(0)
                             .getAsJsonObject().get("indicators")
                             .getAsJsonObject().get("quote")
                             .getAsJsonArray().get(0)
                             .getAsJsonObject().get("close")
                             .getAsJsonArray().get(0).getAsString();
            return true;
            
        } catch (Exception e) {
            
            // no err description so this is a stock symbol
            return false;

        }
    }
    
    public boolean isValid5() {
            
        // if the stock ticker is valid we will get an error field in the JSON
        try {
            String error = jsex6.getAsJsonObject().get("chart")
                             .getAsJsonObject().get("result")
                             .getAsJsonArray().get(0)
                             .getAsJsonObject().get("indicators")
                             .getAsJsonObject().get("quote")
                             .getAsJsonArray().get(0)
                             .getAsJsonObject().get("close")
                             .getAsJsonArray().get(0).getAsString();
            return true;
            
        } catch (Exception e) {
            
            // no err description so this is a stock symbol
            return false;

        }
    }

    public boolean isValid6() {
            
        // if the stock ticker is valid we will get an error field in the JSON
        try {
            String error = jsex7.getAsJsonObject().get("chart")
                             .getAsJsonObject().get("result")
                             .getAsJsonArray().get(0)
                             .getAsJsonObject().get("indicators")
                             .getAsJsonObject().get("quote")
                             .getAsJsonArray().get(0)
                             .getAsJsonObject().get("close")
                             .getAsJsonArray().get(0).getAsString();
            return true;
            
        } catch (Exception e) {
            
            // no err description so this is a stock symbol
            return false;

        }
    }
    
    public boolean isValid7() {
            
        // if the stock ticker is valid we will get an error field in the JSON
        try {
            String error = jsex8.getAsJsonObject().get("chart")
                             .getAsJsonObject().get("result")
                             .getAsJsonArray().get(0)
                             .getAsJsonObject().get("indicators")
                             .getAsJsonObject().get("quote")
                             .getAsJsonArray().get(0)
                             .getAsJsonObject().get("close")
                             .getAsJsonArray().get(0).getAsString();
            return true;
            
        } catch (Exception e) {
            
            // no err description so this is a stock symbol
            return false;

        }
    }

    public boolean isValid8() {
            
        // if the stock ticker is valid we will get an error field in the JSON
        try {
            String error = jsex9.getAsJsonObject().get("chart")
                             .getAsJsonObject().get("result")
                             .getAsJsonArray().get(0)
                             .getAsJsonObject().get("indicators")
                             .getAsJsonObject().get("quote")
                             .getAsJsonArray().get(0)
                             .getAsJsonObject().get("close")
                             .getAsJsonArray().get(0).getAsString();
            return true;
            
        } catch (Exception e) {
            
            // no err description so this is a stock symbol
            return false;

        }
    }
    
    public boolean isValid9() {
            
        // if the stock ticker is valid we will get an error field in the JSON
        try {
            String error = jse2.getAsJsonObject().get("defaultKeyStatistics")
                             .getAsJsonObject().get("forwardEps")
                             .getAsJsonObject().get("raw").getAsString();
            return true;
            
        } catch (Exception e) {
            
            // no err description so this is a stock symbol
            return false;

        }
    }
    
    public String getExchangeName() {
            
        String excName = jse.getAsJsonObject().get("quoteResponse")
                  .getAsJsonObject().get("result")
                  .getAsJsonArray().get(0)
                  .getAsJsonObject().get("fullExchangeName").getAsString();
        
        return excName;
                      
    }
            
    public String getCompName() {
            
        String fullName = jse.getAsJsonObject().get("quoteResponse")
                          .getAsJsonObject().get("result")
                          .getAsJsonArray().get(0)
                          .getAsJsonObject().get("longName").getAsString();
                                  
        return fullName;
                      
                  
                      
    }

    public String getOpenPrice() {
        
        String openF = "%.2f"; 
            
        String open = jse.getAsJsonObject().get("quoteResponse")
                  .getAsJsonObject().get("result")
                  .getAsJsonArray().get(0)
                  .getAsJsonObject().get("regularMarketOpen").getAsString();
                  
        float openP = Float.parseFloat(open);
        
        String openPrice = String.format(openF, openP);
        
        return openPrice;
                      
    }
            
    public String getClosePrice() {
        
        String closeF = "%.2f";
            
        String close = jse.getAsJsonObject().get("quoteResponse")
                          .getAsJsonObject().get("result")
                          .getAsJsonArray().get(0)
                          .getAsJsonObject().get("regularMarketPreviousClose").getAsString();
                  
        float closeP = Float.parseFloat(close);
        
        String closePrice = String.format(closeF, closeP);
        
        return closePrice;
                      
                  
                      
    }
            
    public String getHigh() {

                  
        String highF = "%.2f";
            
        String high = jse.getAsJsonObject().get("quoteResponse")
                          .getAsJsonObject().get("result")
                          .getAsJsonArray().get(0)
                          .getAsJsonObject().get("regularMarketDayHigh").getAsString();
                          
        float highP = Float.parseFloat(high);
        
        String highPrice = String.format(highF, highP);
        
        return highPrice;
                      
    }
            
    public String getLow() {

                  
        String lowF = "%.2f";
            
        String low = jse.getAsJsonObject().get("quoteResponse")
                          .getAsJsonObject().get("result")
                          .getAsJsonArray().get(0)
                          .getAsJsonObject().get("regularMarketDayLow").getAsString();
                          
        float lowP = Float.parseFloat(low);
        
        String lowPrice = String.format(lowF, lowP);
        
        return lowPrice;
                        
                      
    }
            
    public String getPE() {

        try {
                  
        String peF = "%.2f";
            
        String pe = jse.getAsJsonObject().get("quoteResponse")
                          .getAsJsonObject().get("result")
                          .getAsJsonArray().get(0)
                          .getAsJsonObject().get("trailingPE").getAsString();
                          
        float peP = Float.parseFloat(pe);
        
        String peR = String.format(peF, peP);
        
        return peR;  
              
        } catch (Exception e) {
            return "null";
        }
                      
    }
            
    public String getMktCap() {    
        
        try { 
                  
            String capF = "%.0f";
            
            String cap = jse.getAsJsonObject().get("quoteResponse")
                          .getAsJsonObject().get("result")
                          .getAsJsonArray().get(0)
                          .getAsJsonObject().get("marketCap").getAsString();
                          
            float capP = Float.parseFloat(cap);
        
            String mktCap = String.format(capF, capP);
        
            return mktCap;   
              
        } catch (Exception e) {
            return "null";
        }
        
    }
            
    public String getDivYield() {  
        
        try { 
                  
        String divF = "%.2f";
            
        String div = jse.getAsJsonObject().get("quoteResponse")
                          .getAsJsonObject().get("result")
                          .getAsJsonArray().get(0)
                          .getAsJsonObject().get("dividendYield").getAsString();
                          
        float divP = Float.parseFloat(div);
        
        String divYield = String.format(divF, divP);
        
        return divYield;      
              
        } catch (Exception e) {
            return "Company doesnt give dividends";
        }
        
    }
            
    public String get52WkHigh() {

        try {
                  
            String highF = "%.2f";
            
            String high = jse.getAsJsonObject().get("quoteResponse")
                          .getAsJsonObject().get("result")
                          .getAsJsonArray().get(0)
                          .getAsJsonObject().get("fiftyTwoWeekHigh").getAsString();
                          
            float highP = Float.parseFloat(high);
        
            String wkHigh = String.format(highF, highP);
        
            return wkHigh;
                      
        } catch (Exception e) {
            return "null";
        }  
                      
    }
    
    public String get52WkLow() {
                  
        try {
                  
            String lowF = "%.2f";
            
            String low = jse.getAsJsonObject().get("quoteResponse")
                          .getAsJsonObject().get("result")
                          .getAsJsonArray().get(0)
                          .getAsJsonObject().get("fiftyTwoWeekLow").getAsString();
                          
            float lowP = Float.parseFloat(low);
        
            String wkLow = String.format(lowF, lowP);
        
            return wkLow; 
                              
        } catch (Exception e) {
            return "null";
        } 
                      
    }
    
    public String getVol() { 
        
        try {
                  
            String avgVolF = "%.0f";
            
            String avgVol = jse.getAsJsonObject().get("quoteResponse")
                        .getAsJsonObject().get("result")
                        .getAsJsonArray().get(0)
                        .getAsJsonObject().get("regularMarketVolume").getAsString(); 
                          
            float avgVolP = Float.parseFloat(avgVol);
        
            String avgVolR = String.format(avgVolF, avgVolP);
        
            return avgVolR;
                      
        // if return null, stock has no volume   
        } catch (Exception e) {
            return "0";
        }
                      
    }
    
    public String getAvgVol() {
        
        try {
                  
            String avgVolF = "%.0f";
            
            String avgVol = jse.getAsJsonObject().get("quoteResponse")
                        .getAsJsonObject().get("result")
                        .getAsJsonArray().get(0)
                        .getAsJsonObject().get("averageDailyVolume3Month").getAsString(); 
                          
            float avgVolP = Float.parseFloat(avgVol);
            
            String avgVolR = String.format(avgVolF, avgVolP);
        
            return avgVolR;
               
        // if return null, stock has no avg volume       
        } catch (Exception e) {
            return "0";
        }
                      
    }
    
    public String getEPS() {
        
        try {
                  
            String epsF = "%,.2f";
            
            String eps = jse.getAsJsonObject().get("quoteResponse")
                          .getAsJsonObject().get("result")
                          .getAsJsonArray().get(0)
                          .getAsJsonObject().get("epsTrailingTwelveMonths").getAsString();
                          
            float epsP = Float.parseFloat(eps);
        
            String epsR = String.format(epsF, epsP);
        
            return epsR; 
               
        } catch (Exception e) {
            return "null";
        }
                      
    }
    
    public String getDivCashAnnual() {
        
        try {
                  
            String divF = "%,.2f";
            
            String div = jse.getAsJsonObject().get("quoteResponse")
                          .getAsJsonObject().get("result")
                          .getAsJsonArray().get(0)
                          .getAsJsonObject().get("dividendRate").getAsString();
                          
            float divP = Float.parseFloat(div);
        
            String divR = String.format(divF, divP);

        
            return divR; 
               
        } catch (Exception e) {
            return "Company doesnt give dividends";
        }
                      
    }
    
    public String getCash() {
        
        try {
            
 
            
            String cash = jse2.getAsJsonObject().get("financialData")
                          .getAsJsonObject().get("freeCashflow")
                          .getAsJsonObject().get("longFmt").getAsString();

                
            return cash; 
               
        } catch (Exception e) {
            return "null";
        }
                      
    }
    
    public String getDivPayRatio() {
        
        try {
            
            String ratio = jse2.getAsJsonObject().get("summaryDetail")
                          .getAsJsonObject().get("payoutRatio")
                          .getAsJsonObject().get("fmt").getAsString();

            return ratio;
               
        } catch (Exception e) {
            return "null";
        }
                      
    }
    
    public String getSusDiv() {
        
        try {
            
 
            
            String ratioCheck = jse2.getAsJsonObject().get("summaryDetail")
                          .getAsJsonObject().get("payoutRatio")
                          .getAsJsonObject().get("raw").getAsString();
                          
            float ratio = Float.parseFloat(ratioCheck);
                          
            
                          
            if (ratio <= .50 && ratio > 0.00) {
                
                String check = "YES";
                return check; 
                
            } else if (ratio > .50) {
            
                String check = "NO";
                return check; 
                
            } else {
            
                String check = "The Company Doesn't Give Dividends";
                return check;
                
            }
            
               
        } catch (Exception e) {
            return "null";
        }
                      
    }
    
    public String getAfterHoursP() {
        
        try {
            
            String perc = jse2.getAsJsonObject().get("price")
                          .getAsJsonObject().get("postMarketChangePercent")
                          .getAsJsonObject().get("fmt").getAsString();

            return perc;
               
        } catch (Exception e) {
            return "null";
        }
                      
    }
    
    public String getAfterHoursC() {
        
        try {
            
            String cash = jse2.getAsJsonObject().get("price")
                          .getAsJsonObject().get("postMarketChange")
                          .getAsJsonObject().get("fmt").getAsString();

            return cash;
               
        } catch (Exception e) {
            return "null";
        }
                      
    }
    
    public String getRegularHoursC() {
        
        try {
            
            String cash = jse2.getAsJsonObject().get("price")
                          .getAsJsonObject().get("regularMarketChange")
                          .getAsJsonObject().get("fmt").getAsString();

            return cash;
               
        } catch (Exception e) {
            return "null";
        }
                      
    }
    
    public String getRegularHoursP() {
        
        try {
            
            String perc = jse2.getAsJsonObject().get("price")
                          .getAsJsonObject().get("regularMarketChangePercent")
                          .getAsJsonObject().get("fmt").getAsString();

            return perc;
               
        } catch (Exception e) {
            return "null";
        }
                      
    }
    
    public String getExDivDate() {
        
        try {
            
            String exDate = jse2.getAsJsonObject().get("calendarEvents")
                                .getAsJsonObject().get("exDividendDate")
                                .getAsJsonObject().get("fmt").getAsString();

            return exDate;
               
        } catch (Exception e) {
            return "The Company Doesn't Give Dividends";
        }
                      
    }
    
    public String getDivDate() {
        
        try {
            
            String date = jse2.getAsJsonObject().get("calendarEvents")
                              .getAsJsonObject().get("dividendDate")
                              .getAsJsonObject().get("fmt").getAsString();

            return date;
               
        } catch (Exception e) {
            return "The Company Doesn't Give Dividends";
        }
                      
    }
    
    public String getEarnDate() {
        
        try {
            
            String earnDate = jse2.getAsJsonObject().get("earnings")
                                  .getAsJsonObject().get("earningsChart")
                                  .getAsJsonObject().get("earningsDate")
                                  .getAsJsonArray().get(0)
                                  .getAsJsonObject().get("fmt").getAsString();

            return earnDate;
               
        } catch (Exception e) {
            return "The Company Doesn't Give Dividends";
        }
                      
    }
    
    public String getSector() {
        
        try {
            
            String sector = jse2.getAsJsonObject().get("summaryProfile")
                          .getAsJsonObject().get("sector").getAsString();

            return sector;
               
        } catch (Exception e) {
            return "null";
        }
                      
    }
    
    public String getBusSum() {
        
        try {
                  
   
            String sum = jse2.getAsJsonObject().get("summaryProfile")
                             .getAsJsonObject().get("longBusinessSummary").getAsString();

        
            return sum; 
               
        } catch (Exception e) {
            return "null";
        }
                      
    }
            
    public Image getBadImage() {
            
                
            String picURL = "invalidsymbol.png"; 
                  
            return new Image(picURL);
                
    }
    
    public String getGraphDataAt(int index) {
        
        try {    
        String data = jsex.getAsJsonObject().get("chart")
                             .getAsJsonObject().get("result")
                             .getAsJsonArray().get(0)
                             .getAsJsonObject().get("indicators")
                             .getAsJsonObject().get("quote")
                             .getAsJsonArray().get(0)
                             .getAsJsonObject().get("close")
                             .getAsJsonArray().get(index).getAsString();
                             
        return data;
                             
        } catch (Exception e) {
            System.out.println("Company has not been on the stock market over 1 year - Not enough data for 1 year");
            return "0";
        }
        
                      
    }
    
    public String getGraphDataAt1D(int index) {
        
    try {    
        String data = jsex.getAsJsonObject().get("chart")
                             .getAsJsonObject().get("result")
                             .getAsJsonArray().get(0)
                             .getAsJsonObject().get("indicators")
                             .getAsJsonObject().get("quote")
                             .getAsJsonArray().get(0)
                             .getAsJsonObject().get("close")
                             .getAsJsonArray().get(index).getAsString();
                             
        return data;
                             
    } catch (Exception e) {
        System.out.println("Something went wrong");
        return "0";
    }
                      
    }
    
    public String getGraphDataAt5D(int index) {
        
    try {    
        String data = jsex2.getAsJsonObject().get("chart")
                             .getAsJsonObject().get("result")
                             .getAsJsonArray().get(0)
                             .getAsJsonObject().get("indicators")
                             .getAsJsonObject().get("quote")
                             .getAsJsonArray().get(0)
                             .getAsJsonObject().get("close")
                             .getAsJsonArray().get(index).getAsString();
                             
        return data;
                             
    } catch (Exception e) {
        System.out.println("Something went wrong");
        return "0";
    }
                      
    }
    
    public String getGraphDataAt1Mo(int index) {
        
    try {    
        String data = jsex3.getAsJsonObject().get("chart")
                             .getAsJsonObject().get("result")
                             .getAsJsonArray().get(0)
                             .getAsJsonObject().get("indicators")
                             .getAsJsonObject().get("quote")
                             .getAsJsonArray().get(0)
                             .getAsJsonObject().get("close")
                             .getAsJsonArray().get(index).getAsString();
                             
        return data;
                             
    } catch (Exception e) {
        System.out.println("Something went wrong");
        return "0";
    }
                      
    }
    
    public String getGraphDataAt3Mo(int index) {
        
    try {    
        String data = jsex4.getAsJsonObject().get("chart")
                             .getAsJsonObject().get("result")
                             .getAsJsonArray().get(0)
                             .getAsJsonObject().get("indicators")
                             .getAsJsonObject().get("quote")
                             .getAsJsonArray().get(0)
                             .getAsJsonObject().get("close")
                             .getAsJsonArray().get(index).getAsString();
                             
        return data;
                             
    } catch (Exception e) {
        System.out.println("Something went wrong");
        return "0";
    }
                      
    }
    
    public String getGraphDataAt6Mo(int index) {
        
    try {    
        String data = jsex5.getAsJsonObject().get("chart")
                             .getAsJsonObject().get("result")
                             .getAsJsonArray().get(0)
                             .getAsJsonObject().get("indicators")
                             .getAsJsonObject().get("quote")
                             .getAsJsonArray().get(0)
                             .getAsJsonObject().get("close")
                             .getAsJsonArray().get(index).getAsString();
                             
        return data;
                             
    } catch (Exception e) {
        System.out.println("Something went wrong");
        return "0";
    }
                      
    }
    
    public String getGraphDataAt1Yr(int index) {
        
    try {    
        String data = jsex6.getAsJsonObject().get("chart")
                             .getAsJsonObject().get("result")
                             .getAsJsonArray().get(0)
                             .getAsJsonObject().get("indicators")
                             .getAsJsonObject().get("quote")
                             .getAsJsonArray().get(0)
                             .getAsJsonObject().get("close")
                             .getAsJsonArray().get(index).getAsString();
                             
        return data;
                             
    } catch (Exception e) {
        System.out.println("Something went wrong");
        return "0";
    }
                      
    }   
    
    public String getGraphDataAt2Yr(int index) {
        
    try {    
        String data = jsex7.getAsJsonObject().get("chart")
                             .getAsJsonObject().get("result")
                             .getAsJsonArray().get(0)
                             .getAsJsonObject().get("indicators")
                             .getAsJsonObject().get("quote")
                             .getAsJsonArray().get(0)
                             .getAsJsonObject().get("close")
                             .getAsJsonArray().get(index).getAsString();
                             
        return data;
                             
    } catch (Exception e) {
        System.out.println("Something went wrong");
        return "0";
    }
                      
    } 
    
    public String getGraphDataAt5Yr(int index) {
        
    try {    
        String data = jsex8.getAsJsonObject().get("chart")
                             .getAsJsonObject().get("result")
                             .getAsJsonArray().get(0)
                             .getAsJsonObject().get("indicators")
                             .getAsJsonObject().get("quote")
                             .getAsJsonArray().get(0)
                             .getAsJsonObject().get("close")
                             .getAsJsonArray().get(index).getAsString();
                             
        return data;
                             
    } catch (Exception e) {
        System.out.println("Something went wrong");
        return "0";
    }
                      
    }
    
    public String getGraphDataAt10Yr(int index) {
        
    try {    
        String data = jsex9.getAsJsonObject().get("chart")
                             .getAsJsonObject().get("result")
                             .getAsJsonArray().get(0)
                             .getAsJsonObject().get("indicators")
                             .getAsJsonObject().get("quote")
                             .getAsJsonArray().get(0)
                             .getAsJsonObject().get("close")
                             .getAsJsonArray().get(index).getAsString();
                             
        return data;
                             
    } catch (Exception e) {
        System.out.println("Something went wrong");
        return "0";
    }
                      
    }
    
    public String getGraphDataAtYtd(int index) {
        
    try {    
        String data = jsex.getAsJsonObject().get("chart")
                             .getAsJsonObject().get("result")
                             .getAsJsonArray().get(0)
                             .getAsJsonObject().get("indicators")
                             .getAsJsonObject().get("quote")
                             .getAsJsonArray().get(0)
                             .getAsJsonObject().get("close")
                             .getAsJsonArray().get(index).getAsString();
                             
        return data;
                             
    } catch (Exception e) {
        System.out.println("Something went wrong");
        return "0";
    }
                      
    }

} 
