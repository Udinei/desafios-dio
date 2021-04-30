package main.java.desafios;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * Desafio - Validador de senhas com requisitos
 * Pedro e Fernando são os desenvolvedores em uma stratup e vão desenvolver o novo sistema de cadastro, e pediram a
 * sua ajuda. Sua task é fazer o código que valide as senhas que são cadastradas, para isso você deve atentar aos
 * requisitos a seguir:
 *
 * A senha deve conter, no mínimo, uma letra maiúscula, uma letra minúscula e um número;
 * A mesma não pode ter nenhum caractere de pontuação, acentuação ou espaço;
 * Além disso, a senha pode ter de 6 a 32 caracteres.
 * Entrada
 * A entrada contém vários casos de teste e termina com final de arquivo. Cada linha tem uma string S, correspondente
 * a senha que é inserida pelo usuário no momento do cadastro.
 *
 * Saída
 * A saída contém uma linha, que pode ser “Senha valida.”, caso a senha tenha cada item dos requisitos solicitados
 * anteriormente, ou “Senha invalida.”, se um ou mais requisitos não forem atendidos.
 *
 *
 * Exemplo de Entrada
  Digital Innovation One
  AbcdEfgh99
  DigitalInnovationOne123
  Digital Innovation One 123
  Aass9
  Aassd9

 * Exemplo de Saída
  Senha invalida.
  Senha valida.
  Senha valida.
  Senha invalida.
  Senha invalida.
  Senha valida.

 **/
public class ValidadorDeSenha {
    public final static int MAX = 32;
    public final static int MIN = 6;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String senha = "";

        while (scanner.hasNext()) {

            senha = scanner.nextLine();

            String letraHeNumeros = "[A-Za-z0-9]+$"; // nao aceita caracteres especiais

            // transforma string em array de char
            List<Character> listChar = senha.chars().mapToObj(item -> (char) item).collect(Collectors.toList());

            boolean isDigit = listChar.stream().filter(s -> s.isDigit(s)).count() > 0 ? true : false;
            boolean isUpper = listChar.stream().filter(s -> s.isUpperCase(s)).count() > 0 ? true : false;
            boolean isLower = listChar.stream().filter(s -> s.isLowerCase(s)).count() > 0 ? true : false;
            boolean tamanhoOk = (senha.length() >= MIN && senha.length() <= MAX) ? true : false;
            boolean caracterValido = senha.matches(letraHeNumeros);

            /*System.out.println(isDigit);
            System.out.println(isUpper);
            System.out.println(isLower);
            System.out.println(tamanhoOk);
            System.out.println(caracterValido);*/

            if (!isDigit || !isUpper || !isLower || !tamanhoOk || !caracterValido) { //complete o if de acordo com suas variaveis
                System.out.println("Senha invalida.");
            } else {
                System.out.println("Senha valida.");
            }

        }
        scanner.close();
    }
}
