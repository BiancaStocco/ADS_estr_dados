public class Main {
    public static void main(String[] args) {
        // Criando uma lista de inteiros
        DoublyLinkedBase<Integer> list = new DoublyLinkedBase<>();

        // Exemplo 1: Inserir elementos na lista
        list.addLast(10);
        list.addLast(20);
        list.addLast(30);
        list.addLast(40);

        System.out.println("O número de elementos: " + list.size());
        list.display();

        // Exemplo 2: Excluir elementos da lista
        // Obtém o segundo nó
        DoublyLinkedBase.Node<Integer> nodeToDelete = list.getSecondNode();
        if (nodeToDelete != null) {
            list.deleteNode(nodeToDelete); // Exclui o segundo nó
        }

        // Exibe o número de elementos na lista após exclusão
        System.out.println("Tamanho da lista após exclusão: " + list.size());
        list.display();

        // Exemplo 3: Verificar se a lista está vazia
        System.out.println("A lista está vazia? " + list.isEmpty());

        // Removendo todos os elementos
        while (!list.isEmpty()) {
            System.out.println("Removendo: " + list.removeFirst());
        }

        // Verificando se a lista está vazia após a remoção
        System.out.println("A lista está vazia? " + list.isEmpty());

        // Exemplo 4: Inserir elementos no início e no fim da lista
        // Adicionando elementos no início
        list.addFirst(40);

        // Adicionando elementos no final
        list.addLast(50);

        System.out.println("Tamanho da lista após adicionar: " + list.size());
        list.display();
    }
}