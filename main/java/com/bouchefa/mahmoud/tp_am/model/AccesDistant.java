package com.bouchefa.mahmoud.tp_am.model;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import com.bouchefa.mahmoud.tp_am.controle.Controle;
import com.bouchefa.mahmoud.tp_am.controle.ControleEtudiant;
import com.bouchefa.mahmoud.tp_am.outils.AccesHTTP;
import com.bouchefa.mahmoud.tp_am.outils.InterAccesDistant;
import com.bouchefa.mahmoud.tp_am.vues.Prof_Activity;
import com.bouchefa.mahmoud.tp_am.vues.Splash_Activity;


public class AccesDistant implements InterAccesDistant {

    private  ArrayList<String> enseignants;
    private  ArrayList<Etudiant> etudiants;
    private Context context ;

    public AccesDistant(Context context ){
    this.context =context ;
    }







    @Override
    public void processfinish(String output){


        // découpage du message recu
        String[] message = output.split("%");
        //dans message[0] j'aurais soit "erreur","enseignant","etudiants"
        //dans message[1] j'aurais le reste du message

        if(message.length==2 ){
            JSONArray array;

            if(message[0].equals("enseignants")){

                try {


                    enseignants = new ArrayList<String>();
                     array = new JSONArray(message[1]);
                    for(int i=0 ; i != array.length(); i++ ){
                        JSONObject jsonobject = new JSONObject(array.getJSONObject(i).toString());
                        String codebarreEn = jsonobject.getString("codebarreEn");


                        enseignants.add(codebarreEn);
                                 }

                                Controle.startProfActivity(enseignants);

                    } catch (JSONException e) {

                    Toast.makeText(context,"Erreur d'encodage",Toast.LENGTH_LONG).show();
                    }

            }else if(message[0].equals("etudiants")) {

                    etudiants = new ArrayList<Etudiant>();


                    try {
                         array = new JSONArray(message[1]);
                        for(int i=0 ; i != array.length(); i++ ){
                            JSONObject jsonobject = new JSONObject(array.getJSONObject(i).toString());
                            String nom = jsonobject.getString("nom");
                            String prenom = jsonobject.getString("prenom");
                            String presence = jsonobject.getString("presence");
                            String cb = jsonobject.getString("cb");
                            etudiants.add(new Etudiant(cb, nom, prenom, presence));

                        }

                            ControleEtudiant.startStudActivity(etudiants);


                    } catch (JSONException e) {

                        Toast.makeText(context,"Erreur d'encodage",Toast.LENGTH_LONG).show();
                    }


                }else if(message[0].equals("update")){

                    if(message[1].equals("succes")){
                        Toast.makeText(context,"Enregistrement effectué",Toast.LENGTH_LONG).show();

                    }

                }else{
                Toast.makeText(context,"Erreur",Toast.LENGTH_LONG).show();
            }
            }
        }






    public void Envoie(String operarion , String donnees ) {
        AccesHTTP acceshttp = new AccesHTTP();
        acceshttp.AjoutPar("operation", operarion);
        if(operarion.equals("update")){
            acceshttp.AjoutPar("cb", donnees);
        }

        acceshttp.delegate=this;
        acceshttp.execute();


    }






}
