package br.com.bicmsystems.library;

import br.com.bicmsystems.library.model.Book;
import br.com.bicmsystems.library.model.ReserveBook;

import java.time.LocalDate;

public class AppLibrary {

    public static void main(String[] args) {

        var book = new Book("Percy Jackson e os Olimpianos", "Rick Riordan", LocalDate.of(2002, 04, 06));
        var operation = new ReserveBook(book);

        Thread reserveJoao = new Thread(operation, "João");
        Thread reserveMaria = new Thread(operation, "Maria");

        reserveJoao.start();
        reserveMaria.start();

        try {
            reserveJoao.join();
            reserveMaria.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Reservas finalizadas!");
    }

}
