package bp.bidlogger;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import android.widget.AdapterView.*;
import android.widget.ArrayAdapter;

import java.util.*;

/**
 * A placeholder fragment containing a simple view.
 */


public class BiddingFragment extends Fragment {

    private static BidActivity _bidActivity;
    private static Spinner _spinner;
    private ArrayList<Bid> _bidList;
    private  View _rootView;
    private int _passCount = 0;

    /**
     * The fragment argument representing the section number for this
     * fragment.
     */
    private static final String ARG_SECTION_NUMBER = "section_number";

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static BiddingFragment newInstance(int sectionNumber) {
        BiddingFragment fragment = new BiddingFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        //       LoadSpinner();
        return fragment;
    }

    public BiddingFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        _rootView = inflater.inflate(R.layout.fragment_bid, container, false);
        _bidList = new ArrayList<Bid>();
//        View view = this.getView();
        _spinner = (Spinner) _rootView.findViewById(R.id.boards_spinner);
        LoadSpinner();
        Spinner declarer_spinner = (Spinner) _rootView.findViewById(R.id.declarer_spinner);
        ArrayAdapter<String> declarer_dataAdapter;

        List<String> declarer_list = new ArrayList<String>();
        declarer_list.add("North");
        declarer_list.add(("East"));
        declarer_list.add(("South"));
        declarer_list.add(("West"));

        declarer_dataAdapter = new ArrayAdapter<String>
                (_bidActivity, R.layout.my_spinner_style, declarer_list);

        declarer_dataAdapter.setDropDownViewResource
                (android.R.layout.simple_spinner_item);

        declarer_spinner.setAdapter(declarer_dataAdapter);
        declarer_spinner.setOnItemSelectedListener(new DeclarersOnItemSelectedListener());
        _spinner.setOnItemSelectedListener(new BoardsOnItemSelectedListener());

        return _rootView;
    }


    // Create an anonymous implementation of OnClickListener


    public static void SetBidActivity(BidActivity ba) {
        _bidActivity = ba;
    }

    public static void LoadSpinner() {
        ArrayAdapter<String> dataAdapter;

        if (_spinner != null) {
            List<String> list = new ArrayList<String>();

            for (int i = 1; i < 37; i++) {
                list.add("" + i);
            }


            dataAdapter = new ArrayAdapter<String>
                    (_bidActivity, R.layout.my_spinner_style, list);

            dataAdapter.setDropDownViewResource
                    (android.R.layout.simple_spinner_item);
//            (android.R.layout.simple_spinner_dropdown_item);


            _spinner.setAdapter(dataAdapter);

            // Spinner item selection Listener
//                    addListenerOnSpinnerItemSelection();

        }
    }


    public boolean AddBid(Bid bid){

        int result = -1;

        int size = _bidList.size();

        if ((size == 0) || (bid.Suit() == "Pass") ){
            result = 1;
        }
        else {
            Bid previousBid = _bidList.get(size - 1);
            result = (bid.compare(bid, previousBid));
        }
        if (result > 0){
            _bidList.add(bid);
            GridView gridView = (GridView) _rootView.findViewById(R.id.gridView);
            ArrayAdapter<String> adapter = (ArrayAdapter<String>) gridView.getAdapter();
            adapter.add("  "+bid.TheBid());
            adapter.notifyDataSetChanged();

            if (bid.Suit() == "Pass")
                {_passCount++;}
                else {_passCount = 0;}


            if (_passCount == 3){
                View view = this.getView();
                Context context = view.getContext();
                Context appContext = context.getApplicationContext();
                CharSequence text = "Bidding complete";
                int duration = Toast.LENGTH_SHORT;

                Toast toast = Toast.makeText(context, text, duration);
                toast.show();
            }

            return true;
        }
        return false;
    }

    public void RemoveLastBid() {
        int size = _bidList.size();
        if (size == 0) return;
        GridView gridView = (GridView) _rootView.findViewById(R.id.gridView);
        ArrayAdapter<String> adapter = (ArrayAdapter<String>) gridView.getAdapter();
        int count = adapter.getCount();
        String bid = adapter.getItem(count-1);
        if (bid == "") return;
        _bidList.remove(size-1);
        adapter.remove(bid);
        adapter.notifyDataSetChanged();
    }

    public void RemoveAllBids() {
        int size = _bidList.size();
        if (size == 0) return;
        _bidList.clear();
        GridView gridView = (GridView) _rootView.findViewById(R.id.gridView);
        ArrayAdapter<String> adapter = (ArrayAdapter<String>) gridView.getAdapter();
        adapter.clear();

        Spinner declarer_spinner = (Spinner) _rootView.findViewById(R.id.declarer_spinner);
        String declarer = (String)declarer_spinner.getSelectedItem();
        SetDeclarerPosition(declarer);
        adapter.notifyDataSetChanged();
    }

    public void SetDeclarerPosition(String declarer){
        GridView gridView = (GridView)_rootView.findViewById(R.id.gridView);
        int startPosition = 0;
        if (declarer == "North")
        {
            startPosition = 1;
        }
        else
        {
            if (declarer == "East")
            {
                startPosition = 2;
            }
            else
            {
                if (declarer == "South")
                {
                    startPosition = 3;
                }
            }
        }
        ArrayAdapter<String> bidsAdapter = new ArrayAdapter<String>
                (_bidActivity, android.R.layout.simple_list_item_1);
        gridView.setAdapter(bidsAdapter);

        for (int i=0; i<startPosition;i++) {
            bidsAdapter.add(" ");
        }
        bidsAdapter.notifyDataSetChanged();
    }

    public class BoardsOnItemSelectedListener implements OnItemSelectedListener {

        public void onItemSelected(AdapterView<?> parent, View view, int pos,long id) {

 //           Toast.makeText(parent.getContext(),
 //                   "OnItemSelectedListener : " + parent.getItemAtPosition(pos).toString(),
 //                   Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onNothingSelected(AdapterView<?> arg0) {
            // TODO Auto-generated method stub
        }

    }


    public class DeclarersOnItemSelectedListener implements OnItemSelectedListener {

        public void onItemSelected(AdapterView<?> parent, View view, int pos,long id) {

            SetDeclarerPosition(parent.getItemAtPosition(pos).toString());

 //           Toast.makeText(parent.getContext(),
 //                   "OnItemSelectedListener : " + parent.getItemAtPosition(pos).toString(),
 //                   Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onNothingSelected(AdapterView<?> arg0) {
            // TODO Auto-generated method stub
        }

    }



}

