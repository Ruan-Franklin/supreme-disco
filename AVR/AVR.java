public class AVR extends ABP {
    public ARN(Object elemento){
           super(elemento);
    }
    public void rotacaoSimplesDireita(No no){
        if(no.getPai().getPai() == super.raiz){
            // rotaçao direita simples com raiz
            if(no.getPai().getFilhoEsquerdo() == no && no.getPai().getPai().getFilhoDireito() == null){
                System.out.println("rotaçao direita simples com raiz 1");

                no.getPai().getPai().setPai(no.getPai());
                no.getPai().setFilhoDireito(no.getPai().getPai());
                no.getPai().getPai().setFilhoEsquerdo(null);
                super.raiz = no.getPai();
            }
            // rotaçao direita simples com filho direito e com raiz
            else {
                System.out.println("simples esquerdo com raiz 2");
                No novoNo = no.getPai().getPai();
                no.getPai().setPai(no);
                no.setFilhoDireito(no.getPai());
                no.getFilhoDireito().setFilhoEsquerdo(null);
                novoNo.setFilhoDireito(no);
                no.setPai(novoNo);
    }
}
        else{ //Se o avó não é raiz, então o irmão é nulo
            //Rotação direita do filho esquerdo sem raiz
            if(no.getPai().getFilhoEsquerdo() == no && no.getPai().getPai().getFilhoDireito() == null){
                System.out.println("NO FE SIMPLES com raiz 9");
                mostrarRubroNegra();
                No novoNo = no.getPai().getPai().getPai();
                no.getPai().getPai().setPai(no.getPai());
                no.getPai().setFilhoDireito(no.getPai().getPai());
                no.getPai().getPai().setFilhoEsquerdo(null);
                novoNo.setFilhoEsquerdo(no.getPai());
                no.getPai().setPpai(novoNo);
             
            }

        }
        //Rotação simples direitaa com filho esquerdo sem raiz
        else {
            System.out.println("NO FE SIMPLES com raiz 10");
            No novoNo = no.getPai().getPai();
            System.out.print("Nó adicionado: " + novoNo.getElemento());
            no.getPai().setPai(no);
            no.setFilhoDireito(no.getPai());
            no.getFilhoDireito().setFilhoEsquerdo(null);
            novoNo.setFilhoDireito(no);
            no.setPai(novoNo);
        }
    }
}
    public void rotacaoSimplesEsquerda(No no){
        if(no.getPai().getPai() == super.raiz()){
            if(no.getPai().getFilhoDireito() == no && no.getPai().getPai().getFilhoEsquerdo() == null){
                System.out.println("rotaçao esquerda simples com raiz 5");
                no.getPai().getPai().setPai(no.getPai());
                no.getPai().setFilhoEsquerdo(no.getPai().getPai());
                no.getPai().getPai().setFilhoDireito(null);
                super.raiz = no.getPai();
            }
            else{
                System.out.println("rota simples esquerdo com raiz 6");
                No novoNo = no.getPai().getPai();
                no.getPai().setPai(no);
                no.setFilhoEsquerdo(no.getPai());
                no.getFilhoEsquerdo().setFilhoDireito(null);
                novoNo.setFilhoEsquerdo(no);
                no.setPai(novoNo);

            }
        }
        else{
            System.out.println("rota simples esquerdo sem raiz 3");
            

        }



}





    public No busca(Object elemento){
        No no = super.busca(elemento, super.raiz);
        return no;
    } 


    

    // 