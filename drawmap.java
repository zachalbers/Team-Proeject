
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class drawmap extends JPanel{

	public void paintComponent(Graphics g){
		super.paintComponent(g);
		this.setBackground(Color.WHITE);

		g.setColor(Color.BLUE);
		g.fillRect(25, 25, 100, 30);

		g.setColor(Color.BLACK);
		g.fillRect(25, 65, 100, 30);

		g.setColor(Color.RED);
		g.drawString("LIAMS SUCKS BOTH THESE RECTANGLES", 25, 120);

	}













}
