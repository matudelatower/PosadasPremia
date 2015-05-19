package com.delatowebs.posadaspremia;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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

    public void ingresarMessage(View view){

        EditText dniTxt= (EditText) findViewById(R.id.txt_dni);
        String dniStr= dniTxt.getText().toString();

        Class activity;

        String adminCode = getResources().getString(R.string.admin_code);



        if (dniStr.equals(adminCode)){
            activity=AdminActivity.class;
        }else{
            TabletRepository repo = new TabletRepository(this);
            if (repo.getFirstTablet()==0){
                Toast.makeText(this, "Primero debe configurar la tablet", Toast.LENGTH_SHORT).show();
                return;
            }
            activity=ListadoRegistroActivity.class;
        }

        Intent intent= new Intent(this, activity);
        intent.putExtra("numeroDni",dniStr);
        startActivity(intent);
    }
}
