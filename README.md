# Atividade — Recursão e programação dinâmica

Projeto Java sem dependências externas. Requer **JDK 17 ou superior** (com `java` e `javac` no PATH).

## Conteúdo

- `Fatorial.java`: recursão pura, top-down com memoização e bottom-up com tabulação; números exatos com `BigInteger`.
- `Fibonacci.java`: versões clássicas para fundamentar o exercício 3.
- `Testes.java`: casos conhecidos, entradas negativas, 101!, reutilização de cache e 5000! iterativo.
- `RESPOSTAS.txt`: respostas dos três exercícios e análise de complexidade.
- `RESULTADO_VALIDACAO.txt`: registro da execução neste ambiente.

## Executar no Windows

Extraia o ZIP. Abra o PowerShell na pasta que contém `executar.bat` e rode:

```powershell
java -version
javac -version
.\executar.bat
```

No Linux/macOS:

```sh
sh executar.sh
```

O script compila os fontes, executa os testes e mostra exemplos. Se algum teste falhar, ele encerra antes dos exemplos.

## Sondar o limite da recursão

Depois da compilação, execute cada entrada em um processo novo:

```sh
java -cp out br.com.lazaro.algoritmos.Main 101
java -cp out br.com.lazaro.algoritmos.Main 1000
java -cp out br.com.lazaro.algoritmos.Main 5000
```

O modo de sondagem informa o número de dígitos em caso de sucesso ou retorna código 2 se a pilha estourar. Execute valores moderados; não há máximo universal, e a primeira falha não mede um limite estável. `BigInteger` evita overflow numérico, mas não a limitação da pilha.

## Entrega

Leia `RESPOSTAS.txt` e confira o Fibonacci com os slides: eles não foram disponibilizados para esta implementação. Envie o código e as respostas conforme o campo de entrega da EBAC, em ZIP ou pelo link do repositório, se solicitado. A transcrição não exige capturas de tela.

Para versionar: crie um repositório vazio no GitHub e, nesta pasta, rode `git init`, `git add .`, `git commit -m "Implementa recursao e programacao dinamica"`, `git branch -M main`, `git remote add origin URL_DO_REPOSITORIO` e `git push -u origin main`, substituindo a URL pelo endereço real.
