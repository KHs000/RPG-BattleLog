

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
public class JanelaIniciarST extends JFrame{
    private JButton ficha;
    private JButton combate;
    private JButton voltar;
    
    public JanelaIniciarST () {
        super ("Star Wars");
        
        setLayout (new GridLayout (4, 1));
        setVisible (true);
        voltar = new JButton("Voltar");
        ficha = new JButton("Fichas");
        combate = new JButton("Combate");
        add(ficha);
        add(combate);
        add(voltar);
        
        Event onclick = new Event ();
        voltar.addActionListener(onclick);
        ficha.addActionListener(onclick);
        combate.addActionListener(onclick);
    }
    
    public void encerar () {
        this.dispose();
    }
    
    private class Event implements ActionListener{
      @Override
      public void actionPerformed( ActionEvent event ){
         if (event.getSource() == voltar) {
             encerar();
             
             Janela open = new Janela();
             open.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
             open.setSize(250, 250);
             open.setLocation(500, 30);
             open.setVisible(true);
            }
         if (event.getSource() == ficha) {
             encerar();
             
             JanelaFicha open = new JanelaFicha(); //REQUER ALTERAÇÃO
             open.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
             open.setSize(250, 250);
             open.setLocation(500, 30);
             open.setVisible(true);
            }
         if (event.getSource() == combate) {
             encerar();
             
             JanelaConfiguraCombate open = new JanelaConfiguraCombate(); //REQUER ALTERAÇÃO
             open.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
             open.setSize(700, 700);
             open.setLocation(325, 30);
             open.setVisible(true);
            }
        }
    }
}
