import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;


@SuppressWarnings("rawtypes")
public class ComboBoxExample extends JFrame implements ActionListener {


String [] buildings = {"Mac Hall","Science B","Kinesiology A"};
JComboBox<String> cmbMessageList = new JComboBox<>(buildings);
JLabel lblText = new JLabel();

String destinationgui = "";


public static void main(String[] args) {
				ComboBoxExample fr = new ComboBoxExample();
				fr.setVisible(true);
}

public ComboBoxExample() {
				setLayout(new FlowLayout());
				setSize(140,130);
				setTitle("JComboBox Example");
				setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

				cmbMessageList.setSelectedIndex(0);
				cmbMessageList.addActionListener(this);
				add(cmbMessageList);
				add(lblText);
}

public void actionPerformed(ActionEvent e){
				if(e.getSource() == cmbMessageList) {
								JComboBox cb = (JComboBox)e.getSource();
								String destinationgui = (String)cb.getSelectedItem();

								lblText.setText(destinationgui);

								}
}


}
