import java.awt.event.ActionListener;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.chart.*;

/*
 * @author Vadim Tkachuk
 */

public class StockController implements Initializable {

    @FXML
    private LineChart<String, Number> lineChart;

    @FXML
    private Button btnSearch;
    
    @FXML
    private TextField txtStockSymb;
    
    @FXML
    private TextField txtExchangeName; 
    
    @FXML
    private Label lblExchangeName;
    
    @FXML
    private TextField txtCompName; 
    
    @FXML
    private Label lblCompName;
    
    @FXML
    private TextField txtOpenPrice;
    
    @FXML
    private Label lblOpenPrice;
    
    @FXML
    private TextField txtClosePrice;
    
    @FXML
    private Label lblClosePrice;
    
    @FXML
    private TextField txtHigh;
    
    @FXML
    private Label lblHigh;
    
    @FXML
    private TextField txtLow;
    
    @FXML
    private Label lblLow;
    
    @FXML
    private TextField txtPE;
    
    @FXML
    private Label lblPE;
    
    @FXML
    private TextField txtDivYield;
    
    @FXML
    private Label lblDivYield;
    
    @FXML
    private TextField txt52WkLow;
    
    @FXML
    private Label lbl52WkLow;
    
    @FXML
    private TextField txt52WkHigh;
    
    @FXML
    private Label lbl52WkHigh;
    
    @FXML
    private TextField txtVol;
    
    @FXML
    private Label lblVol;
    
    @FXML
    private TextField txtAvgVol;
    
    @FXML
    private Label lblAvgVol;
    
    @FXML
    private TextField txtMktCap;
    
    @FXML
    private Label lblMktCap;
    
    @FXML
    private TextField txtEPS;
    
    @FXML
    private Label lblEPS;
    
    @FXML
    private TextField txtCash; 
    
    @FXML
    private Label lblCash;
    
    @FXML
    private TextField txtAnnualDiv; 
    
    @FXML
    private Label lblAnnualDiv;
    
    @FXML
    private TextField txtDivPayRatio; 
    
    @FXML
    private Label lblDivPayRatio;
    
    @FXML
    private TextField txtAfterHoursC; 
    
    @FXML
    private Label lblAfterHoursC;
    
    @FXML
    private TextField txtAfterHoursP; 
    
    @FXML
    private Label lblAfterHoursP;
    
    @FXML
    private TextField txtTodayUpDownC; 
    
    @FXML
    private Label lblTodayUpDownC;
    
    @FXML
    private TextField txtTodayUpDownP; 
    
    @FXML
    private Label lblTodayUpDownP;
    
    @FXML
    private TextField txtSusDiv; 
    
    @FXML
    private Label lblSusDiv;
    
    @FXML
    private TextField txtEarnDate; 
    
    @FXML
    private Label lblEarnDate;
    
    @FXML
    private TextArea txtBusSum;
    
    @FXML
    private TextField txtDivDate; 
    
    @FXML
    private Label lblDivDate;
    
    @FXML
    private TextField txtExDivDate; 
    
    @FXML
    private Label lblExDivDate;
    
    @FXML
    private TextField txtSector; 
    
    @FXML
    private Label lblSector;
    
    @FXML
    private ImageView badStockSymbImg;
    
    @FXML
    private Button btn1D;
    
    @FXML
    private Button btn5D;
    
    @FXML
    private Button btn1Mo;
    
    @FXML
    private Button btn3Mo;
    
    @FXML
    private Button btn6Mo;
    
    @FXML
    private Button btn1Yr;
    
    @FXML
    private Button btn2Yr;
    
    @FXML
    private Button btn5Yr;
    
