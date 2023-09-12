import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Objects;

public class Gui implements ActionListener {

    JFrame mainFrame;
    JTextField mainInput;
    ArrayList<JButton> buttons = new ArrayList<>();


    ArrayList<Character> operatorArray = new ArrayList<>();
    StringBuilder wholeInputText = new StringBuilder();
    Utilities function = new Utilities();
    char[] operators = {'=','/', '+', '-', '*'};

    public Gui(){
        mainFrame = new JFrame("main");


        for (int i = 0; i < operators.length; i++){
            String operatorName = Character.toString(operators[i]);
            JButton operatorButton = new JButton(operatorName);
            operatorButton.addActionListener(this);
            operatorButton.setName(operatorName);
            buttons.add(operatorButton);
            mainFrame.add(operatorButton);
        }

        JPanel numberPanel = new JPanel();
        numberPanel.setLayout(new GridLayout(3,3));
        for (int i = 1; i <= 9; i++){
            String indexString = Integer.toString(i);
            JButton buttonInstance = new JButton(indexString);
            buttonInstance.addActionListener(this);
            buttonInstance.setName(Integer.toString(i));

            numberPanel.add(buttonInstance);
            buttons.add(buttonInstance);

        }

        mainFrame.add(numberPanel);
        mainInput = new JTextField( 5);


        mainFrame.setVisible(true);
        mainFrame.setSize(300,200);
        mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        mainFrame.setLayout(new FlowLayout());
        mainFrame.add(mainInput);



    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for(int i = 0; i < buttons.size(); i++){
            if(e.getSource() == buttons.get(i)){

              if(i != 0){
                  wholeInputText.append(buttons.get(i).getName());
              }


                if(i < operators.length && i != 0){

                    operatorArray.add(operators[i]);

                }



                if(Objects.equals(buttons.get(i).getName(), "=")){

                    function.calculate(wholeInputText.toString());


                    System.out.println(wholeInputText);
                    wholeInputText.setLength(0);


                }
                mainInput.setText(wholeInputText.toString());

            }
        }
    }
}
