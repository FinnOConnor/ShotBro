package nz.co.couchkumaras.shotmate;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Finn on 01/04/2016.
 */
public class CustomAdapter extends ArrayAdapter {

    private ArrayList<String> details;
    private LayoutInflater inflater;


    public CustomAdapter(Context context, ArrayList<String> attrs) {
        super(context, R.layout.project_card, attrs);
        details = attrs;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        View vi = convertView;

        if(convertView == null){
            vi = inflater.inflate(R.layout.project_card, parent, false);
        }

        TextView project_name = (TextView) vi.findViewById(R.id.project_name);
        TextView project_director = (TextView) vi.findViewById(R.id.project_director);
        TextView project_date = (TextView) vi.findViewById(R.id.project_date);

        project_name.setText(details.get(0).toString());
        project_director.setText(details.get(1).toString());
        project_date.setText(details.get(2).toString());

        return vi;
    }

}
