package br.com.lazaro.algoritmos;

import java.math.BigInteger;

public final class Main {
    public static void main(String[] args) {
        if (args.length > 0) {
            // Para sondar a recursão em processo separado, sem imprimir milhares de dígitos.
            try {
                int n = Integer.parseInt(args[0]);
                BigInteger resultado = Fatorial.recursivo(n);
                System.out.println("Recursivo: " + n + "! calculado; dígitos = " + resultado.toString().length());
            } catch (StackOverflowError e) {
                System.err.println("Limite da pilha atingido nesta JVM para a entrada informada.");
                System.exit(2);
            } catch (IllegalArgumentException e) {
                System.err.println("Informe um inteiro não negativo.");
                System.exit(1);
            }
            return;
        }
        Fatorial.TopDown topDown = new Fatorial.TopDown();
        Fatorial.BottomUp bottomUp = new Fatorial.BottomUp();
        for (int n : new int[]{0, 1, 3, 7, 20, 100, 101}) {
            System.out.println("n = " + n);
            System.out.println("Recursivo: " + Fatorial.recursivo(n));
            System.out.println("Top-down:  " + topDown.calcular(n));
            System.out.println("Bottom-up: " + bottomUp.calcular(n));
        }
        topDown.calcular(101);
        bottomUp.calcular(101);
        System.out.println("Caches após consulta repetida de 101!: "
                + topDown.resultadosArmazenados() + " / " + bottomUp.resultadosArmazenados());
        System.out.println("5000! bottom-up: " + bottomUp.calcular(5000).toString().length() + " dígitos");
        System.out.println("Fibonacci(10): " + Fibonacci.recursivo(10) + " / "
                + Fibonacci.topDown(10) + " / " + Fibonacci.bottomUp(10));
    }
}
