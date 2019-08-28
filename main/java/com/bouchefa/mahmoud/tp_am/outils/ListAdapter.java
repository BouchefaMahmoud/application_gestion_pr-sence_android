package com.bouchefa.mahmoud.tp_am.outils;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bouchefa.mahmoud.tp_am.R;
import com.bouchefa.mahmoud.tp_am.model.Etudiant;

import java.util.ArrayList;


public class ListAdapter extends ArrayAdapter<Etudiant> {
	
	
	Context context ;
	
	public ListAdapter(Context context,ArrayList<Etudiant> objects) {
		super(context, 0, objects);
		this.context = context;
			}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
	
	convertView = LayoutInflater.from(context).inflate(R.layout.item, parent, false);

	TextView nom = (TextView)convertView.findViewById(R.id.tvnom);
	TextView prenom = (TextView)convertView.findViewById(R.id.tvprenom);
		TextView presence = (TextView)convertView.findViewById(R.id.presence);
		TextView cb = (TextView)convertView.findViewById(R.id.tvcb);
	
	Etudiant courrentUser = getItem(position);

	nom.setText(courrentUser.getNom());
	prenom.setText(courrentUser.getPrenom());
	presence.setText(courrentUser.getPresence());
		cb.setText(courrentUser.getCb());
		return convertView;
	}

	
}
