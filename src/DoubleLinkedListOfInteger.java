public class DoubleLinkedListOfInteger {

    // Referencia para o sentinela de inicio da lista encadeada.
    private Node header;
    // Referencia para o sentinela de fim da lista encadeada.
    private Node trailer;
    // Contador do numero de elementos da lista.
    private int count;

    private class Node {
        public Integer element;
        public Node next;
        public Node prev;
        public Node(Integer e) {
            element = e;
            next = null;
            prev = null;
        }
    }

    /**
     * Metodo construtor.
     */
    public DoubleLinkedListOfInteger() {
        header = new Node(null);
        trailer = new Node(null);
        header.next = trailer;
        trailer.prev = header;
        count = 0;
    }

    /**
     * Adiciona um elemento ao final da lista
     * @param element elemento a ser adicionado ao final da lista
     */
    public void add(Integer element) {
        // Cria o nodo
        Node n = new Node(element);

        // Atualiza as referencias do nodo criado para liga-lo na lista
        Node last = trailer.prev;
        n.prev = last;
        n.next = trailer;

        // Atualiza as referencias para incluir o nodo criado
        last.next = n;
        trailer.prev = n;

        // Atualiza o contador
        count++;
    }

    // Metodo privado que retorna a referência para o nodo
    // da posicao index, percorrendo a lista de forma otimizada.
    private Node getRefNode(int index) {
        Node aux = null;
        if (index <= count / 2) {
            aux = header.next;
            for (int i = 0; i < index; i++) {
                aux = aux.next;
            }
        } else {
            aux = trailer.prev;
            for (int i = count - 1; i > index; i--) {
                aux = aux.prev;
            }
        }
        return aux;
    }

    /**
     * Retorna o elemento de uma determinada posicao da lista
     * @param index a posicao da lista
     * @return o elemento da posicao especificada
     * @throws IndexOutOfBoundsException se (index < 0 || index >= size())
     */
    public Integer get(int index) {
        // Verifica se o indice e´ valido
        if ((index < 0) || (index >= count)) {
            throw new IndexOutOfBoundsException();
        }

        // Pega a referencia para o nodo da posicao "index"
        Node aux = getRefNode(index);

        // Retorna o elemento da posicao "index"
        return aux.element;
    }

    /**
     * Remove o elemento de uma determinada posicao da lista
     * @param index a posicao da lista
     * @return o elemento que foi removido da lista
     * @throws IndexOutOfBoundsException se (index < 0 || index >= size())
     */
    public Integer removeByIndex(int index) {
        // Verifica se o indice e´ valido
        if ((index < 0) || (index >= count)) {
            throw new IndexOutOfBoundsException("Index = " + index);
        }

        // Pega a referencia para o nodo da posicao "index"
        Node aux = getRefNode(index);

        // Remove o nodo da lista
        aux.prev.next = aux.next;
        aux.next.prev = aux.prev;

        // Atualiza o contador
        count--;

        // Retorna o elemento que foi removido
        return aux.element;
    }

    /**
     * Insere um elemento em uma determinada posicao da lista
     * @param index a posicao da lista onde o elemento sera inserido
     * @param element elemento a ser inserido
     * @throws IndexOutOfBoundsException se (index < 0 || index > size())
     */
    public void add(int index, Integer element) {
        if (index<0 || index>count) throw new IndexOutOfBoundsException("Index = " + index);

        // Cria o nodo
        Node n = new Node(element);

        if (index==count){
            n.prev=trailer.prev;
            trailer.prev.next=n;
            n.next=trailer;
            trailer.prev=n;
            count++;
            return;
        }

        // Pega a referencia para o nodo da posicao "index"
        Node aux = getRefNode(index);

        // Insere o nodo da lista
        aux.prev.next = n;
        n.next = aux;
        aux.prev = n;
        n.prev = aux.prev;

        // Atualiza o contador
        count++;

    }

    /**
     * Remove a primeira ocorrencia do elemento na lista, se estiver presente
     * @param element o elemento a ser removido
     * @return true se a lista contem o elemento especificado
     */
    public boolean remove(Integer element) {
        //testa se o elemento existe
        if (contains(element)==false) return false;


        Node aux = header.next;
        for (int i = 0; i < count; i++) {
            if (aux.element==element) {removeByIndex(i); return true;}
                aux = aux.next;

            }
        return false;
    }

    /**
     * Substitui o elemento armanzenado em uma determinada posicao da lista pelo elemento indicado
     * @param index a posicao da lista
     * @param element o elemento a ser armazenado na lista
     * @return o elemento armazenado anteriormente na posicao da lista
     * @throws IndexOutOfBoundsException se (index < 0 || index >= size())
     */
    public Integer set(int index, Integer element) {
        // pega o nodo do indice
        Node aux = getRefNode(index);
        Integer elAux = aux.element;
        aux.element=element;
        return elAux;
    }

    /**
     * Retorna true se a lista contem o elemento especificado
     * @param element o elemento a ser testado
     * @return true se a lista contém o elemento especificado
     */
    public boolean contains(Integer element) {
        Node aux = header.next;
        while (aux != trailer) {
            if (aux.element.equals(element)) {
                return (true);
            }
            aux = aux.next;
        }
        return false;
    }

    /**
     * Retorna o indice da primeira ocorrencia do elemento na lista, ou -1 se a lista não contém o elemento
     * @param element o elemento a ser buscado
     * @return o indice da primeira ocorrencia do elemento na lista, ou -1 se a lista não contém o elemento
     */
    public int indexOf(Integer element) {
        Node aux = header.next;
        for(int i=0; i<count; i++) {
            if (aux.element.equals(element)) {
                return i;
            }
            aux = aux.next;
        }
        return -1;
    }

    /**
     * Esvazia a lista
     */
    public void clear() {
        header = new Node(null);
        trailer = new Node(null);
        header.next = trailer;
        trailer.prev = header;
        count = 0;
    }

    /**
     * Retorna o numero de elementos da lista
     * @return o numero de elementos da lista
     */
    public int size() {
        return count;
    }

    /**
     * Retorna true se a lista não contem elementos
     * @return true se a lista não contem elementos
     */
    public boolean isEmpty() {
        return (count == 0);
    }

    @Override
    public String toString()
    {
        StringBuilder s = new StringBuilder();
        Node aux = header.next;
        for (int i = 0; i < count; i++) {
            s.append(aux.element.toString());
            s.append("\n");
            aux = aux.next;
        }
        return s.toString();
    }

    public String toStringBackToFront(){
        StringBuilder s = new StringBuilder();
        Node aux = trailer.prev;
        for (int i = count-1; i >=0; i--) {
            s.append(aux.element.toString());
            s.append("\n");
            aux = aux.prev;
        }
        return s.toString();
    }

    // retorna um arranjo com os elementos da lista original entre fromIndex (inclusivo) e toIndex (exclusivo).
    public int[] subList(int fromIndex, int toIndex){
        int[] arr = new int[toIndex-fromIndex];
        Node aux = getRefNode(fromIndex);
        int j=0;
        for(int i=fromIndex; i<toIndex; i++ ){
            arr[j]=aux.element;
            j++;
            aux=aux.next;
        }
        return arr;
    }

/*
    // inverte o conteúdo da lista.
    public void reverse2(){
        // se lista está vazia é só retornar;
        if (isEmpty()) return;

        Node aux= header.next;
        Node ant = header;
        //Node post = header.next.next;

        for (int i=0; i< count; i++){
            aux.next=ant;
            //aux.prev=post;
            ant.next=ant.prev;
            //post.prev=post.next;
            //post.next=aux;
            ant.prev=aux;


            aux=aux.prev;
            ant=ant.prev;
            //post=post.prev;

        }

        Node newHeader = trailer;
        Node newTrailer = header;
        header=newHeader;
        trailer=newTrailer;

    }

    */

    public void reverse() {
        if (isEmpty()) return;
        Node temp = null;
        Node current = header.next;

        /* swap next and prev for all nodes of
         doubly linked list */
        while (current != null) {
            temp = current.prev;
            current.prev = current.next;
            current.next = temp;
            current = current.prev;
        }

        /* Before changing head, check for the cases like empty
         list and list with only one node */
        if (temp != null) {
            header = temp.prev;
        }
    }

    // conta o número de ocorrências do elemento passado como parâmetro na lista, retornando este valor.
    public int contaOcorrencias(int element){
        if (isEmpty()) return 0;
        int contador=0;

        Node aux = header.next;

        for (int i=0; i<count; i++){
            if (aux.element==element) contador++;
            aux=aux.next;
        }
        return contador;
        }


}
