package br.com.bicmsystems.print;

import br.com.bicmsystems.print.model.Printer;

public class AppPrinter {

    public static void main(String[] args) {

        var printer1 = new Printer("Sala");
        var printer2 = new Printer("Escritório");

        Thread threadPrinter1 = Thread.startVirtualThread(printer1);
        Thread threadPrinter2 = Thread.startVirtualThread(printer2);


        try {
            threadPrinter1.join();
            threadPrinter2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Impressão finalizada!");
    }


}
