package VetManagement;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class buttonHandle implements MouseListener {
    mainPanel mainPanel;
    JPanel cardLayoutPanel;
    CardLayout cardLayout;
    String cardName;

    buttonHandle(mainPanel mainPanel,JPanel cardLayoutPanel , CardLayout cardLayout, String cardName){
    	this.mainPanel = mainPanel;
    	this.cardLayoutPanel = cardLayoutPanel;
    	this.cardLayout = cardLayout;
    	this.cardName = cardName;
    }


    
	@Override
	public void mouseClicked(MouseEvent e) {
       cardLayout.show(cardLayoutPanel, cardName);
      
	}

	@Override
	public void mousePressed(MouseEvent e) {
	      		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		JPanel panel = (JPanel)e.getSource();
		panel.setBackground(new Color(90,197,149));
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
        JPanel panel = (JPanel)e.getSource();
        panel.setBackground(Color.WHITE);
		
	}
}
