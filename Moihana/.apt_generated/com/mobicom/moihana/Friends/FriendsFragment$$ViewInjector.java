// Generated code from Butter Knife. Do not modify!
package com.mobicom.moihana.Friends;

import android.view.View;
import butterknife.ButterKnife.Finder;

public class FriendsFragment$$ViewInjector {
  public static void inject(Finder finder, final com.mobicom.moihana.Friends.FriendsFragment target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131493046, "field 'friends_list_view' and method 'onItemClick'");
    target.friends_list_view = (android.widget.ListView) view;
    ((android.widget.AdapterView<?>) view).setOnItemClickListener(
      new android.widget.AdapterView.OnItemClickListener() {
        @Override public void onItemClick(
          android.widget.AdapterView<?> p0,
          android.view.View p1,
          int p2,
          long p3
        ) {
          target.onItemClick(p2);
        }
      });
    view = finder.findRequiredView(source, 2131493047, "field 'addFriends', method 'onClick', and method 'onLongClick'");
    target.addFriends = (com.melnykov.fab.FloatingActionButton) view;
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.onClick();
        }
      });
    view.setOnLongClickListener(
      new android.view.View.OnLongClickListener() {
        @Override public boolean onLongClick(
          android.view.View p0
        ) {
          return target.onLongClick();
        }
      });
  }

  public static void reset(com.mobicom.moihana.Friends.FriendsFragment target) {
    target.friends_list_view = null;
    target.addFriends = null;
  }
}
