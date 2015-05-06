package com.seriesguideeztvextension.app;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.ListView;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Leinad on 05/05/2015.
 */
public class DownloaderTask extends AsyncTask<String, List<String[]>, List<String[]>> {

    private ListView listView;
    private Context mContext;
    public DownloaderTask(Context context, ListView viewById) {
        mContext = context;
        listView = viewById;
    }

    @Override
    protected List<String[]> doInBackground(String... strings) {
        String query = strings[0];

        List<String[]> data = new ArrayList<String[]>();

        try {
            Document doc = Jsoup.connect("https://eztv.it/search/").data("SearchString1", query).post();

            Elements rows = doc.select("tr.forum_header_border");

            for(org.jsoup.nodes.Element row : rows ){
                String text = row.select("td").get(1).select("a").text();
                String magnet = row.select("td").get(2).select("a").first().attr("href");

                data.add(new String[]{text,magnet});
            }


        } catch (IOException e) {
            e.printStackTrace();
        }


        return data;
    }

    @Override
    protected void onPostExecute(List<String[]> data){
        listView.setAdapter(new TorrentsAdapter(mContext, data));
    }
}
