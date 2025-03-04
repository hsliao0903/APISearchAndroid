package com.mobile_computing;

/**
 * Created by Nicholas Cioli on 1/12/2017.
 */

public class Datum {
    private int    m_id;
    private String m_title;
    private String m_date;
    private String m_text;
    private String m_imageUrl;

    // Constructor
    Datum(int id, String title, String date, String text, String imageUrl) {
        m_id       = id;
        m_title    = title;
        m_date     = date;
        m_text     = text;
        //Log.i("[ALEX]", "Before" + imageUrl);
        //To simply fix Volley connection error with 301, which the URL is use for https already
        if(imageUrl.regionMatches(0, "http:", 0,5))
            imageUrl = imageUrl.replaceFirst("http:","https:");
        //Log.i("[ALEX]", "After" + imageUrl);
        m_imageUrl = imageUrl;

    }

    // Get operations
    public int id () { return m_id; }
    public String title() { return m_title; }
    public String date() { return m_date; }
    public String text() { return m_text; }
    public String imageUrl() { return m_imageUrl; }
}
