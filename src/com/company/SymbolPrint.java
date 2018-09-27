package com.company;

public class SymbolPrint implements Runnable {
    char symbol;
    char previousSymbol;
    Object monitor;
    Character currentSymbol;

    public SymbolPrint(char symbol, char previousSymbol, Object monitor, Character currentSymbol) {
        this.symbol = symbol;
        this.previousSymbol = previousSymbol;
        this.monitor = monitor;
        this.currentSymbol = currentSymbol;
    }

    @Override
    public void run() {

    }
}
