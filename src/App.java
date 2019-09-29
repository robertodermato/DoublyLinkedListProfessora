
public class App {
    public static void main(String[] args) {
        DoubleLinkedListOfInteger lista = new DoubleLinkedListOfInteger();
        lista.add(1);
        lista.add(2);
        lista.add(3);
        lista.add(3);
        lista.add(5);
        lista.add(6);

        System.out.println("Conteudo da lista:\n"+lista);

        //System.out.println("Testando add (index, element)");
        //lista.add(6,9);
        //System.out.println("Conteudo da lista:\n"+lista);

        //System.out.println("Elemento da posicao 0: " +lista.get(0));
        //System.out.println("Elemento da posicao 2: " +lista.get(2));
        //System.out.println("Elemento da posicao 5: " +lista.get(5));
        //System.out.println("Elemento da posicao 7: " +lista.get(7));

        //lista.removeByIndex(0);
        //lista.removeByIndex(6);
        //lista.removeByIndex(2);

        //System.out.println("\nConteudo da lista apos remover elementos das posicoes 0,6 e 2 (nesta ordem):\n"+lista);

        /*
        System.out.println( "Testando boolean remove(int element)");
        boolean remove = lista.remove(1);
        System.out.println("Elemento removido " + remove);
        System.out.println("Conteudo da lista:\n"+lista);



        System.out.println("testando set (index, element)");
        lista.set(4, 9);
        System.out.println("Conteudo da lista:\n"+lista);



        System.out.println("Testando toStringBackToFront");
        String listaInvertida = lista.toStringBackToFront();
        System.out.println("Lista invertida: \n" + listaInvertida);
        */

        //System.out.println("Testando reverse");
        //lista.reverse();
        //System.out.println("Conteudo da lista:\n"+lista);

        //System.out.println("Testando conta ocorrencias");
        //int conta = lista.contaOcorrencias(3);
        //System.out.println(conta);

        //System.out.println("Testando sublist");
        //int[] arr = lista.subList(2,4);
        //System.out.println(arr[0] + " " + arr[1]);

        System.out.println("Testando unique");
        lista.unique();
        System.out.println("Conteudo da lista:\n"+lista);
    }
}

