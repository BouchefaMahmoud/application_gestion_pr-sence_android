package com.bouchefa.mahmoud.tp_am.controle;


import android.content.Context;
import android.content.Intent;

import com.bouchefa.mahmoud.tp_am.model.AccesDistant;
import com.bouchefa.mahmoud.tp_am.vues.Prof_Activity;
import com.bouchefa.mahmoud.tp_am.vues.Splash_Activity;


import java.util.ArrayList;

public class Controle {

    private static Controle instance;
    private static AccesDistant accesDistant;
    public static Context context;


    private Controle() {
        super();
    }


    public static Controle getInstance(Context context) {

        if (instance == null) {
            instance = new Controle();
            Controle.context = context;
            accesDistant = new AccesDistant(context);
            accesDistant.Envoie("prof", null);

              }

        return instance;
    }


    public static void  startProfActivity(ArrayList<String> enseignants) {

                    Intent intent = new Intent(context, Prof_Activity.class);
                    intent.putStringArrayListExtra("ens",enseignants);
                    ((Splash_Activity)context).startActivity(intent);
                   ((Splash_Activity)context).finish();
    }


}