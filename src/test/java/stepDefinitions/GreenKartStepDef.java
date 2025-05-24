package stepDefinitions;

import java.util.*;

public class GreenKartStepDef {
	public static void main(String[] args) {
		
		String str = "Sheik Musthaq Ahamed";
		char [] ch = str.toLowerCase().toCharArray(); 
		Map<Character, Integer> charCountMap = new HashMap<>();

		for (char c : str.toLowerCase().toCharArray()) {
		    charCountMap.merge(c, 1, Integer::sum);
		}

		for (int i = 0; i < ch.length; i++) {
		    int count = 0;
		    for (int j = 0; j < ch.length; j++) {
		        if (ch[i] == ch[j]) {
		            count++;
		        }
		    }
		    if (count == 1) {
		        System.out.println(ch[i] + " is first non-repeating character");
		        break;
		    }
		}

	}

}
