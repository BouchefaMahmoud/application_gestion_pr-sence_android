package com.bouchefa.mahmoud.tp_am.vues;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebView;
import android.widget.Adapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import com.bouchefa.mahmoud.tp_am.R;
import com.bouchefa.mahmoud.tp_am.controle.ControleEtudiant;
import com.bouchefa.mahmoud.tp_am.model.Etudiant;
import com.bouchefa.mahmoud.tp_am.outils.ListAdapter;
import com.bouchefa.mahmoud.tp_am.outils.SwipGestureDetector;

import java.util.ArrayList;


    public class Stud_Activity extends AppCompatActivity{

    private ListView liste ;
    private ListAdapter adapter ;
    private EditText editCodeBarreEt;
        private EditText editRech ;
        private ImageButton imageButton ;

    private ArrayList<Etudiant> etudiants ;

    private WebView webView;
    private SwipGestureDetector gestureDetector ;
        SwipeRefreshLayout mSwipeRefreshLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.liste);
        init();
    }

    public void init() {
        editCodeBarreEt = (EditText) findViewById(R.id.codebarreEtudiant);
        mSwipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipeRefreshLayout);
        editRech =(EditText)findViewById(R.id.editRech);
        imageButton =(ImageButton)findViewById(R.id.imageButton);

        liste = (ListView) findViewById(R.id.listView);
     /*   webView = (WebView) findViewById(R.id.webview2);
        webView.loadUrl("file:///android_asset/vide.html");*/

        //etudiants.add(new Etudiant("00000", "Bouchefa", "Mahmoud", "Absent"));


        etudiants = new ArrayList<Etudiant>();
        etudiants = this.getIntent().getExtras().getParcelableArrayList("etud");

        if (etudiants == null) {
            Toast.makeText(Stud_Activity.this, "Liste d'étudiants vide !", Toast.LENGTH_SHORT).show();
        } else {
            adapter = new ListAdapter(this, etudiants);
            liste.setAdapter(adapter);
        }
        listeners();

        //gestureDetector = new SwipGestureDetector(this);

        /*
    @Override
      public boolean dispatchTouchEvent(MotionEvent ev) {
        return gestureDetector.onTouchEvent(ev);

    }

    */
   /* public WebView getWebView() {
        return webView;
    }

    public void setWebView(WebView webView) {
        this.webView = webView;
    }*/



    }









 private  void listeners(){
     mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
         @Override
         public void onRefresh() {
             ControleEtudiant.setInstance(null);
             ControleEtudiant.getInstance(Stud_Activity.this);

         }
     });


            editCodeBarreEt.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {


             boolean exist = false;
             for (Etudiant et : etudiants) {
                 if (et.getCb().equals(editCodeBarreEt.getText().toString())) {
                     final MediaPlayer bipe = MediaPlayer.create(Stud_Activity.this, R.raw.bip);
                     bipe.start();
                     exist = true;
                     ControleEtudiant.update(editCodeBarreEt.getText().toString());
                     break;
                 }

                 if (!exist) {
                     final MediaPlayer bipe = MediaPlayer.create(Stud_Activity.this, R.raw.error);
                     bipe.start();
                     Toast.makeText(Stud_Activity.this, "code barre inexistant", Toast.LENGTH_SHORT).show();

                 }
             }
         }
     });


     imageButton.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
             ArrayList<Etudiant> recherche = new ArrayList<Etudiant>();
             for(Etudiant et : etudiants){
                 if(et.getNom().toString().contains(editRech.getText().toString())){
                     recherche.add(et);
                 }
             }
             ListAdapter adapter = new ListAdapter(Stud_Activity.this,recherche);

             liste.setAdapter(adapter);

            /*
             Intent intent = new Intent(Stud_Activity.this, Stud_Activity.class);
             intent.putParcelableArrayListExtra("etud", recherche);
             Stud_Activity.this.startActivity(intent);
             Stud_Activity.this.finish();*/

         }
     });


 }


    }
