

package rpg;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Felipe Rabelo
 */
public class JanelaFichaJogador extends JFrame {
    private File [] jogadorLista;
    private final File jogadorPasta;
    private JButton jogadorTemp;
    private JButton [] jogador;
    private JButton voltar;
    private JPanel areaConteudo;
    private final String local;
    private String [] jogadorNome;
    private final JFileChooser path = new JFileChooser();
    
    public JanelaFichaJogador () throws IOException {
        super ("Jogadores");
        
        setLayout(new BorderLayout ());
        areaConteudo = new JPanel (new FlowLayout());
        
        ConfiguracoesSalvas temp = new ConfiguracoesSalvas ();
        if (temp.Exists() && temp.checaPath("Skyrim-Jogadores")) {local = temp.SelecionaPath("Skyrim-Jogadores");}
        else {
            path.setCurrentDirectory(new java.io.File("."));
            path.setDialogTitle("Selecione a pasta");
            path.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            path.setAcceptAllFileFilterUsed(false);
            if (path.showOpenDialog(path) == JFileChooser.APPROVE_OPTION) {
                local = path.getSelectedFile().toString() + "\\";
                temp.SalvaConfiguracoes(local, "Skyrim-Jogadores");
            }
            else {local = null;}
        }
        
        jogadorPasta = new File (local);
        if (jogadorPasta.listFiles().length > 0) {
            jogadorLista = new File [jogadorPasta.listFiles().length];
            jogadorLista = jogadorPasta.listFiles();
            jogadorNome = new String[jogadorPasta.listFiles().length];int index = 0;
            String aux;
            for (File i : jogadorLista) {
                if (i.canRead()) {
                    BufferedReader br = new BufferedReader(new FileReader(i));
                    while (br.ready()) {
                        aux = br.readLine();
                        if (aux.substring(0, 4).equals("Nome")) {jogadorNome[index] = aux.substring(5);index++;}
                    }
                }
            }
            Event e = new Event ();
            
            jogador = new JButton [jogadorNome.length];
            for (int i = 0 ; i < jogador.length ; i++) {
                jogador[i] = new JButton (jogadorNome[i]);
                areaConteudo.add(jogador[i]);
                jogador[i].addActionListener(e);
            }
        }
        else {JOptionPane.showMessageDialog(null, "Não há jogadores");encerrar();}
        
        add(areaConteudo, BorderLayout.CENTER);
        voltar = new JButton ("Voltar");
        add(voltar, BorderLayout.SOUTH);
        voltar.addActionListener(new Event());
    }
    
    public void encerrar () {
        this.dispose();
    }
    
    private class Event extends MostraFichaJogador implements ActionListener{
      @Override
      public void actionPerformed( ActionEvent event ){
         if (event.getSource() == voltar) {
             encerrar();
             
            JanelaFicha open = new JanelaFicha();
             open.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
             open.setSize(250, 250);
             open.setLocation(500, 30);
             open.setVisible(true);
         }
         if (event.getSource() instanceof JButton && event.getSource() != voltar) {
             try {
                 PlayerRead player = new PlayerRead (((JButton)event.getSource()).getText());
                 MostraFichaJogador sheet = new MostraFichaJogador ();
                 
                 player.setName();
                 sheet.campoNome.setText(player.getName());
                 sheet.campoNome.setEditable(false);
                 JOptionPane.showMessageDialog(null, player.getName());
                 
                 player.setHP();
                 sheet.campoHP.setText(player.getHP());
                 sheet.campoHP.setEditable(false);
                 JOptionPane.showMessageDialog(null, player.getHP());
                 
                 sheet.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                 sheet.setLocation(470, 30);
                 sheet.setVisible(true);
             } catch (IOException ex) {
                 Logger.getLogger(JanelaFichaJogador.class.getName()).log(Level.SEVERE, null, ex);
             }
         }
      }
   }
}
