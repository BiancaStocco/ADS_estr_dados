import java.util.ArrayList;

public class MinHeapPriorityQueue<T extends Comparable<T>> {
    private ArrayList<T> heap;

    public MinHeapPriorityQueue() {
        heap = new ArrayList<>();
    }

    public void insert(T value) {
        heap.add(value);
        heapifyUp(heap.size() - 1);
    }

    public T removeMin() {
        if (isEmpty()) return null;

        T min = heap.get(0);
        T last = heap.remove(heap.size() - 1);

        if (!heap.isEmpty()) {
            heap.set(0, last);
            heapifyDown(0);
        }

        return min;
    }

    public T peek() {
        return isEmpty() ? null : heap.get(0);
    }

    public boolean isEmpty() {
        return heap.isEmpty();
    }

    private void heapifyUp(int index) {
        while (index > 0) {
            int parent = (index - 1) / 2;
            if (heap.get(index).compareTo(heap.get(parent)) >= 0)
                break;

            swap(index, parent);
            index = parent;
        }
    }

    private void heapifyDown(int index) {
        int left, right, smallest;
        while (true) {
            left = 2 * index + 1;
            right = 2 * index + 2;
            smallest = index;

            if (left < heap.size() && heap.get(left).compareTo(heap.get(smallest)) < 0)
                smallest = left;
            if (right < heap.size() && heap.get(right).compareTo(heap.get(smallest)) < 0)
                smallest = right;

            if (smallest == index)
                break;

            swap(index, smallest);
            index = smallest;
        }
    }

    private void swap(int i, int j) {
        T tmp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, tmp);
    }

    public int size() {
        return heap.size();
    }

    public ArrayList<T> getHeap() {
        return new ArrayList<>(heap);
    }
}

class Elemento implements Comparable<Elemento> {
    int prioridade;
    String valor;

    public Elemento(int prioridade, String valor) {
        this.prioridade = prioridade;
        this.valor = valor;
    }

    @Override
    public int compareTo(Elemento outro) {
        return Integer.compare(this.prioridade, outro.prioridade); // Menor prioridade vem primeiro
    }

    @Override
    public String toString() {
        return "(" + prioridade + ", \"" + valor + "\")";
    }
}