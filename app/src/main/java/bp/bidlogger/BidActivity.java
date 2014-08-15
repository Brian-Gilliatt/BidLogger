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
import java.util.Date;
import java.io.*;
import java.nio.*;


import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;



import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;



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
        HistoryFragment.SetBidActivity(this);
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
        Bid bid = new Bid(_bidValue,"♣",_biddingFragment.GetBidder());
        if ((_bidValue == 0) ||(!_biddingFragment.AddBid(bid))) {
            Context context = this.getApplicationContext();
            Context appContext = context.getApplicationContext();
            CharSequence text = "Invalid bid!";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
            return;
        }
        _biddingFragment.UpdateBidder();
    }

    public void ClickedButtonDiamonds(View view) {
        Bid bid = new Bid(_bidValue, "♦",_biddingFragment.GetBidder());
        if ((_bidValue == 0) ||(!_biddingFragment.AddBid(bid))) {
            Context context = this.getApplicationContext();
            Context appContext = context.getApplicationContext();
            CharSequence text = "Invalid bid!";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
            return;
        }
        _biddingFragment.UpdateBidder();
    }

    public void ClickedButtonHearts(View view) {
        Bid bid = new Bid(_bidValue, "♥",_biddingFragment.GetBidder());
        if ((_bidValue == 0) ||(!_biddingFragment.AddBid(bid))) {
            Context context = this.getApplicationContext();
            Context appContext = context.getApplicationContext();
            CharSequence text = "Invalid bid!";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
            return;
        }
        _biddingFragment.UpdateBidder();
    }

    public void ClickedButtonSpades(View view) {
        Bid bid = new Bid(_bidValue, "♠",_biddingFragment.GetBidder());
        if ((_bidValue == 0) ||(!_biddingFragment.AddBid(bid))) {
            Context context = this.getApplicationContext();
            Context appContext = context.getApplicationContext();
            CharSequence text = "Invalid bid!";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
            return;
        }
        _biddingFragment.UpdateBidder();
    }

    public void ClickedButtonNT(View view) {
        Bid bid = new Bid(_bidValue, "NT",_biddingFragment.GetBidder());
        if ((_bidValue == 0) ||(!_biddingFragment.AddBid(bid))) {
            Context context = this.getApplicationContext();
            Context appContext = context.getApplicationContext();
            CharSequence text = "Invalid bid!";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
            return;
        }
        _biddingFragment.UpdateBidder();
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
        Bid bid = new Bid(0, "Pass",_biddingFragment.GetBidder());
        if (!_biddingFragment.AddBid(bid)) {
            Context context = this.getApplicationContext();
            Context appContext = context.getApplicationContext();
            CharSequence text = "Invalid bid!";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
            return;
        }
        _biddingFragment.UpdateBidder();
    }

    public void OutputBids(ArrayList<Bid> bidList) {

        Calendar c = Calendar.getInstance();
        String fileName = String.format("BidLogger%tY%tm%td", c, c, c);

        Context context2 = getApplicationContext();
        File dir = context2.getFilesDir();

        String[] files = fileList();
        String data = "";
        Boolean found = false;
        String fileOnDisk = "";

        if ( files.length> 0 ) {
            for (int i=0; i< files.length;i++){
                fileOnDisk = files[i];
                if (fileOnDisk.equals(fileName))
                {
                    found = true;
                    break;
                }
            }

/*
            String file = files[0];
            String path = dir +"/" + file;
            try {
                FileReader in = new FileReader(path);

                 BufferedReader reader = new BufferedReader(in);
                String line = null;
                while ((line = reader.readLine()) != null) {
                    data += line;
 //                   System.out.println(line);
                }
            } catch (IOException x) {
                System.err.println(x);
            }
*/
        }





/*
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            dbf.setNamespaceAware(false);
            dbf.setValidating(false);
            DocumentBuilder db = dbf.newDocumentBuilder();
            return db.parse(source);
//        } catch (Exception e) {
//            e.printStackTrace();
//            return null;
//        }
*/
            Document doc;
            Element rootElement;


            try {
        DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();


        if (found) {
            docFactory.setNamespaceAware(false);
            docFactory.setValidating(false);
            DocumentBuilder db = docFactory.newDocumentBuilder();

            File file = new File(context2.getFilesDir(), fileName);

            doc =  db.parse(file);
            rootElement = doc.getDocumentElement();
           }
        else {
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            // Add root elements
            doc = docBuilder.newDocument();
            rootElement = doc.createElement("Competition");
            doc.appendChild(rootElement);
        }

        // board elements
        Element boardElement = doc.createElement("Board");
        rootElement.appendChild(boardElement);

        // set attribute to board element
        Attr attr = doc.createAttribute("HandNumber");
        attr.setValue("1");
        boardElement.setAttributeNode(attr);

            for(int i=0;i< bidList.size();i++)
            {
                Bid bid = bidList.get(i);

                // bid elements
                Element bidElement = doc.createElement("Bid");
                boardElement.appendChild(bidElement);

                // set attribute to bid element
                Attr attr1 = doc.createAttribute("bid");
                attr1.setValue(bid.TheBid());
                bidElement.setAttributeNode(attr1);

                // set attribute to bid element
                Attr attr2 = doc.createAttribute("by");
                attr2.setValue(bid.By());
                bidElement.setAttributeNode(attr2);
            }


            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
 //           StreamResult result = new StreamResult(new File(fileName));
            StreamResult result = new StreamResult(new File(context2.getFilesDir(), fileName));

            transformer.transform(source, result);

        } catch (ParserConfigurationException pce) {
            pce.printStackTrace();
        } catch (TransformerException tfe) {
        tfe.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        Context context = getApplicationContext();
        Context appContext = context.getApplicationContext();
        CharSequence text = "Output Xml!";
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }

    public String[] GetMyFiles(){
        String[] files = fileList();
        return files;
    }

}







