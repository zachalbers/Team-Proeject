package week2;
import java.util.Random;
import java.util.Scanner;
import javax.swing.ImageIcon;
import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextField;


public class GuessingGame extends JApplet implements ActionListener {
	// generates random number and sets to variable randomNumber
    int randomNumber = new Random().nextInt(10);
    // creates place for the user to input in 
    JTextField text= new JTextField(20);
    // adds new label on gui that shows output if the user is right with his guess or wrong
    JLabel result =new JLabel("Result here");
    
    

    
    private Container contentPane;
    public void init()
      {
    	// initializes the pane over window
      contentPane = getContentPane();
      contentPane.setBackground(Color.WHITE);
      
      // adds the field where the user inputs into the pane
      contentPane.add(text);
      // adds the label Result here to the pane
      contentPane.add(result);
      
      // Creates a button naming it bButton
      JButton bButton = new JButton("Submit Result");
      bButton.addActionListener(this);
      
      // adds submit result button to the pane
      contentPane.add(bButton);
      // sets the layout of the pane of the window
      contentPane.setLayout(new FlowLayout());

    }

    public void actionPerformed(ActionEvent e)
      {
      contentPane.setBackground(Color.PINK);
      text.getText();
      int text2 = Integer.parseInt(text.getText());
      if (text2 < randomNumber){
    	  result.setText("Too Low");
    	
    	  
      }else if(text2 > randomNumber) {
    	  result.setText("Too High");
      }else{
    	  result.setText("You won!");
      }
    }



    // Method returns user's guess
    public int getGuess() {
        System.out.print("What is your guess? ");
        Scanner keyboard = new Scanner(System.in);
        return keyboard.nextInt();
    }

    // Method checks the users guess against the random number
    public boolean checkGuess() {
        int guess = this.getGuess();

        if (guess == randomNumber) {
            System.out.println("Well done!");
            return true;
        } else if (guess < randomNumber) {
            System.out.println("Too low");
        } else if (guess > randomNumber) {
            System.out.println("Too high");
        }

        return false;
    }

    // Will check
    public void play() {
        System.out.println("I'm thinking of a number between 0 and 9");
        boolean check = this.checkGuess();

        while (!check) {
            check = this.checkGuess();
        }
    }


    public static void main(String[] args) {
        GuessingGame game = new GuessingGame();
        game.play();

    }
}
