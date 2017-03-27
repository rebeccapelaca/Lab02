package it.polito.tdp.alien;

/**
 * Sample Skeleton for 'Alien.fxml' Controller Class
 */



import java.net.URL;
import java.util.*;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class AlienController {
	
	private ParolaTraduzione dizionario = new ParolaTraduzione();
	private boolean parolaValida = false;
	
    @FXML
    private ResourceBundle resources;
    @FXML
    private URL location;
    @FXML
    private TextField txtWord;
    @FXML
    private TextArea txtResult;
    @FXML
    private Button btnTranslate;
    @FXML
    private Button btnReset;
        
    
    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
    	assert txtWord != null : "fx:id=\"txtWord\" was not injected: check your FXML file 'Alien.fxml'.";
    	assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Alien.fxml'.";
    	assert btnTranslate != null : "fx:id=\"bntTranslate\" was not injected: check your FXML file 'Alien.fxml'.";
    	assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Alien.fxml'.";
    	
    }
  
    
    @FXML
    void doTranslate(ActionEvent event) {
    	
    	for(int i=0; i<txtWord.getText().length(); i++)
    		if((txtWord.getText().toLowerCase().charAt(i) >= 'a' && txtWord.getText().toLowerCase().charAt(i) <= 'z')
    			|| txtWord.getText().toLowerCase().charAt(i) == ' ' || txtWord.getText().toLowerCase().charAt(i) == '?')
    			
    			parolaValida = true;
    			
    		else {
    			txtResult.setText("Carattere non valido! Inserire una parola");
    			return;
    		}
    	
    	if(parolaValida==true){
    	
	    	if(txtWord.getText().contains(" ")) {
	    		
	    		String array[] = txtWord.getText().split(" ");
	    		
	    		if(array.length > 2) {
	    			txtResult.setText("Inserire al massimo due parole!");
	    			return;
	    		}
	    			
	    		String parolaAliena = array[0].toLowerCase();
	    		String traduzione = array[1].toLowerCase();
	    		
	    		dizionario.putParola(parolaAliena, traduzione);
	    		txtResult.setText(traduzione);
	    		txtWord.clear();	
	    	}
	    	else {
	    		
	    		txtResult.setText(dizionario.translate(txtWord.getText().toLowerCase())); 
	    		txtWord.clear();
	    	}
    	}
    }
    
    
    @FXML
    void doReset(ActionEvent event) {
    	
    	txtResult.clear();

    }
    
}
