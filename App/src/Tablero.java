public class Tablero{
    private Celda[][] tablero;
    private int totalMinas;
    private int celdasMarcadas;

    public Tablero(int filas, int columnas) {
        this.tablero = new Celda[filas][columnas];
        this.celdasMarcadas = 0;

        generarMinas();
    }

    private void generarMinas(){
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++) {
                if (Math.random() < 0.2) { 
                    tablero[i][j] = new Celda(true);
                    totalMinas++;
                } 
                else {
                    tablero[i][j] = new Celda(false);
                }
            }
        }
    }

    public int revelar(int coordenadaY, int coordenadaX){
        coordenadaX--;
        coordenadaY--;

        Celda celda = tablero[coordenadaY][coordenadaX];
        celda.revelar();
        if(celda.tieneMina()){
            return -1;
        } 
        else{
            int minasCercanas = 0;
            for (int i = Math.max(0, coordenadaY - 1); i <= Math.min(tablero.length - 1, coordenadaY + 1); i++) {
                for (int j = Math.max(0, coordenadaX - 1); j <= Math.min(tablero[i].length - 1, coordenadaX + 1); j++) {
                    if (tablero[i][j].tieneMina()) {
                        minasCercanas++;
                    }
                }
            }
            return minasCercanas;
        }
    }

    public boolean marcarCelda(int coordenadaY, int coordenadaX){
        boolean marcado = tablero[coordenadaY - 1][coordenadaX - 1].marcar();
        celdasMarcadas = (marcado ? celdasMarcadas++ : celdasMarcadas--);
        
        return marcado;
    }

    public int getMinasRestantes(){
        return totalMinas - celdasMarcadas;
    }

    public int getMinasEncontradas(){
        return celdasMarcadas;
    }

    public int getTotalMinas(){
        return totalMinas;
    }

    public int getCeldasFaltantes(){
        return (tablero.length * tablero[0].length) - celdasMarcadas;
    }

    //For testing purposes only, will be removed later
    public boolean getCeldaStatus(int coordenadaY, int coordenadaX){
        return tablero[coordenadaY - 1][coordenadaX - 1].tieneMina();
    }
}