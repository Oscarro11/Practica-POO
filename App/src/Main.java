import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        Controlador controlador;
        int filas = 0;
        int columnas = 0;
        int seleccion = 0;

        System.out.println("\n*** Bienvenido a BUSCAMINAS ***\n");
        System.out.println("Daremos inicio a la partida.");
        
        // Creando el tablero
        System.out.print("Para generar el tablero,\n");
        System.out.print("Ingresa el número de filas: ");
        filas = teclado.nextInt();
        System.out.print("Ingresa el número de columnas: ");
        columnas = teclado.nextInt();
        controlador = new Controlador(filas, columnas);
        System.out.println("\nGenerando el tablero...");
        
        // !!! El getTotalMinas() es para el controlador?
        System.out.println("Tablero generado con " + controlador.getMinasRestantes() + " minas.");
        
        while (seleccion >= 5 || seleccion <= 0) {
            System.out.println("\nQué acción deseas realizar?\n" +
                "   1) Seleccionar una celda para revelar\n" +
                "   2) Marcar una celda como 'mina'\n" +
                "   3) Ver tus datos actuales\n" +
                "   4) Salir del juego");
            seleccion = teclado.nextInt();

            // Opción 1: Seleccionar una celda para revelar
            if (seleccion == 1){
                System.out.println("\nREVELAR UNA CELDA");
                System.out.println("Ingresa la fila del 1 al " + filas + ": ");
                int fila = teclado.nextInt();
                System.out.println("Ingresa la columna del 1 al " + columnas + ": ");
                int columna = teclado.nextInt();

                // En caso de una  selección inválida...
                if (fila < 1 || fila > filas || columna < 1 || columna > columnas) {
                        System.out.println("¡Coordenadas inválida!");
                        // \/ Reinicia el menú
                        seleccion = 0;
                    }
                    
                int resultado = controlador.revelarCelda(fila, columna);

                if (resultado == -2) {
                        System.out.println("¡Felicidades, no puedes revelar más casillas, por lo que ganas!");
                        System.out.println("*** FIN DEL JUEGO ***");
                        break;
                    } else if (resultado == -1) {
                        System.out.println("¡BOOM! Has revelado una mina.");
                        System.out.println("*** FIN DEL JUEGO ***");
                        break;
                    } else {
                        System.out.println("Celda revelada. Minas cercanas: " + resultado);
                    }
                    seleccion = 0;
            
            // Opción 2: Marcar una celda como 'mina'
            } else if (seleccion == 2) {
                System.out.println("\nMARCAR UNA CELDA");
                System.out.print("Ingresa la fila para marcar del 1 al " + filas + ": ");
                    int filaMarcar = teclado.nextInt();
                    System.out.print("Ingresa la columna para marcar del 1 al " + columnas + ": ");
                    int columnaMarcar = teclado.nextInt();
                    
                    boolean minaColocada = controlador.marcarCelda(filaMarcar - 1, columnaMarcar - 1);
                    if (minaColocada) {
                        System.out.println("Celda marcada como 'mina'.");
                    }
                    else {
                        System.out.println("Celda desmarcada como 'mina'.");
                    }

                    System.out.println("Minas restantes: " + controlador.getMinasRestantes());
                    seleccion = 0;
            
            // Opción 3: Ver tus datos actuales
            } else if (seleccion == 3) {
                System.out.println("\nMOSTRAR DATOS ACTUALES");
                // !!! Aquí también para el controlador?
                System.out.println("Minas restantes: " + controlador.getMinasRestantes());
                System.out.println("Celdas restantes: " + controlador.getCeldasFaltantes());
                seleccion = 0;
            
            // Opción 4: Salir del juego
            } else if (seleccion == 4) {
                System.out.println("*** FIN DEL JUEGO ***");
                teclado.close();
                break;
            
            } else {
                System.out.println("Selección no válida, por favor intentar de nuevo.");
            }

        }
        
    }
}