    @FXML
    private Button btn10Yr;

    
    @FXML
    private void handleButtonAction(ActionEvent e) {
        //create object access to the StockModel
        StockModel stockAccess = new StockModel();
        
        
    // has the search button been pressed?
        if (e.getSource() == btnSearch) {
            String stockSymb = txtStockSymb.getText();
            
            try {
                //checking both api connections
                if ((stockAccess.getStock(stockSymb)) == true && (stockAccess.getStockGraph(stockSymb)) == true && (stockAccess.getStockInfo(stockSymb)) == true) {
                   
                    txtEarnDate.setText(stockAccess.getEarnDate());
                    txtExchangeName.setText(String.valueOf(stockAccess.getExchangeName()));
                    txtCompName.setText(String.valueOf(stockAccess.getCompName()));
                    txtOpenPrice.setText(String.valueOf(stockAccess.getOpenPrice()));
                    txtClosePrice.setText(String.valueOf(stockAccess.getClosePrice()));
                    txtHigh.setText(String.valueOf(stockAccess.getHigh()));
                    txtLow.setText(stockAccess.getLow());
                    txtPE.setText(String.valueOf(stockAccess.getPE()));
                    txtDivYield.setText(stockAccess.getDivYield());
                    txt52WkHigh.setText(String.valueOf(stockAccess.get52WkHigh()));
                    txt52WkLow.setText(String.valueOf(stockAccess.get52WkLow()));
                    txtVol.setText(String.valueOf(stockAccess.getVol()));
                    txtAvgVol.setText(String.valueOf(stockAccess.getAvgVol()));
                    txtMktCap.setText(String.valueOf(stockAccess.getMktCap()));
                    txtEPS.setText(stockAccess.getEPS());
                    txtAnnualDiv.setText(stockAccess.getDivCashAnnual());
                    txtBusSum.setText(stockAccess.getBusSum());
                    txtCash.setText(stockAccess.getCash());
                    txtDivPayRatio.setText(stockAccess.getDivPayRatio());
                    txtSusDiv.setText(stockAccess.getSusDiv());
                    txtAfterHoursP.setText(stockAccess.getAfterHoursP());
                    txtAfterHoursC.setText(stockAccess.getAfterHoursC());
                    txtTodayUpDownC.setText(stockAccess.getRegularHoursC());
                    txtTodayUpDownP.setText(stockAccess.getRegularHoursP());
                    txtExDivDate.setText(stockAccess.getExDivDate());
                    txtDivDate.setText(stockAccess.getDivDate());
                    txtSector.setText(stockAccess.getSector());
                    badStockSymbImg.setImage(null);

                    lineChart.getData().clear();
                    XYChart.Series<String, Number> data = new XYChart.Series<String, Number>();
                    data.setName("1 Day Interval");
                    
                    for (int i = 0; i<=251; i++) {
                        double graphData = (Double.parseDouble(stockAccess.getGraphDataAt(i)));
                        data.getData().add(new XYChart.Data<String, Number>(String.valueOf(i), graphData));
                    }
                    
                    lineChart.getData().add(data);
                        
                                                
                } else  {                                
                    txtStockSymb.setText("Enter Valid Symbol");
                    txtExchangeName.setText("");
                    txtCompName.setText("");
                    txtOpenPrice.setText("");
                    txtClosePrice.setText("");
                    txtHigh.setText("");
                    txtLow.setText("");
                    txtPE.setText("");
                    txtDivYield.setText("");
                    txt52WkHigh.setText("");
                    txt52WkLow.setText("");
                    txtVol.setText("");
                    txtAvgVol.setText("");
                    txtMktCap.setText("");
                    txtEPS.setText("");
                    txtCash.setText("");
                    txtAnnualDiv.setText("");
                    txtDivPayRatio.setText("");
                    txtAfterHoursC.setText("");
                    txtAfterHoursP.setText("");
                    txtTodayUpDownC.setText("");
                    txtTodayUpDownP.setText("");
                    txtSusDiv.setText("");
                    txtEarnDate.setText("");
                    badStockSymbImg.setImage(stockAccess.getBadImage());
                    lineChart.getData().clear();

                }
                
            } catch (Exception x) {
                
                System.out.println("Something went wrong!");
            
            }
       
        }

    
    }

        
    @FXML
    private void handle1DButtonAction(ActionEvent d) {
    
        //create object access to the StockModel
        StockModel stockAccess = new StockModel();
        
        
        // has the search button been pressed?
        if (d.getSource() == btn1D) {
            String stockSymb = txtStockSymb.getText();
            String historyRange = "1d";
            
            try {
                //checking both api connections
                if  ((stockAccess.getStockGraphRange1D(stockSymb, historyRange)) == true) {
                    
                    lineChart.getData().clear();
                    XYChart.Series<String, Number> data = new XYChart.Series<String, Number>();
                    data.setName("");
                    data.setName("5 Min Interval");
                    
                    for (int i = 0; i<=78; i++) {
                        double graphData = (Double.parseDouble(stockAccess.getGraphDataAt1D(i)));
                        data.getData().add(new XYChart.Data<String, Number>(String.valueOf(i), graphData));
                    }
                    
                    lineChart.getData().add(data);
                        
                                                
                }
                
            } catch (Exception x) {
                
                System.out.println("Something went wrong!");
            
            }
       
        }

    
    }
    
