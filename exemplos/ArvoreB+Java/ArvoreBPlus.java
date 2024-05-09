public class ArvoreBPlus {
    private int raiz;
    
    public ArvoreBPlus(int t){
        raiz = new Pagina(int t, true);
    }

    public void inserir(int chave, Object dado){ throw InsercaoInvalidaExcecao
        //Se a raiz está cheia, a árvore cresce e aumenta mais um em nível

        if(raiz.getNumero() == 2*raiz.geT() -1){
            Pagina novaRaiz = new Pagina(raiz.geT(), false)
            novaRaiz.setPai(null);
            novaRaiz.dividirPagina();     
            raiz = novaRaiz;
            }
            raiz.inserir(chave, dado);
        }

        //Método para buscar chave. Retorna null se a chave não for encontrada.

        public Object buscar(int chave){
            return raiz.buscaBInaria(chave):
        }
    }
    

