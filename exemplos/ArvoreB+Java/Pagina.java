public class Pagina {
    private int [] chaves; //Vetor de chaves de indexação
    private Object [] dados; //Vetor de dados na folha   
    private int t; //Grau mínimo da árvore 
    private int numero; //Número de chaves atualmente na página
    private boolean folha; //Verdadeiro se a página é folha, falso caso contrário
    private Pagina pai; //Ponteiro para a página pai
    private Pagina [] filhos; //Vetor de ponteiros para as subárvores
    public Pagina(int t, boolean folha){
        this.t = t;
        this.folha = folha;
        chaves = new int[2 * t -1];
        dados =  folha ? new Object [2 * t -1] : null;
        numero = 0;
        pai = null;
        }

        public int getChave(int indice){
            return chaves[indice];
        }
        public void setChave(int indice, int chave){
            chaves[indice] = chave;
        }
        public Object getDado(int indice){
            return dados[indice];
        }

        public int getT(){
            return this.t;
        }

        public void setT(int t){
            this.t = t;
        }

        public void setDado(int indice, Object dado){
            dados[indice] = dado;
        }
        public boolean isFolha(){
            return folha;
        }

        public int getNumero(){
            return this.numero;
        }

        public void setNumero(int numero){
            this.numero = numero;
        }

        public Pagina getPai(){
            return this.pai;
        }

        public void setPai(Pagina pai){
            this.pai = pai;
        }

        public int buscaBinaria(int chave){
            //Busca binária
            int esquerda = 0;
            //O número de chaves na página
            int direita = this.numero - 1;
            //Enquanto a esquerda for menor ou igual à direita
            while(esquerda <= direita){
                int meio = esquerda + (direita - esquerda) /2;
                
                if(chaves[meio] == chave){
                    //encontrou
                    return chave;
                }
                //Se a chave é menor que a chave do meio, busca na subárvore esquerda
                if(chaves[meio] < chave){
                    esquerda = meio + 1; //Busca na subárvore esquerd
                }
                else{
                    direita = meio -1; //Busca na subárvore direita
                }
            }
            return - (esquerda +1); //Não encontrou a chave     
        }
        public void inserir(int chave, Object dado)throws InsercaoInvalidaExcecao{
            if(!folha){
                throw new InsercaoInvalidaExcecao("Inserção inválida: a página não é folha");
            }
            if(numero == 2*t-1){
                dividirPagina();
            }
            int i = numero - 1;
            //Se a página está vazia
            if(numero == 0){
                chaves[0] = chave;
                dados[0] = dado;
                numero++;
                return;
            }
            //Se a chave é menor que a primeira chave
            if(chave < chaves[0]){
                for(int j = numero; j > 0; j--){
                    //Desloca as chaves e os dados para a direita
                    chaves[j] = chaves[j - 1];
                    dados[j] = dados[j - 1];
                }
                //Insere a chave e o dado na primeira posição
                chaves[0] = chave;
                dados[0] = dado;
                numero++;
                return;
            }
            //Se a chave é maior que a última chave
            if(chave > chaves[numero - 1]){
                chaves[numero] = chave;              
                dados[numero] = dado;
                numero++;
                return;
            }
            //Desloca as chaves e os dados para a direita
            while(i >= 0 && chave < chaves[i]){
                chaves[i+1] = chaves[i];
                dados[i+1] = dados[i];
                i--;
            }
            chaves[i+1] = chave;            
            dados[i + 1] = dado;
            numero++;
        }
        //Divide a página
        public void dividirPagina(){
            //Cria uma nova pagina
            Pagina novaPagina = new Pagina(t, folha);
            //A nova página não é folha            
            novaPagina.folha = folha;
            //A nova página tem t-1 chaves que é a metade da página atual
            novaPagina.numero = t-1;
            // Copia as chaves e os dados da página atual para a nova página
            for(int i = 0; i < t - 1; i++){
                novaPagina.chaves[i] = chaves[i+1];                
                novaPagina.dados[i] = dados[i+1];
            }
            //Se a página não é folha, copia os ponteiros para as subárvores
            if(!folha){
                for(int i = 0; i < t; i++){                   
                    novaPagina.filhos[i] = filhos[i+t];
                }
            }
            //Reduz o número de chaves na página atual
            numero = t - 1;
            //Se a página é folha, insere a chave mediana na página pai
            if(folha){
                //Desloca as chaves e os dados para a direita
                for(int i = pai.numero; i > 0; i--){
                    pai.chaves[i] = pai.chaves[i - 1];
                    pai.dados[i] = pai.dados[i - 1];
                }
                //Insere a chave mediana na página pai
                pai.chaves[0] = chaves[t - 1];
                pai.dados[0] = dados[t - 1];
                //Incrementa o número de chaves na página pai
                pai.numero++;
                //Ajusta os ponteiros
                pai.filhos[pai.numero] = this;
              
                pai.filhos[pai.numero+1] = novaPagina;
            }
        }



    
}
