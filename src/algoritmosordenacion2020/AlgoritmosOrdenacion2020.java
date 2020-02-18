package algoritmosordenacion2020;

import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author Jorge Cisneros
 */
public class AlgoritmosOrdenacion2020 {

    int[] lista1 = {13, 27, 455, 621, 23, 1, 15};

    int[] arrayParaBurbuja;
    int[] arrayParaInsercion;
    int[] arrayParaShell;

//Crea un array de tantos números aleatorios como le digas
    public int[] generaNumerosRandom(int dimension) {
        int[] numeros = new int[dimension];
        Random r = new Random();
        for (int i = 0; i < numeros.length; i++) {
            numeros[i] = r.nextInt();
        }
        return numeros;
    }

    public void ordenacionBurbuja(int[] numeros) {
        //el método recibe un array de números
        //y lo ordenará mediante el algoritmo de la burbuja
        for (int j = 0; j < numeros.length; j++) {
            for (int i = 0; i < numeros.length - 1; i++) {
                if (numeros[i] > numeros[i + 1]) {
                    //si se cumple, intercambio los valores de i e i+1
                    int aux = numeros[i + 1];
                    numeros[i + 1] = numeros[i];
                    numeros[i] = aux;
                }
            }
        }
    }

    public void ordenacionInsercion(int[] numeros) {
        for (int i = 2; i < numeros.length; i++) {
            int aux = numeros[i];
            int j = 0;
            for (j = i - 1; j >= 0 && numeros[j] > aux; j--) {
                numeros[j + 1] = numeros[j];
            }
            numeros[j + 1] = aux;
        }
    }

    public void shellSort(int[] numeros) {
        int salto, aux;
        boolean intercambio;
        for (salto = numeros.length / 2; salto != 0; salto /= 2) {
            intercambio = true;
            while (intercambio) {
                intercambio = false;
                for (int i = salto; i < numeros.length; i += salto) {
                    if (numeros[i - salto] > numeros[i]) {
                        //Si los numeros están desordenados entre sí los intercambio y lo indico
                        aux = numeros[i];
                        numeros[i] = numeros[i - salto];
                        numeros[i - salto] = aux;
                        intercambio = true;
                    }
                }
            }
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        AlgoritmosOrdenacion2020 ordenacion = new AlgoritmosOrdenacion2020();
        System.out.println("lista sin ordenar:"
                + Arrays.toString(ordenacion.lista1));

        ordenacion.ordenacionBurbuja(ordenacion.lista1);

        System.out.println("lista ordenada:"
                + Arrays.toString(ordenacion.lista1));

        /////////////////////////////////////////////////////////////////////////empiezo las pruebas de rendimiento de los distintos algoritmos
        int rangoPrueba = 100000;  //numero de datos con los que probamos
        int[] numeros = ordenacion.generaNumerosRandom(rangoPrueba);
        ordenacion.arrayParaBurbuja = new int[rangoPrueba];
        ordenacion.arrayParaInsercion = new int[rangoPrueba];
        ordenacion.arrayParaShell = new int[rangoPrueba];
        for (int i = 0; i < rangoPrueba; i++) {
            ordenacion.arrayParaBurbuja[i] = numeros[i];
            ordenacion.arrayParaInsercion[i] = numeros[i];
            ordenacion.arrayParaShell[i] = numeros[i];
        }
        /////////////////////////////////////////////////////////////////////////aquí ya tengo dos copias exactas del array de datos aleatorios

        System.out.println("Empieza la burbuja: (vete a por un café)");
        long tiempoInicio = System.currentTimeMillis();

        ordenacion.ordenacionBurbuja(ordenacion.arrayParaBurbuja);

        long tiempoFinal = System.currentTimeMillis();

        System.out.println("La burbuja ha tardado: " + (tiempoFinal - tiempoInicio));

        ///////////////////////////////////////////////////////////////////
        System.out.println("Empieza Inserción Directa: ");
        tiempoInicio = System.currentTimeMillis();

        ordenacion.ordenacionInsercion(ordenacion.arrayParaInsercion);

        tiempoFinal = System.currentTimeMillis();

        System.out.println("La Inserción Directa ha tardado: " + (tiempoFinal - tiempoInicio));

        ///////////////////////////////////////////////////////////////////
        System.out.println("Empieza ShellSort: ");
        
        tiempoInicio = System.currentTimeMillis();

        ordenacion.ordenacionInsercion(ordenacion.arrayParaShell);

        tiempoFinal = System.currentTimeMillis();

        System.out.println("ShellSort ha tardado: " + (tiempoFinal - tiempoInicio));

    }

}
