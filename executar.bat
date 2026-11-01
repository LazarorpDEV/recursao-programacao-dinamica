@echo off
chcp 65001 >nul
cd /d "%~dp0"
if not exist out mkdir out
javac -encoding UTF-8 -d out src\main\java\br\com\lazaro\algoritmos\*.java src\test\java\br\com\lazaro\algoritmos\*.java
if errorlevel 1 exit /b 1
java -cp out br.com.lazaro.algoritmos.Testes
if errorlevel 1 exit /b 1
java -cp out br.com.lazaro.algoritmos.Main %*
