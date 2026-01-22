public class Celda  implements InterfazCelda{
    private boolean revelado = false; // indica si la celda fue revelada 
    private boolean marcado = false; // indica si la celda esta marcada con una bandera 
    private boolean tieneMina; // indica si la celda tiene una mina 
//indica si la celda tiene una mina o no 
    public Celda(boolean tieneMina) {
        this.tieneMina = tieneMina;
    }
//devuelve -1 si la celda tiene mina, o el numero de las minas que hay en la celda 
    public int siExplota(int minasCercanas) {
        if (tieneMina) {
            return -1;
        } else  {
            return minasCercanas;
        }
    }
//retorna si la celda contiene una mina 
    public boolean tieneMina() {
        return tieneMina;
    }
//este ayuda a revela la celda 
    public void revelar() {
        this.revelado = true;
    }
//indica si la celda a si revelada 
    public boolean estaRevelado() {
        return revelado;
    }
// este ayuda a ver si se marca la celda o desmarcarla 
    public boolean marcar() {
        this.marcado = (this.marcado ? true : false);
        return marcado;
    }
// indica si la celda esta realmente marcada 
    public boolean estaMarcado() {
        return marcado;
    }
}
