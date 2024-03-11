package br.com.bicmsystems.library.model;

public class ReserveBook implements Runnable {

    private final Book book;

    public ReserveBook(Book book) {
        this.book = book;
    }

    public synchronized void reserve(){
        System.out.println("Iniciando reserva");
        if(!book.getReserved()) {
            book.reserve();
            System.out.println("Reserva efetuada com sucesso! Aproveite a leitura, "
                    + Thread.currentThread().getName());
        } else {
            System.out.println("O livro já foi reservado, "
                    + Thread.currentThread().getName());
        }
    }

    @Override
    public void run() {
        reserve();
    }

}
