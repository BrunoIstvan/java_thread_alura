package br.com.bicmsystems.print.model;

public class Printer implements Runnable {
    private String id;

    public Printer(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }


    public void run() {
        for (int i = 1; i <= 10; i++) {
            System.out.println("Impressora " + id + "	valor:	" + i);
        }
    }

}
