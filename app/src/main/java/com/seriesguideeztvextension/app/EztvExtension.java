package com.seriesguideeztvextension.app;

import android.content.Intent;
import com.battlelancer.seriesguide.api.Action;
import com.battlelancer.seriesguide.api.Episode;
import com.battlelancer.seriesguide.api.SeriesGuideExtension;

/**
 * Created by Leinad on 05/05/2015.
 */
public class EztvExtension extends SeriesGuideExtension {

    public EztvExtension() {
        super("EZTVExtension");
    }

    /**
     * Called when a new episode is displayed and the extension should publish the action it wants
     * to display using {@link #publishAction(Action)}.
     *
     * @param episodeIdentifier The episode identifier the extension should submit with the action
     *                          it wants to publish.
     * @param episode
     */
    @Override
    protected void onRequest(int episodeIdentifier, Episode episode) {

        String query = String.format("%s s%02de%02d", episode.getShowTitle(), episode.getSeason(), episode.getNumber());

        Intent intent = ActivityDownloader.getIntent(this, query);

        publishAction(new Action.Builder(this.getString(R.string.extension_title), episodeIdentifier)
                .viewIntent(intent)
                .build());


    }
}
