

package rpg;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Felipe Rabelo
 */
public class ConfiguracoesSalvas {
    private File configuracoes;
    private String path;
    
    public ConfiguracoesSalvas () {
        configuracoes = new File ("Configurações.txt");
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
    
    public boolean Exists () {
        return configuracoes.exists();
    }
    
    public void SalvaConfiguracoes (String path, String key) throws IOException {
        try (BufferedWriter fw = new BufferedWriter(new FileWriter(configuracoes, true))) {
                fw.write(key + ":" + path);
                fw.newLine();
                fw.close();
            }
    }
    
    public String SelecionaPath (String key) throws IOException{
        String diretorio = null;
        String aux;
        
        try (BufferedReader br = new BufferedReader (new FileReader (configuracoes))) {
            while (br.ready()) {
                aux = br.readLine();
                if (aux.startsWith(key)) {
                    diretorio = aux.substring(key.length() + 1);
                }
            }
        }
        return diretorio;
    }
    
    public boolean checaPath (String key) throws IOException {
        boolean flag = false;
        String aux;
        
        try (BufferedReader br = new BufferedReader (new FileReader (configuracoes))) {
            while (br.ready()) {
                aux = br.readLine();
                if (aux.startsWith(key)) {flag = true;}
            }
        }
        
        return flag;
    }
}
