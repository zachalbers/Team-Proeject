import java.awt.*;
import javax.swing.*;
import java.awt.event.*;


public class Rectangle extends JPanel {

  int X=0;
  int Y=0;
  int width=0;
  int height =0;

  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    this.setBackground(Color.BLACK);

    g.setColor(Color.BLUE);
    g.fillRect(X,Y,width,height);
    
    }

    public void setX(int Xco){
      X= Xco;
    }

    public void setY(int Yco){
      Y=Yco;
    }

    public void setwidth(int widthco){
      width=widthco;
    }

    public void setheight(int heightco){
      height=heightco;
    }



  //public static void main(String[] args) {

      //JFrame f = new JFrame("MAP DESIGN");
      //f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      //Map m =new Map();
      //f.add(Map);
      //f.setSize(400,250);
      //f.setVisible(true);




}
