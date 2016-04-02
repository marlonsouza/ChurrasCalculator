package souza.marlon.churrascalculator.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.math.BigDecimal;

import souza.marlon.churrascalculator.R;
import souza.marlon.churrascalculator.model.RequisitosChurrasco;

/**
 * Created by marlonsouza on 02/04/16.
 */
public class RefrigeranteActivity extends AppCompatActivity {

    private EditText refrigeranteText;
    private IntentHelper<RequisitosChurrasco> helper;
    private Button enviarRefrigerante;
    private RequisitosChurrasco requisitosChurrasco;
    private RefrigeranteActivity instance = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.refrigerante);

        refrigeranteText = (EditText) findViewById(R.id.refrigerante);
        helper = new IntentHelper<>(PessoasActivity.class);
        enviarRefrigerante = (Button) findViewById(R.id.enviar_refrigerante);

        try {
            requisitosChurrasco = helper.getEntity(getIntent());

            enviarRefrigerante.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String val = refrigeranteText.getText().toString();

                    if(val.isEmpty()){
                        DialogFactory.error(instance, "Favor informar a quantidade de refrigerante.").show();
                        return;
                    }

                    requisitosChurrasco.setRefrigerante(new BigDecimal(val));
                    startActivity(helper.newIntent(instance, requisitosChurrasco));
                }
            });

        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}

