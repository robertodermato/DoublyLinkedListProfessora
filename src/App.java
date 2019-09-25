
public class App {
    public static void main(String[] args) {
        DoubleLinkedListOfInteger lista = new DoubleLinkedListOfInteger();
        lista.add(10);
        lista.add(21);
        lista.add(32);
        lista.add(43);
        lista.add(54);
        lista.add(65);
        lista.add(76);
        lista.add(97);

        System.out.println("Conteudo da lista:\n"+lista);

        System.out.println("Elemento da posicao 0: " +lista.get(0));
        System.out.println("Elemento da posicao 2: " +lista.get(2));
        System.out.println("Elemento da posicao 5: " +lista.get(5));
        System.out.println("Elemento da posicao 7: " +lista.get(7));

        lista.removeByIndex(0);
        lista.removeByIndex(6);
        lista.removeByIndex(2);

        System.out.println("\nConteudo da lista apos remover elementos das posicoes 0,6 e 2 (nesta ordem):\n"+lista);

    }
}

