package com.myor.android.geonames;

import android.app.AlertDialog;
import android.app.ListActivity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.*;

public class HttpGetActivity extends ListActivity {
	private static final String TAG = "HttpGetActivity";
	private ProgressDialog _progressDialog;
	private String _postalCode;
	private String _countryCode;
	private String _radius;

	// ***************************************
	// Activity methods
	// ***************************************
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Bundle bundle = this.getIntent().getExtras();
		this._postalCode = bundle.getString("postalCode");
		this._countryCode = bundle.getString("countryCode");
		this._radius = bundle.getString("radius");

	}

	@Override
	public void onStart() {
		super.onStart();

		// when this activity starts, initiate an asynchronous HTTP GET request
		new DownloadStatesTask(_postalCode, _countryCode, _radius).execute();
	}

	// ***************************************
	// Private methods
	// ***************************************

	/**
	 * Displays the list of states in the UI
	 */
	private void refreshStates(List<PostalCode> statesList) {
		if (statesList == null) {

			AlertDialog alertDialog = new AlertDialog.Builder(this).create();
			alertDialog.setTitle("Error from server");
			alertDialog
					.setMessage("The free servers are currently overloaded with requests.");
			alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
				public void onClick(DialogInterface dialog, int which) {
					finish();
					return;
				}
			});

			alertDialog.show();
		
			return;
		}

		List<Map<String, String>> stateMaps = new ArrayList<Map<String, String>>();

		for (PostalCode state : statesList) {
			Map<String, String> map = new HashMap<String, String>();
			map.put("name", state.getPlaceName());
			map.put("description", state.getAdminName2() + ", "
					+ state.getAdminName1() + ", " + state.getPostalCode()
					+ ", Lat: " + state.getLat() + ", Lng: " + state.getLng());
			stateMaps.add(map);
		}

//		SimpleAdapter adapter = new SimpleAdapter(this, stateMaps,
//				R.layout.states_list_item,
//				new String[] { "name", "description" }, new int[] { R.id.name,
//						R.id.description });

//		this.setListAdapter(adapter);
	}

	private void showLoadingProgressDialog() {
		_progressDialog = ProgressDialog.show(this, "",
				"Loading. Please wait...", true);
	}

	private void dismissProgressDialog() {
		if (_progressDialog != null) {
			_progressDialog.dismiss();
		}
	}

	private void logException(Exception e) {
		Log.e(TAG, e.getMessage(), e);
		Writer result = new StringWriter();
		e.printStackTrace(new PrintWriter(result));
	}

	// ***************************************
	// Private classes
	// ***************************************
	private class DownloadStatesTask extends
			AsyncTask<Void, Void, List<PostalCode>> {
		private String postalCode;
		private String countryCode;
		private String radius;

		public DownloadStatesTask(String postalCode, String countryCode,
				String radius) {
			this.postalCode = postalCode;
			this.countryCode = countryCode;
			this.radius = radius;
		}

		@Override
		protected void onPreExecute() {
			// before the network request begins, show a progress indicator
			showLoadingProgressDialog();
		}

		@Override
		protected List<PostalCode> doInBackground(Void... params) {
			try {
				// Create a new RestTemplate instance
				RestTemplate restTemplate = new RestTemplate();

				// The HttpComponentsClientHttpRequestFactory uses the
				// org.apache.http package to make network requests
				restTemplate
						.setRequestFactory(new HttpComponentsClientHttpRequestFactory());

				// The URL for making the GET request
				final String url = "http://ws.geonames.org/findNearbyPostalCodesJSON?postalcode={postalCode}&country={countryCode}&radius={radius}";

				// Initiate the HTTP GET request, expecting an array of State
				// objects in response
				PostalCodes result = restTemplate.getForObject(url,
						PostalCodes.class, this.postalCode, this.countryCode,
						this.radius);

				// convert the array to a list and return it
				return Arrays.asList(result.getPostalCodes());
			} catch (Exception e) {
				logException(e);
			}

			return null;
		}

		@Override
		protected void onPostExecute(List<PostalCode> result) {
			// hide the progress indicator when the network request is complete
			dismissProgressDialog();

			// return the list of states
			refreshStates(result);
		}
	}
}
