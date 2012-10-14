package com.leandog.puppies.view;

import android.app.Activity;
import android.text.Spanned;
import android.view.View;
import android.widget.TextView;

public class ViewHelper {

    @SuppressWarnings("unchecked")
    public static <ViewType extends View> ViewType findFor(final Activity activity, int id) {
        return (ViewType) activity.findViewById(id);
    }

    @SuppressWarnings("unchecked")
    public static <ViewType extends View> ViewType findFor(final View view, int id) {
        return (ViewType) view.findViewById(id);
    }
    
    public static String textOf(final Activity activity, final int id) {
        return textView(activity, id).getText().toString();
    }
    
    public static String textOf(final View view, final int id) {
        return textView(view, id).getText().toString();
    }

    public static void setText(final View view, final int id, final String text) {
        textView(view, id).setText(text);
    }

    public static void setText(final Activity activity, final int id, final String text) {
        textView(activity, id).setText(text);
    }

    public static void setText(final Activity activity, final int id, final Spanned spanned) {
        textView(activity, id).setText(spanned);
    }

    public static void setText(final View view, final int id, final Spanned spanned) {
        textView(view, id).setText(spanned);
    }
    
    public static void show(final Activity activity, final int id) {
        activity.findViewById(id).setVisibility(View.VISIBLE);
    }
    
    public static void show(final View view, final int id) {
        view.findViewById(id).setVisibility(View.VISIBLE);
    }
    
    public static void hide(final Activity activity, final int id) {
        activity.findViewById(id).setVisibility(View.GONE);
    }
    
    public static void hide(final View view, final int id) {
        view.findViewById(id).setVisibility(View.GONE);
    }

    private static TextView textView(final Activity activity, final int id) {
        final TextView textView = findFor(activity, id);
        return textView;
    }
    
    private static TextView textView(final View view, final int id) {
        final TextView textView = findFor(view, id);
        return textView;
    }

}
