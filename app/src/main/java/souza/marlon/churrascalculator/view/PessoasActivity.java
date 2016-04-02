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
public class PessoasActivity extends AppCompatActivity {

    private EditText pessoasText;
    private IntentHelper<RequisitosChurrasco> helper;
    private Button enviarPessoas;
    private RequisitosChurrasco requisitosChurrasco;
    private PessoasActivity instance = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.pessoas);

        pessoasText = (EditText) findViewById(R.id.pessoas);
        helper = new IntentHelper<>(ListaComprasActivity.class);
        enviarPessoas = (Button) findViewById(R.id.enviar_pessoas);
        try {
            requisitosChurrasco = helper.getEntity(getIntent());

            enviarPessoas.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String val = pessoasText.getText().toString();

                    if(val.isEmpty()){
                        DialogFactory.error(instance, "Favor informar o número de pessoas.").show();
                        return;
                    }

                    requisitosChurrasco.setNumeroPessoas(new BigDecimal(val));
                    startActivity(helper.newIntent(instance, requisitosChurrasco));
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
