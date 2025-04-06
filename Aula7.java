public class Aula7 {
    private int size;
    private Integer[] slots;
    private String[] data;

    public Aula7() {
        size = 11;
        slots = new Integer[size];
        data = new String[size];
    }

    public void put(int key, String value) {
        int hashValue = hashFunction(key);

        // Se o slot está vazio, insere a chave e os dados
        if (slots[hashValue] == null) {
            slots[hashValue] = key;
            data[hashValue] = value;
        } else {
            // Se o slot contém a mesma chave, substitui os dados
            if (slots[hashValue] == key) {
                data[hashValue] = value;  // Substitui os dados
            } else {
                // Caso contrário, procura o próximo slot vazio
                int nextSlot = rehash(hashValue);
                while (slots[nextSlot] != null && slots[nextSlot] != key) {
                    nextSlot = rehash(nextSlot);
                }

                // Insere a chave e os dados no próximo slot vazio encontrado
                if (slots[nextSlot] == null) {
                    slots[nextSlot] = key;
                    data[nextSlot] = value;
                } else {
                    // Se encontrar a mesma chave, substitui os dados
                    data[nextSlot] = value;  // Substitui os dados
                }
            }
        }
    }

    private int hashFunction(int key) {
        return key % size;
    }

    private int rehash(int oldHash) {
        return (oldHash + 1) % size;
    }

    public String get(int key) {
        int startSlot = hashFunction(key);
        int position = startSlot;
        while (slots[position] != null) {
            if (slots[position] == key) {
                return data[position];
            }
            position = rehash(position);
            if (position == startSlot) {
                break;
            }
        }
        return null;  // Retorna null se a chave não for encontrada
    }

    public String getByKey(int key) {
        return get(key);
    }

    public void setByKey(int key, String value) {
        put(key, value);
    }

    public static void main(String[] args) {
        Aula7 hashTable = new Aula7();

        hashTable.setByKey(54, "Capivara");
        hashTable.setByKey(26, "Cachorro");
        hashTable.setByKey(93, "Lontra");
        hashTable.setByKey(17, "Tigre");
        hashTable.setByKey(77, "Águia");
        hashTable.setByKey(31, "Peixe");
        hashTable.setByKey(44, "Zebra");
        hashTable.setByKey(55, "Leopardo");


        System.out.println("Tabela antes da mudança:");
        System.out.println(hashTable.getByKey(54));  // Saída: Capivara
        System.out.println(hashTable.getByKey(17));  // Saída: Tigre
        System.out.println(hashTable.getByKey(93));  // Saída: Lontra
        System.out.println(hashTable.getByKey(44));  // Saída: Zebra

        System.out.println();

        // Atualizar valor existente
        hashTable.setByKey(44, "Tamanduá");

        System.out.println("Tabela após mudança:");
        System.out.println(hashTable.getByKey(54));  // Saída: Capivara
        System.out.println(hashTable.getByKey(17));  // Saída: Tigre
        System.out.println(hashTable.getByKey(93));  // Saída: Lontra
        System.out.println(hashTable.getByKey(44));  // Saída: Tamanduá
    }
}