    @FXML
    private void handle5DButtonAction(ActionEvent z) {
    
        //create object access to the StockModel
        StockModel stockAccess = new StockModel();
        
        
        // has the search button been pressed?
        if (z.getSource() == btn5D) {
            String stockSymb = txtStockSymb.getText();
            String historyRange = "5d";
            
            try {
                //checking both api connections
                if  ((stockAccess.getStockGraphRange5D(stockSymb, historyRange)) == true) {
                    
                    lineChart.getData().clear();
                    XYChart.Series<String, Number> data = new XYChart.Series<String, Number>();
                    data.setName("");
                    data.setName("30 Min Interval");
                    
                    for (int i = 0; i<=65; i++) {
                        double graphData = (Double.parseDouble(stockAccess.getGraphDataAt5D(i)));
                        data.getData().add(new XYChart.Data<String, Number>(String.valueOf(i), graphData));
                    }
                    
                    lineChart.getData().add(data);
                        
                                                
                } 
                
            } catch (Exception x) {
                
                System.out.println("Something went wrong!");
            
            }
       
        }

    
    }
    
    @FXML
    private void handle1MoButtonAction(ActionEvent f) {
    
        //create object access to the StockModel
        StockModel stockAccess = new StockModel();
        
        
        // has the search button been pressed?
        if (f.getSource() == btn1Mo) {
            String stockSymb = txtStockSymb.getText();
            String historyRange = "1mo";
            
            try {
                //checking both api connections
                if  ((stockAccess.getStockGraphRange1Mo(stockSymb, historyRange)) == true) {
                    
                    lineChart.getData().clear();
                    XYChart.Series<String, Number> data = new XYChart.Series<String, Number>();
                    data.setName("");
                    data.setName("1 Day Interval");
                    
                    for (int i = 0; i<=21; i++) {
                        double graphData = (Double.parseDouble(stockAccess.getGraphDataAt1Mo(i)));
                        data.getData().add(new XYChart.Data<String, Number>(String.valueOf(i), graphData));
                    }
                    
                    lineChart.getData().add(data);
                        
                }
                
            } catch (Exception x) {
                
                System.out.println("Something went wrong!");
            
            }
       
        }

    
    }
    
    
    @FXML
    private void handle3MoButtonAction(ActionEvent q) {
    
        //create object access to the StockModel
        StockModel stockAccess = new StockModel();
        
        
        // has the search button been pressed?
        if (q.getSource() == btn3Mo) {
            String stockSymb = txtStockSymb.getText();
            String historyRange = "3mo";
            
            try {
                //checking both api connections
                if  ((stockAccess.getStockGraphRange3Mo(stockSymb, historyRange)) == true) {
                    
                    lineChart.getData().clear();
                    XYChart.Series<String, Number> data = new XYChart.Series<String, Number>();
                    data.setName("");
                    data.setName("1 Day Interval");
                    
                    for (int i = 0; i<=62; i++) {
                        double graphData = (Double.parseDouble(stockAccess.getGraphDataAt3Mo(i)));
                        data.getData().add(new XYChart.Data<String, Number>(String.valueOf(i), graphData));
                    }
                    
                    lineChart.getData().add(data);
                        
                                                
                } 
                                
            } catch (Exception x) {
                
                System.out.println("Something went wrong!");
            
            }
       
        }
    }
    
    
    @FXML
    private void handle6MoButtonAction(ActionEvent r) {
    
        //create object access to the StockModel
        StockModel stockAccess = new StockModel();
        
        
        // has the search button been pressed?
        if (r.getSource() == btn6Mo) {
            String stockSymb = txtStockSymb.getText();
            String historyRange = "6mo";
            
            try {
                //checking both api connections
                if  ((stockAccess.getStockGraphRange6Mo(stockSymb, historyRange)) == true) {
                    
                    lineChart.getData().clear();
                    XYChart.Series<String, Number> data = new XYChart.Series<String, Number>();
                    data.setName("");
                    data.setName("1 Day Interval");
                    
                    for (int i = 0; i<=122; i++) {
                        double graphData = (Double.parseDouble(stockAccess.getGraphDataAt6Mo(i)));
                        data.getData().add(new XYChart.Data<String, Number>(String.valueOf(i), graphData));
                    }
                    
                    lineChart.getData().add(data);
                        
                                                
                } 
                                
            } catch (Exception x) {
                
                System.out.println("Something went wrong!");
            
            }
       
        }

    }
    
