public class Pagina {
    private int [] chaves; //Vetor de chaves de indexação
    private Object [] dados; //Vetor de dados na folha   
    private int t; //Grau mínimo da árvore 
    private int numero; //Número de chaves atualmente na página
    private boolean folha; //Verdadeiro se a página é folha, falso caso contrário
    private Pagina pai; //Ponteiro para a página pai

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

    
}
