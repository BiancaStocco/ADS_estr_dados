class HeapExerc2 {
    public static void main(String[] args) {
        MinHeapPriorityQueue<Elemento> fila = new MinHeapPriorityQueue<>();

        fila.insert(new Elemento(10, "Z"));
        fila.insert(new Elemento(5, "Y"));
        fila.insert(new Elemento(1, "X"));
        fila.insert(new Elemento(7, "W"));
        fila.insert(new Elemento(3, "V"));


        System.out.println("Estado da fila:");
        for (Elemento e : fila.getHeap()) {
            System.out.println(e);
        }
        System.out.println();

        System.out.println("Teste 1 de menor elemento: " + fila.peek());
        System.out.println("Estado da fila:");
        for (Elemento e : fila.getHeap()) {
            System.out.println(e);
        }
        System.out.println();

        System.out.println("Teste 2 de menor elemento: " + fila.peek());
        System.out.println("Estado da fila:");
        for (Elemento e : fila.getHeap()) {
            System.out.println(e);
        }
        System.out.println();

        System.out.println("Teste 3 de menor elemento: " + fila.peek());
        System.out.println("Estado da fila:");
        for (Elemento e : fila.getHeap()) {
            System.out.println(e);
        }
    }
}