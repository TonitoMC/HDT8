package uvg.edu.gt;

import junit.framework.TestCase;

public class VectorHeapTest extends TestCase {

    public void testGetFirst() {
        VectorHeap<Integer> testVectorHeap = new VectorHeap<>();
        testVectorHeap.add(3);
        testVectorHeap.add(4);
        testVectorHeap.add(2);
        assertEquals((Integer) 2, testVectorHeap.getFirst());
    }
    public void testRemove() {
        VectorHeap<Integer> testVectorHeap = new VectorHeap<>();
        testVectorHeap.add(3);
        testVectorHeap.add(4);
        testVectorHeap.add(2);
        assertEquals((Integer) 2, testVectorHeap.remove());
        assertEquals((Integer) 3, testVectorHeap.getFirst());
    }
    public void testAdd() {
        VectorHeap<Integer> testVectorHeap = new VectorHeap<>();
        testVectorHeap.add(3);
        testVectorHeap.add(4);
        testVectorHeap.add(2);
        assertEquals((Integer) 2, testVectorHeap.getFirst());
        testVectorHeap.add(1);
        assertEquals((Integer) 1, testVectorHeap.getFirst());
    }
}