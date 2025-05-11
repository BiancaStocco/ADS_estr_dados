public class ListaPosicional<E> {

    // Classe interna para o nó
    private static class Node<E> {
        E element;
        Node<E> prev;
        Node<E> next;

        Node(E e, Node<E> p, Node<E> n) {
            element = e;
            prev = p;
            next = n;
        }
    }

    // Classe interna estática para a posição
    public static class Position<E> {
        private ListaPosicional<E> container;
        private Node<E> node;

        Position(ListaPosicional<E> container, Node<E> node) {
            this.container = container;
            this.node = node;
        }

        public E getElement() {
            return node.element;
        }
    }

    // Cabeçalhos da lista
    private Node<E> header;
    private Node<E> trailer;
    private int size = 0;

    // Construtor
    public ListaPosicional() {
        header = new Node<>(null, null, null);
        trailer = new Node<>(null, header, null);
        header.next = trailer;
    }

    // Métodos auxiliares
    private Node<E> validate(Position<E> p) {
        if (p == null || p.container != this)
            throw new IllegalArgumentException("Posição inválida.");
        return p.node;
    }

    private Position<E> makePosition(Node<E> node) {
        if (node == header || node == trailer) return null;
        return new Position<>(this, node);
    }

    private Position<E> insertBetween(E element, Node<E> predecessor, Node<E> successor) {
        Node<E> newNode = new Node<>(element, predecessor, successor);
        predecessor.next = newNode;
        successor.prev = newNode;
        size++;
        return new Position<>(this, newNode);
    }

    // Métodos públicos
    public Position<E> first() {
        return makePosition(header.next);
    }

    public Position<E> last() {
        return makePosition(trailer.prev);
    }

    public Position<E> before(Position<E> p) {
        Node<E> node = validate(p);
        return makePosition(node.prev);
    }

    public Position<E> after(Position<E> p) {
        Node<E> node = validate(p);
        return makePosition(node.next);
    }

    public Position<E> addFirst(E element) {
        return insertBetween(element, header, header.next);
    }

    public Position<E> addLast(E element) {
        return insertBetween(element, trailer.prev, trailer);
    }

    public Position<E> addBefore(Position<E> p, E element) {
        Node<E> node = validate(p);
        return insertBetween(element, node.prev, node);
    }

    public Position<E> addAfter(Position<E> p, E element) {
        Node<E> node = validate(p);
        return insertBetween(element, node, node.next);
    }

    public void printList() {
        Position<E> current = first();
        while (current != null) {
            System.out.print(current.getElement() + " ");
            current = after(current);
        }
        System.out.println();
    }

    // Método main de teste
    public static void main(String[] args) {
        ListaPosicional<Integer> lista = new ListaPosicional<>();

        Position<Integer> p1 = lista.addFirst(10);        // [10]
        Position<Integer> p2 = lista.addLast(20);         // [10, 20]
        Position<Integer> p3 = lista.addLast(30);         // [10, 20, 30]
        Position<Integer> p4 = lista.addBefore(p3, 25);   // [10, 20, 25, 30]
        Position<Integer> p5 = lista.addAfter(p1, 15);    // [10, 15, 20, 25, 30]

        lista.printList(); // Saída esperada: 10 15 20 25 30
    }
}