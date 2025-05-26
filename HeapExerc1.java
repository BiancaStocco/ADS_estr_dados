class HeapExerc1 {
    public static void main(String[] args) {
        MinHeapPriorityQueue<Elemento> fila = new MinHeapPriorityQueue<>();

        fila.insert(new Elemento(3, "C"));
        fila.insert(new Elemento(1, "A"));
        fila.insert(new Elemento(2, "B"));

        System.out.println("Estado da fila:");
        for (Elemento e : fila.getHeap()) {
            System.out.println(e);
        }
        System.out.println();

        System.out.println("Removido: " + fila.removeMin());
        System.out.println();

        System.out.println("Estado da fila após remoção:");
        for (Elemento e : fila.getHeap()) {
            System.out.println(e);
        }
    }
}