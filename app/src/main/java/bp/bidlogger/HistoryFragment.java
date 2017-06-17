package bp.bidlogger;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.*;
import android.widget.AdapterView.*;

import java.io.*;
import java.nio.*;



/**
 * A placeholder fragment containing a simple view.
 */


public class HistoryFragment extends Fragment {
    /**
     * The fragment argument representing the section number for this
     * fragment.
     */
    private static final String ARG_SECTION_NUMBER = "section_number";
    private static BidActivity _bidActivity;

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static HistoryFragment newInstance(int sectionNumber) {
        HistoryFragment fragment = new HistoryFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    public HistoryFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_history, container, false);


        String[] files = _bidActivity.GetMyFiles();
        String[] dates = new String[files.length];

        for (int i=0;i<files.length;i++)
        {
            String year = files[i].substring(9,13);
            String month = files[i].substring(13,15);
            String day = files[i].substring(15,17);
            String date = day+"/"+month+"/"+year;
            dates[i] = date;
        }

        ArrayAdapter adapter = new ArrayAdapter<String>(_bidActivity,
                android.R.layout.simple_list_item_1, dates);

        ListView listView = (ListView) rootView.findViewById(R.id.listView);
        listView.setAdapter(adapter);

        return rootView;
    }

    public static void SetBidActivity(BidActivity ba) {
        _bidActivity = ba;
    }
}