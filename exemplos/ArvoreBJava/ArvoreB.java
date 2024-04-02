public class ArvoreB implements IABP{

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

        

    }

    @Override 
    public void remover(Object chave){}


    @Override
    public boolean estaVazia(){
        return raiz == null;
    }

    @Override
    public Pagina buscar(Object chave) throws ArvoreVaziaExcecao{
        if(estaVazia()){
            throw new ArvoreVaziaExcecao();
        }
        else{
            return raiz.buscar(chave);
        }
    }
    private Pagina buscar(Pagina pagina, Object chave){
        int posicao = 0;
        while(posicao < pagina.getNumero() && (int) chave > pagina.getChave(posicao)){
            posicao++;
        }
        if(posicao < pagina.getNumero() && (int) chave == pagina
    }
    @Override
    public int tamanho(){
        return tamanho;
    }
    @Override
    public void atravessar(){
        if(raiz != null){
            raiz.atravessar();
            System.out.println();
        }
    }
 
}