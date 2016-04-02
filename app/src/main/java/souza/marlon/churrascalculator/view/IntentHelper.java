package souza.marlon.churrascalculator.view;

import android.app.Activity;
import android.content.Intent;

import java.io.Serializable;

/**
 * Created by marlonsouza on 02/04/16.
 */
public class IntentHelper <T extends Serializable>  {

    private static final String TRANSFER = "TRANSFER";

    private Class clazzTo;

    public IntentHelper(Class clazz){
        this.clazzTo = clazz;
    }

    public IntentHelper(){

    }

    public Intent newIntent(Activity activity, T entity){
        if(clazzTo == null){
            throw new IllegalArgumentException("Objeto em Activity Destino!");
        }

        Intent intent = new Intent(activity, clazzTo);

        intent.putExtra(TRANSFER, entity);

        return intent;
    }

    public T getEntity(Intent intent) throws Exception {
        return (T) intent.getSerializableExtra(TRANSFER);
    }
}
