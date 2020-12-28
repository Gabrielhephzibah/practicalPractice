package com.cherish.practicalpractice;

import android.text.InputType;

import androidx.annotation.ContentView;
import androidx.test.espresso.Espresso;

import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.Espresso.onView;

import androidx.test.espresso.ViewAction;
import androidx.test.espresso.ViewAssertion;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.*;
import static org.hamcrest.Matchers.is;

import androidx.test.rule.ActivityTestRule;


import com.cherish.practicalpractice.debugging.BreakPointActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class BreakPointEspressoUITest {
    @Rule
    public ActivityTestRule mActivityRule  = new ActivityTestRule(BreakPointActivity.class);

    @Test
    public void  goToNextActivity(){
       onView(withId(R.id.nextBtn)).perform(click());
       onView(withId(R.id.newText)).check(matches(isDisplayed()));
        onView(withId(R.id.newText)).perform(click());
        onView(withId(R.id.firstEdit)).perform(typeText(String.valueOf(3.9)));
        onView(withId(R.id.addBtn)).perform(click());
        onView(withId(R.id.secondEdit)).perform(typeText(String.valueOf(5.9)));
        onView(withId(R.id.firstEdit)).check(matches(withHint("enter a number")));
//        onView(withId(R.id.secondEdit)).check(matches(withInputType(InputType.TYPE_CLASS_TEXT)));

//        onView(withId(R.id.subtractBtn)).perform(click());
//        onView(withId(R.id.divisionBtn)).perform(click());
//        onView(withId(R.id.multiplyBtn)).perform(click());

    }

    @Test
    public void iterateSpinner(){
        String[] arrays =  mActivityRule.getActivity().getResources()
                .getStringArray(R.array.labels_array);
        int size = arrays.length;
        for (int i=0; i<size; i++) {
            onView(withId(R.id.spinner)).perform(click());
            onData(is(arrays[i])).perform(click());

        }
    }


}

