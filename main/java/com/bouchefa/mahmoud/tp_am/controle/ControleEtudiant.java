package com.bouchefa.mahmoud.tp_am.controle;

import android.content.Context;
import android.content.Intent;

import com.bouchefa.mahmoud.tp_am.model.AccesDistant;
import com.bouchefa.mahmoud.tp_am.model.Etudiant;
import com.bouchefa.mahmoud.tp_am.vues.Prof_Activity;
import com.bouchefa.mahmoud.tp_am.vues.Stud_Activity;

import java.util.ArrayList;


public class ControleEtudiant {

    private static  ControleEtudiant instance ;
    private static  Context context ;
    private static AccesDistant accesDistant ;

    private ControleEtudiant(){
    super();
    }

    public static void getInstance(Context context){
        if( instance == null  ){
            instance = new ControleEtudiant();
            ControleEtudiant.context = context ;
            accesDistant = new AccesDistant(context);
            accesDistant.Envoie("etudiants",null);
        }
    }


        public static void update(String cb ){

                accesDistant.Envoie("update", cb);

                }



    public static void  startStudActivity(ArrayList<Etudiant> etudiants) {

        Intent intent = new Intent(context, Stud_Activity.class);

        intent.putParcelableArrayListExtra("etud", etudiants);


        if(context.getClass() == Prof_Activity.class) {

            ((Prof_Activity)context).startActivity(intent);

            ((Prof_Activity) context).finish();

        }else if (context.getClass() == Stud_Activity.class){
            ((Stud_Activity)context).startActivity(intent);

            ((Stud_Activity) context).finish();
        }
    }


    public static void setInstance(ControleEtudiant instance) {
        ControleEtudiant.instance = instance;
    }
}
