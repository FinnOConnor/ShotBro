package nz.co.couchkumaras.shotmate;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Finn on 01/04/2016.
 */
public class ProjectInfo implements Parcelable {

    protected String name;
    protected String director;
    protected String date;

    protected static final String NAME_PREFIX = "Name_";
    protected static final String DIRECTOR_PREFIX = "Director_";
    protected static final String DATE_PREFIX = "Date_";

    public ProjectInfo(String name, String director, String date){
        this.name = name;
        this.director = director;
        this.date = date;
    }


    public ProjectInfo(Parcel in){
        String[] data = new String[3];

        in.readStringArray(data);
        this.name = data[0];
        this.director = data[1];
        this.date = data[2];
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeStringArray(new String[] {this.name, this.director, this.date});
    }

    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {
        public ProjectInfo createFromParcel(Parcel in) {
            return new ProjectInfo(in);
        }

        public ProjectInfo[] newArray(int size) {
            return new ProjectInfo[size];
        }
    };


}
