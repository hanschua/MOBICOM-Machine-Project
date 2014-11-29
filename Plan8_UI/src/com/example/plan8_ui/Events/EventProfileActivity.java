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
import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

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

	@InjectView(R.id.event_profile_activity_title_edit_text) EditText title_edit_text;
	@InjectView(R.id.event_profile_activity_date_start_edit_text) EditText date_start_edit_text;
	@InjectView(R.id.event_profile_activity_time_start_edit_text) EditText time_start_edit_text;
	@InjectView(R.id.event_profile_activity_date_end_edit_text) EditText date_end_edit_text;
	@InjectView(R.id.event_profile_activity_time_end_edit_text) EditText time_end_edit_text;
	@InjectView(R.id.event_profile_activity_location_edit_text) EditText location_edit_text;
	@InjectView(R.id.event_profile_activity_description_edit_text) EditText description_edit_text;
	
	@InjectView(R.id.event_profile_activity_invite_button) Button invite_button;
	@InjectView(R.id.event_profile_activity_attendees_button) Button attendees_button;
	
	@InjectView(R.id.event_profile_activity_activity_toolbar) Toolbar toolbar;
	
	private GoogleMap googleMap;
	private MarkerOptions markerOptions;
	private Marker marker;
	private EditText tempET;
	private SimpleDateFormat dateFormatter, timeFormatter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_event_profile);
		ButterKnife.inject(this);
		
		InputMethodManager im = (InputMethodManager) this.getApplicationContext().getSystemService(Context.INPUT_METHOD_SERVICE);
		im.hideSoftInputFromWindow(getWindow().getDecorView().getWindowToken(), 0);
		
		if (toolbar != null) {
		    setSupportActionBar(toolbar);
		}
		
		dateFormatter = new SimpleDateFormat("MMM dd, yyyy", Locale.US);
		timeFormatter = new SimpleDateFormat("HH:mm", Locale.US);

		initializeMap();
        
	}
	
	private void initializeMap(){
		
		if (googleMap == null) {

            googleMap = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(
                    R.id.event_profile_activity_map_fragment)).getMap();
            
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
	
	@OnClick(R.id.event_profile_activity_invite_button)
	public void onClickInvite(View v) {
		// TODO Auto-generated method stub
		
		Intent i = new Intent();
		i.setClass(getBaseContext(), InviteFriendsActivity.class);
		//i.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
		startActivityForResult(i, 0);
		
	}
	
	@OnClick(R.id.event_profile_activity_attendees_button)
	public void onClickAttendees(View v) {

		Intent i = new Intent();
		i.setClass(getBaseContext(), EventAttendeesActivity.class);
		startActivity(i);
		
	}

	private Menu menu;
	
	private OnClickListener startDateOCL = new OnClickListener(){

		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			tempET = date_start_edit_text;
			showDatePicker();
		}
		
	};

	private OnClickListener endDateOCL = new OnClickListener(){

		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			tempET = date_end_edit_text;
			showDatePicker();
		}
		
	};

	private OnClickListener startTimeOCL = new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			tempET = time_start_edit_text;
			showTimePicker();
		}
		
	};
	
	private OnClickListener endTimeOCL = new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			tempET = time_end_edit_text;
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
			title_edit_text.setFocusableInTouchMode(true);
			date_start_edit_text.setOnClickListener(startDateOCL);
			time_start_edit_text.setOnClickListener(startTimeOCL);
			date_end_edit_text.setOnClickListener(endDateOCL);
			time_end_edit_text.setOnClickListener(endTimeOCL);
			location_edit_text.setFocusableInTouchMode(true);
			description_edit_text.setFocusableInTouchMode(true);
			
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
			title_edit_text.setFocusable(false);
			date_start_edit_text.setOnClickListener(null);
			time_start_edit_text.setOnClickListener(null);
			date_end_edit_text.setOnClickListener(null);
			time_end_edit_text.setOnClickListener(null);
			location_edit_text.setFocusable(false);
			description_edit_text.setFocusable(false);
			
		}
		
		return super.onOptionsItemSelected(item);
		
	}
}
