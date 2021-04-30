package main.java.desafios;

import java.io.IOException;
import java.util.*;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Desafio - Conjunto bons ou ruins
 * Nesse algoritmo você deverá descobrir se um conjunto de palavras é bom ou ruim. Por definição, um conjunto é bom
 * quando nenhuma palavra desse conjunto é um prefixo de outra palavra. Caso contrário, é considerado um conjunto ruim.
 *
 * Por exemplo, {dbc, dae, dbcde} é um conjunto ruim, pois dbc é um prefixo de dbcde. Quando duas palavras são
 * idênticas, definimos como uma sendo prefixo da outra.
 *
 * Entrada
 * A entrada contém vários casos de teste. A primeira linha de cada caso de teste terá um inteiro N (1 ≤ N ≤ 10⁵),
 * que representa a quantidade de palavras no conjunto. Segue então N linhas, cada uma tendo uma palavra de no máximo
 * 100 letras minúsculas. A entrada termina quando N = 0 e não deve ser processada.
 *
 * Saída
 * Para cada caso de teste, você deverá imprimir "Conjunto Bom", ou "Conjunto Ruim", conforme explicado acima.
 *
 *
 * Exemplo de Entrada
 * 3
 * abc
 * dae
 * abcde
 * 2
 * abc
 * def
 * 0
 *Exemplo de Saída
 * Conjunto Ruim
 * Conjunto Bom
 *
 * Desafio no URI: 2087
 * Entradas
 * 2
 * abc
 * abcdef
 * 2
 * abcdef
 * abc
 * 2
 * acde
 * acde
 * 0
 *
 *
 *
 * */

public class ConjuntosBomRuins {

    public static void main(String[] args) throws IOException {
        ArrayList<String> conjunto = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        String linha = scanner.nextLine().toLowerCase(Locale.ROOT).trim();
        while (!linha.equals("0") && linha.length() <= 100) {

            // o conjunto sempre inicia com um numero, se for zero ou maior que 100, sai do loop
            if (linha.matches("[0]"))
                break;

            // avanca a qtd de linhas indicada pelo numero
            for (int i = 0; i < Integer.parseInt(linha); i++) {
                if (i == 0)
                    conjunto.add(linha); // posicao zero será sempre um numero
                conjunto.add(scanner.nextLine()); // letras
            }

            analisaConjunto(conjunto);
            conjunto.clear();

            linha = scanner.nextLine().toLowerCase(Locale.ROOT).trim();
        }
        System.exit(0);
    }


    private static void analisaConjunto(List<String> conjunto) {
        boolean isPalavraRepetida = false;

        for (String palavra : conjunto) {
            // processa somente letras
            if (!palavra.matches("[0-9]+")) {
                // existe strings repetidas no conjunto, que inicia com a palavra, entao retorna um numero > 1
                if(conjunto.stream() .filter(string -> string.startsWith(palavra)).collect(Collectors.toList()).stream().count() > 1)
                    isPalavraRepetida = true;
            }
        }
        System.out.println(isPalavraRepetida ? "Conjunto Ruim" : "Conjunto Bom");
    }

}