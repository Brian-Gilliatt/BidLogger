package bp.bidlogger;

import java.util.Comparator;

/**
 * Created by Brian on 09/08/2014.
 */
public class Bid implements Comparator<Bid> {

    private int _bidValue;
    private String _suit;

    public enum Player {
        NORTH, EAST, SOUTH, WEST
    }

    Bid(int bidValue, String suit) {
        _bidValue =  bidValue;
        _suit = suit;
    }

    public String TheBid ()
    {
        if (_suit == "Pass" ) return _suit;
        else return _bidValue + _suit;
    }

    public int Value ()
    {
        return _bidValue;
    }

    public String Suit(){
        return _suit;
    }

    @Override
    public int compare(Bid b1, Bid b2) {

        if (b1.Value() > b2.Value()) return 1;
        if (b1.Value() < b2.Value()) return -1;
        if (b1.Suit() == "♣") {
            if (b2.Suit() == "♣") return 0;
            else return -1;
        }
        if (b1.Suit() == "♦") {
            if (b2.Suit() == "♦") return 0;
            else {
                if (b2.Suit() == "♣")return 1;
            }
            return -1;
        }

        if (b1.Suit() == "♥") {
            if (b2.Suit() == "♥") return 0;
            else {
                if ((b2.Suit() == "♠") || (b2.Suit() == "NT")) return -1;
            }
            return 1;
        }

        if (b1.Suit() == "♠") {
            if (b2.Suit() == "♠") return 0;
            else{
                if (b2.Suit() == "NT") return -1;
            }
            return 1;
        }

        if (b1.Suit() == "NT") {
            if (b2.Suit() == "NT") return 0;

        }
        return 1;
    }

}
