public class AVR extends ABP {
    public AVR(Object elemento) {
        super(elemento);
    }


    public No busca(Object elemento){
        No atual = raiz;
        while(atual != null){
            int cmp = elemento.compareTo(atual.getElemento());
            if(cmp == 0){
                return atual;
            }
            else if(cmp < 0){
                atual = atual.getFilhoEsquerdo();
            }
            else{
                atual = atual.getFilhoDireito();
            }
        }
        return null; // Adicione um retorno padrão caso o elemento não seja encontrado
    }
}

    // 