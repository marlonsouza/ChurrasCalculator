package souza.marlon.churrascalculator.model;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by marlonsouza on 02/04/16.
 */
public class RequisitosChurrasco implements Serializable {

    private BigDecimal carne;
    private BigDecimal linguica;
    private BigDecimal refrigerante;
    private BigDecimal numeroPessoas;

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

    public BigDecimal getNumeroPessoas() {
        return numeroPessoas;
    }

    public void setNumeroPessoas(BigDecimal numeroPessoas) {
        this.numeroPessoas = numeroPessoas;
    }
}
