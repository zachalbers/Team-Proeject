import javax.swing.*;

public class mainmap {

  public static void main(String[] args) {

      JFrame f = new JFrame("MAP DESIGN");
      f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      //Making first Rectangle
      Rectangle r1 =new Rectangle();
      r1.setX(10);
      r1.setY(10);
      r1.setwidth(200);
      r1.setheight(60);

      //Rectangle square=  new Rectangle();
      //square.setX(10);
      //square.setY(100);
      //square.setwidth(80);
      //square.setheight(80);




      f.add(r1);
      //f.add(square);
      f.setSize(800,600);
      f.setVisible(true);

    }









}
