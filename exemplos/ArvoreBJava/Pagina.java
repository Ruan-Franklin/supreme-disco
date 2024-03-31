public class Pagina{
    int [] chaves; // Vetor de chaves
    int t; //Define o intervalo de chaves que a página pode ter
    Pagina [] filhos; // Vetor de filhos
    int numero; // Número de chaves atualmente na página
    boolean folha; // Indica se a página é folha ou não

    // Construtor
    public Pagina(int t, boolean folha){
        this.t = t;
        this.folha = folha;
        chaves = new int[2*t-1];
        filhos = new Pagina[2*t];
        numero = 0;
    }
}