package com.example.user.secondtask.ui.info;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.example.user.secondtask.R;
import com.example.user.secondtask.adapters.GlideApp;
import com.example.user.secondtask.entity.Technology;

/**
 * A simple {@link Fragment} subclass.
 */
public class TechInfoFragment extends Fragment {

    View fragmentView;
    public TechInfoFragment() { }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        fragmentView = inflater.inflate(R.layout.fragment_tech_info, container, false);

        TextView description = fragmentView.findViewById(R.id.tech_description);
        ImageView pic= fragmentView.findViewById(R.id.tech_image);
        Technology technology = (Technology) getArguments().getSerializable("data");
        if (technology.getHelptext() != null) description.setText(technology.getHelptext());

        GlideApp.with(getContext())
                .load("https://raw.githubusercontent.com/wesleywerner/ancient-tech/02decf875616dd9692b31658d92e64a20d99f816/src/images/tech/" + technology.getGraphic())
                .override(300, 300)
                .transform(new CenterCrop())
                .error(R.mipmap.ic_launcher)
                .into(pic);

        return fragmentView;
    }

}
