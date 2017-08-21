
package com.company;


import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {


    public static String getdate()
    {

        Date dnow = new Date();
        SimpleDateFormat ft = new SimpleDateFormat("E");
        return ft.format(dnow);
    }

    public static void main(String[] args) throws IOException {
        String[][] tablica = new String[9][7];
        Connection connect = Jsoup.connect("http://www.zsb.iq.pl/plan/plany/o1.html");
        Document document = connect.get();



        //Nagłówek
        int i = 0;
        Elements allth = document.select("th");
        for(Element elem: allth) {
            tablica[0][i] = elem.text();
            i++;
          //  System.out.println(elem.text());
        }

        // zajecia
       int j = 2;
        i = 1;
        Elements alltd = document.select("td.l");
        for(Element elem: alltd) {
            if(j==7){
                j=2;
                i++;
            }

            tablica[i][j] = elem.text();
            j++;
             //System.out.println(elem.text());
        }

        //numer
        i=1;
        Elements allnr = document.select(".nr");
        for(Element elem: allnr) {
            tablica[i][0] = elem.text();
            i++;
            //System.out.println(elem.text());
        }

        //godziny
        i=1;
        Elements allgod = document.select(".g");
        for(Element elem: allgod) {
            tablica[i][1] = elem.text();
            i++;
            //System.out.println(elem.text());
        }

       String day = getdate();


        switch (day)
        {
            case "Pn":  i = 2;
                break;
            case "Wt":  i = 3;
                break;
            case "Sr":  i = 4;
                break;
            case "Cw":  i = 5;
                break;
            case "Pt":  i = 6;
                break;
            default:System.out.println( "Invalid day");
                break;
        }




        for(int k = 0; k < 9; k++){
            System.out.println(tablica[k][i]);
        }

    }
}
