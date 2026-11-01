#!/usr/bin/env sh
set -eu
cd "$(dirname "$0")"
mkdir -p out
javac -encoding UTF-8 -d out src/main/java/br/com/lazaro/algoritmos/*.java src/test/java/br/com/lazaro/algoritmos/*.java
java -cp out br.com.lazaro.algoritmos.Testes
java -cp out br.com.lazaro.algoritmos.Main "$@"
