package it.polito.tdp.alien;

import java.util.*;
import java.util.TreeMap;

public class ParolaTraduzione {
		
	private TreeMap<String, String> dizionario = new TreeMap<String, String>();
	
	public void putParola(String parolaAliena, String traduzione) {
			
		if(dizionario.containsKey(parolaAliena) && !dizionario.values().contains(traduzione)){
			String t =  dizionario.get(parolaAliena) + ", " + traduzione;
			dizionario.put(parolaAliena, t);
		}
		else
			dizionario.put(parolaAliena, traduzione);
	}
	
	public String translate(String parolaAliena) {
		
		List<String> risultato = new LinkedList<String>();
		
		boolean trovato = true;
		
		int count = 0;
		
		for(int i=0; i<parolaAliena.length(); i++)
			if(parolaAliena.charAt(i) == '?')
				count++;
			
		if(count==1){
			List<String> temp = new LinkedList<String>(dizionario.keySet());
			for(int i=0; i<temp.size(); i++){
				if(temp.get(i).length()==parolaAliena.length()){
					for(int j=0; j<parolaAliena.length(); j++){
						trovato = true;
						if(temp.get(i).charAt(j)!=parolaAliena.charAt(j) && parolaAliena.charAt(j)!='?'){
							trovato = false;
							break;	
						}	
					}
					if(trovato==true)
						risultato.add(temp.get(i));
				}
			}
			
			String stampa = "";
			for(String s : risultato)
				for(String m : dizionario.keySet())
					if(s.compareTo(m)==0)
						stampa += m + " " + dizionario.get(m) + "\n";
			return stampa;
		}
		
		else if(count>1)
			return "Inserire un solo punto interrogativo";
		
		if(dizionario.containsKey(parolaAliena))
			return dizionario.get(parolaAliena);
		else 
			return "Parola non presente!";
	}
}
