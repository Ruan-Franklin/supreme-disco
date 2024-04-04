public class ArvoreB implements IArvoreB{

    private Pagina raiz;
    private int t;
    private int tamanho;

    public ArvoreB(int t){
        this.t = t;
        this.raiz = null;
        this.tamanho = 0;
    }

    @Override
    public void inserir(Object chave){
        if(raiz == null){
            raiz = new Pagina(t, true);
            raiz.setChave(0, (int) chave);
            raiz.setNumero(1);
            tamanho++;
        }
        else{
            if(raiz.getNumero() == 2*t - 1){
                Pagina novaPagina = new Pagina(t, false);
                novaPagina.setFilho(0, raiz);
                dividirPagina(novaPagina, 0, raiz);
                int i = 0;
                if(novaPagina.getChave(0) < (int) chave){
                    i++;
                }
                inserirNaoCheio(novaPagina.getFilho(i), chave);
                raiz = novaPagina;
            }
            else{
                inserirNaoCheio(raiz, chave);
            }
        }

    }
        private void inserirNaoCheio(Pagina pagina, Object chave){
            int i = pagina.getNumero() - 1;
            if(pagina.getFolha()){
                while(i >= 0 && (int) chave < pagina.getChave(i)){
                    pagina.setChave(i+1, pagina.getChave(i));
                    i--;
                }
                pagina.setChave(i+1, (int) chave);
                pagina.setNumero(pagina.getNumero() + 1);
                tamanho++;
            }
            else{
                while(i >= 0 && (int) chave < pagina.getChave(i)){
                    i--;
                }
                i++;
                if(pagina.getFilho(i).getNumero() == 2*t - 1){
                    dividirPagina(pagina, i, pagina.getFilho(i));
                    if((int) chave > pagina.getChave(i)){
                        i++;
                    }
                }
                inserirNaoCheio(pagina.getFilho(i), chave);
            }
        }
        private void dividirPagina(Pagina pagina, int i, Pagina paginaCheia){
            Pagina novaPagina = new Pagina(t, paginaCheia.getFolha());
            novaPagina.setNumero(t - 1);
            for(int j = 0; j < t - 1; j++){
                novaPagina.setChave(j, paginaCheia.getChave(j + t));
            }
            if(!paginaCheia.getFolha()){
                for(int j = 0; j < t; j++){
                    novaPagina.setFilho(j, paginaCheia.getFilho(j + t));
                }
            }
            paginaCheia.setNumero(t - 1);
            for(int j = pagina.getNumero(); j >= i + 1; j--){
                pagina.setFilho(j + 1, pagina.getFilho(j));
            }
            pagina.setFilho(i + 1, novaPagina);
            for(int j = pagina.getNumero() - 1; j >= i; j--){
                pagina.setChave(j + 1, pagina.getChave(j));
            }
            pagina.setChave(i, paginaCheia.getChave(t - 1));
            pagina.setNumero(pagina.getNumero() + 1);
            
    }

    @Override 
    public void remover(Object chave) throws  ArvoreVaziaExcecao{
        if(estaVazia()){
            throw new ArvoreVaziaExcecao("Arvore vazia");
        }

    }


    @Override
    public boolean estaVazia(){
        return raiz == null;
    }

    @Override
    public Pagina buscar(Object chave) throws ArvoreVaziaExcecao{
        if(estaVazia()){
            throw new ArvoreVaziaExcecao("Arvore vazia");
        }
        else{
            return buscar(raiz, chave);
        }

        
    }
    private Pagina buscar(Pagina pagina, Object chave){
        int posicao = 0;
        while(posicao < pagina.getNumero() && (int) chave > pagina.getChave(posicao)){
            posicao++;

        }
        if(posicao < pagina.getNumero() && (int) chave == pagina.getChave(posicao)){
            return pagina;
        }
        if(pagina.getFolha()){
            return null;
        }
        else{
            return buscar(pagina.getFilho(posicao), chave);
        }
    }
        @Override
        public int tamanho(){
            return tamanho;
        }
        @Override
        public void percorrer(){
            if(raiz != null){
                percorrerP(raiz);
                System.out.println();
            }
        }
        private void percorrerP(Pagina pagina){
            int posicao = 0;
            for(posicao = 0 ; posicao < raiz.getNumero(); posicao++){
                if(!raiz.getFolha()){
                    percorrerP(raiz.getFilho(posicao));
                }
                System.out.print(raiz.getChave(posicao) + " ");

            }
            if(!raiz.getFolha()){
                percorrerP(raiz.getFilho(posicao));
            }
        }


    @Override
    public void limpar(){
        raiz = null;
        tamanho = 0;
    }
 
}