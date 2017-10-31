package com.example.raulrcg.multipleshilos;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ProgressBar pb1,pb2,pb3;
    EditText et1,et2,et3;
    int val1,val2,val3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pb1=(ProgressBar)findViewById(R.id.pb1);
        pb2=(ProgressBar)findViewById(R.id.pb2);
        pb3=(ProgressBar)findViewById(R.id.pb3);
        et1=(EditText)findViewById(R.id.txt1);
        et2=(EditText)findViewById(R.id.txt2);
        et3=(EditText)findViewById(R.id.txt3);

        //Task 01
        findViewById(R.id.btn1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                val1=Integer.parseInt(et1.getText().toString());
                AsyncT01 at1=new AsyncT01();
                at1.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
            }
        });
        //Task 02
        findViewById(R.id.btn2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                val2=Integer.parseInt(et2.getText().toString());
                AsyncT02 at2=new AsyncT02();
                at2.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
            }
        });
        //Task 03
        findViewById(R.id.btn3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                val3=Integer.parseInt(et3.getText().toString());
                AsyncT03 at3=new AsyncT03();
                at3.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
            }
        });
    }

    private void delay() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private class  AsyncT01 extends AsyncTask<Void, Integer,Boolean> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pb1.setMax(val1);
        }

        @Override
        protected Boolean doInBackground(Void... params) {

            for (int i=0; i<=val1; i++){
                delay();
                publishProgress(i+1);
            }
            return true;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            //Actualizar la barra de progreso
            pb1.setProgress(values[0].intValue());
        }

        @Override
        protected void onPostExecute(Boolean aVoid) {
            //super.onPostExecute(aVoid);
            if (aVoid){
                Toast.makeText(getApplicationContext(),"Tarea finaliza AsyncTask 01", Toast.LENGTH_SHORT).show();
                pb1.setProgress(0);
            }
        }
    }

    private class  AsyncT02 extends AsyncTask<Void, Integer,Boolean> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pb2.setMax(val2);
        }

        @Override
        protected Boolean doInBackground(Void... params) {

            for (int i=0; i<=val2; i++){
                delay();
                publishProgress(i+1);
            }
            return true;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            //Actualizar la barra de progreso
            pb2.setProgress(values[0].intValue());
        }

        @Override
        protected void onPostExecute(Boolean aVoid) {
            //super.onPostExecute(aVoid);
            if (aVoid){
                Toast.makeText(getApplicationContext(),"Tarea finaliza AsyncTask 02", Toast.LENGTH_SHORT).show();
                pb2.setProgress(0);
            }
        }
    }

    private class  AsyncT03 extends AsyncTask<Void, Integer,Boolean> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pb3.setMax(val3);
        }

        @Override
        protected Boolean doInBackground(Void... params) {

            for (int i=0; i<=val3; i++){
                delay();
                publishProgress(i+1);
            }
            return true;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            //Actualizar la barra de progreso
            pb3.setProgress(values[0].intValue());
        }

        @Override
        protected void onPostExecute(Boolean aVoid) {
            //super.onPostExecute(aVoid);
            if (aVoid){
                Toast.makeText(getApplicationContext(),"Tarea finaliza AsyncTask 03", Toast.LENGTH_SHORT).show();
                pb3.setProgress(0);
            }
        }
    }

}
