import java.util.Vector;
import java.util.ArrayList;
import java.util.List;
public class Grafo implements IGrafo{
    private int numVertices;
    private int numArestas;
    private Vector<Vertice> vertices;
    private Vector<Vector<Aresta>> arestas;
    private Vector<Vector<List<Aresta>>> adj;
    public Grafo(int numVertices) {
        this.numVertices = numVertices;
        this.numArestas = 0;
        vertices = new Vector<>(numVertices);
        arestas = new Vector<>(numVertices);
        adj = new Vector<>(numVertices);
        for (int i = 0; i < numVertices; i++) {
            vertices.add(null);
            Vector<Aresta> linhaArestas = new Vector<>(numVertices);
            Vector<List<Aresta>> linhaAdj = new Vector<>(numVertices);
            for (int j = 0; j < numVertices; j++) {
                linhaArestas.add(null);
                linhaAdj.add(new ArrayList<>());
            }
            arestas.add(linhaArestas);
            adj.add(linhaAdj);
        }
    }


    @Override
    public boolean ehAdjacente(int v, int w){
        return !adj.get(v).get(w).isEmpty();
    }
    @Override
    public int[] finalVertices(int e) throws NaoIncidente{
        int [] v = new int[2];
        for (int i = 0 ; i < numVertices ; i++) {
            for (int j = 0; j < numVertices; j++) {
                if (arestas.get(i).get(j).equals(e)) {
                    v[0] = i;
                    v[1] = j;
                    return v;
                }
            }
        }
        throw new NaoIncidente("Aresta não incidente");
    }
    @Override
    public void substituir(Vertice v, Object x) {
        v.setValor(x);
    }

    @Override
    public void substituirAresta(Aresta e,  Object x) {
        e.setValor(x);
    }



    @Override
    public Vector <Vertice> vertices(){
        return vertices;
    }
    @Override
    public Vector<Vector<List<Aresta>>> arestas(){
        return adj;
    }
    @Override
   public int inserirAresta(int v, int w, Object o){
    Aresta aresta = (Aresta) o;
    adj.get(v).get(w).add(aresta);
    numArestas++;
    return numArestas;

   }
    @Override
    public int inserirVertice(Object o){
        for(int i = 0 ; i < numVertices ; i++){
            if(vertices.get(i) == null){
                vertices.set(i, (Vertice) o);
                return i;
            }
        }
        numVertices++;
        vertices.add((Vertice) o);
        return numVertices -1;
    }
    @Override
    public boolean ehDirecionado(int e){
        for(int i = 0 ; i < numVertices ; i++){
            for(int j = 0 ; j < 0 ; j++){
                for ( Aresta aresta : adj.get(i).get(j)){
                    if(aresta.equals(e)){
                        return true;
                    }
                }
            }
        }
        return false;
    }
    @Override
    public int oposto(Vertice v, int e){
        for(int i = 0 ; i < numVertices ; i++){
            for(int j = 0 ; j < numVertices ; j++){
                for (Aresta aresta : adj.get(i).get(j)){
                    if(aresta.equals(e)){
                        if(vertices.get(i).equals(v)){
                            return j;
                        }
                        else if(vertices.get(j).equals(v)){
                            return i;
                        }
                    }
                }
            }
        }
        throw new NaoIncidente("O vértice não é incidente");
    }
    @Override
    public void inserirArestaDirecionada(int v, int w, Object o){
        Aresta aresta = (Aresta) o;
        adj.get(v).get(w).add(aresta);
        numArestas++;
    }
    public Object arestasIncidentes(int v){
        return adj.get(v);
    }

    public Object removerAresta(Aresta e) throws NaoIncidente{
        for(int i = 0 ; i < numVertices ; i++){
            for(int j = 0 ; j < numVertices ; j++){
                List <Aresta> listaArestas = adj.get(i).get(j);
                if(listaArestas.remove(e)){
                    numArestas--;
                    return e.getValor();
                }
            }
        }
        throw new ArestaNaoEncontradaExcecao("A aresta " + e + " não foi encontrada");
    }

    public void mostrar(){
        for(int i = 0 ; i < numVertices ; i++){
            System.out.print(vertices.get(i) + " ");
        }
        System.out.println();
    }

}