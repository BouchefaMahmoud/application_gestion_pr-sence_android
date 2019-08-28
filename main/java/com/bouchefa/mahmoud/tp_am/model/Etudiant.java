package com.bouchefa.mahmoud.tp_am.model;


import android.os.Parcel;
import android.os.Parcelable;

public class Etudiant implements Parcelable {

    private String cb ;
    private String nom ;
    private String prenom ;
    private String presence ;

    public Etudiant(String cb, String nom, String prenom, String presence) {
        this.cb = cb;
        this.nom = nom;
        this.prenom = prenom;
        this.presence = presence;
    }

    /**
     * Partie Serialisation
     *
     */

    protected Etudiant(Parcel in) {
        cb = in.readString();
        nom = in.readString();
        prenom = in.readString();
        presence = in.readString();
    }

    public static final Creator<Etudiant> CREATOR = new Creator<Etudiant>() {
        @Override
        public Etudiant createFromParcel(Parcel in) {
            return new Etudiant(in);
        }

        @Override
        public Etudiant[] newArray(int size) {
            return new Etudiant[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags){
        dest.writeString(cb);
        dest.writeString(nom);
        dest.writeString(prenom);
        dest.writeString(presence);
    }

    /**
     *
     * fin Partie Sérialisation
     */


    public String getCb() {
        return cb;
    }

    public void setCb(String cb) {
        this.cb = cb;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getPresence() {
        return presence;
    }

    public void setPresence(String presence) {
        this.presence = presence;
    }



    @Override
    public String toString() {
        return "Etudiant{" +
                "cb='" + cb + '\'' +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", presence='" + presence + '\'' +
                '}';
    }
}
