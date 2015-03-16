

package rpg;

import java.awt.Event;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Felipe Rabelo
 */
public class JanelaJogo extends JFrame{
    private JButton st;
    private JButton sk;
    private JButton voltar;
    
    public JanelaJogo () {
        super("RPGs");
        
        setLayout (new GridLayout(3, 1));
        setVisible (true);
        st = new JButton ("Star Wars");
        sk = new JButton ("Skyrim");
        voltar  =new JButton ("Voltar");
        
        add(st);
        add(sk);
        add(voltar);
        
        Event onclick = new Event ();
        st.addActionListener(onclick);
        sk.addActionListener(onclick);
        voltar.addActionListener(onclick);
    }
    
    public void fechar (){  
        if(JOptionPane.showConfirmDialog(rootPane, "Deseja encerrar o programa?", "ATENÇÂO ", JOptionPane.YES_NO_OPTION ) == 0){  
            this.dispose();  
        }  
    }
    
    public void encerar () {
        this.dispose();
    }
    
    private class Event implements ActionListener {
        @Override
        public void actionPerformed (ActionEvent e) {
            if (e.getSource() == st) {
                
            }
            if (e.getSource() == sk) {
                encerar();
                
                JanelaIniciar init = new JanelaIniciar();
                init.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
                init.setSize(250, 250);
                init.setLocation(500, 30);
                init.setVisible( true );
            }
            if (e.getSource() == voltar) {
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
