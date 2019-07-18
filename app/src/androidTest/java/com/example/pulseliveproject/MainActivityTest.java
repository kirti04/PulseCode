package com.example.pulseliveproject;

import androidx.recyclerview.widget.RecyclerView;
import androidx.test.espresso.Espresso;
import androidx.test.espresso.assertion.ViewAssertions;
import androidx.test.espresso.contrib.RecyclerViewActions;
import androidx.test.espresso.matcher.RootMatchers;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.rule.ActivityTestRule;
import androidx.test.runner.AndroidJUnit4;

import com.example.pulseliveproject.ui.MainActivity;

import org.hamcrest.Matchers;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

        @Rule
        public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(MainActivity.class);


        @Test
        public void TestCase_isRecyclerDisplayed() {
            onView(withId(R.id.items_recycler)).check(ViewAssertions.matches(isDisplayed()));
        }

        @Test
        public void Testcase_forRecyclerViewScroll() {

            RecyclerView recyclerView  = mActivityRule.getActivity().findViewById(R.id.items_recycler);
        /*int itemcount=  recyclerView.getAdapter().getItemCount();
        System.out.println("item" + itemcount);*/
            Espresso.registerIdlingResources(mActivityRule.getActivity().countingIdlingResource);
            Espresso.onView(ViewMatchers.withId(R.id.items_recycler))
                    .inRoot(RootMatchers.withDecorView(Matchers.is(mActivityRule.getActivity().getWindow().getDecorView())))
                    .perform(RecyclerViewActions.scrollToPosition(8-1));

        }
        @Test
        public void Testcase_forRecyclerOnItemClick() {
            Espresso.registerIdlingResources(mActivityRule.getActivity().countingIdlingResource);
            Espresso.onView(ViewMatchers.withId(R.id.items_recycler))
                    .inRoot(RootMatchers.withDecorView(Matchers.is(mActivityRule.getActivity().getWindow().getDecorView())))
                    .perform(RecyclerViewActions.actionOnItemAtPosition(3,click()));
        }
}

