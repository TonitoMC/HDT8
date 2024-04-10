package uvg.edu.gt;

/**
 * La interfaz PriorityQueue se utiliza para implementar el VectorHeap
 * @param <E> un generico comparable
 */
public interface PriorityQueue<E extends Comparable<E>> {
    public E getFirst();
    public E remove();
    public void add(E value);
    public boolean isEmpty();
}
