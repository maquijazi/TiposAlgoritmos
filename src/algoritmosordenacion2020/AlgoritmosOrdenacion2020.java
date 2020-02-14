package algoritmosordenacion2020;

import java.util.Arrays;

/**
 *
 * @author Jorge Cisneros
 */
public class AlgoritmosOrdenacion2020 {

    
    int [] lista1 = {13, 27, 455, 621, 23, 1, 15}; 
             
             
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
    
    
   
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        AlgoritmosOrdenacion2020 ordenacion =new AlgoritmosOrdenacion2020();
        System.out.println("lista sin ordenar:" 
                + Arrays.toString(ordenacion.lista1));
        
        ordenacion.ordenacionBurbuja(ordenacion.lista1);
        
        System.out.println("lista ordenada:" 
                + Arrays.toString(ordenacion.lista1));
        
        
    }

}
