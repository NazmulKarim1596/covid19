package com.example.c_19;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class PatientsList extends ArrayAdapter<Patients> {

    private Activity context;
    private List<Patients> patientsList;

    public PatientsList(Activity context, List<Patients> patientsList){
        super(context, R.layout.list_layout, patientsList);
        this.context = context;
        this.patientsList = patientsList;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();

        View listViewItem = inflater.inflate(R.layout.list_layout,null,true);

        TextView textViewName =  listViewItem.findViewById(R.id.textViewName);
        TextView textViewRank =  listViewItem.findViewById(R.id.textViewRank);
        TextView textViewUnit =  listViewItem.findViewById(R.id.textViewUnit);
        TextView textViewStart =  listViewItem.findViewById(R.id.textViewStart);
        TextView textViewEnd = listViewItem.findViewById(R.id.textViewEnd);

        Patients patients = patientsList.get(position);

        textViewName.setText(patients.getName());
        textViewRank.setText(patients.getRank());
        textViewUnit.setText(patients.getUnit());
        textViewStart.setText(patients.getStart());
        textViewEnd.setText(patients.getEnd());

        return listViewItem;

    }
}
