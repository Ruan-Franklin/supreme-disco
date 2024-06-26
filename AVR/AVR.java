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
            No novoNo = no.getPai().getPai();
            no.getPai().setPai(no);
            no.setFilhoEsquerdo(no.getPai());
            no.getFilhoEsquerdo().setFilhoDireito(null);
            novoNo.setFilhoEsquerdo(no);
            no.setPai(novoNo);
        }
}
    public No pintar(No no){
        //Caso w, o pai de v é negro, isso mantḿ o critério 4, então não precisa modificar
        if(no.getPai().getCor()  no.getCor() == "preto"){
            System.out.println("Caso 1 cumprido");
            return no;
        }
        /*
                Caso 2: Suponha w(pai de v) rubro e t, o pai
        de w(avó de v) é negro. Se u, o irmão de w
        (tio de v) é rubro, ainda é possível manter o
        critério IV apenas fazendo a re-coloração de
        t(Rubro),u(Negro) e w(Negro)'
         */
        else if (no.getPai().getPai().getFilhoDireito() == no.getPai() && no.getPai().getPai().getFilhoEsquerdo() != null && no.getPai().getPai().getFilhoEsquerdo().getCor() != "preto"){
            System.out.println("Caso 2 - filho no lado esquerdo");
            //Avó negro && pai e tio do nó rubros
            if(no.getPai().getCor() == "vermelho" && no.getPai().getPai().getCor() == "preto" && no.getPai().getPai().getFilhoEsquerdo().getCor() == "vermelho"){
                no.getPai().setCor("preto");
                no.getPai().getPai().getFilhoDireito().setCor("preto");
                if(no.getPai().getPai() == super.raiz){
                    return no;
            }
                else{
                    no.getPai().getPai().setCor("vermelho");
                    pintar(no.getPai().getPai());
                    

                }
            }
        }
        /* 
       Caso 3
            Caso 3: suponha w rubro, seu pai t é negro e
        seu irmão u é negro. Neste caso, para manter
        o critério III é necessário fazer rotações com
        w, v, t e u. Existe 4 subcasos que
        correspondem às 4 rotações possíveis
        */

      // Caso 3a: Rotação direita simples
        else if (no.getPai().getPai().getFilhoEsquerdo() == no.getPai()  && no.getPai().getPai().getFilhoDireito() == null && no.getPai().getFilhoDireito() == null){
            System.out.println("Estou no caso 3a - rotação direta simples");
            no.getPai().setCor("preto");
            no.getPai().getPai().setCor("vermelho");
            rotacaoSimplesEsquerda(no);
        }
        //caso 3b: rotação diretia simples
        else if (no.getPai().getPai().getFilhoDireito() == no.getPai()){
            
        } 



        else if (no.getPai().getPai().getFilhoDireito() == no.getPai()  && no.getPai().getPai().getFilhoEsquerdo() == null && no.getPai().getFilhoEsquerdo() == null){
            System.out.println("Estou no caso 3b - rotação diretia simples");
            no.getPai().setCor("preto");
            no.getPai().getPai().setCor("vermelho");
            rotacaosimplesEsquerda(no);
            System.out.println("Estou  caso 3b - rotação direita simples");
            no.getPai().setCor("negro");
            no.getPai().getPai().setCor("vermelho");
            rotacaoSimplesEsquerda(no);
      }

        
        }




    public No busca(Object elemento){
        No no = super.busca(elemento, super.raiz);
        return no;
    } 


    

    // 