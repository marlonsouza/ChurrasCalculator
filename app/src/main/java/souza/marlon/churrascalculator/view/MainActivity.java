package souza.marlon.churrascalculator.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.math.BigDecimal;

import souza.marlon.churrascalculator.R;
import souza.marlon.churrascalculator.model.RequisitosChurrasco;

public class MainActivity extends AppCompatActivity {

    private IntentHelper<RequisitosChurrasco> helper;
    private RequisitosChurrasco requisitosChurrasco;
    private Button enviarCarne;
    private EditText carneText;

    private MainActivity instance = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.carne);

        requisitosChurrasco = new RequisitosChurrasco();
        helper = new IntentHelper<>(LinguicaActivity.class);

        enviarCarne = (Button) findViewById(R.id.enviar_carne);
        carneText = (EditText) findViewById(R.id.carne);

        enviarCarne.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    String val = carneText.getText().toString();

                    if(val.isEmpty()){
                        DialogFactory.error(instance, "Favor informar a quantidade de carne.").show();
                        return;
                    }
                    requisitosChurrasco.setCarne(new BigDecimal(val));
                    startActivity(helper.newIntent(instance, requisitosChurrasco));

                    }
                }
        );
    }
}
