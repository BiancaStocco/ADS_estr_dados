class HeapExerc3 {
    public static void main(String[] args) {
        MinHeapPriorityQueue<Elemento> fila = new MinHeapPriorityQueue<>();

        fila.insert(new Elemento(2, "Tarefa 1"));
        fila.insert(new Elemento(5, "Tarefa 2"));
        fila.insert(new Elemento(1, "Tarefa 3"));
        fila.insert(new Elemento(4, "Tarefa 4"));
        fila.insert(new Elemento(3, "Tarefa 5"));

        System.out.println("Estado da fila:");
        for (Elemento e : fila.getHeap()) {
            System.out.println(e);
        }
        System.out.println();

        System.out.println("Removido: " + fila.removeMin());
        System.out.println("Removido: " + fila.removeMin());
        System.out.println("Removido: " + fila.removeMin());

        System.out.println("Estado da fila após remoção:");
        for (Elemento e : fila.getHeap()) {
            System.out.println(e);
        }
    }
}