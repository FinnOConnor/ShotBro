package nz.co.couchkumaras.shotmate;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Finn on 01/04/2016.
 */
public class ProjectAdapter extends  RecyclerView.Adapter<ProjectAdapter.ProjectViewHolder> {

    private ArrayList<ProjectInfo> projects;

    public ProjectAdapter(ArrayList<ProjectInfo> projects) {
        this.projects = projects;
    }

    @Override
    public int getItemCount() {
        return projects.size();
    }

    @Override
    public void onBindViewHolder(ProjectViewHolder projectViewHolder, int i) {
        ProjectInfo pi  = projects.get(i);
        projectViewHolder.projectViewName.setText(pi.name);
        projectViewHolder.projectViewDirector.setText(pi.director);
        projectViewHolder.projectViewDate.setText(pi.date);
    }

    @Override
    public ProjectViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.
                from(viewGroup.getContext()).
                inflate(R.layout.project_card, viewGroup, false);

        return new ProjectViewHolder(itemView);
    }



    public class ProjectViewHolder extends RecyclerView.ViewHolder {

        private LayoutInflater inflater;

        private TextView projectViewName;
        private TextView projectViewDirector;
        private TextView projectViewDate;


        public ProjectViewHolder(View v) {
            super(v);

            projectViewName = (TextView) v.findViewById(R.id.project_name);
            projectViewDirector = (TextView) v.findViewById(R.id.project_director);
            projectViewDate = (TextView) v.findViewById(R.id.project_date);

        }


    }

}
