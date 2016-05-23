package bd_stuff;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by Ayrton on 2016-05-18.
 */
public class Backrun extends AsyncTask<Void,Void,Void> {
    @Override
    protected Void doInBackground(Void... params) {
        BDConnector.load_servico();
        BDConnector.load_categoria();
        BDConnector.load_contacto_estabelecimento();
        BDConnector.load_estabelecimento();
        BDConnector.load_estabeleciometo_servico();
        BDConnector.load_instituicao();
        BDConnector.load_instituicao_servico();
        BDConnector.load_requisito();

        BDConnector.load_servico_requisito();
        return null;
    }


    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        Log.d("LoadBD","Backrun acabou");

    }
}
