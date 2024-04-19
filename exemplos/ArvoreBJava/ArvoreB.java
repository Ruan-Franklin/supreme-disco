
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
            novaRaiz.getFilho(i).InserirNaoCheio(chave);
            //Atualiza a raiz
            raiz = novaRaiz;
        }
        else{
            //Se a raiz não estiver cheia, insere na raiz
            raiz.InserirNaoCheio(chave);
    }
    }
    public void InserirNaoCheio(int chave){
        Pagina pagina;
        int posicaoChave = pagina.getNumero() - 1;
        if(pagina.getFolha()){
            //Se a página é folha, insere a chave na página
            //Desloca as chaves maiores para a direita
            while(posicaoChave >= 0 && chaves[posicaoChave] > chave){
                pagina.chaves[posicaoChave+1] = pagina.chaves [posicaoChave];
                posicaoChave--;
            }
            pagina.chaves[posicaoChave+1] = chave;
            pagina.setNumero(pagina.getNumero() + 1);
            }
            else{
                while(posicaoChave >= 0 && pagina.chaves[posicaoChave] > chave){
                    posicaoChave--;
                }
                //Verifica se a página filho está cheia

                if(pagina.filhos[posicaoChave + 1].getNumero() == 2 * t -1){
                    dividirFilho(posicaoChave + 1, pagina.filhos[posicaoChave+ 1]);                    

                    if(pagina.chaves[posicaoChave + 1] < chave){
                        posicaoChave++;
                    }
                }


                }
            }
            public void dividirFilho(int indice, Pagina pagina){
                Pagina novaPagina = new Pagina(pagina.getT(), pagina.getFolha());
                novaPagina.setNumero(pagina.getT() - 1);

                // Copia as chaves da página para a nova página
                for (int i = 0; i < pagina.getT() - 1; i++) {
                    novaPagina.setChave(i, pagina.getChave(i + pagina.getT()));
                }

                // Copia os filhos da página para a nova página, se não for folha
                if (!pagina.getFolha()) {
                    for (int i = 0; i < pagina.getT(); i++) {
                        novaPagina.setFilho(i, pagina.getFilho(i + pagina.getT()));
                    }
                }

                // Reduz o número de chaves da página
                pagina.setNumero(pagina.getT() - 1);

                // Desloca os filhos da página para a direita
                for (int i = pagina.getNumero(); i >= indice + 1; i--) {
                    pagina.filhos[i + 1] = pagina.filhos[i];
                }

                // Insere a nova página como filho da página atual
                pagina.filhos[indice + 1] = novaPagina;

                // Desloca as chaves da página para a direita
                for (int i = pagina.getNumero() - 1; i >= indice; i--) {
                    pagina.chaves[i + 1] = pagina.chaves[i];
                }

                // Copia a chave do meio da página para a página atual
                pagina.chaves[indice] = pagina.getChave(pagina.getT() - 1);

                // Incrementa o número de chaves da página
                pagina.setNumero(pagina.getNumero() + 1);
            }

        
        


        
    }