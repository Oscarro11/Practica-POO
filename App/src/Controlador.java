public class Controlador {
    private Tablero tablero;

    public Controlador(int filas, int columnas) {
        generarTablero(filas, columnas);
    }

    public void generarTablero(int filas, int columnas) {
        this.tablero = new Tablero(filas, columnas);
    }

    public int revelarCelda(int fila, int columna) {
        int minasCercanas = tablero.revelar(fila, columna);
        if (minasCercanas != -1) {
            if (tablero.getCeldasFaltantes() - tablero.getMinasRestantes() == 0) {
                return -2;
            }
        }
        
        return minasCercanas;
    }

    public boolean marcarCelda(int fila, int columna) {
        return tablero.marcarCelda(fila, columna);
    }

    public int getMinasRestantes() {
        return tablero.getMinasRestantes();
    }

    public int getCeldasFaltantes() {
        return tablero.getCeldasFaltantes();
    }
}
