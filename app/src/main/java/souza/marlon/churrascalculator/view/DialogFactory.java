package souza.marlon.churrascalculator.view;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;

/**
 * Created by marlonsouza on 02/04/16.
 */
public class DialogFactory {

    public static AlertDialog error(Context context,String text){
        return new AlertDialog.Builder(context)
            .setTitle("Erro!")
            .setMessage(text)
            .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                }
            })
            .create();
    }
}
