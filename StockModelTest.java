import org.junit.Assert;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.text.ParseException;


public class StockModelTest {


   /** Fixture initialization (common initialization
    *  for all tests). **/
   @Before public void setUp() {
   }

    @Test
    //my testGetStock1 test
    public void testFirstURLConnection() 
    {
        StockModel stock = new StockModel();
        assertEquals(true, stock.getStock("nflx"));
    }
    
    @Test
    public void testAllCapsInput() 
    {
        StockModel stock = new StockModel();
        assertEquals(true, stock.getStock("TSLA"));
    }
    
    @Test
    public void testNumberSymbolInput() 
    {
        StockModel stock = new StockModel();
        assertEquals(false, stock.getStock("123"));
    }
    
    @Test
    //my testGetStock2 test
    public void testInvalidUserInput() 
    {
        StockModel stock = new StockModel();
        assertEquals(false, stock.getStock("abcdef"));
    }
    
    @Test
    //testing connection to graph api
    public void testGraphApiURLConnection() 
    {
        StockModel graph = new StockModel();
        assertEquals(true, graph.getStockGraph("jwn"));
    }
    
    @Test
    public void testGraphMethodAllCapsInput() 
    {
        StockModel graph = new StockModel();
        assertEquals(true, graph.getStockGraph("VOO"));
    }
    
    @Test
    public void testGraphMethodNumberInput() 
    {
        StockModel graph = new StockModel();
        assertEquals(false, graph.getStockGraph("1234566"));
    }
    
    @Test
    public void testGraphMethodInvalidInput() 
    {
        StockModel stock = new StockModel();
        assertEquals(false, stock.getStockGraph("abfcdef"));
    }           
    
    @Test
    public void testExchangeName()
    {
        StockModel stock = new StockModel();
        
        if ((stock.getStock("abbv")) == true) {
            String s = (stock.getExchangeName());
            assertEquals(s, "NYSE");
        }
        
     }
    
    @Test
    public void testCompanyName()
    {
        StockModel stock = new StockModel();
        
        if ((stock.getStock("abt")) == true) {
            String s = (stock.getCompName());
            assertEquals(s, "Abbott Laboratories");
        }
        
     }
    
    @Test
    public void testOpenPrice()
    {
        StockModel stock = new StockModel();
        
        if ((stock.getStock("aapl")) == true) {
            double x = Double.parseDouble(stock.getOpenPrice());
            if ( x < 180.00 && x > 110.00) {
                assertEquals(true, true);
            } else {
                assertEquals(true, false);
            }
        }
        
     }
     
    @Test
    public void testClosePrice()
    {
        StockModel stock = new StockModel();
        
        if ((stock.getStock("crsr")) == true) {
            double x = Double.parseDouble(stock.getClosePrice());
            if ( x < 20.00 && x > 10.00) {
                assertEquals(true, true);
            } else {
                assertEquals(true, false);
            }
        }
        
     }
     
    @Test
    public void testHigh()
    {
        StockModel stock = new StockModel();
        
        if ((stock.getStock("googl")) == true) {
            double x = Double.parseDouble(stock.getHigh());
            if ( x < 2600.00 && x > 1600.00) {
                assertEquals(true, true);
            } else {
                assertEquals(true, false);
            }
        }
        
     }
     
    @Test
    public void testLow()
    {
        StockModel stock = new StockModel();
        
        if ((stock.getStock("jnj")) == true) {
            double x = Double.parseDouble(stock.getLow());
            if ( x < 190.00 && x > 150.00) {
                assertEquals(true, true);
            } else {
                assertEquals(true, false);
            }
        }
        
     }
     
    @Test
    public void testPE()
    {
        StockModel stock = new StockModel();
        
        if ((stock.getStock("fb")) == true) {
            double x = Double.parseDouble(stock.getPE());
            if ( x < 70.00 && x > 5.00) {
                assertEquals(true, true);
            } else {
                assertEquals(true, false);
            }
        }
        
     }
     
    @Test
    public void testDivYield()
    {
        StockModel stock = new StockModel();
        
        if ((stock.getStock("xom")) == true) {
            double x = Double.parseDouble(stock.getDivYield());
            if ( x < 15.00 && x >= 0.00) {
                assertEquals(true, true);
            } else {
                assertEquals(true, false);
            }
        }
        
     }
     
    @Test
    public void test52WkHigh()
    {
        StockModel stock = new StockModel();
        
        if ((stock.getStock("nvda")) == true) {
            double x = Double.parseDouble(stock.get52WkHigh());
            if ( x < 400.00 && x > 300.00) {
                assertEquals(true, true);
            } else {
                assertEquals(true, false);
            }
        }
        
     }
     
    @Test
    public void test52WkLow()
    {
        StockModel stock = new StockModel();
        
        if ((stock.getStock("nvda")) == true) {
            double x = Double.parseDouble(stock.get52WkLow());
            if ( x < 2000.00 && x > 80.00) {
                assertEquals(true, true);
            } else {
                assertEquals(true, false);
            }
        }
        
     }
     
    @Test
    public void testVolume()
    {
        StockModel stock = new StockModel();
        
        if ((stock.getStock("v")) == true) {
            double x = Double.parseDouble(stock.getVol());
            if ( x < 20000000000.00 && x > 5000.00) {
                assertEquals(true, true);
            } else {
                assertEquals(true, false);
            }
        }
        
     }
     
    @Test
    public void testAvgVolume()
    {
        StockModel stock = new StockModel();
        
        if ((stock.getStock("cvx")) == true) {
            double x = Double.parseDouble(stock.getAvgVol());
            if ( x < 25000000.00 && x > 8000000.00) {
                assertEquals(true, true);
            } else {
                assertEquals(true, false);
            }
        }
        
     }
     
    @Test
    public void testMktCap()
    {
        StockModel stock = new StockModel();
        
        if ((stock.getStock("fb")) == true) {
            double x = Double.parseDouble(stock.getMktCap());
            if ( x < 600000000000.00 && x > 100000000000.00) {
                assertEquals(true, true);
            } else {
                assertEquals(true, false);
            }
        }
        
     }
     
    @Test
    public void testEPS()
    {
        StockModel stock = new StockModel();
        
        if ((stock.getStock("pep")) == true) {
            double x = Double.parseDouble(stock.getEPS());
            if ( x < 10.00 && x > 1.00) {
                assertEquals(true, true);
            } else {
                assertEquals(true, false);
            }
        }
        
     }


}
