package com.example.user.secondtask.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.example.user.secondtask.R;
import com.example.user.secondtask.entity.Technology;
import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.RecyclerViewHolder> {

    ArrayList<Technology> technologies;
    ItemClickListener listener;
    Context context;
    CountScrollListener countScrollListener;
    int position;

    public RecyclerAdapter(ArrayList<Technology> technologies, ItemClickListener listener, Context context, CountScrollListener countScrollListener) {
        this.technologies = technologies;
        this.listener = listener;
        this.context = context;
        this.countScrollListener = countScrollListener;
        this.position = position;
    }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View itemView = inflater.inflate(R.layout.technology_layout, viewGroup, false);
        return new RecyclerViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder myViewHolder, int i) {
        myViewHolder.name.setText(technologies.get(i).getName());
        myViewHolder.itemView.setOnClickListener(v -> {
            listener.onItemClick(i);
        });

        GlideApp.with(context)
                .load("https://raw.githubusercontent.com/wesleywerner/ancient-tech/02decf875616dd9692b31658d92e64a20d99f816/src/images/tech/" + technologies.get(i).getGraphic())
                .override(300, 300)
                .transform(new CenterCrop())
                .error(R.mipmap.ic_launcher)
                .into(myViewHolder.pic);
        countScrollListener.count(i);

    }

    @Override
    public int getItemCount() {
        return technologies.size();
    }

    class RecyclerViewHolder extends RecyclerView.ViewHolder{

        ImageView pic;
        TextView name;

        public RecyclerViewHolder(@NonNull View itemView) {
            super(itemView);
            pic = itemView.findViewById(R.id.tech_image);
            name = itemView.findViewById(R.id.tech_name);
        }
    }

}
