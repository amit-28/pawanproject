package freeversion.loadboard.com.loadkhoj.bean;

import java.util.Date;

/**
 * Created by amit.ja.
 * Date: 9/8/15
 * Time: 5:54 PM
 */
public class LoadFragmentItem {
    private int loadId;
    private String loadType;
    private String companyName;
    private String source;
    private String destination;
    private Date expiryDate;
    private int quote;
    private int minQuote;
    private int rankForQuote;

    public LoadFragmentItem(int loadId, String loadType, String companyName, String source,
                            String destination, Date expiryDate, int quote, int minQuote,
                            int rankForQuote) {
        this.loadId = loadId;
        this.companyName = companyName;
        this.loadType = loadType;
        this.source = source;
        this.destination = destination;
        this.expiryDate = expiryDate;
        this.quote = quote;
        this.minQuote = minQuote;
        this.rankForQuote = rankForQuote;
    }

    public int getLoadId() {
        return loadId;
    }

    public void setLoadId(int loadId) {
        this.loadId = loadId;
    }

    public String getLoadType() {
        return loadType;
    }

    public void setLoadType(String loadType) {
        this.loadType = loadType;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }

    public int getQuote() {
        return quote;
    }

    public void setQuote(int quote) {
        this.quote = quote;
    }

    public int getMinQuote() {
        return minQuote;
    }

    public void setMinQuote(int minQuote) {
        this.minQuote = minQuote;
    }

    public int getRankForQuote() {
        return rankForQuote;
    }

    public void setRankForQuote(int rankForQuote) {
        this.rankForQuote = rankForQuote;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
}
