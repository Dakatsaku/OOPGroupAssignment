/**
 * Part B - QUESTION 2: Exam Result System
 * This program is used to calculate student exam results. Users will input the name, ID and marks for each individual
 * subject and the program will determine the GPA, the status and the best and worst subjects.
 * @author (Caitlin Lee Shiao Juen - B04180020) and (Auni Qistina Mohd. Shukran - B01180001) and (Muhammad Amien Abu Hassan Sha'ari - B01180003)
 * @version 1.0
 */
package GroupProject;

import javax.swing.JOptionPane;
import java.text.DecimalFormat;

public class SectionB_Q2 {
    public static final int LENGTH = 121;
    private static final DecimalFormat DF2 = new DecimalFormat("0.00");
    static String grade, status, bestSubject, worstSubject;
    double points, total_points, GPA, marks;
    static int inform_sys = 0, c_program = 0, interact_mm =0, mm_tech=0, interact_design=0;
    
    public static void DrawLine(int length){
        for(int idx = 0; idx < length; idx++){
            System.out.print("-");   //prints out horzontal line for table
        }//end for loop to print line
        System.out.print("\n");     //Goes to new line to print 
    }//end of method line to draw the table

    public double calcGPA(double input){
        GPA = (CalcIS(total_points)+(CalcCP(total_points))+(CalcIM(total_points))+(CalcMT(total_points))+(CalcIDesign(total_points)))/15;
        return GPA;
    }//end of method calcGPA
    
    public String PassFail(double GPA){
        if(GPA>2.00){
            status = "Pass";
        }else{
            status = "Fail";
        }
        return status;
    }//end of method PassFail
    
