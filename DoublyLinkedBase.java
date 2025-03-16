public class DoublyLinkedBase<E> {

    // Classe interna Node (nó) agora é pública
    public static class Node<E> {
        private E element;        // Elemento armazenado no nó
        private Node<E> next;     // Referência para o próximo nó
        private Node<E> prev;     // Referência para o nó anterior

        public Node(E e, Node<E> prev, Node<E> next) {
            element = e;
            this.next = next;
            this.prev = prev;
        }

        public E getElement() {
            return element;
        }

        public Node<E> getNext() {
            return next;
        }

        public void setNext(Node<E> n) {
            next = n;
        }

        public Node<E> getPrev() {
            return prev;
        }

        public void setPrev(Node<E> p) {
            prev = p;
        }
    }

    // Atributos da lista
    private Node<E> head = null; // Primeiro nó da lista
    private Node<E> tail = null; // Último nó da lista
    private int size = 0;        // Tamanho da lista

    // Construtor
    public DoublyLinkedBase() { }

    // Métodos de acesso
    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public E first() {
        if (isEmpty()) return null;
        return head.getElement();
    }

    public E last() {
        if (isEmpty()) return null;
        return tail.getElement();
    }

    // Método público para obter o segundo nó (para fins de teste e exclusão)
    public Node<E> getSecondNode() {
        if (head == null || head.getNext() == null) {
            return null; // Se a lista não tem um segundo nó, retorna nulo
        }
        return head.getNext(); // Retorna o segundo nó
    }

    // Métodos de atualização
    public void addFirst(E e) {
        Node<E> newNode = new Node<>(e, null, head); // Cria um novo nó
        if (isEmpty()) {
            tail = newNode; // Caso especial: lista estava vazia
        } else {
            head.setPrev(newNode); // Atualiza o antigo head para apontar para o novo nó
        }
        head = newNode; // Atualiza o head para o novo nó
        size++;
    }

    public void addLast(E e) {
        Node<E> newest = new Node<>(e, tail, null); // Cria um novo nó
        if (isEmpty()) {
            head = newest; // Caso especial: lista estava vazia
        } else {
            tail.setNext(newest); // Liga o novo nó ao final da lista
        }
        tail = newest; // Atualiza o tail para o novo nó
        size++;
    }

    public E removeFirst() {
        if (isEmpty()) return null; // Lista vazia, nada para remover
        E answer = head.getElement();
        head = head.getNext(); // Atualiza o head para o próximo nó
        if (head == null) {
            tail = null; // Caso especial: lista ficou vazia
        } else {
            head.setPrev(null); // Atualiza o novo head para não ter um nó anterior
        }
        size--;
        return answer;
    }

    public E removeLast() {
        if (isEmpty()) return null; // Lista vazia, nada para remover
        E answer = tail.getElement();
        tail = tail.getPrev(); // Atualiza o tail para o nó anterior
        if (tail == null) {
            head = null; // Caso especial: lista ficou vazia
        } else {
            tail.setNext(null); // Atualiza o novo tail para não ter um próximo nó
        }
        size--;
        return answer;
    }

    // Método para excluir um nó específico
    public void deleteNode(Node<E> node) {
        if (node == null) return; // Se o nó é nulo, não faz nada

        Node<E> prevNode = node.getPrev();
        Node<E> nextNode = node.getNext();

        if (prevNode != null) {
            prevNode.setNext(nextNode); // Atualiza o ponteiro do nó anterior
        } else {
            head = nextNode; // Se o nó é o primeiro, atualiza o head
        }

        if (nextNode != null) {
            nextNode.setPrev(prevNode); // Atualiza o ponteiro do próximo nó
        } else {
            tail = prevNode; // Se o nó é o último, atualiza o tail
        }

        size--; // Decrementa o tamanho da lista
    }

    // Método para imprimir todos os elementos da lista
    public void display() {
        Node<E> current = head;
        while (current != null) {
            System.out.println(current.getElement());
            current = current.getNext();
        }
    }
}