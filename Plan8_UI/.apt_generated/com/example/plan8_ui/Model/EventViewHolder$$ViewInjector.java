// Generated code from Butter Knife. Do not modify!
package com.example.plan8_ui.Model;

import android.view.View;
import butterknife.ButterKnife.Finder;

public class EventViewHolder$$ViewInjector {
  public static void inject(Finder finder, final com.example.plan8_ui.Model.EventViewHolder target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131493021, "field 'location_text_view'");
    target.location_text_view = (android.widget.TextView) view;
    view = finder.findRequiredView(source, 2131493020, "field 'title_text_view'");
    target.title_text_view = (android.widget.TextView) view;
    view = finder.findRequiredView(source, 2131493016, "field 'date_start_text_view'");
    target.date_start_text_view = (android.widget.TextView) view;
    view = finder.findRequiredView(source, 2131493017, "field 'time_start_text_view'");
    target.time_start_text_view = (android.widget.TextView) view;
    view = finder.findRequiredView(source, 2131493019, "field 'time_end_text_view'");
    target.time_end_text_view = (android.widget.TextView) view;
    view = finder.findRequiredView(source, 2131493018, "field 'date_end_text_view'");
    target.date_end_text_view = (android.widget.TextView) view;
  }

  public static void reset(com.example.plan8_ui.Model.EventViewHolder target) {
    target.location_text_view = null;
    target.title_text_view = null;
    target.date_start_text_view = null;
    target.time_start_text_view = null;
    target.time_end_text_view = null;
    target.date_end_text_view = null;
  }
}
