package com.example.plan8_ui.Events;

import java.util.ArrayList;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnItemClick;

import com.example.plan8_ui.R;
import com.example.plan8_ui.AsyncTasks.FetchDeclinedEvents;
import com.example.plan8_ui.Interfaces.AsyncFetchListTaskCompleteListener;
import com.example.plan8_ui.Model.Event;

/**
 * A simple {@link Fragment} subclass. Use the
 * {@link DeclinedEventsFragment#newInstance} factory method to create an
 * instance of this fragment.
 *
 */
public class DeclinedEventsFragment extends Fragment implements AsyncFetchListTaskCompleteListener<ArrayList<Event>>{
	// TODO: Rename parameter arguments, choose names that match
	// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
	private static final String ARG_PARAM1 = "param1";
	private static final String ARG_PARAM2 = "param2";

	// TODO: Rename and change types of parameters
	private String mParam1;
	private String mParam2;

	/**
	 * Use this factory method to create a new instance of this fragment using
	 * the provided parameters.
	 *
	 * @param param1
	 *            Parameter 1.
	 * @param param2
	 *            Parameter 2.
	 * @return A new instance of fragment DeclinedEventsFragment.
	 */
	// TODO: Rename and change types and number of parameters
	public static DeclinedEventsFragment newInstance(String param1,
			String param2) {
		DeclinedEventsFragment fragment = new DeclinedEventsFragment();
		Bundle args = new Bundle();
		args.putString(ARG_PARAM1, param1);
		args.putString(ARG_PARAM2, param2);
		fragment.setArguments(args);
		return fragment;
	}

	public DeclinedEventsFragment() {
		// Required empty public constructor
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		if (getArguments() != null) {
			mParam1 = getArguments().getString(ARG_PARAM1);
			mParam2 = getArguments().getString(ARG_PARAM2);
		}
	}

	// lazy to find view by id 
	@InjectView(R.id.declined_events_fragment_list_view) ListView events_list_view;
	
	EventsAdapter eventsAdapter;
	View DeclinedEventsFragmentView;
	ArrayList<Event> events;
	FetchDeclinedEvents fetchDeclinedEvents;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// Inflate the layout for this fragment

		super.onCreateView(inflater, container, savedInstanceState);
		DeclinedEventsFragmentView = inflater.inflate(R.layout.fragment_declined_events, container, false);
		ButterKnife.inject(this, DeclinedEventsFragmentView);
		
		events = new ArrayList<Event>();
		eventsAdapter = new EventsAdapter(getActivity().getBaseContext(), R.layout.event_item, events);

		events_list_view.setAdapter(eventsAdapter);

		fetchDeclinedEvents = new FetchDeclinedEvents(this);
		fetchDeclinedEvents.execute();
		
		return DeclinedEventsFragmentView;
		
	}
	
	@Override
	public void onDestroy() {
		super.onDestroy();
		fetchDeclinedEvents.cancel(true);
	}
	
	@OnItemClick (R.id.declined_events_fragment_list_view)
	public void onItemClick(int position){

		Intent i = new Intent();
		i.setClass(getActivity().getBaseContext(), EventProfileActivity.class);
		startActivityForResult(i, 1);
		
	}
	
	@Override
	public void update_list(ArrayList<Event> result) {
		events.clear();
		events.addAll(result);
		eventsAdapter.notifyDataSetChanged();
	}

}
