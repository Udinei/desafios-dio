package main.java.desafios;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/**
 * Divisores
 Pense um número positivo n. Agora me diga um divisor A de n. Agora me dê um outro número B que não seja divisor de n.
 Agora um múltiplo C. E um não múltiplo D. O número que você pensou é...

 Parece um truque de mágica, mas é matemática! Será que, conhecendo os números A, B, C e D, você consegue descobrir
 qual era o número original n? Note que pode existir mais de uma solução!

 Neste problema, dados os valores de A, B, C e D, você deve escrever um programa que determine qual o menor número n
 que pode ter sido pensado ou concluir que não existe um valor possível.

 Entrada
 A entrada consiste de uma única linha que contém quatro números inteiros A, B, C, e D, como descrito acima (1 ≤ A, B,
 C, D ≤ 109).

 Saída
 Seu programa deve produzir uma única linha. Caso exista pelo menos um número n para os quais A, B, C e D
 façam sentido, a linha deve conter o menor n possível. Caso contrário, a linha deve conter -1.

** Entrada 1
 2 12 8 2

*** Saida 1
 4

** Entrada 2
 3 4 60 105

** Saida 2
 6

 * */
public class Divisores {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A, B, C, D;

        A = Integer.parseInt(st.nextToken()); // divisor de n
        B = Integer.parseInt(st.nextToken()); // nao divisor de n
        C = Integer.parseInt(st.nextToken()); // multiplo de n
        D = Integer.parseInt(st.nextToken()); // nao multiplo de n
        br.close();

        int menorValor = -1; // sera retornado -1 caso nao encontre nenhum valor de n

        // se C é divisivel por A - entao C é multiplo de n e A divisor de N
        if (C % A == 0) {

            // raiz quadrada de C arredondada
            // n é um natural entre 1 e raiz de C
            int sqrt = (int)Math.sqrt(C);

            // de 1 até o maior natural possivel de n - sqrt
            for(int i = 1; i <= sqrt; i++){

                int n = A*i; // i naturais a serem multiplicados, n deve ser multiplo de A

                // n não pode ser divisivel por B e nem por D(n nao é multiplos desses numeros),
                // mas C deve ser divisivel por n
                if ((n % B != 0) && (D % n != 0) && (C % n == 0)) {
                    menorValor = n;
                    break;
                }
                if (i == sqrt){
                    menorValor = n;
                }
            }
        }
        System.out.println(menorValor);
    }
}
