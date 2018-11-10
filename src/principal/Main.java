package principal;
import entradaSaidaDados.*;

public class Main {

    public static void main(String[] args) {
        LE le = new LE();
        longestCommonSubsequence l = new longestCommonSubsequence();
        
        /*leitura das palavras*/
        String palavra1 = le.readStringPane("Palavra 1: ");
        String palavra2 = le.readStringPane("Palavra 2: ");
        
        /*exibe no terminal*/
        System.out.println("Palavra 1: "+palavra1);
        System.out.println("Palavra 2: "+palavra2+"\n\n");
        
        /*funcao do LCS*/
        l.lcs(palavra1,palavra2);
        
        /*exibe a maior sequencia e os caracteres no terminal*/
        System.out.println("Quantidade de caracteres na LCS: "+l.getMaiorSequencia());
        System.out.println("Caracteres da LCS: "+l.getPalavraComum()+"\n\n");
    }
    
}
