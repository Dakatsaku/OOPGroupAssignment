/**
 * QUESTION 2: Name Analyzer
 * This program is used to calculate certain attributes of the user's name. Users will input their name and the 
 * program will analyze the total characters in the name, the vowels and the consonants. 
 * @author (Caitlin Lee Shiao Juen - B04180020) and (Auni Qistina Mohd. Shukran - B01180001)
 * @version 1.0
 */
package GroupProject; 

import javax.swing.JOptionPane;	

class countName{
    int countTotalCharacters = 0;
    int vowel = 0;
    int cons = 0;
    
    public void countName(){
    }//end default constructor
    
    public void countName(String a){

        for(int i =0; i<a.length();i++){   //to go through every character in the input string
           if(a.matches(".*\\d+.*")) {
               JOptionPane.showMessageDialog(null,"The input must be a string, no numeric values. Please try again.","Name Analysers", JOptionPane.ERROR_MESSAGE);
               System.exit(0);
           }else{
            if (a.length() < 3){ //ensures that the number of characters is less than 3
                JOptionPane.showMessageDialog(null, "The input is invalid, please enter a name with more than 3 characters", "Name Analyzer", JOptionPane.ERROR_MESSAGE);
                System.exit(0); //to exit JOptionPane
                }//end if for character check
            else if (a.charAt(i) != ' '){ //to exclude the whitespaces when counting characters
                countTotalCharacters++; //add to the total characters counter
         
                switch (a.charAt(i)){
                    case 'A' : case 'a':
                    case 'E' : case 'e':
                    case 'I' : case 'i':
                    case 'O' : case 'o':
                    case 'U' : case 'u':
                        vowel++; //to count the vowels in the input
                        break;
                    default :
                        cons++; //to count the consonants in the input
                }//end switch case
            }// end else if
        }//end for loop
        }
        JOptionPane.showMessageDialog(null,"Your name = " + a + "\nTotal characters = " + countTotalCharacters + "\nVowels = " + vowel + "\nConsonants = " + cons, "Name Analyser", JOptionPane.INFORMATION_MESSAGE);   
    }//end counstructor countName
}//end class countName

public class SectionA_Q2{					 
  public static void main(String[] args){
    countName count = new countName();
    
    String a = JOptionPane.showInputDialog(null, "Please enter a name: ", "Name Analyzer", JOptionPane.INFORMATION_MESSAGE); //asks the user to input name
    count.countName(a);
  }//end main
}//end OOPGroupAssignment_1 class