package com.cherish.practicalpractice.paging;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.paging.PagedListAdapter;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.cherish.practicalpractice.R;

import java.util.List;
import java.util.Objects;

public class ItemAdapter extends PagedListAdapter<InspectorData, ItemAdapter.ItemViewHolder> {
    private Context context;

    protected ItemAdapter(Context context ) {
        super(DIFF_CALLBACK);
        this.context = context;
    }
//    private List<ItemList>item;

//    protected ItemAdapter(@NonNull DiffUtil.ItemCallback<ItemList> diffCallback, Context context) {
//        super(diffCallback);
//        this.context = context;
//
//    }


    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.vehicle_list_layout, parent,false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
            InspectorData itemList = getItem(position);
            if (itemList!= null){
                holder.vehicleName.setText(String.format("%s %s", itemList.getModel(), itemList.getMake()));
                holder.vinNo.setText(itemList.getMooveId());
                holder.year.setText(itemList.getYear());
            }else {
                Log.i("ERROR", "ItemList is NULL");
            }
    }

    private  static DiffUtil.ItemCallback<InspectorData> DIFF_CALLBACK  = new DiffUtil.ItemCallback<InspectorData>() {
        @Override
        public boolean areItemsTheSame(@NonNull InspectorData oldItem, @NonNull InspectorData newItem) {
            return oldItem.getId() == newItem.getId();

        }

        @SuppressLint("DiffUtilEquals")
        @Override
        public boolean areContentsTheSame(@NonNull InspectorData oldItem, @NonNull InspectorData newItem) {
             return oldItem.equals(newItem);
        }
    };





    public  class ItemViewHolder extends RecyclerView.ViewHolder{
            TextView vehicleName,vinNo, year;
        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            vehicleName = itemView.findViewById(R.id.vehicleName);
            vinNo = itemView.findViewById(R.id.vinNo);
            year = itemView.findViewById(R.id.year);

        }
    }
}
