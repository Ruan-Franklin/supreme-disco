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

            public void removerChave(int chave){
                int indice = buscaBinaria(chave);
                
                //A chave está presente nessa página.  
                if (indice < numero && chaves[indice] == chave){
                    //Se a página é uma folha. remove a chave diretamente.
                    
                    //Se a chave é uma folha, remove a chave diretamente
                    if(folha){
                        for(int i = 0 ; i < numero ; ++i){                            
                            chaves[i-1] = chaves[i]; //Move todas as chaves após a chave a ser removida uma posição para trás
                        }
                        numero--; //Decrementa o número de chaves   
                        }
                    else{
                         //SE a chave não é uma folha, substitua a chave pelo predecessor ou sucessor
                           // e remova o predecessor ou sucessor
                           //Substituir a chave pelo maior elemento da subárvore esquerda
                            if(filhos[indice].numero >= t){
                                 int antecessor = getChaveAntecessora(indice);
                                 chaves[indice] = antecessor;
                                 filhos[indice].removerChave(antecessor);
                            }
                        }
                    }
                else{
                    //A chave não está presente nesta página ,desce para o filho apropriado.
                    if(folha){
                        //CHave fora da árvore
                        System.out.println( "A chave " + chave + " não está presente na árvore");
                    }
                    else{
                        /// O filho onde a chave deve estar tem apenas t-1 chaves
                        // Então, precisamos ajustar a árvore antes de descer para o filho
                        if(filhos[indice].numero == t-1){
                            //Se o filho tem menos de t chaves, preenche o filho
                            if(indice != numero && filhos[indice+1].numero >= t){
                                //Se o filho seguinte tem mais de t-1 chaves, empresta uma chave
                                emprestarDoProximo(indice);
                            }
                            else if(indice != 0 && filhos[indice-1].numero >= t){
                                //Se o filho anterior tem mais de t-1 chaves, empresta uma chave
                                emprestarDoAnterior(indice);
                            }
                            else{
                                //Se os filhos anterior e seguinte têm t-1 chaves, funde o filho com um dos filhos
                                if(indice != numero){
                                    fundir(indice);
                                }
                                else{
                                    fundir(indice-1);
                                }
                            }
                        }
                 }
            }
            }
                


            public int getChaveAntecessora(int indice){
                Pagina atual = filhos[indice];
                while(!atual.folha){
                    atual = atual.filhos[atual.numero];
                }
                return atual.chaves[atual.numero - 1];
            }

            //Emprestar do anterior
            public void emprestarDoAnterior(int indice){
                Pagina filho = filhos[indice];
                
                Pagina irmao = filhos[indice-1];
                //A última chave do irmão vai para a página atual
                for(int i = filho.numero ; i >= 0 ; i--){
                    filho.chaves[i+1] = filho.chaves[i];
;                }
                //Se a página atual não é folha, move todos os filhos uma posição para frente
                if(!filho.folha){
                    for(int i = filho.numero ; i >= 0 ; i--){
                        filho.filhos[i+1] = filho.filhos[i];
                       
                    }
                }
                
                //A última chave de irmao vai para a primeira posição de chaves da página atual                
                filho.chaves[0] = chaves[indice-1];
                                
                //Se a página atual não é folha, move o último filho de irmao como o primeiro filho de filho
                if(!filho.folha){
                    filho.filhos[0] = irmao.filhos[irmao.numero];
                }
                //Decrementa o número de chaves de irmao
               
                irmao.numero--;
                //Aumenta o número de chaves de filho
               
                filho.numero++;
            }
        

            //Emprestar do próximo
            public void emprestarDoProximo(int indice){
                Pagina filho = filhos[indice];
                Pagina irmao = filhos[indice+1];
                //A última chave de filho vai para a página atual
                filho.chaves[filho.numero] = chaves[indice];
                //A primeira chave de irmao vai para a posição de chaves[indice]
                chaves[indice] = irmao.chaves[0];
                //Se irmao não é folha, move todas as chaves uma posição para trás
                if(!irmao.folha){
                    for(int i = 0 ; i < irmao.numero -1 ; i++){
                        irmao.chaves[i] = irmao.chaves[i+1];
                    }
                    //Move os filhos uma posição para trás
                    for(int i = 0 ; i < irmao.numero ; i++){
                        irmao.filhos[i] = irmao.filhos[i+1];
                    }
                }
                // A primeira chave de irmao vai para a última chave de filho

                if(!filho.folha){
                    filho.filhos[filho.numero+1] = irmao.filhos[0];
                }
                //Decrementa o número de chaves de irmao
                irmao.numero--;
            }

            public void fundir(int indice){
                Pagina filho = filhos[indice];
                Pagina irmao = filhos[indice + 1];
                //Puxando a chave da página pai para a última posição das chaves da página filho
                filho.chaves[t-1] = chaves[indice];
                //Copiando as chaves da página irmã para a página filho
                for(int i = 0 ; i < irmao.numero ; i++){
                    filho.chaves[i+t]  = irmao.chaves[i] ;         
                }
                //Copiando os filhos da página irmã para a página filho
                if(!filho.folha){
                     for(int i = 0 ; i <= irmao.numero ; i++){
                        filho.filhos[i+t] = irmao.filhos[i];                   }
                    }
                
                //Movendo todas as chaves na página pai para trás para preencher o espaço vazio.
                for(int i = indice+1; i < numero ; i++){
                    chaves[i-1] = chaves[i];
                }
                    // Movendo todos os filhos na página pai uma posição para trás
                
                //Movendo todos os filhos na posição pai uma página para trás
                for(int i = indice+2 ; i < numero ; i++){
                    filhos[i-1] = filhos[i];
            }
            //Atualizando o número de chaves na página filho e na página pai
           
            filho.numero += irmao.numero+1;
           //Liberando a memória ocupada pela página irmã
            numero--;            
        }
    }
           
