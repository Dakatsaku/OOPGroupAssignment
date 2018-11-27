
package GroupProject;

import javax.swing.JOptionPane;

public class GuessLotteryNumber {
    
    int guessDigit1;
    int guessDigit2;
    int guessDigit3;
    int lotteryDigit1;
    int lotteryDigit2;
    int lotteryDigit3;
    
    private void aquireGuess()
    {
        String a1= JOptionPane.showInputDialog(null,"Enter your 3-digit lottery number :  ", "LOTTERY",JOptionPane.QUESTION_MESSAGE);
        int a = Integer.parseInt(a1);
        
        guessDigit1 = a % 10;
        guessDigit2 = (a / 10) % 10;
        guessDigit3 = (a / 100) % 10;
        
        if ((a >= 100)&&(a < 1000)) {
            generateLottery();
        } else {
            JOptionPane.showMessageDialog(null,"Sorry, entry only accepts 3 digits. Please try again. \nThank you.", "LOTTERY",JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
    }

    private void generateLottery()
    {
        int lottery = (int)(Math.random()*1000);
        JOptionPane.showMessageDialog(null,"The Lottery Number for today is : " +lottery,"LOTTERY NUMBER",JOptionPane.INFORMATION_MESSAGE);

        lotteryDigit1 = lottery % 10;
        lotteryDigit2 = (lottery / 10) % 10;
        lotteryDigit3 = (lottery/ 100) % 10;
    }

    private void compare()
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
        }
    }

    public static void main(String args[]){
        GuessLotteryNumber answer = new GuessLotteryNumber();
        answer.aquireGuess();
        answer.compare();
    }//end main
}//end class