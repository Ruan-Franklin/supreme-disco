
public class ArvoreB{
    private Pagina raiz;
    private int t; // Grau mínimo da árvore

    public ArvoreB(int t){
        this.t = t;
        raiz = new Pagina(t, true);
    }





    public Pagina busca(Pagina pagina, int chave){
        if(pagina == null){
            return null;
        }

        int i = pagina.buscaBinaria(chave);
        if(i >= 0){
            // Encontrou a chave na página atual
            return pagina;
        }
        else{
            if(pagina.getFolha()){
                // Não encontrou a chave e a página é folha
                return null; // Chave não existe
            }
            else{
                int indiceFilho = -(i + 1); //Índice do filho onde a chave pode estar
                return busca(pagina.getFilho(indiceFilho), chave); //Busca recursivamente no filho
            }
        }
}
    public void inserir(int chave){
        //Se a raiz estiver cheia, divide
        if(raiz.getNumero() == 2*t -1){
            Pagina novaRaiz = new Pagina(t, false);
            novaRaiz.setFilho(0, raiz);
            novaRaiz.dividirFilho(0, raiz);

            //Agora a raiz tem 2 filhos. Vamos inserir a chave em um dos filhos
            int i = 0;
            if(novaRaiz.getChave(0) < chave){
                i++;
            }
            novaRaiz.getFilho(i).inserirNaoCheio(chave);
            //Atualiza a raiz
            raiz = novaRaiz;
        }
        else{
            //Se a raiz não estiver cheia, insere na raiz
            raiz.inserirNaoCheio(chave);
    }
    }
    

    

        
    }