package nz.co.couchkumaras.shotmate;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

/**
 * Created by Finn on 31/03/2016.
 */
public class CreateProject extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_project);
//        Intent activityThatCalled = getIntent();
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
