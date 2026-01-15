public class Tablero{
    private Celda[][] tablero;
    private int minas;

    public Tablero(int filas, int columnas) {
        this.tablero = new Celda[filas][columnas];
        this.minas = 0;
    }

    public void generarMinas(){
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++) {
                if (Math.random() < 0.2) { 
                    tablero[i][j] = new Celda(true);
                    minas++;
                } else {
                    tablero[i][j] = new Celda(false);
                }
            }
        }
    }
    public void minasEncontradas(){
        int minasEncontradas = 0;
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++) {
                if (tablero[i][j].estaRevelado() && tablero[i][j].tieneMina()) {
                    minasEncontradas++;
                }
            }
        }
        System.out.println("Minas encontradas: " + minasEncontradas);
    }
    public void revelar(int filas, int columnas){
        Celda celda = tablero[filas][columnas];
        celda.revelar();
        if(celda.tieneMina()){
            System.out.println("¡Explotaste una mina!");
        } else{
            int minasCercanas = 0;
            for (int i = Math.max(0, filas - 1); i <= Math.min(tablero.length - 1, filas + 1); i++) {
                for (int j = Math.max(0, columnas - 1); j <= Math.min(tablero[i].length - 1, columnas + 1); j++) {
                    if (tablero[i][j].tieneMina()) {
                        minasCercanas++;
                    }
                }
            }
            System.out.println("Minas cercanas: " + minasCercanas);
        }
    }
    public void minasRestantes(){
        int minasRestantes = 0;
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++) {
                if (!tablero[i][j].estaRevelado() && tablero[i][j].tieneMina()) {
                    minasRestantes++;
                }
            }
        }
        System.out.println("Minas restantes: " + minasRestantes);
    }

}