public class Pagina{
    public int [] chaves; // Vetor de chaves
    private int t; //Define o intervalo de chaves que a página pode ter
    public Pagina [] filhos; // Vetor de filhos
    public int numero; // Número de chaves atualmente na página
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

    public int buscaBinaria(int chave){
        int esquerda = 0;
        int direita = this.numero - 1;
        while(esquerda <= direita){
            int meio = esquerda + (direita - esquerda) / 2 ;
        
            if(chaves[meio] == chave){
                //Encontrou 
                return chave;
            }
            if(chaves[meio] < chave){ 
                esquerda = meio + 1; //Busca na direita
            }
            else{
                direita = meio - 1; //Busca na esquerda
            }
    }
        return -(esquerda + 1); //Não encontrou
}
    public void inserirNaoCheio(int chave){
        //Criando uma nova página
        int indice = numero - 1;
        if(folha){
            while(indice >= 0 && chaves[indice] > chave){
                chaves[indice+1] = chaves[indice];
                indice--;
        }
        //Inserindo a chave na página
        chaves[indice+1] = chave;
        numero++;
    }
        else{
            // Encontra o filho que terá a nova chave
            while(indice >= 0 && chaves[indice] > chave){
                indice--;
            }
            //Verifica se a página filho está cheia
            if(filhos[indice + 1].numero==2*t-1){
                // Se o filho está cheio, divide-o
                dividirFilho(indice + 1, filhos[indice+1]);
                //Depois de dividir, a chave do meio de filhos[indice] sobe para a página atual e  
                //filhos[indice] é dividido m dois. Verifica em qual dos dois filhos a chave deve ser inserida
                if(chaves[indice + 1] < chave){
                    indice++;
                }
                filhos[indice + 1].inserirNaoCheio(chave);
            }
        }
    }

        public void dividirFilho(int indice, Pagina pagina){
            Pagina novaPagina = new Pagina(pagina.getT(), pagina.getFolha());
            pagina.numero = t - 1;
            // Copia as chaves da página para a nova página
            for(int i = 0 ; i < t - 1 ; i++){
                novaPagina.chaves[i] = pagina.chaves[i+t];
            }
            // Copia os filhos da página para a nova página, se não for folha
            if(!pagina.folha){
                for(int i = 0 ; i < t ; i++){   
                    novaPagina.filhos[i] = pagina.filhos[i+t];
                }
                // Reduz o número de chaves da página atual
                pagina.numero = t - 1;
                // Como esta página vai ter um novo filho, cria espaço para o novo filho
                //Como esta pagina vai ter um novo filho, cria um espaço para o filho novo.
                for(int i = numero ; numero >= indice + 1 ; i--){
                    filhos[i+1] = filhos[i];
                }
                // Coloca o novo filho na posição correta
                
                filhos[indice + 1] = novaPagina;
                //Move as chaves uma posição para a frente
                for(int i = numero - 1 ; i >= indice ; i--){
                    chaves[i+1] = chaves[i];
                }
                // Coloca a chave do meio de y na posição correta na página atua
                chaves[indice] = novaPagina.chaves[t-1];        
                // Incrementa o número de chaves na página atual
                numero++;
        

                }

            }
    }
        
