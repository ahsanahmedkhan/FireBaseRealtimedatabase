package com.example.ahsan.firebaserealtimedatabase;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AddTrackActivity extends AppCompatActivity {

    TextView txtArtistName;
    EditText editTrackName;
    SeekBar seekBarRating;
    Button btnaddTrack;

    ListView listViewTracks;

    DatabaseReference databaseTracks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_track);

        txtArtistName = (TextView) findViewById(R.id.textview);
        editTrackName = (EditText) findViewById(R.id.editTextName);
        seekBarRating = (SeekBar) findViewById(R.id.seekBarRating);
        btnaddTrack = (Button) findViewById(R.id.buttonAddTrack);

        listViewTracks = (ListView) findViewById(R.id.listViewTracks);

        Intent intent = getIntent();

        String id = intent.getStringExtra(MainActivity.Artist_Id);
        String name = intent.getStringExtra(MainActivity.Artist_Name);

        txtArtistName.setText(name);

        databaseTracks = FirebaseDatabase.getInstance().getReference("tracks").child(id);

        btnaddTrack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveTrack();
            }
        });


    }

    private void saveTrack(){
        String trackName = editTrackName.getText().toString().trim();
        int rating = seekBarRating.getProgress();

        if (!TextUtils.isEmpty(trackName)){
            String id = databaseTracks.push().getKey();

            Track track = new Track(id, trackName, rating);

            databaseTracks.child(id).setValue(track);

            Toast.makeText(this, "Track saved Successfully ", Toast.LENGTH_LONG).show();

        }else {
            Toast.makeText(this, "Track Nmae Should not be Empty", Toast.LENGTH_LONG).show();
        }

    }

}
