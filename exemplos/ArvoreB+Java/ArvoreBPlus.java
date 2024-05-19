public class ArvoreBPlus {
    private Pagina raiz;
    private int t;

    public ArvoreBPlus(int t){
        this.raiz = null;
        this.t = t;
    }

    public void inserir(int chave, Object dado) throws InsercaoInvalidaExcecao{
        if(raiz == null){
            raiz = new Pagina(t, true);
            raiz.inserir(chave, dado);
        }
        else{
            // Se a raiz estiver cheia, divida-a antes de inserir a nova chave.
            if(raiz.getNumero() == 2*t - 1){
                //Nova raiz não é folha, então ela não tem pai.
                Pagina novaRaiz = new Pagina(t, false);
                novaRaiz.filhos[0] = raiz;
                raiz.setPai(novaRaiz);
                novaRaiz.dividirFilho(0, raiz);
                raiz = novaRaiz;
        }
        Pagina pagina = raiz;
        while(!pagina.isFolha()){
            int i = pagina.buscaBinaria(chave);
            // Se i for negativo, então a chave não está na página.
            if(i <0){
                i = -(i+1);
            }
            if (pagina.filhos[i].getNumero() == 2 * t - 1) {
                pagina.dividirPagina(i, pagina.filhos[i]);
                if(chave > pagina.getChave(i)){
                    i++;
                }
    }
    pagina = pagina.filhos[i];
}
    pagina.inserir(chave, dado);
    }
 }
    
        public Object buscar(int chave) throws ArvoreVaziaExcecao{
            if(raiz == null){
                throw new ArvoreVaziaExcecao("A árvore está vazia!");
            }
            else{
                return buscar(chave, raiz);
            }
        }
        private Object buscar(Pagina pagina, int chave){
            int i = pagina.buscaBinaria(chave);
            
            if(i>=0){
                return pagina.getDado(i);
            }
            else if(pagina.isFolha()){
            // Se a chave não está na página e a página é folha, então a chave não está na árvore.
                throw new ChaveInvalidaExcecao("Chave inválida: a chave não está na árvore");
        }
        else{
            //A chave não está na pagina e a página não é uma folha
            //Segue para a subárvore apropriada.
            int indiceFilho = -(i +1);
            return buscar(pagina.filhos[indiceFilho], chave);
        }
        }

        public void remover(int chave) throws RemocaoInvalidaExcecao, ArvoreVaziaExcecao{
           
            if(raiz == null){
                throw new ArvoreVaziaExcecao("A árvore está vazia");
            }
            else{
                //Se a raiz tiver 0 chaves, então  a tornamos a única filha da raiz
                remover( raiz, chave);
                if(raiz.getNumero() == 0){
                    Pagina tmp = raiz;
                    if(raiz.isFolha()){
                        raiz = null;
                    }
                    else{
                        raiz = raiz.filhos[0];
                    }
                    tmp = null; //Libera a memória
                }
            }
        }
        private void remover(Pagina pagina, int chave){
            int i = pagina.buscaBinaria(chave);
            //Se a chave está na página
            if(i > 0 ){
                //Se a página é uma folha
                if(pagina.isFolha()){ //Remove sem nenhum problema
                    pagina.remover(i);
                }
                else { //A chave está em uma página não folha
                    
                    Pagina sucessora = pagina.filhos[i+1];
                   
                    while(!sucessora.isFolha()){
                        sucessora = sucessora.filhos[0];

                   }
                   
                   int chaveSucessora = sucessora.getChave(0);
                   Object dadoSucessor = sucessora.getDado(0);
                   remover(sucessora, chaveSucessora);
                   pagina.setChave(i, chaveSucessora);
                   pagina.setDado(i, dadoSucessor);
                }
                else{
                    if(pagina.isFolha()){
                        throw new RemocaoInvalidaExcecao("Remoção inválida: a chave não está na árvore");
                    }                   
                    int indiceFilho = - (i + 1);
                    Pagina filho = pagina.filhos[indiceFilho];
                    if(filho.getNumero() == t -1){
                        Pagina irmaoEsquerdo = null;
                        Pagina irmaoDireito = null;

                    }
                    if( filho.getNumero() == t -1){
                        Pagina irmaoEsquerdo = null;
                    }
                
                    
                    if(indiceFilho > 0 ){
                        irmaoEsquerdo = pagina.filhos[indiceFilho -1];

                    }
                   
                    
                    if(indiceFilho < pagina.getNumero()){
                        irmaoDireito = pagina.filhos[indiceFilho + 1];

                    }

                    if(irmaoEsquerdo != null && irmaoEsquerdo.getNumero() >= t){
                        filho.inserir(pagina.getChave(indiceFilho - 1), pagina.getDado(indiceFilho - 1));
                        pagina.setChave(indiceFilho - 1, irmaoEsquerdo.getChave(irmaoEsquerdo.getNumero() - 1));
                        pagina.setDado(indiceFIlhoIrmaoEsquerdo -1, irmaoEsquerdo.getDado(irmaoEsquerdo.getNumero() - 1));
                        irmaoEsquerdo.remover(irmaoEsquerdo.getNumero() -1);
                    }
                    else if(irmaoDireito != null && irmaoDireito.getNumero() >= t){
                        
                        filho.inserir(pagina.getChave(indiceFilho), pagina.getDado(indiceFilho));
                        pagina.setChave(indiceFilho, irmaoDireito.getChave(0));
                        pagina.setDado(indiceFilho, irmaoDireito.getDado(0));
                        irmaoDireito.remover(0);
                
                    }
                    else{
        
                        if(irmaoDireito != null){
                            
                            filho.fundirComIrmaoDireito(pagina, indiceFilho);
                        }
                        else{                            
                            filho.fundirComIrmaoEsquerdo(pagina, indiceFilho -1);
                        }
                    }

                }
                remover(filho, chave);
    

        
}