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
    
        
}