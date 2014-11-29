// Generated code from Butter Knife. Do not modify!
package com.example.plan8_ui.Events;

import android.view.View;
import butterknife.ButterKnife.Finder;

public class EventProfileActivity$$ViewInjector {
  public static void inject(Finder finder, final com.example.plan8_ui.Events.EventProfileActivity target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131492977, "field 'attendees_button' and method 'onClickAttendees'");
    target.attendees_button = (android.widget.Button) view;
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.onClickAttendees(p0);
        }
      });
    view = finder.findRequiredView(source, 2131492976, "field 'invite_button' and method 'onClickInvite'");
    target.invite_button = (android.widget.Button) view;
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.onClickInvite(p0);
        }
      });
    view = finder.findRequiredView(source, 2131492974, "field 'toolbar'");
    target.toolbar = (android.support.v7.widget.Toolbar) view;
    view = finder.findRequiredView(source, 2131492986, "field 'time_end_edit_text' and method 'onClickTimeEnd'");
    target.time_end_edit_text = (android.widget.EditText) view;
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.onClickTimeEnd(p0);
        }
      });
    view = finder.findRequiredView(source, 2131492978, "field 'scroll_view'");
    target.scroll_view = (android.widget.ScrollView) view;
    view = finder.findRequiredView(source, 2131492985, "field 'date_end_edit_text' and method 'onClickDateEnd'");
    target.date_end_edit_text = (android.widget.EditText) view;
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.onClickDateEnd(p0);
        }
      });
    view = finder.findRequiredView(source, 2131492982, "field 'date_start_edit_text' and method 'onClickDateStart'");
    target.date_start_edit_text = (android.widget.EditText) view;
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.onClickDateStart(p0);
        }
      });
    view = finder.findRequiredView(source, 2131492980, "field 'title_edit_text'");
    target.title_edit_text = (android.widget.EditText) view;
    view = finder.findRequiredView(source, 2131492990, "field 'description_edit_text'");
    target.description_edit_text = (android.widget.EditText) view;
    view = finder.findRequiredView(source, 2131492983, "field 'time_start_edit_text' and method 'onClickTimeStart'");
    target.time_start_edit_text = (android.widget.EditText) view;
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.onClickTimeStart(p0);
        }
      });
    view = finder.findRequiredView(source, 2131492988, "field 'location_edit_text'");
    target.location_edit_text = (android.widget.EditText) view;
  }

  public static void reset(com.example.plan8_ui.Events.EventProfileActivity target) {
    target.attendees_button = null;
    target.invite_button = null;
    target.toolbar = null;
    target.time_end_edit_text = null;
    target.scroll_view = null;
    target.date_end_edit_text = null;
    target.date_start_edit_text = null;
    target.title_edit_text = null;
    target.description_edit_text = null;
    target.time_start_edit_text = null;
    target.location_edit_text = null;
  }
}
