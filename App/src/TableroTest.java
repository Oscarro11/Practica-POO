import org.junit.*;

public class TableroTest {
    @Test
    public void revelarMina(){
        Tablero tablero = new Tablero(3, 3);

        int minasCercanas = 0;
        if (tablero.getCeldaStatus(2, 2)) {
            Assert.assertEquals(tablero.revelar(2, 2), -1);
        }
        else{
            //Manually check the status of each Cell in a 3X3 board, to count all mines
            for (int fila = 1; fila <= 3; fila++) {
                for (int columna = 1; columna <= 3; columna++) {
                    if (tablero.getCeldaStatus(fila, columna)) {
                        minasCercanas++;
                    }
                }
            }

            Assert.assertEquals(tablero.revelar(2, 2), minasCercanas);
        };
    }

    @Test
    public void getMinasRestantes() {
        Tablero tablero = new Tablero(5, 5);

        Assert.assertEquals(tablero.getMinasRestantes(), tablero.getTotalMinas());
    }

    @Test
    public void getMissingMines() {
        Tablero tablero = new Tablero(4, 4);
        int totalMinas = tablero.getTotalMinas();

        //Se marcan con bandera 3 Celdas aleatorias, para reducir el numero de minas sin identificar
        tablero.marcarCelda(1, 1);
        tablero.marcarCelda(2, 2);
        tablero.marcarCelda(3, 3);

        Assert.assertEquals(totalMinas - 3, tablero.getMinasRestantes());
    }
}
