package com.myor.android.geonames;


import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

public class MainActivity extends Activity implements OnClickListener
{   
	//***************************************
    // Activity methods
    //***************************************
	@Override
	public void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
//		setContentView(R.layout.main);
//		Button button = (Button) findViewById(R.id.findDetail);
//		button.setOnClickListener(this);
		
	}



	public void onClick(View v) {
//		Bundle bundle = new Bundle();
//		bundle.putString("postalCode", ((EditText) findViewById(R.id.PostalCodeText)).getText().toString());
//		bundle.putString("countryCode", ((EditText) findViewById(R.id.CountryCodeText)).getText().toString());
//		bundle.putString("radius", ((EditText) findViewById(R.id.RadiusText)).getText().toString());
//		Intent intent = new Intent();
//		intent.setClass(this, HttpGetActivity.class);
//	    intent.putExtras(bundle);
//		startActivity(intent);
	}
}
