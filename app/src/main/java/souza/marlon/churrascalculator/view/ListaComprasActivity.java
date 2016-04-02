package souza.marlon.churrascalculator.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.math.BigDecimal;

import souza.marlon.churrascalculator.R;
import souza.marlon.churrascalculator.controller.CalculadoraChurrasco;
import souza.marlon.churrascalculator.model.ListaCompras;
import souza.marlon.churrascalculator.model.RequisitosChurrasco;

/**
 * Created by marlonsouza on 02/04/16.
 */
public class ListaComprasActivity extends AppCompatActivity {

    private IntentHelper<RequisitosChurrasco> helper;
    private RequisitosChurrasco requisitosChurrasco;
    private LinearLayout linearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.lista_churrasco);

        helper = new IntentHelper<>();

        try {
            requisitosChurrasco = helper.getEntity(getIntent());

            ListaCompras listaCompras = CalculadoraChurrasco.calcule(requisitosChurrasco);
            linearLayout = (LinearLayout) findViewById(R.id.result_area_lista);


            appendTextView(R.string.carneLabel, listaCompras.getCarne());
            appendTextView(R.string.linguicaLabel, listaCompras.getLinguica());
            appendTextView(R.string.refrigeranteLabel, listaCompras.getRefrigerante());

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void appendTextView(int string, BigDecimal valor) {
        TextView textView = new TextView(this);

        textView.setText(new StringBuilder()
                        .append(getResources().getString(string))
                        .append(valor)
                        .toString()
        );

        this.linearLayout.addView(textView);
    }
}
