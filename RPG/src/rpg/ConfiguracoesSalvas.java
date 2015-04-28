

package rpg;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
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
        try (FileWriter fw = new FileWriter(configuracoes, true )) {
                fw.write(key + ":" + path);
                fw.close();
            }
    }
    
    public String SelecionaPath (String key) throws IOException{
        String diretorio = null;
        
        try (BufferedReader br = new BufferedReader (new FileReader (configuracoes))) {
            while (br.ready()) {
                String aux = br.readLine();
                if (aux.startsWith(key)) {
                    diretorio = aux.substring(key.length() + 1);
                }
            }
        }
        return diretorio;
    }
}
