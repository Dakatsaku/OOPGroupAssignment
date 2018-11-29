
package GroupProject;

import javax.swing.JOptionPane;


/** Guess Lottery Number 
 *  This java program is a guess lottery number. It require an input from user which is  the user should entered the 3-digit input. The lottery number will generate by the formula given.
 *  Then,it will showed the result that the user entered if the user win one of the prizes given or not. If the user win,there is a message will showed to tell the user win in which prize.
 *  @author (Nur Ashikin binti Zahri - B04180014) & (Caitlin Lee Shiao Juen - B04180020) 
 *  @version 
 */

public class GuessLotteryNumber {
    int guessDigit1; //declare guess first digit 
    int guessDigit2; //declare guess second digit 
    int guessDigit3; //declare guess third digit 
    int lotteryDigit1; //declare lottery first digit 
    int lotteryDigit2; //declare lottery second digit 
    int lotteryDigit3; //declare lottery third digit 
    
    public void aquireGuess()
    {
        String a1= JOptionPane.showInputDialog(null,"Enter your 3-digit lottery number :  ", "LOTTERY NUMBER",JOptionPane.QUESTION_MESSAGE);  // require input form user
        int a = Integer.parseInt(a1);
        
        //to get each of the digits from user
        guessDigit1 = a % 10;           
        guessDigit2 = (a / 10) % 10;    
        guessDigit3 = (a / 100) % 10;   
        
        if ((a >= 100)&&(a < 1000)) {  // to perform the generateLottery if the input meet the condition
            generateLottery();
        }else{                         //to recall generateLottery method if input not meet the condition
            JOptionPane.showInputDialog(null,"Sorry entry only accepts 3 digits. Please try again. \nThank you", "LOTTERY NUMBER",JOptionPane.QUESTION_MESSAGE);//an output if the input not meet the condotion
            System.exit(0); //end of method
        } // end of condition 
    }//end of class

    public void generateLottery()
    {
        int lottery = (int)(Math.random()*1000);  // to generate the random lottery number
        String lotteryString = "" +lottery;
        JOptionPane.showMessageDialog(null,"The Lottery Number for today is : " +lottery,"LOTTERY NUMBER",JOptionPane.INFORMATION_MESSAGE); // to show the random lottery number

        //to get each of the digits from the lottery number
        lotteryDigit1 = lottery % 10;           
        lotteryDigit2 = (lottery / 10) % 10;   
        lotteryDigit3 = (lottery/ 100) % 10;   
    }//end of class

    public void compare()
    {  
        if((guessDigit1==lotteryDigit1)&&(guessDigit2==lotteryDigit2)&&(guessDigit3==lotteryDigit3)){ 
            JOptionPane.showMessageDialog(null,"Jackpot! Congratulations! \nYou matched all 3 digits with the exact order! You win RM5000!",
                    "LOTTERY NUMBER",JOptionPane.INFORMATION_MESSAGE);
        }else if(((guessDigit1==lotteryDigit1)||(guessDigit1==lotteryDigit2)||(guessDigit1==lotteryDigit3))&&
                ((guessDigit2==lotteryDigit1)||(guessDigit2==lotteryDigit2)||(guessDigit2==lotteryDigit3))&&
                ((guessDigit3==lotteryDigit1)||(guessDigit3==lotteryDigit2)||(guessDigit3==lotteryDigit3))){
            JOptionPane.showMessageDialog(null,"Congrats! You matched all 3 digits, but not in exact order. \nYou win RM2000!", "LOTTERY NUMBER",
                    JOptionPane.INFORMATION_MESSAGE);   
        }else if(((guessDigit1==lotteryDigit1)||(guessDigit2==lotteryDigit2)||(guessDigit3==lotteryDigit3))||
                ((guessDigit1==lotteryDigit1)&&(guessDigit2==lotteryDigit2))||(guessDigit1==lotteryDigit1)&&(guessDigit3==lotteryDigit3)||
                ((guessDigit2==lotteryDigit2)&&(guessDigit3==lotteryDigit3))){
            JOptionPane.showMessageDialog(null,"Congrats! You matched 1 or 2 digits in the exact order. \nYou win RM500!", "LOTTERY NUMBER",
                    JOptionPane.INFORMATION_MESSAGE);
        }else{
            JOptionPane.showMessageDialog(null,"Sorry! You did not match the lottery for today. \nBetter luck next time!", "LOTTERY NUMBER",
                    JOptionPane.INFORMATION_MESSAGE);
        }//end of condition 
    }//end of class

    public static void main(String args[]){
       GuessLotteryNumber answer = new GuessLotteryNumber(); // create new object and allocate the memory in it
       answer.aquireGuess(); // call the aquireGuess method
       answer.compare();    // call the compare method as well as print the output that include in the method
    } //end of main
}// end of code