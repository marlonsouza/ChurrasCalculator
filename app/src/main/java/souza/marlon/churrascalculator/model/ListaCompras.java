package souza.marlon.churrascalculator.model;

import java.math.BigDecimal;

/**
 * Created by marlonsouza on 02/04/16.
 */
public class ListaCompras {

    private BigDecimal carne;
    private BigDecimal linguica;
    private BigDecimal refrigerante;

    public BigDecimal getCarne() {
        return carne;
    }

    public void setCarne(BigDecimal carne) {
        this.carne = carne;
    }

    public BigDecimal getLinguica() {
        return linguica;
    }

    public void setLinguica(BigDecimal linguica) {
        this.linguica = linguica;
    }

    public BigDecimal getRefrigerante() {
        return refrigerante;
    }

    public void setRefrigerante(BigDecimal refrigerante) {
        this.refrigerante = refrigerante;
    }
}
