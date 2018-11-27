/**
 * Part A - QUESTION 2: Name Analyzer
 * This program is used to calculate certain attributes of the user's name. Users will input their name and the 
 * program will analyze the total characters in the name, the vowels and the consonants. 
 * @author (Caitlin Lee Shiao Juen - B04180020) and (Auni Qistina Mohd. Shukran - B01180001)
 * @version 1.0
 */
package GroupProject; 

//javax.swing.JOptionPane library imported to be able to use JOptionPane
import javax.swing.JOptionPane;	

class countName{
    int countTotalCharacters = 0; //initialize the counter used to count total characters in name
    int vowel = 0; //initialize the counter used to count total vowel characters in name
    int cons = 0; //initialize the counter used to count total consonant characters in name
    
    //default constructor countName 
    public countName(){
    }//end default constructor
    
    //Method countName used to count total characters, vowel(s) and consonant(s) in user name
    public void countName(String a){
        for(int i = 0; i < a.length(); i++){ //to go through every character in the input string
            if (a.length() < 3){ //ensures that the number of characters is less than 3
                JOptionPane.showMessageDialog(null, "The input is invalid, please enter a name with more than 3 characters", "Name Analyzer", JOptionPane.ERROR_MESSAGE);
                System.exit(0); //to exit JOptionPane
                }//end if for character check
            else if (a.charAt(i) != ' '){ //to exclude the whitespaces when counting characters
                countTotalCharacters++; //add to the total characters counter
         
                //switch case used to check for total vowels and consonants
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
        JOptionPane.showMessageDialog(null,"Your name = " + a + "\nTotal characters = " + countTotalCharacters + "\nVowels = " + vowel + "\nConsonants = " + cons, "Name Analyzer", JOptionPane.INFORMATION_MESSAGE); //displays the total characters, vowels and consonant in user name   
    }//end counstructor countName
}//end class countName

public class SectionA_Q2{					 
  public static void main(String[] args){
    //declares object count
    countName count = new countName();
    
    String a = JOptionPane.showInputDialog(null, "Please enter a name: ", "Name Analyzer", JOptionPane.INFORMATION_MESSAGE); //asks the user to input name
    count.countName(a); //calls method countName and sends user's name 
  }//end main
}//end OOPGroupAssignment_1 class