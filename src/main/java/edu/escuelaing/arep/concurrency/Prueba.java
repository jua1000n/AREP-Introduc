package edu.escuelaing.arep.concurrency;

import java.io.IOException;
import java.util.ArrayList;

public class Prueba {
    public static void main(String[] args) throws IOException {
        int thread = 10;
        ArrayList<VerifyConcurrencyConect> concurrencyConect = new ArrayList<>();
        for (int i = 0; i< thread; i++) {
            concurrencyConect.add(new VerifyConcurrencyConect());
        }
        for (int i = 0; i< thread; i++) {
            concurrencyConect.get(i).threadStart();
            concurrencyConect.get(i).threadJoin();
        }
        int q = 0;
        for (int i = 0; i< thread; i++) {
            if (concurrencyConect.get(i).getRes().equals( "{\"result\":-12.22}")) {
                q++;
            }
        }
        if (q == thread) {
            System.out.println("Respuesta correcta");
        }
    }
}
