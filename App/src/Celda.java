public class Celda  implements InterfazCelda{
    private boolean revelado = false;
    private boolean marcado = false;
    private boolean tieneMina;

    public Celda(boolean tieneMina) {
        this.tieneMina = tieneMina;
    }

    public int siExplota(int minasCercanas) {
        if (tieneMina) {
            return -1;
        } else  {
            return minasCercanas;
        }
    }

    public boolean tieneMina() {
        return tieneMina;
    }

    public void revelar() {
        this.revelado = true;
    }

    public boolean estaRevelado() {
        return revelado;
    }

    public boolean marcar() {
        this.marcado = (this.marcado ? false : true);
        return marcado;
    }

    public boolean estaMarcado() {
        return marcado;
    }
}