    public String AssignGrade(int mark){
        if((mark < 0 || mark > 100)){
            JOptionPane.showMessageDialog(null,"Mark input is invalid. Please try again.", "Exam Result System", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }else if ((mark >=80 && mark <=100)){
            grade = "A";
        }else if ((mark >=75 && mark <=79)){
            grade = "A-";
        }else if ((mark >=70 && mark <=74)){
            grade = "B+";
        }else if ((mark >=65 && mark <=69)){
            grade = "B";
        }else if ((mark >=60 && mark <=64)){
            grade = "B-";
        }else if ((mark >=55 && mark <=59)){
            grade = "C+";
        }else if ((mark >=50 && mark <=54)){
            grade = "C";
        }else if ((mark >=45 && mark <=49)){
            grade = "C-";
        }else if ((mark >=40 && mark <=44)){
            grade = "D";
        }else{
            grade = "F";
        }
        return grade; 
    }//end method AssignGrade
    
    public double AssignPoint(double point){
        if((point < 0 || point > 100)){
            JOptionPane.showMessageDialog(null,"Mark input is invalid. Please try again.", "Exam Result System", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }else if ((point >=80 && point <=100)){
            points = 4.00;
        }else if ((point >=75 && point <=79)){
            points = 3.67;
        }else if ((point >=70 && point <=74)){
            points = 3.33;
        }else if ((point >=65 && point <=69)){
            points = 3.00;
        }else if ((point >=60 && point <=64)){
            points = 2.67;
        }else if ((point >=55 && point <=59)){
            points = 2.33;
        }else if ((point >=50 && point <=54)){
            points = 2.00;
        }else if ((point >=45 && point <=49)){
            points = 1.67;
        }else if ((point >=40 && point <=44)){
            points = 1.33;
        }else{
            points = 0.00;
        }      
        return points;
    }//end method AssignPoint
    
    public double CalcIS(double total){
        total_points = 3 * AssignPoint(inform_sys);
        return total_points;
    }//end method CalcIS
    
    public double CalcCP(double total){
        total_points = 4 * AssignPoint(c_program);
        return total_points;
    }//end method CalcCP
    
    public double CalcIM(double total){
        total_points = 3 * AssignPoint(interact_mm);
        return total_points;
    }//end method CalcIM
    
    public double CalcMT(double total){
        total_points = 2 * AssignPoint(mm_tech);
        return total_points;
    }//end method CalcMT
    
    public double CalcIDesign(double total){
        total_points = 3 * AssignPoint(interact_design);
        return total_points;
    }//end method CalcIDesign
    
     public String bestSubject(){

        if((c_program > inform_sys) && (c_program > interact_mm) && (c_program > mm_tech) && (c_program > interact_design)){
            bestSubject = "C++ Programming I";
        }else if((interact_mm > inform_sys) && (interact_mm > c_program) && (interact_mm > mm_tech) && (interact_mm > interact_design)){
            bestSubject = "Interactive Multimedia";
        }else if((mm_tech > inform_sys) && (mm_tech > interact_mm) && (mm_tech > c_program) && (mm_tech > interact_design)){
            bestSubject = "Multimedia Technology";
        }else if((interact_design > inform_sys) && (interact_design > interact_mm) && (interact_design > mm_tech) && (interact_design > c_program)){
            bestSubject = "Interaction Design";
        }else if((inform_sys > interact_design) && (inform_sys > interact_mm) && (inform_sys > mm_tech) && (inform_sys > c_program)){
            bestSubject = "Intro to Information Systems";
        }//end if else
        
        return bestSubject;
    }//end of method bestWorstSubject
    
    public String worstSubject(){
        
        if((c_program < inform_sys) && (c_program < interact_mm) && (c_program < mm_tech) && (c_program < interact_design)){
            worstSubject = "C++ Programming I";
        }else if((interact_mm < inform_sys) && (interact_mm < c_program) && (interact_mm < mm_tech) && (interact_mm < interact_design)){
            worstSubject = "Interactive Multimedia";
        }else if((mm_tech < inform_sys) && (mm_tech < interact_mm) && (mm_tech < c_program) && (mm_tech < interact_design)){
            worstSubject = "Multimedia Technology";
        }else if((interact_design < inform_sys) && (interact_design < interact_mm) && (interact_design < mm_tech) && (interact_design < c_program)){
            worstSubject = "Interaction Design";
        }else if((inform_sys < c_program) && (inform_sys < interact_mm) && (inform_sys < mm_tech) && (inform_sys < interact_design)){
            worstSubject = "Intro to Information Systems";
        }//end if else
        
        return worstSubject;
    }//end of method worstSubject
    
    public void InputMarks(){
        String bis1513 = JOptionPane.showInputDialog(null,"Please enter your marks for BIS1513: ", "Exam Result System", JOptionPane.QUESTION_MESSAGE);
        inform_sys = Integer.parseInt(bis1513);
        String bit1214 = JOptionPane.showInputDialog(null,"Please enter your marks for BIT1214: ", "Exam Result System", JOptionPane.QUESTION_MESSAGE);
        c_program = Integer.parseInt(bit1214);
        String bit2333 = JOptionPane.showInputDialog(null,"Please enter your marks for BIT2333: ", "Exam Result System", JOptionPane.QUESTION_MESSAGE);
        interact_mm = Integer.parseInt(bit2333);
        String bit1312 = JOptionPane.showInputDialog(null,"Please enter your marks for BIT1312: ", "Exam Result System", JOptionPane.QUESTION_MESSAGE);
        mm_tech = Integer.parseInt(bit1312);
        String bie2243 = JOptionPane.showInputDialog(null,"Please enter your marks for BIE2243: ", "Exam Result System", JOptionPane.QUESTION_MESSAGE);
        interact_design = Integer.parseInt(bie2243);
    }
    
    public void dispOutput(){
       
        System.out.println("Code            Course                              Credit       Marks\t\tGrade\t\tPoints       Total Points");
        System.out.println("BIS1513         Intro to Information Systems         3            "+inform_sys+"\t\t "+AssignGrade(inform_sys)+"\t\t "+DF2.format(AssignPoint(inform_sys))+"\t\t "+DF2.format(CalcIS(total_points)));
        System.out.println("BIT1214         C++ Programming                      4            "+c_program+"\t\t " +AssignGrade(c_program)+"\t\t "+DF2.format(AssignPoint(c_program))+"\t\t "+DF2.format(CalcCP(total_points)));
        System.out.println("BIT2333         Interactive Multimedia               3            "+interact_mm+"\t\t "+AssignGrade(interact_mm)+"\t\t "+DF2.format(AssignPoint(interact_mm))+"\t\t "+DF2.format(CalcIM(total_points)));
        System.out.println("BIT1312         Multimedia Technology                2            "+mm_tech+"\t\t "+AssignGrade(mm_tech)+"\t\t "+DF2.format(AssignPoint(mm_tech))+"\t\t "+DF2.format(CalcMT(total_points)));
        System.out.println("BIE2243         Interaction Design                   3            "+interact_design+"\t\t "+AssignGrade(interact_design)+"\t\t "+DF2.format(AssignPoint(interact_design))+"\t\t "+DF2.format(CalcIDesign(total_points)));
        DrawLine(LENGTH);
        System.out.println("Your GPA: "+DF2.format(calcGPA(GPA)));//TBC
        System.out.println("Status: "+PassFail(GPA));//TBC
        DrawLine(LENGTH);
        System.out.println("Summary:");
        System.out.println("Intro to Information Systems : " + DF2.format(inform_sys));
        System.out.println("C++ Programming I            : " + DF2.format(c_program));
        System.out.println("Interactive Multimedia       : " + DF2.format(interact_mm));
        System.out.println("Multimedia Technology        : " + DF2.format(mm_tech));
        System.out.println("Interation Design            : " + DF2.format(interact_design) + "\n");
        System.out.println("Best Subject: " + bestSubject());
        System.out.println("Worst Subject: " + worstSubject());
    }//end method dispOutput
    
    
    public static void main(String[] args) throws InterruptedException {
        int again = 0;
         SectionB_Q2 output = new SectionB_Q2();   
         SectionB_Q2 user = new SectionB_Q2();
         
        while(again==JOptionPane.YES_OPTION){
            String input = JOptionPane.showInputDialog(null, "Please enter the number of students in the class: ", "Exam Result System", JOptionPane.QUESTION_MESSAGE); //ask user to enter number of students
            int no_Student = Integer.parseInt(input);
        
            for(int i =0; i< no_Student; i++){
                String name = JOptionPane.showInputDialog(null,"Please enter student name: ", "Exam Result System", JOptionPane.QUESTION_MESSAGE);
                String Id = JOptionPane.showInputDialog(null,"Please enter student ID: ", "Exam Result System", JOptionPane.QUESTION_MESSAGE);
            
                //first check, Student ID, more/less 4 digits
                if((Id.length()>4) || (Id.length()<4)){
                    JOptionPane.showMessageDialog(null, "ERROR. ID input is invalid. Please try again.", "Exam Result System", JOptionPane.ERROR_MESSAGE);
                }else{
                    System.out.println("NAME: " + name + "\t\tID NO: "+Id);
                    user.InputMarks();
                    
                }
                DrawLine(LENGTH);
   
                output.dispOutput();
            }//end for loop
            //Thread.sleep(2500);
        again = JOptionPane.showConfirmDialog(null, "Do you want to use the Exam Result System again?", "Exam Result System", JOptionPane.YES_NO_OPTION);
        }//end while loop
    
        System.out.println("Thank you for using the Exam Result System!");
        System.exit(0);
    }//end main  
}//end class 