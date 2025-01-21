public class Aresta<TipoVertice, TipoAresta>{
    private TipoVertice vertice1;
    private TipoVertice vertice2;
    private TipoAresta elemento;

    public Aresta(TipoVertice vertice1, TipoVertice vertice2, TipoAresta elemento){
        this.vertice1 = vertice1;
        this.vertice2 = vertice2;
        this.elemento = elemento;
    }

    public TipoVertice.getVertice1(){
        return vertice1;
    }

    public TipoVertice.getVertice2(){
        return Vertice2;
    }

    public TipoAresta.getElemento(){
        return elemento;
    }

    public void setElemento(TipoAresta elemento){
        this.elemento = elemento;
    }

    public boolean conecta(TipoVertice v1, TipoVertice v2){
        return (vertice1.equals(v1) && vertice2.equals(v2)) || (vertice1.equals(v2) && vertice2.equals(v1));
    }

    public void substituirVertice(TipoVertice verticeAntigo, TipoVertice verticeNovo){
        if(vertice1.equals(verticeAntigo)){
            vertice1 = verticeNovo;
        }
        else if(vertice2.equals(verticeAntigo)){
            vertice2 = verticeNovo;
        }

    }


    public tipoVertice [] getVertices(){
        

    }
}