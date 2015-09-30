

package rpg;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 *
 * @author Felipe Rabelo
 */
public class JanelaConfiguraCombate extends JFrame {
    private JButton voltar;
    private JButton [] jogador;
    private File ficha;
    private JPanel painel;
    
    public JanelaConfiguraCombate () {
        super("Configurações da Batalha");
        
        setLayout(new BorderLayout());
        setVisible(true);
        voltar = new JButton ("Voltar");
        painel = new JPanel();
        JScrollPane scroll = new JScrollPane(painel);
        painel.setLayout(new GridBagLayout());
        add(painel, BorderLayout.CENTER);
        add(voltar, BorderLayout.SOUTH);
        
        GridBagConstraints c = new GridBagConstraints ();
        c.insets = new Insets (2, 2, 2, 2);
        
        painel.setBackground(Color.BLACK);
        
        ficha = new File("C:\\Users\\Felipe Rabelo\\Documents\\RPGs\\RPG - Skyrim\\Jogadores");
        jogador = new JButton [ficha.listFiles().length];
        
        for (JButton i : jogador) {
            i = new JButton();
            add(i);
        }
        
        JanelaConfiguraCombate.Event onclick = new JanelaConfiguraCombate.Event();
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
                
                JanelaIniciar open = new JanelaIniciar();
                open.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                open.setSize(250, 250);
                open.setLocation(500, 30);
                open.setVisible(true);
            }
        }
          
    }
}
