import java.util.Vector;
import java.util.ArrayList;
import java.util.List;
public class Grafo implements IGrafo{
    private int numVertices;
    private int numArestas;
    private Vector<Vertice> vertices;
    private Vector<Vector<Aresta>> arestas;
    private Vector<Vector<List<Aresta>>> adj;
    public Grafo(int numVertices){
        this.numVertices = numVertices;
        this.numArestas = 0;
        vertices = new Vector<>(numVertices);
        arestas = new Vector<>(numVertices);
        adj = new Vector<>(numVertices);
        for (int i = 0 ; i < numVertices ; i++){
            vertices.add(null);
            Vector<Aresta> linhaArestas = new Vector<>(numVertices);
            Vector<List<Aresta>> linhaAdj = new Vector<>(numVertices);
            for(int j = 0 ; j < numVertices ; j ++){
                linhaArestas.add(null);
                linhaadj.add(new Araylist<>());
            }
            arestas.add(linhasArestas);
            adj.add(linhaAdj); 
        }
    }
    @Override
    public boolean ehAjacente(int v, int w){
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
    public void substituir(Vertice v, Object x){
        vertices.set(v, x);
    }
    @Override
    public void substituirAresta(Aresta e,  Object x){
        for(int i = 0 ; i < numVertices ; i++){
            for(int j = 0 ; j < numVertices ; j++){
                List<Aresta> listaArestas = adj.get(i).get(j);
                for(int k  = 0 ; k < listaArestas.size() ; k++){
                    if(listaArestas.get(k).equals(e)){
                        listaAresta.set(k, (Aresta) x);
                        return;
                    }
                }
            }
        }
    }
    @Override
    public Vector <Vertice> vertices(){
        return vertices;
    }
    @Override
    public Vector <Vector <Vector <arestas>>> arestas(){
        return arestas;
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
                vertices.set(i, o);
                return i;
            }
        }
        numVertices++;
        return numVertices;
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
    public int oposto(Vertice v, int e) throws NaoIncidente{
        for(int i = 0 ; i < numVertices ; i++){
            for(int j = 0 ; j < numVertices ; j++){
                for(Aresta aresta : adj.get(i).get(j)){
                    if(i == v){
                        return j;
                    }
                    else if(j == v){
                        return i;
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
    public void mostrar(){
        for(int i = 0 ; i < numVertices ; i++){
            System.out.print(arestas.get(i).get(j) + " ");
        }
        System.out.println();
    }

}