

package rpg;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;

/**
 *
 * @author Felipe Rabelo
 */
public class JanelaConfiguraCombate extends JFrame {
    private JButton voltar;
    private JButton confirma;
    private JCheckBox [] jogador;
    private File pastaJogador;
    private File [] ficha;
    private JPanel painelCentral;
    private JPanel painelJogador;
    private JPanel painelOponente;
    
    public JanelaConfiguraCombate () {
        super("Configurações da Batalha");
        
        setLayout(new BorderLayout());
        setVisible(true);
        voltar = new JButton ("Voltar");
        painelCentral = new JPanel();
        painelCentral.setLayout(new BorderLayout());
        add(painelCentral, BorderLayout.CENTER);
        add(voltar, BorderLayout.SOUTH);
        
        confirma = new JButton ("Confirma");
        painelCentral.add(confirma, BorderLayout.SOUTH);
        
        GridBagConstraints c = new GridBagConstraints ();
        c.insets = new Insets (2, 2, 2, 2);
        
        painelJogador = new JPanel();
        painelJogador.setLayout(new GridBagLayout());
        painelJogador.setBackground(Color.BLACK);
        JScrollPane jsp1 = new JScrollPane(painelJogador);
        painelCentral.add(jsp1, BorderLayout.WEST);
        
        painelOponente = new JPanel();
        painelOponente.setLayout(new GridBagLayout());
        painelOponente.setBackground(Color.BLACK);
        JScrollPane jsp2 = new JScrollPane(painelOponente);
        painelCentral.add(jsp2, BorderLayout.EAST);
        
        pastaJogador = new File("C:\\Users\\Felipe Rabelo\\Documents\\RPGs\\RPG - Skyrim\\Jogadores");
        jogador = new JCheckBox [pastaJogador.listFiles().length];
        ficha = new File [pastaJogador.listFiles().length];
        ficha = pastaJogador.listFiles();
        
        for (int i = 0 ; i < ficha.length ; i++) {
            if (ficha[i].canRead() == true) {
                try (BufferedReader b = new BufferedReader(new FileReader(ficha[i]))) {
                    String aux;
                    while (b.ready()) {
                        aux = b.readLine();
                        if (aux.startsWith("Nome:")){
                            jogador[i] = new JCheckBox(aux.substring(5));
                            jogador[i].setBackground(Color.BLACK);
                            jogador[i].setForeground(new Color(255, 255, 255));
                            c.gridy = i;c.gridx = 0;
                            c.gridwidth = 1;
                            c.fill = GridBagConstraints.HORIZONTAL;
                            painelJogador.add(jogador[i], c);
                        }
                    }
                } catch (IOException e) {
                    e.getMessage();
                }
            }
        }
        
        JanelaConfiguraCombate.Event onclick = new JanelaConfiguraCombate.Event();
        
        confirma.addActionListener(onclick);
        voltar.addActionListener(onclick);
    }
    
    public void encerar () {
        this.dispose();
    }
    
    private class Event implements ActionListener {
        
        @Override
        public void actionPerformed(ActionEvent event) {
            if (event.getSource() == confirma) {
                Auxiliar obj = new Auxiliar();
                String [] namePlayer = new String [jogador.length];
                for (int i = 0 ; i < jogador.length ; i++) {
                    if (jogador[i].isSelected()) {
                        namePlayer[i] = "C:\\Users\\Felipe Rabelo\\Documents\\RPGs\\RPG - Skyrim\\Jogadores\\"
                                + jogador[i].getText();
                    }
                }
            }
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
