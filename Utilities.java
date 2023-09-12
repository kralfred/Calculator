import javax.swing.*;
import java.util.ArrayList;

public class Utilities {
    JButton button;
    public void actionListener(){

    }


    public String calculate(String input){

        String result = new String();
        String[] secondaryNum = input.split("[+-]");
        StringBuilder primaryNumBuilder = new StringBuilder();
        String[] primaryNum;
        String[] multiplyNumbers;
        Float devideResult;
        Float multiplyResult = 0.0f;
        float finalNumberResult = 0.0f;
        float negativeNumbers = 0.0f;





        for (int i = 0; i < secondaryNum.length; i++){
            if(secondaryNum[i].contains("/") || secondaryNum[i].contains("*")){
                      multiplyNumbers = secondaryNum[i].split("\\Q*\\E");



                      for(int b = 0; b < multiplyNumbers.length; b++){
                          if(multiplyNumbers[b].contains("/")){
                             String[] individualDevideNum = multiplyNumbers[b].split("/");
                             devideResult = Float.parseFloat(individualDevideNum[0]);
                             for(int c = 1; c < individualDevideNum.length; c++){
                                 devideResult = devideResult / Float.parseFloat(individualDevideNum[c]);
                                 System.out.println("devide result: " + devideResult);
                             }
                             multiplyNumbers[b] = devideResult.toString();
                              System.out.println("devide numbers:" + multiplyNumbers[b]);
                          }

                          Float fistNumber = Float.parseFloat(multiplyNumbers[0]);

                          if(b != 0){
                              multiplyResult = fistNumber * Float.parseFloat(multiplyNumbers[b]);
                              System.out.println("multiply result: " + multiplyResult);

                          }


                      }


            }



            secondaryNum[i] = multiplyResult.toString();
            primaryNumBuilder.append(secondaryNum[i]);
            System.out.println("this is secondary Num:" + primaryNumBuilder);

        }
        String[] subtract = primaryNumBuilder.toString().split("-");

        for(int i = 0; i < subtract.length; i++){
            String[] allNumbers = subtract[i].split("\\Q+\\E");
            negativeNumbers += Float.parseFloat(allNumbers[0]);

        }
        for(int i = 0; i< secondaryNum.length; i++){
            finalNumberResult += Float.parseFloat(secondaryNum[i]) - 2 * negativeNumbers;
        }
        System.out.println("this is the final result: " + finalNumberResult);


        return result;

    }


}
