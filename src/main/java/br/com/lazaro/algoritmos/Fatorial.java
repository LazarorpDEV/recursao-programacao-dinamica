package br.com.lazaro.algoritmos;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/** Três implementações: recursão pura, memoização e tabulação. */
public final class Fatorial {
    private Fatorial() { }

    public static BigInteger recursivo(int n) {
        validar(n);
        // Condição de parada: 0! = 1! = 1.
        if (n <= 1) return BigInteger.ONE;
        return BigInteger.valueOf(n).multiply(recursivo(n - 1));
    }

    private static void validar(int n) {
        if (n < 0) throw new IllegalArgumentException("O número deve ser não negativo.");
    }

    /** Cache pertence à instância e é reutilizado entre consultas. Não é thread-safe. */
    public static final class TopDown {
        private final Map<Integer, BigInteger> memo = new HashMap<>();
        public TopDown() {
            memo.put(0, BigInteger.ONE);
            memo.put(1, BigInteger.ONE);
        }
        public BigInteger calcular(int n) {
            validar(n);
            BigInteger salvo = memo.get(n);
            if (salvo != null) return salvo;
            BigInteger resultado = BigInteger.valueOf(n).multiply(calcular(n - 1));
            memo.put(n, resultado);
            return resultado;
        }
        public int resultadosArmazenados() { return memo.size(); }
    }

    /** Tabulação iterativa: não utiliza a pilha de chamadas recursivas. */
    public static final class BottomUp {
        private final List<BigInteger> tabela = new ArrayList<>();
        public BottomUp() {
            tabela.add(BigInteger.ONE); // 0!
            tabela.add(BigInteger.ONE); // 1!
        }
        public BigInteger calcular(int n) {
            validar(n);
            for (int i = tabela.size(); i <= n; i++) {
                tabela.add(tabela.get(i - 1).multiply(BigInteger.valueOf(i)));
            }
            return tabela.get(n);
        }
        public int resultadosArmazenados() { return tabela.size(); }
    }
}
