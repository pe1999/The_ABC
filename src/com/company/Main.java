package com.company;

public class Main {
    private static final char[] SYMBOLS = {'A', 'B', 'C'};
    private static final int NUMBER_OF_SYMBOLS = 5;
    private static Object monitor = new Object();
    private static volatile MyChar currentSymbol = new MyChar(SYMBOLS[0]);

    public static void main(String[] args) {
        for (int i = 0; i < SYMBOLS.length; i++) {
            new Thread(new SymbolPrint(SYMBOLS[i], SYMBOLS[(i + 1) % SYMBOLS.length], NUMBER_OF_SYMBOLS, monitor, currentSymbol)).start();
        }
    }
}
