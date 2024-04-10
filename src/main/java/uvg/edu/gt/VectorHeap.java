package uvg.edu.gt;

import java.util.Vector;

/**
 * Esta clase es una implementacion de un PriorityQueue utilizando un VectorHeap, en este caso se utilizara
 * para almacenar datos de pacientes pero utiliza genericos. Implementacion tomada del libro JavaStructures escrito
 * por Duane A. Bailey.
 * @param <E> el tipo de datos que almacena el VectorHeap.
 * @author Jose Merida (Basado en la implementacion de JavaStructures de Duane A. Bailey)
 * @version 1.0
 * @since 09-04-2024
 */
public class VectorHeap <E extends Comparable<E>> implements PriorityQueue<E> {
    protected Vector<E> data;
    /**
     * Crea un nuevo VectorHeap
     */
    public VectorHeap(){
        data = new Vector<E>();
    }
    /**
     * Retorna la posicion del nodo padre
     * @param i la posicion del nodo del cual se desea buscar el padre
     * @return la posicion del nodo padre dentro del vector
     */
    protected static int parent(int i){
        return (i - 2) / 2;
    }

    /**
     * Retorna la posicion del nodo izquierdo
     * @param i la posicion del nodo del cual se desea buscar el nodo izquierdo
     * @return la posicion del nodo izquierdo dentro del vector
     */
    protected static int left(int i){
        return 2 * i + 1;
    }

    /**
     * Retorna la posicion del nodo derecho
     * @param i la posicion del nodo del cual se desea  buscar el nodo derecho
     * @return la posicion del nodo derecho dentro del vector
     */
    protected static int right(int i){
        return (2 * i + 1) + 1;
    }

    /**
     * Empuja un valor hacia arriba hasta encontrar su posicion correcta
     * @param leaf la posicion dentro del vector del nodo
     */
    protected void percolateUp(int leaf){
        int parent = parent(leaf);
        E value = data.get(leaf);
        while (leaf > 0 && (value.compareTo(data.get(parent)) < 0)){
            data.set(leaf,data.get(parent));
            leaf = parent;
            parent = parent(leaf);
        }
        data.set(leaf,value);
    }

    /**
     * Asegura que el root del arbol sea el valor correcto
     */
    protected void pushDownRoot(int root){
        int heapSize = data.size();
        E value = data.get(root);
        while (root < heapSize){
            int childpos = left(root);
            if (childpos < heapSize){
                if ((right(root) < heapSize) && ((data.get(childpos + 1)).compareTo(data.get(childpos)) < 0)){
                    childpos++;
                }
                if ((data.get(childpos)).compareTo(value) < 0){
                    data.set(root,data.get(childpos));
                    root = childpos;
                } else {
                    data.set(root,value);
                    return;
                }
            } else {
                data.set(root,value);
                return;
            }
        }

    }

    /**
     * Retorna el primer valor del vector
     * @return el primer valor del vector
     */
    @Override
    public E getFirst() {
        return data.elementAt(0);
    }

    /**
     * Concatena los datos del VectorHeap a un string
     * @return
     */
    public String toString() {
        return "VectorHeap{" +
                "data=" + data +
                '}';
    }

    /**
     * Remueve el valor al inicio y lo retorna
     * @return el valor al inicio del vector
     */
    @Override
    public E remove() {
        E minVal = getFirst();
        data.set(0,data.get(data.size()-1));
        data.setSize(data.size()-1);
        if (data.size() > 1) pushDownRoot(0);
        return minVal;
    }

    /**
     * Agrega uun valor
     * @param value el valor por agregar
     */
    @Override
    public void add(E value) {
        data.add(value);
        percolateUp(data.size()-1);
    }

    /**
     * Verifica si esta vacio
     * @return True si esta vacio, False si contiene algun elemento
     */
    @Override
    public boolean isEmpty() {
        return data.isEmpty();
    }
}
