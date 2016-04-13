package com.example.pethoalpar.gpsexample;

import android.location.Location;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private GpsTool gpsTool;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) this.findViewById(R.id.textView);
        if(gpsTool == null){
            gpsTool = new GpsTool(this);
        }
        Location location = gpsTool.getLocation();
        Double longitude = location.getLongitude();
        Double latitude = location.getLatitude();
        Double altitude = location.getAltitude();
        StringBuilder sb = new StringBuilder();
        sb.append("Longitude:").append(longitude).append("\n");
        sb.append("Latitude:").append(latitude).append("\n");
        sb.append("Altitude:").append(altitude);
        textView.setText(sb.toString());
    }

    @Override
    protected void onPause() {
        super.onPause();
        gpsTool.stopGpsUpdate();
    }

    @Override
    protected void onResume() {
        super.onResume();
        gpsTool.startGpsUpdate();
    }
}
