package org.appspot.mid_term.adapter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import org.appspot.mid_term.R;
import org.appspot.mid_term.dto.dtoDonor;

import java.util.ArrayList;

public class ListAdapter extends ArrayAdapter<dtoDonor> {

    private ArrayList<dtoDonor> dataSet;
    Context mContext;

    // View lookup cache
    private static class ViewHolder {
        TextView textView_DonorDetail;
    }

    public ListAdapter(ArrayList<dtoDonor> data, Context context) {
        super(context, R.layout.donor_item, data);
        this.dataSet = data;
        this.mContext = context;

    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        dtoDonor dataModel = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        ViewHolder viewHolder; // view lookup cache stored in tag

        final View result;

        if (convertView == null) {

            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.donor_item, parent, false);
            viewHolder.textView_DonorDetail = convertView.findViewById(R.id.textView_DonorDetail);

            result = convertView;

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
            result = convertView;
        }

        viewHolder.textView_DonorDetail.setText(dataModel.getName() + " - " + dataModel.getBloodGroup());
        return convertView;
    }

    public void updateList(ArrayList<dtoDonor> donors) {
        dataSet = donors;
        notifyDataSetChanged();
    }
}
