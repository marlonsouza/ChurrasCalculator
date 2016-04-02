package souza.marlon.churrascalculator.controller;

import souza.marlon.churrascalculator.model.ListaCompras;
import souza.marlon.churrascalculator.model.RequisitosChurrasco;

/**
 * Created by marlonsouza on 02/04/16.
 */
public class CalculadoraChurrasco {

    public static ListaCompras calcule(RequisitosChurrasco requisitosChurrasco){

        ListaCompras listaCompras = new ListaCompras();

        listaCompras.setCarne(requisitosChurrasco.getCarne().multiply(requisitosChurrasco.getNumeroPessoas()));
        listaCompras.setLinguica(requisitosChurrasco.getLinguica().multiply(requisitosChurrasco.getNumeroPessoas()));
        listaCompras.setRefrigerante(requisitosChurrasco.getRefrigerante().multiply(requisitosChurrasco.getNumeroPessoas()));

        return listaCompras;

    }

}
