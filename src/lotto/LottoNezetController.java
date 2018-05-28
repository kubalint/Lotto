
package lotto;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.ResourceBundle;
import java.util.Set;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;


public class LottoNezetController implements Initializable {
    private final int MAX = 90;
    private final int MIN = 1;
    
    //random generált számok
    int genNum1;
    int genNum2;
    int genNum3;
    int genNum4;
    int genNum5;
    //bekért számok (textfield)
    int setNum1;
    int setNum2;
    int setNum3;
    int setNum4;
    int setNum5;
    
   
    @FXML
    private Pane basePane;
    @FXML
    private Pane alertpane;
    @FXML
    private Label alerttext;
    @FXML
    private Button alertBtn;
    @FXML
    private Button otosBtn;
    @FXML
    private Label label1;
    @FXML
    private Label label2;
    @FXML
    private Label label3;
    @FXML
    private Label label4;
    @FXML
    private Label label5;
    @FXML
    private Label resulttextID;
    
    @FXML
    private TextField input1;
    @FXML
    private TextField input2;
    @FXML
    private TextField input3;
    @FXML
    private TextField input4;
    @FXML
    private TextField input5;
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
                 
    genNum1 = 0;
    genNum2 = 0;
    genNum3 = 0;
    genNum4 = 0;
    genNum5 = 0;
        
    genNum1 = getRandomNumber();
    genNum2 = getRandomNumber();
    genNum3 = getRandomNumber();
    genNum4 = getRandomNumber();
    genNum5 = getRandomNumber();
    
    label1.setText(""+genNum1);
    label2.setText(""+genNum2);
    label3.setText(""+genNum3);
    label4.setText(""+genNum4);
    label5.setText(""+genNum5);
    
    calculate(); 
     
    }
    //Random szám generálás
    private int getRandomNumber(){
        int random = (int) (Math.random()*MAX+MIN);
        //Ha már kisorsolta a számot, generáljon újat
        if (random == genNum1 || random == genNum2 || random == genNum3 || random == genNum4 || random == genNum5 )
           return getRandomNumber();
            
            return random;
    
    }
    
    //Egyezések keresése
    private String calculate(){
     
   try{   
    setNum1 = Integer.parseInt(input1.getText());
    setNum2 = Integer.parseInt(input2.getText());
    setNum3 = Integer.parseInt(input3.getText());
    setNum4 = Integer.parseInt(input4.getText());
    setNum5 = Integer.parseInt(input5.getText());
    
   }catch(Exception e){ 
    //hibakezelés, ha üresen maradt valamelyik mező
    alert("Nem adtál meg minden számot!");
    return "";
    }
    //hibakezelés, ha nem 1-90 között adtál meg számokat
   if (setNum1<1 || setNum1>90 ||setNum2<1 || setNum2>90 ||setNum3<1 || setNum3>90 ||setNum4<1 || setNum4>90 ||setNum5<1 || setNum5>90) {
    alert("A számoknak 1 és 90 között kell lenniük!");
    return "";   
  
   
   }
   
   // egyező számok kizárása
   Set<Integer> selectedNumbers = new HashSet<>();
   selectedNumbers.add(setNum1);
   selectedNumbers.add(setNum2);
   selectedNumbers.add(setNum3);
   selectedNumbers.add(setNum4);
   selectedNumbers.add(setNum5);
   
   if (selectedNumbers.size() < 5) {
    alert("A számoknak különbözőeknek kell lenniük!");
    return "";   
   
   }
   
   
    ArrayList<Integer> selNumbers = new ArrayList<>(selectedNumbers);
    int result = 0;
    //Megvizsgáljuk, hogy hány találatunk van
    for(int i=0 ; i<selNumbers.size() ; i++)
        if(selNumbers.get(i)==genNum1 || selNumbers.get(i)==genNum2 || selNumbers.get(i)==genNum3 || selNumbers.get(i)==genNum4 || selNumbers.get(i)==genNum5)
            result++;
    
    //Az eredményt kiírjuk
    switch(result){
        case 0: resulttextID.setText("Ez egy semmi");
                break;
        case 1: resulttextID.setText("Egyesed van. Leülhetsz.");
                break;
        case 2: resulttextID.setText("Kettesed van. A semmire pont elég.");
                break;
        case 3: resulttextID.setText("Hármasod van. Nekem még sose volt");
                break;
        case 4: resulttextID.setText("Négyesed van. Adj fel egy lottót!");
                break;
        case 5: resulttextID.setText("Ötösöd van. Csak programhiba lehet :D");
                break;
        }
    
   return "";
   
   } 
    
    //Popup ablak, ha valami rosszul sül el
    private void alert(String alertMsg) {
    alertpane.setVisible(true);
    basePane.setOpacity(0.3);
    basePane.setDisable(true);
    alerttext.setText(alertMsg);
    
}
    //Addig sorsol a program, ameddig telitalálatunk nem lesz
    @FXML
    private void sorsoljOtosig(ActionEvent event) {
    setNum1 = Integer.parseInt(input1.getText());
    setNum2 = Integer.parseInt(input2.getText());
    setNum3 = Integer.parseInt(input3.getText());
    setNum4 = Integer.parseInt(input4.getText());
    setNum5 = Integer.parseInt(input5.getText());
    
    ArrayList<Integer> sel5Numbers = new ArrayList<>(); 
    sel5Numbers.add(setNum1);
    sel5Numbers.add(setNum2);
    sel5Numbers.add(setNum3);
    sel5Numbers.add(setNum4);
    sel5Numbers.add(setNum5);
    //változóban tároljuk, hogy hányadik húzás eredményezett telitalálatot
    long sorsolasSzam=0;
    genNum1 = 0;
    genNum2 = 0;
    genNum3 = 0;
    genNum4 = 0;
    genNum5 = 0;
        
    genNum1 = getRandomNumber();
    genNum2 = getRandomNumber();
    genNum3 = getRandomNumber();
    genNum4 = getRandomNumber();
    genNum5 = getRandomNumber();
    
   
    int result=0;
    while (result != 5) {
    genNum1 = 0;
    genNum2 = 0;
    genNum3 = 0;
    genNum4 = 0;
    genNum5 = 0;
    genNum1 = getRandomNumber();
    genNum2 = getRandomNumber();
    genNum3 = getRandomNumber();
    genNum4 = getRandomNumber();
    genNum5 = getRandomNumber(); 
        
    result = 0;
    for(int i=0 ; i<sel5Numbers.size() ; i++)
        if(sel5Numbers.get(i)==genNum1 || sel5Numbers.get(i)==genNum2 || sel5Numbers.get(i)==genNum3 || sel5Numbers.get(i)==genNum4 || sel5Numbers.get(i)==genNum5)
            result++;
    sorsolasSzam++;
    
    }
    System.out.println(sorsolasSzam);
    }

    //Popup ablak bezárása
    @FXML
    private void handleAlertButton(ActionEvent event) {
    
    alertpane.setVisible(false);
    basePane.setOpacity(1);
    basePane.setDisable(false);
    alerttext.setText("");
    
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
