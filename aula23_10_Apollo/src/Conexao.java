import java.io.*;
import java.util.*;

public class Conexao {
    static final String ARQUIVO = "nome.txt";

    static List<String> ler() {
        List<String> nomes = new ArrayList<>();
        try (BufferedReader r = new BufferedReader(new FileReader(ARQUIVO))) {
            String l; while ((l = r.readLine()) != null) nomes.add(l.trim());
        } catch (FileNotFoundException e) {}
        catch (IOException e) { System.out.println("Erro: " + e.getMessage()); }
        return nomes;
    }

    static void gravar(List<String> nomes) {
        try (BufferedWriter w = new BufferedWriter(new FileWriter(ARQUIVO))) {
            for (String n : nomes) w.write(n + "\n");
        } catch (IOException e) { System.out.println("Erro: " + e.getMessage()); }
    }

    public static boolean incluirNome(String nome) {
        List<String> nomes = ler();
        if (nomes.contains(nome)) { System.out.println("Nome já existe."); return false; }
        nomes.add(nome); gravar(nomes);
        System.out.println("Nome '" + nome + "' incluído com sucesso!");
        return true;
    }

    public static boolean alterarNome(String antigo, String novo) {
        List<String> nomes = ler();
        int i = nomes.indexOf(antigo);
        if (i == -1) { System.out.println("Nome não encontrado."); return false; }
        nomes.set(i, novo); gravar(nomes);
        System.out.printf("Nome '%s' alterado para '%s'.\n", antigo, novo);
        return true;
    }
}
