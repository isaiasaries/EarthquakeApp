package com.example.isaiaslagunes.quakereport;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 * Created by Isaias Lagunes on 11/20/2017.
 */

public class EarthquakeAdapter extends ArrayAdapter<Earthquake> {

    private Context context;
    private ArrayList<Earthquake> earthquakes;

    public EarthquakeAdapter(@NonNull Context context, ArrayList<Earthquake> earthquakes) {
        super(context, R.layout.list_item, earthquakes);
        this.context = context;
        this.earthquakes = earthquakes;
    }

    //View lookup cache
    private static class ViewHolder {
        TextView txtMagnitude;
        TextView txtLocation;
        TextView txtHour;
        TextView txtUrl;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Earthquake earthquake = getItem(position);
        ViewHolder viewHolder;

        if (convertView == null) {
            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.list_item, parent, false);

            viewHolder.txtMagnitude = convertView.findViewById(R.id.tv_magnitude);
            viewHolder.txtLocation = convertView.findViewById(R.id.tv_location);
            viewHolder.txtHour = convertView.findViewById(R.id.tv_hour);
            viewHolder.txtUrl = convertView.findViewById(R.id.tv_url);

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.txtMagnitude.setText("" + earthquakes.get(position).getMagnitude());
        viewHolder.txtLocation.setText(earthquakes.get(position).getLocation());
        viewHolder.txtHour.setText(getDateString(earthquakes.get(position).getHour()));
        viewHolder.txtUrl.setText(String.valueOf(earthquakes.get(position).getUrl()));

        return convertView;
    }

    private String getDateString(long timeInMilliseconds) {
        SimpleDateFormat formatter = new SimpleDateFormat("EEE, d MMM yyyy 'at' HH:mm:ss z");
        return formatter.format(timeInMilliseconds);
    }
}
