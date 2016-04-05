package nz.co.couchkumaras.shotmate;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.ArrayList;
import java.util.List;

public class ProjectsActivity extends AppCompatActivity implements SearchView.OnQueryTextListener {

    private GoogleApiClient client;
    private ArrayList<ProjectInfo> projects = new ArrayList<ProjectInfo>();
    private RecyclerView projectList;
    private ProjectAdapter pa;
    private LinearLayoutManager llm;
    private ProjectInfo pi;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_projects);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();

        actionBar.setDisplayHomeAsUpEnabled(true);

        // Set up FAB
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Open CreateProjectActivity
                createProject();
            }
        });



    }

    public void createProject(){
        Intent createProjectIntent = new Intent(this, CreateProjectActivity.class);
        final int result = 1;
        startActivityForResult(createProjectIntent, result);
    }

    @Override
    protected void onResume(){
        super.onResume();

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch(requestCode){
            case 1:
                String projectNameSentBack = data.getStringExtra("projectName");
                String projectDirectorSentBack = data.getStringExtra("projectDirector");
                String projectDateSentBack = data.getStringExtra("projectDate");

                projectList = (RecyclerView) findViewById(R.id.project_list);
                llm = new LinearLayoutManager(this);
                llm.setOrientation(LinearLayoutManager.VERTICAL);
                projectList.setLayoutManager(llm);

                pi = new ProjectInfo(projectNameSentBack, projectDirectorSentBack, projectDateSentBack);

                projects.add(pi);

                pa = new ProjectAdapter(projects);
                projectList.setAdapter(pa);

                pa.setOnItemClickListener(new ProjectAdapter
                        .ProjectClickListener() {
                    @Override
                    public void onItemClick(int position, View v) {
                        //open Project Activity!
                        Intent openProjectIntent = new Intent(getApplicationContext(), ProjectActivity.class);
                        openProjectIntent.putExtra("projectInfo", pi);
                        startActivity(openProjectIntent);
                    }
                });

                break;
        }

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
                inflater.inflate(R.menu.menu_main, menu);

        final MenuItem item = menu.findItem(R.id.action_search);
        final SearchView searchView = (SearchView) MenuItemCompat.getActionView(item);
        searchView.setOnQueryTextListener(this);

        MenuItemCompat.setOnActionExpandListener(item,
                new MenuItemCompat.OnActionExpandListener() {
                    @Override
                    public boolean onMenuItemActionCollapse(MenuItem item) {
                        // Do something when collapsed
                        pa.setFilter(projects);
                        return true; // Return true to collapse action view
                    }

                    @Override
                    public boolean onMenuItemActionExpand(MenuItem item) {
                        // Do something when expanded
                        return true; // Return true to expand action view
                    }
                });
        return true;
    }


    @Override
    public boolean onQueryTextChange(String newText) {
        final ArrayList<ProjectInfo> filteredProjectsList = filter(projects, newText);
        pa.setFilter(filteredProjectsList);
        return true;
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    private ArrayList<ProjectInfo> filter(List<ProjectInfo> projects, String query) {
        query = query.toLowerCase();

        final ArrayList<ProjectInfo> filteredProjectsList = new ArrayList<>();
        for (ProjectInfo project : projects) {
            final String text = project.name.toLowerCase();
            if (text.contains(query)) {
                filteredProjectsList.add(project);
            }
        }
        return filteredProjectsList;
    }
}