package com.alex.ultim2.test;

import static androidx.test.espresso.matcher.ViewMatchers.isAssignableFrom;

import android.view.View;
import android.widget.EditText;

import androidx.test.espresso.UiController;
import androidx.test.espresso.ViewAction;

import org.hamcrest.Matcher;

public class EnableViewAction implements ViewAction {
    @Override
    public Matcher<View> getConstraints() {
        return isAssignableFrom(EditText.class);
    }

    @Override
    public String getDescription() {
        return "Enable a view";
    }

    @Override
    public void perform(final UiController uiController, final View view) {
        ((EditText) view).setEnabled(true);
    }
}
