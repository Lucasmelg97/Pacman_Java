
/**
 * A classe Pacman e responsavel para mudar as imagens de acordo cm movimento.* 
 * @author Carlos,Lucas,Brayan.
 * @version 24/11 - Final.
 */
import java.awt.Rectangle;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Pacman extends JFrame
{
    // variáveis de instância - Responsaveis por ser as imagens de direção de movimento do pacman.
    protected ImageIcon Pacman1 = new ImageIcon(getClass().getResource("pac1.PNG"));
    protected ImageIcon Pacman2 = new ImageIcon(getClass().getResource("pac2.png"));
    protected ImageIcon Pacman3 = new ImageIcon(getClass().getResource("pac3.png"));
    protected ImageIcon Pacman4 = new ImageIcon(getClass().getResource("pac4.png"));
    protected ImageIcon Pacman5 = new ImageIcon(getClass().getResource("pac5.png"));
    protected ImageIcon Boom = new ImageIcon(getClass().getResource("boom.png"));
    JLabel Pacman = new JLabel(Pacman1);

    /**
     * Construtor para objetos da classe Pacman-Define imagem inicial 
     * e posicoes na tela.
     */
    public Pacman() {
        Pacman.setIcon(Pacman5);
        Pacman.setBounds(365, 458, 45, 43);

    }

    /**
     * Metodo responsavel por retornar uma JLabel do tipo Pacman.
     */
    public JLabel getPacman() {
        return Pacman;
    }

    /**
     * Retorna as posicoes da JLabel do Pacman. Obs: a JLabel tem 
     * posicoes como um retangulo.
     */
    public Rectangle getBounds() {
        return Pacman.getBounds();
    }

    /**
     * Metodo responsavel para trocar a imagem do Pacman após colizão 
     * com Fantasma Azul ou Vermelho(Mais informações na classe Jogo).
     */
    public void mortePac(){
        Pacman.setIcon(Boom);
    }

    /**
     * Metodo responsavel por morver o pacman de acordo com X e Y recebido ao 
     * pressionar teclas.
     */
    public void Movimento(int xx,int yy) {
        Pacman.setBounds(xx * 27 + 10, yy * 20 - 3, 45, 43);
    }

    /**
     * Metodo para mudar imagem do Pacman de acordo com a direção da tela 
     * pressionada.
     * Obs: Gera a animação de movimmento.
     */
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
