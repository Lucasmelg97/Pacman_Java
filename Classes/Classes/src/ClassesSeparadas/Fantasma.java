package ClassesSeparadas;

import java.awt.Rectangle;


import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Fantasma extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	protected ImageIcon GhostR0 = new ImageIcon(getClass().getResource("ghostR_0.png"));
	protected ImageIcon GhostR1 = new ImageIcon(getClass().getResource("ghostR_1.png"));
	protected ImageIcon GhostR2 = new ImageIcon(getClass().getResource("ghostR_2.png"));
	protected ImageIcon GhostR3 = new ImageIcon(getClass().getResource("ghostR_3.png"));
	protected ImageIcon GhostB0 = new ImageIcon(getClass().getResource("ghostB_0.png"));
	protected ImageIcon GhostB1 = new ImageIcon(getClass().getResource("ghostB_1.png"));
	protected ImageIcon GhostB2 = new ImageIcon(getClass().getResource("ghostB_2.png"));
	protected ImageIcon GhostB3 = new ImageIcon(getClass().getResource("ghostB_3.png"));
	JLabel FantasmaR = new JLabel(GhostR1);
	JLabel FantasmaB = new JLabel(GhostB1);
	
	public Fantasma() {
	    	FantasmaR.setIcon(GhostR0);
	    	FantasmaR.setBounds(350,280,40,40);
	    	FantasmaB.setIcon(GhostB1);
	    	FantasmaB.setBounds(400,280,40,40);
	      
	 }
	public JLabel getFantasmaR() {
	        return FantasmaR;
    }
	public JLabel getFantasmaB() {
        return FantasmaB;
	}
	public Rectangle getBoundsR() {
	    	return FantasmaR.getBounds();
    }
	public Rectangle getBoundsB() {
    	return FantasmaB.getBounds();
	}
	public void Movimento(int xr,int yr,int xb,int yb) {
	    	FantasmaR.setBounds(xr * 27 + 10, yr * 20 - 3, 40, 40);
	    	FantasmaB.setBounds(xb * 27 + 10, yb * 20 - 3, 40, 40);
    }
	public void setImagemFR(int FanR,boolean anima){
			if(anima) {
				FantasmaR.setIcon(GhostR0);
			}
			else {
				FantasmaR.setIcon(GhostR1);
			}
			switch(FanR) {
				case 0:
					FantasmaR.setIcon(GhostR0);
					break;
				case 1:
					FantasmaR.setIcon(GhostR1);
					break;
				case 2:
					FantasmaR.setIcon(GhostR3);
					break;
				case 3:
					FantasmaR.setIcon(GhostR2);
					break;
				case 4:
					FantasmaR.setIcon(GhostR1);
					break;
				default:
					break;
			
		}
	}
	public void setImagemFB(int FanB,boolean anima){
		if(anima) {
			FantasmaB.setIcon(GhostB0);
		}
		else {
			FantasmaB.setIcon(GhostB1);
		}
		switch(FanB) {
			case 0:
				FantasmaB.setIcon(GhostB0);
				break;
			case 1:
				FantasmaB.setIcon(GhostB1);
				break;
			case 2:
				FantasmaB.setIcon(GhostB3);
				break;
			case 3:
				FantasmaB.setIcon(GhostB2);
				break;
			case 4:
				FantasmaB.setIcon(GhostB1);
				break;
			default:
				break;
		
		}
	}
}
