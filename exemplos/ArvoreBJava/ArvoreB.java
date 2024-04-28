
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
    public void remover(Pagina pagina, int chave){
        //Busca a chave na página
        int indice = pagina.buscaBinaria(chave);
        //A chave está na página e a página é uma folha
        if(indice >= 0 && pagina.getFolha()){
            pagina.removerChave(indice);
        }
        
        //A chave está na página e a página não é uma folha
        else if(indice >= 0 && !pagina.getFolha()){
            //Substitui a chave pela chave sucessora
            int chaveSucessora = pagina.getChaveAntecessora(indice);
            pagina.setChave(indice, chaveSucessora);
            //Remove a chave sucessora da página
            remover(pagina.getFilho(indice + 1), chaveSucessora);
        }
        //A chave não está na página e a página é uma folha
        else if(indice < 0 && pagina.getFolha()){
            return;
        }
        //A chave não está na página e a página não é uma folha
        else{
            //Busca o filho onde a chave pode estar
            int indiceFilho = -(indice + 1);
            Pagina filho = pagina.getFilho(indiceFilho);
            //Se o filho tem o número mínimo de chaves, preenche o filho
            if(filho.getNumero() == t - 1){
                //Se o filho anterior tem mais de t - 1 chaves, empresta uma chave
                if(indiceFilho > 0 && pagina.getFilho(indiceFilho - 1).getNumero() >= t){
                    filho.emprestarDoAnterior(indiceFilho);
                }
                //Se o filho seguinte tem mais de t - 1 chaves, empresta uma chave
                else if(indiceFilho < pagina.getNumero() && pagina.getFilho(indiceFilho + 1).getNumero() >= t){
                    filho.emprestarDoProximo(indiceFilho);
                }
                //Se os filhos anterior e seguinte têm t - 1 chaves, funde o filho com um dos filhos
                else{
                    if(indiceFilho < pagina.getNumero()){
                        filho.fundir(indiceFilho);
                    }
                    else{
                        filho.fundir(indiceFilho - 1);
                    }
                }
            }
            //Remove a chave recursivamente
            remover(filho, chave);
        }
        

    }

    public void mostrar(Pagina pagina){
        if(pagina != null){
            for(int i = 0 ; i < pagina.getNumero() ; i++){
                //Se a página não é uma folha, deve-se chamar o método "mostrar" para o filho no indice 1
                if(!pagina.getFolha()){
                    mostrar(pagina.getFilho(1));
                }
                //Imprime a chave no indice 1 
                System.out.println(pagina.getChave(i) + " ");
            }
     }
        //Se a página não é uma folha, deve-se chamar o método "mostrar" para o último filho
        //Se a página não é uma folha, deve-se chamar o método "mostrar" apra o último filho
        //Se a página não é uma folha, deve-se chamar o método "mostrar'" para o último filho
        if(!pagina.getFolha()){
            mostrar(pagina.getFilho(pagina.getNumero()));

            }
        }
    

    

        
    }