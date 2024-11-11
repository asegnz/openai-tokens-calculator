package com.asegnz;

import com.knuddels.jtokkit.Encodings;
import com.knuddels.jtokkit.api.Encoding;
import com.knuddels.jtokkit.api.EncodingRegistry;
import com.knuddels.jtokkit.api.EncodingType;
import com.knuddels.jtokkit.api.IntArrayList;

import java.math.BigDecimal;

import static java.math.RoundingMode.HALF_UP;

public class Calculadora {

    private final static BigDecimal millon = new BigDecimal("1000000");
    public static final int DECIMAL_SCALE = 10;
    private final String consulta;
    private final int maxTokens;
    private final Precio precio;


    public Calculadora(String consulta, int maxTokens, Precio precio) {
        this.consulta = consulta;
        this.maxTokens = maxTokens;
        this.precio = precio;
    }

    public BigDecimal calcula() {
        int inputToken = numeroTokens(consulta);
        BigDecimal inputCoste = coste(inputToken, precio.input());
        BigDecimal outputCoste = coste(maxTokens, precio.output());
        System.out.println("El coste de la consulta es: " + inputCoste + " $ y el coste esperado de la respuesta de ChatGPT es: " + outputCoste + " $");
        BigDecimal totalCoste = inputCoste.add(outputCoste);
        return totalCoste;
    }

    private BigDecimal coste(int tokens, BigDecimal costePorMillon) {
        // Regla de tres:
        // 300 tokens - X
        // 1000000 - costePorMillon
        BigDecimal aux = costePorMillon.multiply(new BigDecimal(tokens));
        return aux.divide(millon, DECIMAL_SCALE, HALF_UP);
    }

    private int numeroTokens(String consulta) {
        EncodingRegistry registry = Encodings.newDefaultEncodingRegistry();
        Encoding enc = registry.getEncoding(EncodingType.O200K_BASE); //o200k_base
        long inicio = System.nanoTime();
        IntArrayList encoded = enc.encode(consulta);
        long fin = System.nanoTime();
        System.out.println("Esta conversión ha tardado "+ (fin - inicio) +" nanosegundos");
        System.out.println("La consulta '" + consulta + "' se ha codificado en " + encoded + " y son " + encoded.size() + " tokens.");
        return encoded.size();
    }

}
