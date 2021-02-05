package ClassesSeparadas;


	import java.awt.Rectangle;

import javax.swing.ImageIcon;
	import javax.swing.JFrame;

	import javax.swing.JLabel;

	/**
	 *
	 * @author c_jun
	 */
	public class Pacman extends JFrame {

	    /**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		/**
	     *
	     */
	 
	    protected ImageIcon Pacman1 = new ImageIcon(getClass().getResource("pac1.PNG"));
	    protected ImageIcon Pacman2 = new ImageIcon(getClass().getResource("pac2.png"));
	    protected ImageIcon Pacman3 = new ImageIcon(getClass().getResource("pac3.png"));
	    protected ImageIcon Pacman4 = new ImageIcon(getClass().getResource("pac4.png"));
	    protected ImageIcon Pacman5 = new ImageIcon(getClass().getResource("pac5.png"));
	    protected ImageIcon Boom = new ImageIcon(getClass().getResource("boom.png"));
	    JLabel Pacman = new JLabel(Pacman1);
	   
	    public Pacman() {
	    	Pacman.setIcon(Pacman5);
	    	Pacman.setBounds(365, 458, 45, 43);
	      
	    }
	    public JLabel getPacman() {
	        return Pacman;
	    }
	    public Rectangle getBounds() {
	    	return Pacman.getBounds();
	    }
	    public void mortePac(){
	        Pacman.setIcon(Boom);
	    }
	    public void Movimento(int xx,int yy) {
	    	Pacman.setBounds(xx * 27 + 10, yy * 20 - 3, 45, 43);
	    }
	    public void setImagemPac(int PacM,boolean iniciar) {
	        if (iniciar) {
	            switch (PacM) {
	                case 1:
	                    Pacman.setIcon(Pacman1);
	                    break;
	                case 2:
	                    Pacman.setIcon(Pacman2);
	                    break;
	                case 3:
	                    Pacman.setIcon(Pacman3);
	                    break;
	                case 4:
	                    Pacman.setIcon(Pacman4);
	                    break;
	                default:
	                    break;
	            }
	        } else {
	            Pacman.setIcon(Pacman5);
	        }
	    }
	}
