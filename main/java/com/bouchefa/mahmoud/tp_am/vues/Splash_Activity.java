package com.bouchefa.mahmoud.tp_am.vues;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.bouchefa.mahmoud.tp_am.R;
import com.bouchefa.mahmoud.tp_am.controle.Controle;

import java.util.ArrayList;


public class Splash_Activity extends AppCompatActivity {

    private Controle controle;
    ArrayList<String> enseignants ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);





        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {

                 controle.getInstance(Splash_Activity.this);

                }
            }
        }).start();


    }



}
