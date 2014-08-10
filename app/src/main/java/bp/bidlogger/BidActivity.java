package bp.bidlogger;

import java.util.Locale;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.support.v13.app.FragmentPagerAdapter;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import java.util.*;


public class BidActivity extends Activity {

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v13.app.FragmentStatePagerAdapter}.
     */
    SectionsPagerAdapter mSectionsPagerAdapter;
    private int _bidValue = 0;
    private BiddingFragment _biddingFragment;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bid);


        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getFragmentManager());
        BiddingFragment.SetBidActivity(this);
        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.pager);
        mViewPager.setAdapter(mSectionsPagerAdapter);
    }

    // Add spinner data

    public void addListenerOnSpinnerItemSelection() {

        //     spinner1.setOnItemSelectedListener(new CustomOnItemSelectedListener());
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.bid, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

//        private BidActivity _bidActivity;

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            if (position == 1) {
                return HistoryFragment.newInstance(position + 1);
            } else {
                _biddingFragment = BiddingFragment.newInstance(position + 1);
     //           BiddingFragment.LoadSpinner();
                return _biddingFragment;
            }
        }


        @Override
        public int getCount() {
            // Show 3 total pages.
            return 2;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            Locale l = Locale.getDefault();
            switch (position) {
                case 0:
                    return "History".toUpperCase(l);
                case 1:
                    return "Bidding".toUpperCase(l);
//                case 2:
//                    return getString(R.string.title_section3).toUpperCase(l);
            }
            return null;
        }
    }

    public void ClickedButton1(View view) {
        _bidValue = 1;
        Context context =  this.getApplicationContext();
        CharSequence text = "Button 1 clicked!";
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, text, duration);
//        toast.show();
    }

    public void ClickedButton2(View view) {
        _bidValue = 2;
        Context context =  this.getApplicationContext();
        CharSequence text = "Button 2 clicked!";
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, text, duration);
//        toast.show();
    }

    public void ClickedButton3(View view) {
        _bidValue = 3;
        Context context =  this.getApplicationContext();
        Context appContext = context.getApplicationContext();
        CharSequence text = "Button 3 clicked!";
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
//        toast.show();
    }
    public void ClickedButton4(View view) {
        _bidValue = 4;
        Context context =  this.getApplicationContext();
        Context appContext = context.getApplicationContext();
        CharSequence text = "Button 4 clicked!";
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
//        toast.show();
    }
    public void ClickedButton5(View view) {
        _bidValue = 5;
        Context context =  this.getApplicationContext();
        Context appContext = context.getApplicationContext();
        CharSequence text = "Button 5 clicked!";
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
//        toast.show();
    }
    public void ClickedButton6(View view) {
        _bidValue = 6;
        Context context =  this.getApplicationContext();
        Context appContext = context.getApplicationContext();
        CharSequence text = "Button 6 clicked!";
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
//        toast.show();
    }
    public void ClickedButton7(View view) {
        _bidValue = 7;
        Context context =  this.getApplicationContext();
        Context appContext = context.getApplicationContext();
        CharSequence text = "Button 7 clicked!";
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }

    public void ClickedButtonClubs(View view) {
        Bid bid = new Bid(_bidValue,"♣");
        if ((_bidValue == 0) ||(!_biddingFragment.AddBid(bid))) {
            Context context = this.getApplicationContext();
            Context appContext = context.getApplicationContext();
            CharSequence text = "Invalid bid!";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }
    }

    public void ClickedButtonDiamonds(View view) {
        Bid bid = new Bid(_bidValue, "♦");
        if ((_bidValue == 0) ||(!_biddingFragment.AddBid(bid))) {
            Context context = this.getApplicationContext();
            Context appContext = context.getApplicationContext();
            CharSequence text = "Invalid bid!";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }
    }

    public void ClickedButtonHearts(View view) {
        Bid bid = new Bid(_bidValue, "♥");
        if ((_bidValue == 0) ||(!_biddingFragment.AddBid(bid))) {
            Context context = this.getApplicationContext();
            Context appContext = context.getApplicationContext();
            CharSequence text = "Invalid bid!";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }
    }

    public void ClickedButtonSpades(View view) {
        Bid bid = new Bid(_bidValue, "♠");
        if ((_bidValue == 0) ||(!_biddingFragment.AddBid(bid))) {
            Context context = this.getApplicationContext();
            Context appContext = context.getApplicationContext();
            CharSequence text = "Invalid bid!";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }
    }

    public void ClickedButtonNT(View view) {
        Bid bid = new Bid(_bidValue, "NT");
        if ((_bidValue == 0) ||(!_biddingFragment.AddBid(bid))) {
            Context context = this.getApplicationContext();
            Context appContext = context.getApplicationContext();
            CharSequence text = "Invalid bid!";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }
    }


    public void ClickedButtonBack(View view) {
        _biddingFragment.RemoveLastBid();
/*            Context context = this.getApplicationContext();
            Context appContext = context.getApplicationContext();
            CharSequence text = "Invalid bid!";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
*/
    }

    public void ClickedButtonBackAll(View view) {
        _biddingFragment.RemoveAllBids();
/*            Context context = this.getApplicationContext();
            Context appContext = context.getApplicationContext();
            CharSequence text = "Invalid bid!";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
*/
    }

    public void ClickedButtonPass(View view) {
        Bid bid = new Bid(0, "Pass");
        if (!_biddingFragment.AddBid(bid)) {
            Context context = this.getApplicationContext();
            Context appContext = context.getApplicationContext();
            CharSequence text = "Invalid bid!";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }
    }
}







