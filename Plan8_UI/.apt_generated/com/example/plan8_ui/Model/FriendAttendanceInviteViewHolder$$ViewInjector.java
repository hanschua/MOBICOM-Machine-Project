// Generated code from Butter Knife. Do not modify!
package com.example.plan8_ui.Model;

import android.view.View;
import butterknife.ButterKnife.Finder;

public class FriendAttendanceInviteViewHolder$$ViewInjector {
  public static void inject(Finder finder, final com.example.plan8_ui.Model.FriendAttendanceInviteViewHolder target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131493058, "field 'first_name_text_view'");
    target.first_name_text_view = (android.widget.TextView) view;
    view = finder.findRequiredView(source, 2131493059, "field 'last_name_text_view'");
    target.last_name_text_view = (android.widget.TextView) view;
    view = finder.findRequiredView(source, 2131493057, "field 'pic_image_view'");
    target.pic_image_view = (android.widget.ImageView) view;
    view = finder.findRequiredView(source, 2131493060, "field 'check_box'");
    target.check_box = (android.widget.CheckBox) view;
  }

  public static void reset(com.example.plan8_ui.Model.FriendAttendanceInviteViewHolder target) {
    target.first_name_text_view = null;
    target.last_name_text_view = null;
    target.pic_image_view = null;
    target.check_box = null;
  }
}