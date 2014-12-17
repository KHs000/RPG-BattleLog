

package rpg;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author Felipe Rabelo
 */
public class JanelaFichaJogador extends JFrame {
    private JButton player [];
    private String playername [] = {"Lestrade", "Tyrion", "Izuna"};
    private JButton voltar;
    
    public JanelaFichaJogador () {
        super ("Jogadores");
        
        setLayout (new GridLayout (4, 1));
        setVisible (true);
        player = new JButton [playername.length];
        voltar = new JButton("Voltar");
        for (int i = 0 ; i < player.length ; i++) {
            player[i] = new JButton (playername[i]);
            add(player[i]);
        }
        add(voltar);
        
        JanelaFichaJogador.Event onclick = new JanelaFichaJogador.Event ();
        for (int i = 0 ; i < player.length ; i++) {
            player[i].addActionListener(onclick);
        }
        voltar.addActionListener(onclick);
    }
    
    public void encerar () {
        this.dispose();
    }
    
    private class Event implements ActionListener{
      @Override
      public void actionPerformed( ActionEvent event ){
         if (event.getSource() == voltar) {
             encerar();
             
            JanelaFicha open = new JanelaFicha();
             open.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
             open.setSize(250, 250);
             open.setLocation(500, 30);
             open.setVisible(true);
         }
         if (event.getSource() == player[0]) {
             encerar();
             
             JanelaLestrade playerLestrad = new JanelaLestrade ();
             playerLestrad.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
             playerLestrad.setSize(700, 700);
             playerLestrad.setLocation(325, 30);
             playerLestrad.setVisible(true);
         }
         if (event.getSource() == player[1]) {
             encerar();
             
             JanelaTyrion playerTyrion = new JanelaTyrion ();
             playerTyrion.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
             playerTyrion.setSize(700, 700);
             playerTyrion.setLocation(325, 30);
             playerTyrion.setVisible(true);
         }
         if (event.getSource() == player[2]) {
             encerar();
             
             JanelaIzuna playerIzuna = new JanelaIzuna ();
             playerIzuna.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
             playerIzuna.setSize(700, 700);
             playerIzuna.setLocation(325, 30);
             playerIzuna.setVisible(true);
         }
      }
   }
}
