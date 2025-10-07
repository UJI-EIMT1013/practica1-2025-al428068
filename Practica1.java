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
        Set<Integer> union = new HashSet<>(cuadrados);
        union.addAll(noCuadrados);

        Set<Integer> posiblesRaices = new HashSet<>();
        for (int y : union) {
            posiblesRaices.add(y);
        }

        Set<Integer> nuevosCuadrados = new HashSet<>();
        Set<Integer> nuevosNoCuadrados = new HashSet<>();
        for (int x : union) {
            boolean esCuadrado = false;
            for (int y : posiblesRaices) {
                if (y * y == x) {
                    esCuadrado = true;
                    break;
                }
            }
            if (esCuadrado) {
                nuevosCuadrados.add(x);
            } else {
                nuevosNoCuadrados.add(x);
            }
        }

        cuadrados.clear();
        noCuadrados.clear();
        cuadrados.addAll(nuevosCuadrados);
        noCuadrados.addAll(nuevosNoCuadrados);
    }

    //EJERCICIO 3
    public static<T> Collection<Set<T>> divideInSets (Iterator<T> it) {
        //TODO
        return null;
    }

    //EJERCICIO 4
    public static<T> Collection<Set<T>> coverageSet2 (Set<T> u,ArrayList<Set<T>> col) {
        //TODO
        return null;
    }



}
