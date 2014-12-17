

package rpg;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;

/**
 *
 * @author Felipe Rabelo
 */
public class JanelaTemporaria extends JFrame{
    private JTextArea emConstrucao;
    private JButton voltar;
    
    public JanelaTemporaria() {
        super("Em construção!");
        
        setLayout (new GridLayout(2, 1));
        setVisible (true);
        
        emConstrucao = new JTextArea ();
        emConstrucao.setText("Desculpe o transtorno, mas essa página \nainda"
                + " está em construção");
        emConstrucao.setEditable(false);
        add(emConstrucao);
        voltar = new JButton ("Voltar");
        add(voltar);
        
        JanelaTemporaria.Event onclick = new JanelaTemporaria.Event();
        voltar.addActionListener(onclick);
    }
    
    public void encerar () {
        this.dispose();
    }
    
    private class Event implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent event) {
            if (event.getSource() == voltar) {
                encerar();
             
                Janela open = new Janela();
                open.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                open.setSize(250, 250);
                open.setLocation(500, 30);
                open.setVisible(true);
            }
        }
        
    }
}
