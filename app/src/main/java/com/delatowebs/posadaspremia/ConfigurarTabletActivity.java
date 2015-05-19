package com.delatowebs.posadaspremia;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class ConfigurarTabletActivity extends ActionBarActivity {

    private int _Tablet_Id=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configurar_tablet);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_configurar_tablet, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void guardarConfiguracion(View view){
        EditText idTabletTxt= (EditText) findViewById(R.id.txt_id_tablet);
        String idTablet= idTabletTxt.getText().toString();


        TabletRepository repo = new TabletRepository(this);
        Tablet tablet = new Tablet();

        tablet.setIdTablet(Integer.parseInt(idTablet));

        if (repo.getFirstTablet()==0){
            _Tablet_Id = repo.insert(tablet);

            Toast.makeText(this, "Identificador de Tablet: "+_Tablet_Id, Toast.LENGTH_SHORT).show();
        }else{
            tablet.setId(repo.getFirstTablet());
            repo.update(tablet);
            Toast.makeText(this,"Id Tablet Actualizada",Toast.LENGTH_SHORT).show();
        }

        finish();


    }
}
