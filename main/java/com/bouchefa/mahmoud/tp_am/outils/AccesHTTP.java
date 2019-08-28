package com.bouchefa.mahmoud.tp_am.outils;

import android.os.AsyncTask;


import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

public class AccesHTTP extends AsyncTask< String, Integer, Long > {




    private ArrayList<NameValuePair> parametres;
    private static final String URL="http://192.168.8.100/tp/tp.php";
    private String retour=null ;
    public static InterAccesDistant delegate=null ;
    public AccesHTTP(){
        super();
        parametres = new ArrayList<NameValuePair>();
    }


    public void AjoutPar(String operation, String valeur){
        parametres.add(new BasicNameValuePair(operation, valeur));
    }



    @Override
    protected Long doInBackground(String... arg0) {

        HttpClient httpclient = new DefaultHttpClient();
        HttpPost httpPost = new HttpPost(URL);


        try {
            httpPost.setEntity(new UrlEncodedFormEntity(parametres));
            System.out.println("Avant");
            HttpResponse reponse = httpclient.execute(httpPost);
            System.out.println("Apres");
            retour = EntityUtils.toString(reponse.getEntity());

        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            System.out.println("Encodage : "+e.toString());
        } catch (ClientProtocolException e) {
            // TODO Auto-generated catch block
            System.out.println("Protocol : "+e.toString());
        } catch (IOException e) {
            // TODO Auto-generated catch block
            System.out.println("I/O : "+e.toString());
        }


        return null;
    }



    @Override
    protected void onPostExecute(Long result){
        System.out.println("**************************************onPostExecute");
        if(retour == null ){
            System.out.println("**************************************Retour null");
        }
        delegate.processfinish(retour.toString());
    }

}
