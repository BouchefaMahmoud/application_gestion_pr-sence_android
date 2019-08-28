package com.bouchefa.mahmoud.tp_am.outils;

import android.app.Activity;
import android.content.Intent;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.webkit.WebView;


import com.bouchefa.mahmoud.tp_am.R;
import com.bouchefa.mahmoud.tp_am.vues.Stud_Activity;

import static android.support.v4.app.ActivityCompat.startActivity;

public class SwipGestureDetector extends GestureDetector {
	
	public SwipGestureDetector(final Stud_Activity context){
		super(context, new SimpleOnGestureListener(){

			@Override
			public boolean onFling(MotionEvent e1, MotionEvent e2,
					float velocityX, float velocityY) {


				Activity activity = (Activity)context;
				float DeltaX = Math.abs(e1.getX() - e2.getX() );
				float DeltaY = Math.abs(e1.getY() - e2.getY() );
				
				if(DeltaY > DeltaX){

					/*WebView web=context.getWebView() ;
					web = (WebView)activity.findViewById(R.id.webview2);
					web.loadUrl("file:///android_asset/GIF.html");
					context.setWebView(web);*/
				}
				
				
				
				return super.onFling(e1, e2, velocityX, velocityY);
				
			
			}
			
			
		});
		
		
		
	}
	
	public static enum SwipOrientation{
		TOP_TO_BOTTOM
	}
	

}
