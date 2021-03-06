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
    private static ProjectClickListener pcl;

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

    public void addItem(ProjectInfo pi, int index) {
        projects.add(index, pi);
        notifyItemInserted(index);
    }

    public void deleteItem(int index) {
        projects.remove(index);
        notifyItemRemoved(index);
    }

    @Override
    public ProjectViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.
                from(viewGroup.getContext()).
                inflate(R.layout.project_card, viewGroup, false);

        return new ProjectViewHolder(itemView);
    }

    public void setOnItemClickListener(ProjectClickListener pcl) {
        this.pcl = pcl;
    }

    public class ProjectViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {


        private TextView projectViewName;
        private TextView projectViewDirector;
        private TextView projectViewDate;


        public ProjectViewHolder(View v) {
            super(v);

            projectViewName = (TextView) v.findViewById(R.id.project_name);
            projectViewDirector = (TextView) v.findViewById(R.id.project_director);
            projectViewDate = (TextView) v.findViewById(R.id.project_date);

            v.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            pcl.onItemClick(getAdapterPosition(), v);
        }
    }

    public interface ProjectClickListener {
        public void onItemClick(int position, View v);
    }

    // Search Filter

    public void setFilter(ArrayList<ProjectInfo> p) {
        projects = new ArrayList<>();
        projects.addAll(p);
        notifyDataSetChanged();
    }

}
