package com.delatowebs.posadaspremia;
import java.io.File;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;

import java.util.List;

import android.app.AlertDialog;

import android.app.ListActivity;

import android.content.DialogInterface;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;

import android.os.Environment;
import android.util.Log;
import android.view.View;

import android.widget.ArrayAdapter;

import android.widget.ListAdapter;
import android.widget.ListView;

import android.widget.TextView;
import android.widget.Toast;


public class AndroidExplorer extends ListActivity {



    private List<String> item = null;

    private List<String> path = null;

//    private String root="/";
    private String root= Environment.getExternalStorageDirectory().toString()+"/";

    private TextView myPath;

    private static final String TAG = "AndroidExplorer.java";




    /** Called when the activity is first created. */

    @Override

    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.explorer_file_list);

        myPath = (TextView)findViewById(R.id.path);

        getDir(root);

    }



    private void getDir(String dirPath)

    {

        myPath.setText("Location: " + dirPath);



        item = new ArrayList<String>();

        path = new ArrayList<String>();



        File f = new File(dirPath);

        File[] files = f.listFiles();



        if(!dirPath.equals(root))

        {



            item.add(root);

            path.add(root);



            item.add("../");

            path.add(f.getParent());



        }



        for(int i=0; i < files.length; i++)

        {

            File file = files[i];

            path.add(file.getPath());

            if(file.isDirectory())

                item.add(file.getName() + "/");

            else

                item.add(file.getName());

        }

        ListAdapter adaptador = new ArrayAdapter<String>(
                this, android.R.layout.simple_list_item_1, item);

        //Asociamos el adaptador a la vista.
        ListView lv = (ListView) findViewById(android.R.id.list);
        lv.setAdapter(adaptador);

//        ArrayAdapter <String> fileList =
//
//                new ArrayAdapter <String> (this, R.layout.file_explorer_row, item);
//
//        setListAdapter(fileList);

    }



    @Override

    protected void onListItemClick(ListView l, View v, int position, long id) {



        final File file = new File(path.get(position));



        if (file.isDirectory())

        {

            if(file.canRead())

                getDir(path.get(position));

            else

            {

                new AlertDialog.Builder(this)

//                        .setIcon(R.drawable.icon)

                        .setTitle("[" + file.getName() + "] folder can't be read!")

                        .setPositiveButton("OK",

                                new DialogInterface.OnClickListener() {



                                    @Override

                                    public void onClick(DialogInterface dialog, int which) {
                                    }



                                }).show();

            }

        }

        else

        {

            new AlertDialog.Builder(this)

//                    .setIcon(R.drawable.icon)

                    .setTitle("[" + file.getName() + "]")

                    .setPositiveButton("OK",

                            new DialogInterface.OnClickListener() {



                                @Override

                                public void onClick(DialogInterface dialog, int which) {


                                    // your sd card
                                    String sdCard = Environment.getExternalStorageDirectory().toString();

                                    // the file to be moved or copied
                                    File sourceLocation = new File (file.getAbsolutePath());

                                    PackageManager m = getPackageManager();
                                    String s = getPackageName();
                                    try {
                                        PackageInfo p = m.getPackageInfo(s, 0);
                                        s = p.applicationInfo.dataDir;
                                    } catch (PackageManager.NameNotFoundException e) {
                                        Log.w(TAG, "Error Package name not found ", e);
                                    }


                                    // make sure your target location folder exists!
                                    File targetLocation = new File (s + "/padron.csv");

                                    // just to take note of the location sources
                                    Log.v(TAG, "sourceLocation: " + sourceLocation);
                                    Log.v(TAG, "targetLocation: " + targetLocation);

                                    try {

                                        // 1 = move the file, 2 = copy the file
                                        int actionChoice = 2;

                                        // moving the file to another directory
                                        if(actionChoice==1){

                                            if(sourceLocation.renameTo(targetLocation)){
                                                Log.v(TAG, "Move file successful.");
                                            }else{
                                                Log.v(TAG, "Move file failed.");
                                            }

                                        }

                                        // we will copy the file
                                        else{

                                            // make sure the target file exists

                                            if(sourceLocation.exists()){

                                                InputStream in = new FileInputStream(sourceLocation);
                                                OutputStream out = new FileOutputStream(targetLocation);

                                                // Copy the bits from instream to outstream
                                                byte[] buf = new byte[1024];
                                                int len;

                                                while ((len = in.read(buf)) > 0) {
                                                    out.write(buf, 0, len);
                                                }

                                                in.close();
                                                out.close();

                                                Log.v(TAG, "Copy file successful.");
                                                Toast.makeText(AndroidExplorer.this, "Padron Copiado Correctamente", Toast.LENGTH_SHORT).show();

                                            }else{
                                                Log.v(TAG, "Copy file failed. Source file missing.");
                                                Toast.makeText(AndroidExplorer.this, "Error al copiar el archivo", Toast.LENGTH_SHORT).show();
                                            }

                                        }

                                    } catch (NullPointerException e) {
                                        e.printStackTrace();
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }

                                }

                            }).show();

        }

    }

}
