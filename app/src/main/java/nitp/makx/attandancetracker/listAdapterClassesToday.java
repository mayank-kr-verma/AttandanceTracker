package nitp.makx.attandancetracker;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;

/**
 * Created by makx on 23/10/17.
 */

public class listAdapterClassesToday extends ArrayAdapter<JSONObject>{

    int vg;

    ArrayList<JSONObject> list;

    Context context;

    public listAdapterClassesToday(Context context, int vg, int id, ArrayList<JSONObject> list){

        super(context,vg, id,list);

        this.context=context;

        this.vg=vg;

        this.list=list;

    }

    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View itemView = inflater.inflate(vg, parent, false);

        TextView time=itemView.findViewById(R.id.time);

        TextView subjectCode=itemView.findViewById(R.id.subjectCode);

        TextView subjectName=itemView.findViewById(R.id.subjectName);

        try {

            time.setText(list.get(position).getString("Time"));

            subjectCode.setText(list.get(position).getString("Subject Code"));

            subjectName.setText(list.get(position).getString("Subject"));



        } catch (JSONException e) {

            e.printStackTrace();

        }



        return itemView;

    }

}

