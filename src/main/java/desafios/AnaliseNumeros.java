package main.java.desafios;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Analise de Numeros
 * Você deve fazer a leitura de 5 valores inteiros. Em seguida mostre quantos valores informados são pares, quantos
 * valores informados são ímpares, quantos valores informados são positivos e quantos valores informados são negativos.
 *
 * Entrada
 * Você receberá 5 valores inteiros.
 *
 * Saída
 * Exiba a mensagem conforme o exemplo de saída abaixo, sendo uma mensagem por linha e não esquecendo o final de
 * linha após cada uma.
 *
 * Exemplo de Entrada
  -5
  0
  -3
  -4
  12
 * Saida
  3 valor(es) par(es)
  2 valor(es) impar(es)
  1 valor(es) positivo(s)
  3 valor(es) negativo(s)
 * */
public class AnaliseNumeros {

    public static void main(String[] args) throws IOException {
        Scanner leitor = new Scanner(System.in);

        //declare suas variaveis corretamente
        int n1 = leitor.nextInt();
        int n2 = leitor.nextInt();
        int n3 = leitor.nextInt();
        int n4 = leitor.nextInt();
        int n5 = leitor.nextInt();

        List list = Arrays.asList(n1, n2, n3,  n4, n5);
        int vPar = 0;
        int vInPar = 0;
        int vNeg = 0;
        int vPos = 0;

        //continue a solução
        for (int i=0; i <= list.size()-1; i++) {
            int num = (int) list.get(i);

            // valores impares
            if(Math.abs(num) % 2 != 0) {
                vInPar++;
            }

            // valores pares
           if(Math.abs(num) % 2 == 0){
                    vPar++;
            }

            // valores negativos
            if(num < 0) {
                vNeg++;
            }

            // valores positivos
            if(num > 0){
               vPos++;
            }

        }

       //insira suas variaveis corretamente
        System.out.println(vPar + " valor(es) par(es)");
        System.out.println(vInPar + " valor(es) impar(es)");
        System.out.println(vPos + " valor(es) positivo(s)");
        System.out.println(vNeg + " valor(es) negativo(s)");
        leitor.close();
    }


}
