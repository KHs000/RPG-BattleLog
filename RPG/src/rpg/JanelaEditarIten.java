

package rpg;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 *
 * @author Felipe Rabelo
 */
public class JanelaEditarIten extends JFrame{
    private File pastaIten;
    private File [] iten;
    private JButton voltar;
    private JButton [] itenButton;
    private JPanel areaConteudo;
    private String [] nomeIten;
    
    public JanelaEditarIten () throws IOException {
        super ("Editar Item");
        
        setLayout(new BorderLayout());
        setVisible(true);
        voltar = new JButton ("Voltar");
        areaConteudo = new JPanel();
        areaConteudo.setLayout(new FlowLayout());
        JScrollPane jsp = new JScrollPane(areaConteudo);
        add(jsp, BorderLayout.CENTER);
        add(voltar, BorderLayout.SOUTH);
        
        Event e = new Event ();
        
        pastaIten = new File ("C:\\Users\\Felipe Rabelo\\Documents\\RPGs\\RPG - Skyrim\\Itens");
        if (pastaIten.listFiles().length > 0) {
            itenButton = new JButton [pastaIten.listFiles().length];
            iten = new File[pastaIten.listFiles().length];
            iten = pastaIten.listFiles();int index = 0;
            ItenRead ficha = new ItenRead();
            nomeIten = ficha.getNomeIten();
            for (int i = 0 ; i < itenButton.length ; i++) {
                itenButton[i] = new JButton(nomeIten[index]);
                itenButton[i].setName(nomeIten[index]);
                areaConteudo.add(itenButton[i]);
                ActionListener event = (ActionEvent e1) -> {
                    String name1 = new Button().getName((JButton) e1.getSource());
                    JanelaAlteraFichaIten obj = new JanelaAlteraFichaIten(name1);
                    obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    obj.setLocation(500, 30);
                    obj.setVisible(true);
                    encerrar();
                };
                itenButton[i].addActionListener(event);
                index++;
            }
        } 
        
        voltar.addActionListener(e);
    }
    
    public final void encerrar () {
        this.dispose();
    }
    
    private class Event implements ActionListener {
        @Override
        public void actionPerformed (ActionEvent e) {
            if (e.getSource() == voltar) {
                encerrar();
                
                JanelaConfiguraIten open = new JanelaConfiguraIten ();
                open.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                open.setSize(400, 400);
                open.setLocation(450, 30);
                open.setVisible(true);
            }
        }
    }
    
    private class Button {
        public String getName (JButton b) {return b.getName();}
    }
}
