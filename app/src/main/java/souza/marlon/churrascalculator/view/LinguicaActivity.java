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
public class LinguicaActivity extends AppCompatActivity {

    private RequisitosChurrasco requisitosChurrasco;
    private IntentHelper<RequisitosChurrasco> helper;
    private EditText linguicaText;
    private Button enviarLinguica;
    private LinguicaActivity instance = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.linguica);

        linguicaText = (EditText) findViewById(R.id.linguica);
        helper = new IntentHelper<>(RefrigeranteActivity.class);
        enviarLinguica = (Button) findViewById(R.id.enviar_linguica);

        try {
            requisitosChurrasco = helper.getEntity(getIntent());

            enviarLinguica.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String val = linguicaText.getText().toString();

                    if(val.isEmpty()){
                        DialogFactory.error(instance, "Favor informar a quantidade de linguiça.").show();
                        return;
                    }

                    requisitosChurrasco.setLinguica(new BigDecimal(val));
                    startActivity(helper.newIntent(instance, requisitosChurrasco));
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
