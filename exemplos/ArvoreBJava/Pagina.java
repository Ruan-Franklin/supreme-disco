public class Pagina{
    private int [] chaves; // Vetor de chaves
    private int t; //Define o intervalo de chaves que a página pode ter
    private Pagina [] filhos; // Vetor de filhos
    private int numero; // Número de chaves atualmente na página
    private boolean folha; // Indica se a página é folha ou não
    private Pagina pai; // Página pai

    // Construtor
    public Pagina(int t, boolean folha){
        this.t = t;
        this.folha = folha;
        chaves = new int[2*t-1];
        filhos = new Pagina[2*t];
        numero = 0;
        pai = null;
    }
    
    public Pagina getPai(){
        return this.pai;
    }

    public void setPai(Pagina pai){
        this.pai = pai;
    }

    public int getNumero(){
        return this.numero;
    }

    public void setNumero(int numero){
        this.numero = numero;
    }

    public int getT(){
        return this.t;
    }

    public void setT(int t){
        this.t = t;
    }

    public boolean getFolha(){
        return this.folha;
    }

    public void setFolha(boolean folha){
        this.folha = folha;
    
    }

    public int getChave(int i){
        return this.chaves[i];
    }

    public void setChave(int i, int chave){
        this.chaves[i] = chave;
    }

    public Pagina getFilho(int i){
        return this.filhos[i];
    }

    public void setFilho(int posicao, Pagina filho){
        this.filhos[posicao] = filho;
    }

}