package com.example.plan8_ui.Events;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import android.app.DatePickerDialog;
import android.app.DatePickerDialog.OnDateSetListener;
import android.app.TimePickerDialog;
import android.app.TimePickerDialog.OnTimeSetListener;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;

import com.example.plan8_ui.R;
import com.example.plan8_ui.Friends.EventAttendeesActivity;
import com.example.plan8_ui.Friends.InviteFriendsActivity;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMap.OnMapClickListener;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class EventProfileActivity extends ActionBarActivity {

	private EditText title_et, start_date_et, start_time_et, end_date_et, end_time_et, location_et, description_et;
	private GoogleMap googleMap;
	private MarkerOptions markerOptions;
	private Marker marker;
	private EditText tempET;
	private SimpleDateFormat dateFormatter, timeFormatter;
	private Button inviteButton, attendeesButton;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_event_profile);
		
		InputMethodManager im = (InputMethodManager) this.getApplicationContext().getSystemService(Context.INPUT_METHOD_SERVICE);
		im.hideSoftInputFromWindow(getWindow().getDecorView().getWindowToken(), 0);
		
		Toolbar toolbar = (Toolbar) findViewById(R.id.event_profile_activity_toolbar);
		if (toolbar != null) {
		    setSupportActionBar(toolbar);
		}
		
		dateFormatter = new SimpleDateFormat("MMM dd, yyyy", Locale.US);
		timeFormatter = new SimpleDateFormat("HH:mm", Locale.US);

		title_et = (EditText) findViewById(R.id.event_profile_title);
		start_date_et = (EditText) findViewById(R.id.event_profile_date_start);
		start_time_et = (EditText) findViewById(R.id.event_profile_time_start);
		end_date_et = (EditText) findViewById(R.id.event_profile_date_end);
		end_time_et = (EditText) findViewById(R.id.event_profile_time_end);
		location_et = (EditText) findViewById(R.id.event_profile_location);
		description_et = (EditText) findViewById(R.id.event_profile_description);
		
		inviteButton = (Button) findViewById(R.id.event_profile_invite_button);
		inviteButton.setOnClickListener(inviteButtonOCL);
		
		attendeesButton = (Button) findViewById(R.id.event_profile_attendees_button);
		attendeesButton.setOnClickListener(attendeesButtonOCL);
		
		initializeMap();
        
	}
	
	private void initializeMap(){
		
		if (googleMap == null) {

            googleMap = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(
                    R.id.event_profile_map)).getMap();
            
            markerOptions = new MarkerOptions();
            
            LatLng latLng = new LatLng(14.566402, 120.993179);
            markerOptions.position(latLng);
            CameraUpdate cameraUpdate = CameraUpdateFactory.newLatLngZoom(latLng, 17);
            googleMap.moveCamera(cameraUpdate);
            marker = googleMap.addMarker(markerOptions);

		}

	}

	OnMapClickListener map_OMCL = new OnMapClickListener() {
		
		@Override
		public void onMapClick(LatLng point) {

			marker.remove();
			markerOptions.position(point);
			marker = googleMap.addMarker(markerOptions.draggable(true));
			googleMap.animateCamera(CameraUpdateFactory.newLatLng(point));
            
		}
		
	};
	
	private OnClickListener inviteButtonOCL = new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			
			Intent i = new Intent();
			i.setClass(getBaseContext(), InviteFriendsActivity.class);
			//i.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
			startActivityForResult(i, 0);
			
		}
		
	};
	
	private OnClickListener attendeesButtonOCL = new OnClickListener() {
		
		@Override
		public void onClick(View arg0) {

			Intent i = new Intent();
			i.setClass(getBaseContext(), EventAttendeesActivity.class);
			//i.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
			startActivity(i);
			
		}
		
	};
	
	private Menu menu;
	private OnClickListener event_fab_OCL = new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			
		}
		
	};
	
	private OnClickListener startDateOCL = new OnClickListener(){

		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			tempET = start_date_et;
			showDatePicker();
		}
		
	};

	private OnClickListener endDateOCL = new OnClickListener(){

		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			tempET = end_date_et;
			showDatePicker();
		}
		
	};

	private OnClickListener startTimeOCL = new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			tempET = start_time_et;
			showTimePicker();
		}
		
	};
	
	private OnClickListener endTimeOCL = new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			tempET = end_time_et;
			showTimePicker();
		}
		
	};
	
	private void showDatePicker(){
		
		Calendar newCalendar = Calendar.getInstance();
		DatePickerDialog dpd = new DatePickerDialog(EventProfileActivity.this, new OnDateSetListener() {

			@Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                Calendar newDate = Calendar.getInstance();
                newDate.set(year, monthOfYear, dayOfMonth);
                tempET.setText(dateFormatter.format(newDate.getTime()));
            }
 
        },newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));
		dpd.show();
		
	}
	
	private void showTimePicker(){
		
		Calendar newCalendar = Calendar.getInstance();
		
		TimePickerDialog tpd = new TimePickerDialog(EventProfileActivity.this, new OnTimeSetListener() {

			@Override
			public void onTimeSet(TimePicker view, int hour, int minute) {
				Calendar newDate = Calendar.getInstance();
				newDate.set(Calendar.HOUR, hour);
				newDate.set(Calendar.MINUTE, minute);
                tempET.setText(timeFormatter.format(newDate.getTime()));
			}
 
        },newCalendar.get(Calendar.HOUR), newCalendar.get(Calendar.MINUTE), true);
		
		tpd.show();
		
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		new MenuInflater(getApplication()).inflate(R.menu.event_profile, menu);
		this.menu = menu;
		return true;
	}

	private boolean first = true;
	private MenuItem back, edit, cancel, save, delete;
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();

		InputMethodManager im = (InputMethodManager) this.getApplicationContext().getSystemService(Context.INPUT_METHOD_SERVICE);
		im.hideSoftInputFromWindow(getWindow().getDecorView().getWindowToken(), 0);
		
		if(true == first){
			back = menu.findItem(R.id.event_profile_back);
			edit = menu.findItem(R.id.event_profile_edit);
			cancel = menu.findItem(R.id.event_profile_cancel);
			save = menu.findItem(R.id.event_profile_save);
			delete = menu.findItem(R.id.event_profile_delete);
			first = false;
		}
		
		if (R.id.event_profile_back == id) {
			finish();
			return true;
		}

		if(R.id.event_profile_edit == id){
			
			back.setVisible(false);
			edit.setVisible(false);
			title_et.setFocusableInTouchMode(true);
			start_date_et.setOnClickListener(startDateOCL);
			start_time_et.setOnClickListener(startTimeOCL);
			end_date_et.setOnClickListener(endDateOCL);
			end_time_et.setOnClickListener(endTimeOCL);
			location_et.setFocusableInTouchMode(true);
			description_et.setFocusableInTouchMode(true);
			
			cancel.setVisible(true);
	        save.setVisible(true);
	        delete.setVisible(true);
            googleMap.setOnMapClickListener(map_OMCL);
            
		}
		
		if(R.id.event_profile_cancel == id){
			
			cancel.setVisible(false);
	        save.setVisible(false);
	        delete.setVisible(false);
            googleMap.setOnMapClickListener(null);
            
			back.setVisible(true);
			edit.setVisible(true);
			title_et.setFocusable(false);
			start_date_et.setOnClickListener(null);
			start_time_et.setOnClickListener(null);
			end_date_et.setOnClickListener(null);
			end_time_et.setOnClickListener(null);
			location_et.setFocusable(false);
			description_et.setFocusable(false);
			
		}
		
		return super.onOptionsItemSelected(item);
		
	}
}