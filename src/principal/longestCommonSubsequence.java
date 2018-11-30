package principal;

/*classe contendo algoritmos para manipulacao da maior sequencia comum entre duas palavras*/
public class longestCommonSubsequence {
    /*armazena a sequencia*/
    private String palavraComum = "";
    /*armazena a quantidade de caracteres da sequencia*/
    private int maiorSequencia = 0;

    public String getPalavraComum() {
        return palavraComum;
    }
    public int getMaiorSequencia() {
        return maiorSequencia;
    }
    
    /*funcao lcs: manipula duas strings informadas por parametros
     *a fim de obter a quantidade de caracteres na sequencia e a propria
     *sequencia comum*/
    public int[][] lcs(String x, String y){
        int m = x.length(); /*primeira palavra*/
        int n = y.length(); /*segunda palavra*/
        int c[][] = new int[m+1][n+1];
        int i,j;
        
        /*zera a linha 0 e coluna 0 da matriz c*/
        for (i=1; i<=m;i++) {
            c[i][0] = 0;
        }
        for (i=1; i<=n;i++) {
            c[0][i] = 0;
        }
        
        /*percorre cada caractere de ambas palavras veriricando sua igualdade*/
        for (i=1; i<=m; i++) {
            for (j=1; j<=n; j++) {
                if (x.charAt(i-1) == y.charAt(j-1)) {
                    /*caracteres comparados sejam iguais é feita a soma
                     *para guardar informacao da sequencia comum*/
                    c[i][j] = c[i-1][j-1] + 1;
                }else {
                    c[i][j] = Integer.max(c[i-1][j],c[i][j-1]);
                }
            }
        }
        
        /*percorre a ultima linha da matriz a fim de obter os caracteres iguais
         *e formar de fato a sequencia comum.
         *eh feito uma comparacao de tamanho entre as palavras a fim de percorer
         *a palavra mais curta na composicao da sequencia.*/
        if (m >= n) { //primeira palavra maior
            for (j=1; j<=n; j++) { //percorre a segunda palavra, ultima linha da matriz
                if (c[m][j] != c[m][j-1]) {
                    this.palavraComum = this.palavraComum + y.charAt(j-1);
                }
            }
        }else { //segunda palavra maior
            for (i=1; i<=m; i++) { //percorre a primeira palavra, ultima coluna da matriz
                if (c[i][n] != c[i-1][n]) {
                    this.palavraComum = this.palavraComum + x.charAt(i-1);
                }
            }
        }
        
        this.maiorSequencia = c[m][n];
        return c;
    }
   
    /*      usado em testes*/
    //print matriz
    public void printMatriz(int[][] m) {
        int lin = m.length;
        int col = m[0].length;
        for (int i=0; i<lin; i++) {
            System.out.print("| ");
            for (int j=0; j<col; j++) {
                System.out.print(m[i][j] + "| ");
            }
            System.out.print("\n");
        }
        System.out.print("\n");
    }
    
}
