package nz.co.couchkumaras.shotmate;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;

/**
 * Created by Finn on 31/03/2016.
 */
public class CreateProjectActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_project);
        Toolbar tb = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(tb);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        tb.setTitle("Create Project");
    }

    public void submitProject(View view){
        EditText projectNameEditText = (EditText) findViewById(R.id.project_name_edit);
        EditText projectDirectorEditText = (EditText) findViewById(R.id.project_director_edit);
        EditText projectDateEditText = (EditText) findViewById(R.id.project_date_edit);

        String projectName = String.valueOf(projectNameEditText.getText());
        String projectDirector = String.valueOf(projectDirectorEditText.getText());
        String projectDate = String.valueOf(projectDateEditText.getText());

        Intent goingBack = new Intent();

        goingBack.putExtra("projectName", projectName);
        goingBack.putExtra("projectDirector", projectDirector);
        goingBack.putExtra("projectDate", projectDate);

        setResult(RESULT_OK, goingBack);

        finish();

    }

}
