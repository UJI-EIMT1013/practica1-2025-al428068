package practica1;

import java.util.*;

public class Practica1 {

    //EJERCICIO 1
    public static Set<Integer> multiplos (Iterator<Integer> it) {
        List<Integer> elementos = new ArrayList<>();
        Set<Integer> resultado = new HashSet<>();
        while (it.hasNext()) {
            int n = it.next();
            if (n != 0) {
                elementos.add(n);
            }
        }

        for (int i = 0; i < elementos.size(); i++) {
            int actual = elementos.get(i);
            for (int j = 0; j < elementos.size(); j++) {
                if (i != j) {
                    int otro = elementos.get(j);
                    if (otro != 0 && actual % otro == 0) {
                        resultado.add(actual);
                        break;
                    }
                }
            }
        }
        return resultado;
    }

    //EJERCICIO2
    public static void separate (Set<Integer> cuadrados, Set<Integer> noCuadrados)  {
        Set<Integer> universo = new HashSet<>();
        universo.addAll(cuadrados);
        universo.addAll(noCuadrados);

        Set<Integer> cuadradosFinal = new HashSet<>();
        Set<Integer> noCuadradosFinal = new HashSet<>();

        for (int candidato : universo) {
            boolean encontrado = false;
            for (int posibleRaiz : universo) {
                if (Math.sqrt(candidato) == posibleRaiz) {
                    // Solo debe ser cuadrado si está en ambos conjuntos
                    if (candidato == posibleRaiz) {
                        if (cuadrados.contains(candidato) && noCuadrados.contains(candidato)) {
                            encontrado = true;
                            break;
                        }
                    } else {
                        encontrado = true;
                        break;
                    }
                }
            }
            if (encontrado) {
                cuadradosFinal.add(candidato);
            } else {
                noCuadradosFinal.add(candidato);
            }
        }
        cuadrados.clear();
        cuadrados.addAll(cuadradosFinal);
        noCuadrados.clear();
        noCuadrados.addAll(noCuadradosFinal);
    }

    //EJERCICIO 3
    public static<T> Collection<Set<T>> divideInSets (Iterator<T> it) {
        Collection<Set<T>> coleccion = new ArrayList<>();

        while (it.hasNext()) {
            T numero = it.next();
            boolean esAñadido = false;

            for (Set<T> conjunto : coleccion) {
                if (!conjunto.contains(numero)) {
                    conjunto.add(numero);
                    esAñadido = true;
                    break;
                }
            }

            if (!esAñadido) {
                Set<T> nuevoConjunto = new HashSet<>();
                nuevoConjunto.add(numero);
                coleccion.add(nuevoConjunto);
            }
        }

        return coleccion;
    }

    //EJERCICIO 4
    public static<T> Collection<Set<T>> coverageSet2 (Set<T> u,ArrayList<Set<T>> col) {
        Collection<Set<T>> resultado = new LinkedHashSet<>();
        for (int a = 0; a < col.size(); a++) {
            Set<T> setA = col.get(a);
            for (int b = 0; b < col.size(); b++) {
                if (a == b) continue;
                Set<T> unionTemp = new HashSet<>(setA);
                unionTemp.addAll(col.get(b));
                if (unionTemp.size() == u.size() && unionTemp.containsAll(u) && !setA.equals(u) && !col.get(b).equals(u)) {
                    resultado.add(setA);
                    resultado.add(col.get(b));
                    return resultado;
                }
            }
        }
        return resultado;
    }




}
