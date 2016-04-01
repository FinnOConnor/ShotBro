package nz.co.couchkumaras.shotmate;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.TextView;


/**
 * Created by Finn on 31/03/2016.
 */

public class ProjectCard extends CardView {

    private TextView projectName;
    private TextView projectDirector;
    private TextView projectDate;


    public ProjectCard(Context context) {
        super(context);
        init();
    }

    public ProjectCard(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ProjectCard(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    public void init(){
        LayoutInflater inflater = LayoutInflater.from(getContext());
        inflater.inflate(R.layout.project_card, this);

        this.projectName = (TextView) findViewById(R.id.project_name);
        this.projectName = (TextView) findViewById(R.id.project_director);
        this.projectName = (TextView) findViewById(R.id.project_date);

    }




}
