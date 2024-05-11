public class ArvoreBPlus {
    private Pagina raiz;
    private int t;

    public ArvoreBPlus(int t){
        this.raiz = null;
        this.t = t;
    }

    public void inserir(int chave, Object dado) throw InsercaoInvalidaExcecao{
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
                
                

            
    }
}
 