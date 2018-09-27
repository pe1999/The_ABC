package com.company;

public class SymbolPrint implements Runnable {
    private char symbol;
    private char nextSymbol;
    private int numberOfSymbols;
    private Object monitor;
    private MyChar currentSymbol;

    public SymbolPrint(char symbol, char nextSymbol, int numberOfSymbols, Object monitor, MyChar currentSymbol) {
        this.symbol = symbol;
        this.nextSymbol = nextSymbol;
        this.numberOfSymbols = numberOfSymbols;
        this.monitor = monitor;
        this.currentSymbol = currentSymbol;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < numberOfSymbols; i++) {
                synchronized (monitor) {
                    while(currentSymbol.value != symbol) {
                        monitor.wait();
                    }
                    System.out.print(symbol);
                    currentSymbol.value = nextSymbol;
                    monitor.notifyAll();
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
