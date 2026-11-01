package br.com.lazaro.algoritmos;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

/** Versões clássicas usadas como referência para a análise do exercício 3. */
public final class Fibonacci {
    private Fibonacci() { }
    private static void validar(int n) {
        if (n < 0) throw new IllegalArgumentException("O índice deve ser não negativo.");
    }
    public static BigInteger recursivo(int n) {
        validar(n);
        if (n <= 1) return BigInteger.valueOf(n);
        return recursivo(n - 1).add(recursivo(n - 2));
    }
    public static BigInteger topDown(int n) {
        validar(n);
        Map<Integer, BigInteger> memo = new HashMap<>();
        memo.put(0, BigInteger.ZERO);
        memo.put(1, BigInteger.ONE);
        return calcular(n, memo);
    }
    private static BigInteger calcular(int n, Map<Integer, BigInteger> memo) {
        BigInteger salvo = memo.get(n);
        if (salvo != null) return salvo;
        BigInteger valor = calcular(n - 1, memo).add(calcular(n - 2, memo));
        memo.put(n, valor);
        return valor;
    }
    public static BigInteger bottomUp(int n) {
        validar(n);
        if (n <= 1) return BigInteger.valueOf(n);
        BigInteger[] tabela = new BigInteger[n + 1];
        tabela[0] = BigInteger.ZERO;
        tabela[1] = BigInteger.ONE;
        for (int i = 2; i <= n; i++) tabela[i] = tabela[i - 1].add(tabela[i - 2]);
        return tabela[n];
    }
}
