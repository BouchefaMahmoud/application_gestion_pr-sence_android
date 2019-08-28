package com.bouchefa.mahmoud.tp_am.vues;

import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.Toast;


import com.bouchefa.mahmoud.tp_am.R;
import com.bouchefa.mahmoud.tp_am.controle.ControleEtudiant;
import com.bouchefa.mahmoud.tp_am.model.Etudiant;

import java.util.ArrayList;

public class Prof_Activity extends AppCompatActivity {

    private EditText edit ;
    private ArrayList<String> codes ;
    private WebView webView ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.prof_layout);


        edit = (EditText) findViewById(R.id.inputCodeBarreEns);
        edit.setOnClickListener(new EnseignantListener());
        codes = this.getIntent().getExtras().getStringArrayList("ens");


    }


    public class EnseignantListener implements View.OnClickListener {


        @Override
        public void onClick(View v) {
            if(edit.getText().length() == 10  ){
                if(codes.contains(edit.getText().toString())) {
                    final MediaPlayer bipe = MediaPlayer.create(Prof_Activity.this,R.raw.bip);
                    bipe.start();
                    webView =(WebView)findViewById(R.id.webViewIntialise);
                    webView.loadUrl("file:///android_asset/GIF.html");
                     new Thread(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                Thread.sleep(5000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }).start();
                    ControleEtudiant.getInstance(Prof_Activity.this);
                   finish();
                }else{
                    final MediaPlayer bipe = MediaPlayer.create(Prof_Activity.this,R.raw.error);
                    bipe.start();
                    Toast.makeText(Prof_Activity.this, "code barre inexistant",Toast.LENGTH_SHORT).show();
                }
            }
        }


    }


}
