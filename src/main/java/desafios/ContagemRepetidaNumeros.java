package main.java.desafios;

import java.util.*;
/**
 * Contagem repetida de números
 * Neste desafio sua tarefa será ler vários números e em seguida dizer quantas vezes cada número aparece, ou seja,
 * deve-se escrever cada um dos valores distintos que aparecem na entrada por ordem crescente de valor.
 *
 * Entrada
 * A primeira linha de entrada contem um único inteiro N, que indica a quantidade de valores que serão lidos para X
 * (1 ≤ N ≤ 2000) logo em seguida. Com certeza cada número não aparecerá mais do que 20 vezes na entrada de dados.
 *
 * Saída
 * Imprima a saída de acordo com o exemplo fornecido abaixo, indicando quantas vezes cada um deles aparece na entrada
 * por ordem crescente de valor.
 *
 *Exemplo de entrada
   7
   8
   10
   8
   260
   4
   10
   10

 * Saida
  4 aparece 1 vez(es)
  8 aparece 2 vez(es)
  10 aparece 3 vez(es)
  260 aparece 1 vez(es)

 * Site referencias: https://www.concretepage.com/java/java-8/java-map-compute
 * */
public class ContagemRepetidaNumeros {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<Integer> listNumeros = new ArrayList<Integer>();

        int qtdValores = sc.nextInt();

        while(qtdValores > 0) {
            listNumeros.add(sc.nextInt());
            qtdValores--;
        }

        SortedMap<Integer, Integer> contaQuant = new TreeMap<>();

        listNumeros.forEach(id -> contaQuant.compute(id, (k , v) -> ( v == null ? 1 : v + 1)));


        contaQuant.entrySet().forEach(entry -> {
            System.out.printf("%d aparece %d vez(es)\n", entry.getKey(), entry.getValue());
        });

        sc.close();
    }
}
