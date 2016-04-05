package nz.co.couchkumaras.shotmate;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by Finn on 2/04/2016.
 */
public class ProjectActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        init();
    }

    public void init(){
        setContentView(R.layout.activity_project);
        Bundle data = getIntent().getExtras();
        ProjectInfo pi = (ProjectInfo) data.getParcelable("projectInfo");

        TextView t = (TextView) findViewById(R.id.project_name_scene);
        t.setText(pi.name);
    }



}
