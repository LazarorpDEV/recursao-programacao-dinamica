package br.com.lazaro.algoritmos;

import java.math.BigInteger;

/** Testes executáveis sem bibliotecas externas; falha produz saída não zero. */
public final class Testes {
    private static int total;
    private static void igual(Object esperado, Object obtido) {
        total++;
        if (!esperado.equals(obtido)) throw new AssertionError("Esperado: " + esperado + "; obtido: " + obtido);
    }
    private static void rejeita(Runnable chamada) {
        total++;
        try { chamada.run(); }
        catch (IllegalArgumentException e) { return; }
        throw new AssertionError("Entrada negativa deveria ser rejeitada.");
    }
    public static void main(String[] args) {
        Fatorial.TopDown td = new Fatorial.TopDown();
        Fatorial.BottomUp bu = new Fatorial.BottomUp();
        int[] entradas = {0, 1, 2, 3, 7, 10, 20};
        String[] valores = {"1", "1", "2", "6", "5040", "3628800", "2432902008176640000"};
        for (int i = 0; i < entradas.length; i++) {
            BigInteger esperado = new BigInteger(valores[i]);
            igual(esperado, Fatorial.recursivo(entradas[i]));
            igual(esperado, td.calcular(entradas[i]));
            igual(esperado, bu.calcular(entradas[i]));
        }
        BigInteger cem = new BigInteger("93326215443944152681699238856266700490715968264381621468592963895217599993229915608941463976156518286253697920827223758251185210916864000000000000000000000000");
        igual(cem, Fatorial.recursivo(100));
        BigInteger centoUm = cem.multiply(BigInteger.valueOf(101));
        igual(centoUm, Fatorial.recursivo(101));
        igual(centoUm, td.calcular(101));
        igual(centoUm, bu.calcular(101));
        igual(102, td.resultadosArmazenados());
        igual(102, bu.resultadosArmazenados());
        igual(centoUm, td.calcular(101));
        igual(centoUm, bu.calcular(101));
        igual(cem, td.calcular(100));
        igual(cem, bu.calcular(100));
        igual(102, td.resultadosArmazenados());
        igual(102, bu.resultadosArmazenados());
        igual(16326, bu.calcular(5000).toString().length());
        BigInteger[] fib = {BigInteger.ZERO, BigInteger.ONE, BigInteger.ONE,
            BigInteger.valueOf(2), BigInteger.valueOf(3), BigInteger.valueOf(5)};
        for (int i = 0; i < fib.length; i++) {
            igual(fib[i], Fibonacci.recursivo(i));
            igual(fib[i], Fibonacci.topDown(i));
            igual(fib[i], Fibonacci.bottomUp(i));
        }
        igual(BigInteger.valueOf(55), Fibonacci.recursivo(10));
        igual(new BigInteger("354224848179261915075"), Fibonacci.topDown(100));
        igual(new BigInteger("354224848179261915075"), Fibonacci.bottomUp(100));
        rejeita(() -> Fatorial.recursivo(-1));
        rejeita(() -> td.calcular(-1));
        rejeita(() -> bu.calcular(-1));
        rejeita(() -> Fibonacci.recursivo(-1));
        rejeita(() -> Fibonacci.topDown(-1));
        rejeita(() -> Fibonacci.bottomUp(-1));
        System.out.println("SUCESSO: " + total + " verificações passaram.");
    }
}
