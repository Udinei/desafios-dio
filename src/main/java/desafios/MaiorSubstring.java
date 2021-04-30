package main.java.desafios;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 * Desafio - Encontre a maior substring
 * Encontre a maior substring comum entre as duas strings informadas. A substring pode ser qualquer parte da string, inclusive ela toda. Se não houver subseqüência comum, a saída deve ser “0”. A comparação é case sensitive ('x' != 'X').
 *
 * Entrada
 * A entrada contém vários casos de teste. Cada caso de teste é composto por duas linhas, cada uma contendo uma string. Ambas strings de entrada contém entre 1 e 50 caracteres ('A'-'Z','a'-'z' ou espaço ' '), inclusive, ou no mínimo uma letra ('A'-'Z','a'-'z').
 *
 * Saída
 * O tamanho da maior subsequência comum entre as duas Strings.
 *
 *
 * Exemplo de Entrada	Exemplo de Saída
 * abcdef
 * cdofhij
 * TWO
 * FOUR
 * abracadabra
 * open
 * Hey This java is hot
 * Java is a new paradigm
 *
 * 2
 * 1
 * 0
 * 7
 *
 *
 *
 * ENTRADAS:
 * abcdef
 * cdofhij
 * TWO
 * FOUR
 * abracadabra
 * open
 * Hey This java is hot
 * Java is a new paradigm
 * SAIDAS:
 * 2
 * 1
 * 0
 * 7
 * */
public class MaiorSubstring {

    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) throws IOException {
        String min = "", max="", string1="", string2="";

        // enquanto a rimeira entrada for valida ""
        while ((string1 = in.readLine()) != null) { // complete seu código
                string2 = in.readLine(); // aguarde a segunda entrada "linha"

          // identifica e classifica a maior e menor string
         if (string1.length() > string2.length()) {
              max = string1;
              min = string2;
            } else {
                max = string2;
                min = string1;
            }

            int minLength = min.length();
            int maxS = minLength; // maxS variavel de controle, para percorrer a maior string até o tamanho maximo da menor
            boolean naoContem = true;

            while (maxS > 0 && naoContem) { //altere as variaveis, se achar necessario
                int diff = minLength - maxS;
                for (int i = 0; i <= diff ; i++ ) { //complete o laco de repeticao
                    if (max.contains(min.substring(i, i + maxS))) {
                        naoContem = false;
                        maxS++;
                        break;
                    }
                }
                maxS--;
            }
            System.out.println(maxS);
        }
        out.close();
    }

}