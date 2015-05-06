package com.seriesguideeztvextension.app;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.ListView;

/**
 * Created by Leinad on 05/05/2015.
 */
public class ActivityDownloader extends ActionBarActivity {

    public static Intent getIntent(Context context, String query) {
        Intent intent = new Intent(context, ActivityDownloader.class);

        intent.putExtra("query", query);

        return intent;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list);

        DownloaderTask task = new DownloaderTask(this, (ListView) findViewById(R.id.listview));
        task.execute(getIntent().getExtras().getString("query"));
    }
}
