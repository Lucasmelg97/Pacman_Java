
/**
 *Classe Jogo é a principal,responsavel por toda logica do jogo.
 * @author Carlos,Lucas,Brayan.
 * @version 24/11 - Final.
 */
import java.awt.Font;
import java.awt.Color;
import static java.awt.Font.ITALIC;
import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.net.URL;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.Timer;

public class Jogo extends Fantasma implements ActionListener 
{
    // variáveis de instância - Definições:
    //Variaveis P: responsaveis por ser a posição dos objetos no mapa.
    //Variaveis FanR e FanB,responsaveis por receber as posições de movimentos 
    //dos fantasmas para serem passadas para os metodos do  Fantasma.
    //Variavel PacM responsavel por receber os movimentos do Pacman ao 
    //prescionar teclas e passar para os metodos do Pacman.
    //Variavel vidas,vidas do Pacman no jogo,Variaves pontos,sua pontuação.
    int px=13; 
    int py=23;
    int prx=13;
    int pry=15;
    int pbx=15;
    int pby=15;
    int FanR = 0;
    int FanB =0;
    int PacM = 0;
    int vida = 3;
    int pontos = 0;
    boolean iniciar = false, anima = false, sair = false;
    Random random = new Random();
    Timer Tempo;

    char mapa[][] = {//  4    5    6    7    8    9   10   11   12   13   14   15   16   17   18   19   20   21   22   23   24   25   26   27   28      
            {'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x'},//01
            {'x', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'x', 'x', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'x'},//02
            {'x', 'o', 'x', 'x', 'x', 'x', 'o', 'x', 'x', 'x', 'x', 'x', 'o', 'x', 'x', 'o', 'x', 'x', 'x', 'x', 'x', 'o', 'x', 'x', 'x', 'x', 'o', 'x'},//03
            {'x', '-', 'x', 'x', 'x', 'x', 'o', 'x', 'x', 'x', 'x', 'x', 'o', 'x', 'x', 'o', 'x', 'x', 'x', 'x', 'x', 'o', 'x', 'x', 'x', 'x', '-', 'x'},//04
            {'x', 'o', 'x', 'x', 'x', 'x', 'o', 'x', 'x', 'x', 'x', 'x', 'o', 'x', 'x', 'o', 'x', 'x', 'x', 'x', 'x', 'o', 'x', 'x', 'x', 'x', 'o', 'x'},//05
            {'x', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'x'},//06
            {'x', 'o', 'x', 'x', 'x', 'x', 'o', 'x', 'x', 'o', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'o', 'x', 'x', 'o', 'x', 'x', 'x', 'x', 'o', 'x'},//07
            {'x', 'o', 'x', 'x', 'x', 'x', 'o', 'x', 'x', 'o', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'o', 'x', 'x', 'o', 'x', 'x', 'x', 'x', 'o', 'x'},//08
            {'x', 'o', 'o', 'o', 'o', 'o', 'o', 'x', 'x', 'o', 'o', 'o', 'o', 'x', 'x', 'o', 'o', 'o', 'o', 'x', 'x', 'o', 'o', 'o', 'o', 'o', 'o', 'x'},//09
            {'x', 'x', 'x', 'x', 'x', 'x', 'o', 'x', 'x', 'x', 'x', 'x', 'o', 'x', 'x', 'o', 'x', 'x', 'x', 'x', 'x', 'o', 'x', 'x', 'x', 'x', 'x', 'x'},//10
            {'x', 'x', 'x', 'x', 'x', 'x', 'o', 'x', 'x', 'x', 'x', 'x', 'o', 'x', 'x', 'o', 'x', 'x', 'x', 'x', 'x', 'o', 'x', 'x', 'x', 'x', 'x', 'x'},//11
            {'x', 'x', 'x', 'x', 'x', 'x', ' ', 'x', 'x', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'x', 'x', 'o', 'x', 'x', 'x', 'x', 'x', 'x'},//12
            {'x', 'x', 'x', 'x', 'x', 'x', 'o', 'x', 'x', 'o', 'x', 'x', 'x', 'z', 'z', 'x', 'x', 'x', 'o', 'x', 'x', 'o', 'x', 'x', 'x', 'x', 'x', 'x'},//13
            {'x', 'x', 'x', 'x', 'x', 'x', 'o', 'x', 'x', 'o', 'x', 'x', 'x', ' ', ' ', 'x', 'x', 'x', 'o', 'x', 'x', 'o', 'x', 'x', 'x', 'x', 'x', 'x'},//14
            {' ', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'x', ' ', ' ', ' ', ' ', ' ', ' ', 'x', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', ' '},//15
            {'x', 'x', 'x', 'x', 'x', 'x', 'o', 'x', 'x', 'o', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'o', 'x', 'x', 'o', 'x', 'x', 'x', 'x', 'x', 'x'},//16
            {'x', 'x', 'x', 'x', 'x', 'x', 'o', 'x', 'x', 'o', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'o', 'x', 'x', 'o', 'x', 'x', 'x', 'x', 'x', 'x'},//17
            {'x', 'x', 'x', 'x', 'x', 'x', ' ', 'x', 'x', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'x', 'x', 'o', 'x', 'x', 'x', 'x', 'x', 'x'},//18
            {'x', 'x', 'x', 'x', 'x', 'x', 'o', 'x', 'x', 'o', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'o', 'x', 'x', 'o', 'x', 'x', 'x', 'x', 'x', 'x'},//19
            {'x', 'x', 'x', 'x', 'x', 'x', 'o', 'x', 'x', 'o', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'o', 'x', 'x', 'o', 'x', 'x', 'x', 'x', 'x', 'x'},//20
            {'x', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'x', 'x', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'x'},//21
            {'x', 'o', 'x', 'x', 'x', 'x', 'o', 'x', 'x', 'x', 'x', 'x', 'o', 'x', 'x', 'o', 'x', 'x', 'x', 'x', 'x', 'o', 'x', 'x', 'x', 'x', 'o', 'x'},//22
            {'x', 'o', 'x', 'x', 'x', 'x', 'o', 'x', 'x', 'x', 'x', 'x', 'o', 'x', 'x', 'o', 'x', 'x', 'x', 'x', 'x', 'o', 'x', 'x', 'x', 'x', 'o', 'x'},//23
            {'x', '-', 'o', 'o', 'x', 'x', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'x', 'x', 'o', 'o', '-', 'x'},//24
            {'x', 'x', 'x', 'o', 'x', 'x', 'o', 'x', 'x', 'o', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'o', 'x', 'x', 'o', 'x', 'x', 'o', 'x', 'x', 'x'},//25
            {'x', 'x', 'x', 'o', 'x', 'x', 'o', 'x', 'x', 'o', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'o', 'x', 'x', 'o', 'x', 'x', 'o', 'x', 'x', 'x'},//26
            {'x', 'o', 'o', 'o', 'o', 'o', 'o', 'x', 'x', 'o', 'o', 'o', 'o', 'x', 'x', 'o', 'o', 'o', 'o', 'x', 'x', 'o', 'o', 'o', 'o', 'o', 'o', 'x'},//27
            {'x', 'o', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'o', 'x', 'x', 'o', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'o', 'x'},//28
            {'x', 'o', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'o', 'x', 'x', 'o', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'o', 'x'},//28
            {'x', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'x'},//28
            {'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'x'}};//29

    ImageIcon ponto = new ImageIcon(getClass().getResource("Ponto.png"));
    ImageIcon pilula1 = new ImageIcon(getClass().getResource("pilula1.png"));
    ImageIcon pilula2 = new ImageIcon(getClass().getResource("pilula3.png"));
    ImageIcon fundo = new ImageIcon(getClass().getResource("fundo.png"));
    ImageIcon title = new ImageIcon(getClass().getResource("title.png"));
    ImageIcon gate = new ImageIcon(getClass().getResource("portao.png"));
    ImageIcon FimDeGame = new ImageIcon(getClass().getResource("GameOver.png"));
    ImageIcon Lula1 = new ImageIcon(getClass().getResource("lula1.png"));

    JLabel foto = new JLabel(fundo);
    JLabel titulo = new JLabel(title);
    JLabel texto = new JLabel("Trabalho");
    JLabel vidas = new JLabel ("Vidas");
    JLabel portao = new JLabel(gate);
    JLabel Ponto[][] = new JLabel[31][28];
    JLabel Fim = new JLabel(FimDeGame);
    JLabel lula =new JLabel(Lula1);
    JLabel lula2 =new JLabel(Lula1);
    JLabel lula1 =new JLabel(Lula1);

    Font fonte = new Font("Serif", Font.BOLD + ITALIC, 30);

    URL SoundPonto = Jogo.class.getResource("ponto.wav");
    URL SoundPilula = Jogo.class.getResource("pilula.wav");
    URL SoundInicio = Jogo.class.getResource("inicio.wav");

    AudioClip soundPonto = Applet.newAudioClip(SoundPonto);
    AudioClip soundPilula = Applet.newAudioClip(SoundPilula);
    AudioClip soundInicio = Applet.newAudioClip(SoundInicio);
    Pacman pacman = new Pacman();
    Fantasma Fan = new Fantasma();

    /**
     * Construtor para objetos da classe Jogo,inicia o jogo ,trata a colizão 
     * entre objetos,contabiliza as vidas,e abre o portão para liberação dos 
     * Fantasmas.
     */
    public void jogo() {
        if (iniciar) {
            if (Fan.getBoundsR().intersects(pacman.getBounds())||Fan.getBoundsB().intersects(pacman.getBounds())) {//*******
                vida--;
                pacman.mortePac();
                JOptionPane.showMessageDialog(null, "Você perdeu 1 vida!!!!");
                if(vida==2) {
                    remove(lula);
                }
                else if(vida==1) {
                    remove(lula1);

                }else if(vida==0){
                    remove(lula2);

                }
                px=13;py=23;
                pacman.setBounds(px * 27 + 10, py * 20 - 3, 45, 43);
            }else if (mapa[py][px] == 'o') {
                mapa[py][px] = ' ';
                pontos++;
                soundPonto.play();
            }else if (mapa[py][px] == '-') {
                mapa[py][px] = ' ';
                pontos += 5;
                soundPilula.play();

            }else if (vida == 0) {
                pacman.mortePac();
                Fim.setBounds(365, 458, 80, 80);
                JOptionPane.showMessageDialog(null, Fim);
                add(Fim);
                Tempo.stop();

            }
            for (int i = 0; i < 28; i++) {
                for (int j = 0; j < 31; j++) {
                    switch (mapa[j][i]) {
                        case 'o':
                        Ponto[j][i].setIcon(ponto);
                        break;
                        case '-':
                        if (anima) {
                            Ponto[j][i].setIcon(pilula1);
                        } else {
                            Ponto[j][i].setIcon(pilula2);
                        }
                        break;
                        case ' ':
                        Ponto[j][i].setBounds(0, 0, 0, 0);
                        break;
                        default:
                        break;

                    }
                }
            }
            if(!anima) {
                anima=true;
            }else {
                anima=false;
            }
            if (sair) {
                FanR = random.nextInt(5);
                FanB = random.nextInt(5);
            } 
            else {
                if (mapa[pry][prx] == 'z' || mapa[pry][prx + 1] == 'z' || mapa[pry][prx - 1] == 'z') {
                    mapa[pry][prx] = 'x';
                    mapa[pry][prx + 1] = 'x';
                    mapa[pry][prx - 1] = 'x';
                    pry -=1;
                    pby-=1;
                    portao.setBounds(360, 238, 60, 52);
                    sair = true;
                }else 
                    pry-=1;
                pby-=1;
            }    
            FanR = random.nextInt(5);
            FanB = random.nextInt(5);
            switch (PacM) {
                case 1:
                if (mapa[py][px+ 1] != 'x') {
                    px += 1;
                }
                break;
                case 2:
                if (mapa[py][px - 1] != 'x') {
                    px -= 1;
                }
                break;
                case 3:
                if (mapa[py+ 1][px] != 'x') {
                    py += 1;
                }
                break;
                case 4:
                if (mapa[py- 1][px] != 'x') {
                    py -= 1;
                }
                break;
                default:
                break;
            }
            switch(FanB) {
                case 0:
                if(mapa[pby][pbx+1]!='x') {
                    pbx +=1;
                }	
                break;
                case 1:
                if(mapa[pby][pbx-1]!='x') {
                    pbx-=1;
                }	
                break;
                case 2:
                if(mapa[pby+1][pbx]!='x') {
                    pby+=1;
                }	
                break;
                case 3:
                if(mapa[pby-1][pbx]!='x') {
                    pby-=1;
                }	
                break;
                default:
                break;			
            }
            switch(FanR) {
                case 0:
                if(mapa[pry][prx+1]!='x') {
                    prx +=1;
                }	
                break;
                case 1:
                if(mapa[pry][prx-1]!='x') {
                    prx-=1;
                }	
                break;
                case 2:
                if(mapa[pry+1][prx]!='x') {
                    pry+=1;
                }	
                break;
                case 3:
                if(mapa[pry-1][prx]!='x') {
                    pry-=1;
                }	
                break;
                default:
                break;			
            }

            if (px<= 0) {
                px = 27;
            } else if (px>= 27) {
                px = 0;
            }
            if(prx<=0) {
                prx=27;
            }else if(prx>=27) {
                prx=0;
            }
            if(pbx<=0) {
                pbx=27;
            }else if(pbx>=27) {
                pbx=0;
            }
            texto.setText(Integer.toString(pontos));
            Fan.setImagemFR(FanR, anima);
            Fan.setImagemFB(FanB, anima);
            Fan.Movimento(prx, pry,pbx,pby);
            pacman.setImagemPac(PacM,anima);
            pacman.Movimento(px, py);
        }
    }

    /**
     * Método que inicia e adiciona os objetos na tela,seta suas posições,
     * desenha o mapa e é responsavel pela parte grafica do programa.
     */
    public void Tela() {
        setTitle("pacman");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 690);
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(null);
        setVisible(true);
        texto.setBounds(830, 200, 130, 30);
        texto.setFont(fonte);
        vidas.setBounds(850, 300, 130, 30);
        vidas.setFont(fonte);
        vidas.setForeground(Color.RED);
        texto.setForeground(Color.yellow);
        titulo.setBounds(808, 40, 160, 45);
        portao.setBounds(360, 238, 60, 52);
        lula.setBounds(808, 360, 45, 45);
        lula1.setBounds(863, 360, 45, 45);
        lula2.setBounds(918, 360, 45, 45);
        Fim.setBounds(0, 0, 0, 0);
        add(Fim);
        add(vidas);
        add(titulo);
        add(texto);
        add(portao);
        add(pacman.getPacman());
        add(Fan.getFantasmaB());
        add(Fan.getFantasmaR());
        add(lula);
        add(lula1);
        add(lula2);
        for (int i = 0; i < 28; i++) {
            for (int j = 0; j < 31; j++) {
                switch (mapa[j][i]) {
                    case 'o':
                    Ponto[j][i] = new JLabel(ponto);
                    Ponto[j][i].setBounds(i * 27 + 22, j * 20 + 12, 10, 10);
                    add(Ponto[j][i]);
                    break;
                    case '-':
                    Ponto[j][i] = new JLabel(pilula1);
                    Ponto[j][i].setBounds(i * 27 + 16, j * 20 + 4, 25, 25);
                    add(Ponto[j][i]);
                    break;
                    case ' ':
                    Ponto[j][i] = new JLabel(pilula1);
                    Ponto[j][i].setBounds(0, 0, 0, 0);
                    add(Ponto[j][i]);
                    break;

                }
            }
        }
        add(foto);
        foto.setBounds(0,0, 1001, 686);
        Tempo = new Timer(150,this);
        Tempo.start();
        soundInicio.play();
        try {
            Thread.sleep(1000);

        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();

        }

    }

    /**
     * Método que é responsavel por ao prescionar as teclas de movimento 
     * retornar valores caso a posição atual + a direção pressionada não
     * vão de encontro com uma "parede" o 'x' na matriz de caracteres.
     */
    public void mover() {
        addKeyListener(new KeyListener() {

                @Override
                public void keyPressed(KeyEvent e) {
                    if(e.getKeyCode()==KeyEvent.VK_SPACE) {
                        iniciar = true;
                        portao.setBounds(0,0,0,0);

                    }
                    else if(iniciar==false){
                        JOptionPane.showMessageDialog(null, "PRESSIONE 'SPACE'PARA CONTINUAR !!!");
                    }

                    {
                        if(e.getKeyCode()==KeyEvent.VK_RIGHT && mapa[py][px+1]!='x') {
                            PacM=1;
                        }
                        if(e.getKeyCode()==KeyEvent.VK_LEFT && mapa[py][px-1]!='x') {
                            PacM=2;
                        }
                        if(e.getKeyCode()==KeyEvent.VK_DOWN && mapa[py+1][px]!='x') {
                            PacM=3;
                        }
                        if(e.getKeyCode()==KeyEvent.VK_UP && mapa[py-1][px]!='x') {
                            PacM =4;
                        }

                    }
                }

                @Override
                public void keyReleased(KeyEvent e) {

                }

                @Override
                public void keyTyped(KeyEvent e) {
                    // TODO Auto-generated method stub

                }

            });
    }

    /**
     * Método que ao apertar uma tecla,chama o metodo jogo.
     */
    public void actionPerformed(ActionEvent e) {
        jogo();
    }
}

