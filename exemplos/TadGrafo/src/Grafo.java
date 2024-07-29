import java.util.Vector;
public class Grafo implements IGrafo{
    private int numVertices;
    private int numArestas;
    private Vector<Object> vertices;
    private Vector<Vector<Object>> arestas;
    private boolean[][] adj;
    public Grafo(int numVertices){
        this.numVertices = numVertices;
        this.numArestas = 0;
        vertices = new Vector<>(numVertices);
        arestas = new Vector<>(numVertices);
        for (int i = 0 ; i < numVertices ; i++){
            vertices.add(null);
        }

    }
    public boolean ehAjacente(int v, int w){
        return adj[v][w];

    }
    public void substituir(int v, Object x){
        Vector novoVector = new Vector();
        novoVector.add(x);
        vertices.set(v, x);
    }
    public void substituirAresta(int v, int w, Object x){
        Vector novoVector = new Vector();
        novoVector.add(x);
        arestas.set(v, novoVector);
    }
    public Object vertices(){
        return vertices;
    }
    public Object arestas(){
        return arestas;
    }
    public boolean ehDirecionado(int e){
        return false;   
    }
    public void inserirArestaDirecionada(int v, int w, Object o){
        arestas.get(v).set(w, o);
        adj [v][w] = true;
        numArestas++;
    }

}