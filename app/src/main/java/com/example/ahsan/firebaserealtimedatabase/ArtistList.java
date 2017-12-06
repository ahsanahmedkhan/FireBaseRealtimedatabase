package com.example.ahsan.firebaserealtimedatabase;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Ahsan on 3/19/2017.
 */

public class ArtistList extends ArrayAdapter<Artist> {

    private Activity context;
    private List<Artist> artistList;

    public ArtistList(Activity context, List<Artist> artistList){
        super(context,R.layout.list_layout, artistList);
        this.context = context;
        this.artistList = artistList;
    }
    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();

        View listViewItem = inflater.inflate(R.layout.list_layout,null,true);
        TextView txtName = (TextView) listViewItem.findViewById(R.id.txtname);
        TextView txtGenre = (TextView) listViewItem.findViewById(R.id.txtGenre);

        Artist artist = artistList.get(position);
        txtName.setText(artist.getArtistName());
        txtGenre.setText(artist.getArtistGenre());

        return listViewItem;
    }
}