    @FXML
    private void handle1YrButtonAction(ActionEvent u) {
    
        //create object access to the StockModel
        StockModel stockAccess = new StockModel();
        
        
        // has the search button been pressed?
        if (u.getSource() == btn1Yr) {
            String stockSymb = txtStockSymb.getText();
            String historyRange = "1y";
            
            try {
                //checking both api connections
                if  ((stockAccess.getStockGraphRange1Yr(stockSymb, historyRange)) == true) {
                    
                    lineChart.getData().clear();
                    XYChart.Series<String, Number> data = new XYChart.Series<String, Number>();
                    data.setName("");
                    data.setName("1 Day Interval");
                    
                    for (int i = 0; i<=251; i++) {
                        double graphData = (Double.parseDouble(stockAccess.getGraphDataAt1Yr(i)));
                        data.getData().add(new XYChart.Data<String, Number>(String.valueOf(i), graphData));
                    }
                    
                    lineChart.getData().add(data);
                        
                                                
                } 
                                
            } catch (Exception x) {
                
                System.out.println("Something went wrong!");
            
            }
       
        }

    }

    @FXML
    private void handle2YrButtonAction(ActionEvent a) {
    
        //create object access to the StockModel
        StockModel stockAccess = new StockModel();
        
        
        // has the search button been pressed?
        if (a.getSource() == btn2Yr) {
            String stockSymb = txtStockSymb.getText();
            String historyRange = "2y";
            
            try {
                //checking both api connections
                if  ((stockAccess.getStockGraphRange2Yr(stockSymb, historyRange)) == true) {
                    
                    lineChart.getData().clear();
                    XYChart.Series<String, Number> data = new XYChart.Series<String, Number>();
                    data.setName("");
                    data.setName("1 Day Interval");
                    
                    for (int i = 0; i<=503; i++) {
                        double graphData = (Double.parseDouble(stockAccess.getGraphDataAt2Yr(i)));
                        data.getData().add(new XYChart.Data<String, Number>(String.valueOf(i), graphData));
                    }
                    
                    lineChart.getData().add(data);
                        
                                                
                } 
                                
            } catch (Exception x) {
                
                System.out.println("Something went wrong!");
            
            }
       
        }

    }
    
    @FXML
    private void handle5YrButtonAction(ActionEvent b) {
    
        //create object access to the StockModel
        StockModel stockAccess = new StockModel();
        
        
        // has the search button been pressed?
        if (b.getSource() == btn5Yr) {
            String stockSymb = txtStockSymb.getText();
            String historyRange = "5y";
            
            try {
                //checking both api connections
                if  ((stockAccess.getStockGraphRange5Yr(stockSymb, historyRange)) == true) {
                    
                    lineChart.getData().clear();
                    XYChart.Series<String, Number> data = new XYChart.Series<String, Number>();
                    data.setName("");
                    data.setName("1 Week Interval");
                    
                    for (int i = 0; i<=261; i++) {
                        double graphData = (Double.parseDouble(stockAccess.getGraphDataAt5Yr(i)));
                        data.getData().add(new XYChart.Data<String, Number>(String.valueOf(i), graphData));
                    }
                    
                    lineChart.getData().add(data);
                        
                                                
                } 
                                
            } catch (Exception x) {
                
                System.out.println("Something went wrong!");
            
            }
       
        }

    }
    

    @FXML
    private void handle10YrButtonAction(ActionEvent m) {
    
        //create object access to the StockModel
        StockModel stockAccess = new StockModel();
        
        
        // has the search button been pressed?
        if (m.getSource() == btn10Yr) {
            String stockSymb = txtStockSymb.getText();
            String historyRange = "10y";
            
            try {
                //checking both api connections
                if  ((stockAccess.getStockGraphRange10Yr(stockSymb, historyRange)) == true) {
                    
                    lineChart.getData().clear();
                    XYChart.Series<String, Number> data = new XYChart.Series<String, Number>();
                    data.setName("");
                    data.setName("1 month Interval");
                    
                    for (int i = 0; i<=85; i++) {
                        double graphData = (Double.parseDouble(stockAccess.getGraphDataAt10Yr(i)));
                        data.getData().add(new XYChart.Data<String, Number>(String.valueOf(i), graphData));
                    }
                    
                    lineChart.getData().add(data);
                        
                                                
                }
                                
            } catch (Exception x) {
                
                System.out.println("Something went wrong!");
            
            }
       
        }

    }
    
           
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }     
     
}  