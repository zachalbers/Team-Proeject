
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
import javax.swing.JOptionPane;


public class GuessingGame extends JApplet implements ActionListener {
	  // generates random number and sets to variable randomNumber
    int randomNumber = new Random().nextInt(10);

    // creates place for the user to input in
    JTextField text= new JTextField(20);

    // adds new label on gui that shows output if the user is right with his guess or wrong
    JLabel result =new JLabel("");

    // label for reprompting user to enter value of guess again:
    JLabel prompt =new JLabel("Please type in a guess within 0-9");

    // Adds label that displays the random number
    JLabel answer =new JLabel("The answer is: " + randomNumber);



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

      // adds the prompt label to the pane
      contentPane.add(prompt);

      // Adds the answer label to the pane
      contentPane.add(answer);

      // Creates a button naming it bButton
      JButton bButton = new JButton("Submit Result");
      bButton.addActionListener(this);

      // adds submit result button to the pane
      contentPane.add(bButton);

      // sets the layout of the pane of the window
      contentPane.setLayout(new FlowLayout());

    }

    // ACTION LISTENER FOR BUTTON Submit Result
    public void actionPerformed(ActionEvent e)
      {

      text.getText();
      int text2 = Integer.parseInt(text.getText());
      if(text2 <0 || text2>9){
    	  JOptionPane.showMessageDialog(null,"Enter a number between range 0-9","Guessing Game",JOptionPane.WARNING_MESSAGE);
      }
      else if(text2 < randomNumber){
    	  result.setText("Too Low");
    	  contentPane.setBackground(Color.RED);
    	}else if(text2 > randomNumber) {
    	  result.setText("Too High");
    	  contentPane.setBackground(Color.RED);
      }else if(text2 == randomNumber){
    	  result.setText("You won!");
    	  contentPane.setBackground(Color.GREEN);

      }

    }



    // Method returns user's guess
    public int getGuess() {
        System.out.print("What is your guess? ");
        Scanner keyboard = new Scanner(System.in);
        return keyboard.nextInt();
    }

    // Method checks the users guess against the random number
    // and prints an appropriate message.
    public boolean checkGuess(int guess) {
        if (guess == randomNumber) {
            System.out.println("Well done!");
            return true;
        } else if (guess < 0 || guess > 9) {
          System.out.println("Number out of range");
        } else if (guess < randomNumber) {
            System.out.println("Too low");
        } else if (guess > randomNumber) {
            System.out.println("Too high");
        }

        return false;
    }

    // Keeps the game running until the answer has bee guessed.
    public void play() {
        System.out.println("I'm thinking of a number between 0 and 9");
        boolean check = this.checkGuess(getGuess());

        while (!check) {
            check = this.checkGuess(getGuess());
        }
    }

    // Main method that runs the program
    public static void main(String[] args) {
        GuessingGame game = new GuessingGame();
        game.play();

    }
}
