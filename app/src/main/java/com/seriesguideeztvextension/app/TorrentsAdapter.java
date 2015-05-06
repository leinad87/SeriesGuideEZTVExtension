package com.seriesguideeztvextension.app;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by Leinad on 05/05/2015.
 */
public class TorrentsAdapter extends BaseAdapter {

    private List<String[]> mDataset;
    private Context mContext;

    public TorrentsAdapter(Context context, List<String[]> data) {
        mContext = context;
        mDataset = data;
    }

    @Override
    public int getCount() {
        return mDataset.size();
    }

    @Override
    public Object getItem(int i) {
        return mDataset.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        //TODO: use viewholder
        View v = null;
        if (view == null) {
            v = LayoutInflater.from(mContext).inflate(R.layout.listitem, null, false);
        } else {
            v = view;
        }

        ((TextView) v.findViewById(R.id.title)).setText(mDataset.get(i)[0]);

        final int ii = i;
        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW).setData(Uri.parse(mDataset.get(ii)[1]));
                mContext.startActivity(intent);
                Toast.makeText(mContext, "Enviando " + mDataset.get(ii)[1], Toast.LENGTH_LONG).show();
            }
        });
        return v;
    }
}
