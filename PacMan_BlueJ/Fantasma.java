
/**
 * Classe Fantasma responsavel para mudar as imagens do Fantasma Azul e Vermelho 
 * dentro do jogo de acordo cm movimento .
 * 
 * @author (Carlos,Lucas,Brayan) 
 * @version (24/11 - Final)
 */
import java.awt.Rectangle;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Fantasma extends JFrame
{
    // variáveis de instância - Responsaveis pela criação das imagens referentes
    // a cada Fantasma e da JLabel de ambos.
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

    /**
     * Construtor para objetos da classe Fantasma,que define imagem inicial
     * e posições iniciais para o Fantasma Azul e Vermeho.
     */
    public Fantasma() {
        FantasmaR.setIcon(GhostR0);
        FantasmaR.setBounds(350,280,40,40);
        FantasmaB.setIcon(GhostB1);
        FantasmaB.setBounds(400,280,40,40);

    }

    /**
     * Método para retornar uma JLabel do tipo Fantasma e de cor R(vermelho).
     * @return     a JLabel
     */
    public JLabel getFantasmaR() {
        return FantasmaR;
    }

    /**
     * Método para retornar uma JLabel do tipo Fantasma e de cor B(Azul).
     * @return     a JLabel
     */
    public JLabel getFantasmaB() {
        return FantasmaB;
    }

    /**
     * Método para retornar valores de uma JLabel do tipo Fantasma 
     * e de cor R(Vermelha).
     * Obs:Uma JLabel e tratada como um retangulo.
     * @return     a posição do Fantasma R na tela;
     * Sua posição x,y,largura e comprimento.
     */
    public Rectangle getBoundsR() {
        return FantasmaR.getBounds();
    }

    /**
     * Método para retornar valores de uma JLabel do tipo Fantasma 
     * e de cor B(Blue).
     * Obs:Uma JLabel e tratada como um retangulo.
     * @return     a posição do Fantasma R na tela;
     * Sua posição x,y,largura e comprimento.
     */
    public Rectangle getBoundsB() {
        return FantasmaB.getBounds();
    }

    /**
     * Método para mover os Fantasma R e B de acordo com as variaveis X e Y ,
     * que representam sua posição numa matriz.
     * X = Sua Linha.
     * Y = Sua Coluna.
     */
    public void Movimento(int xr,int yr,int xb,int yb) {
        FantasmaR.setBounds(xr * 27 + 10, yr * 20 - 3, 40, 40);
        FantasmaB.setBounds(xb * 27 + 10, yb * 20 - 3, 40, 40);
    }

    /**
     * Método para mudar as imagens do Fantasmas R de acordo com a direção
     * em que se move.
     */

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

    /**
     * Método para mudar as imagens do Fantasma B de acordo com a direção
     * em que se move.
     */

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
