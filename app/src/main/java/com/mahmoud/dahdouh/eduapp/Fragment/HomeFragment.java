package com.mahmoud.dahdouh.eduapp.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.mahmoud.dahdouh.eduapp.Adapter.ActivityAdapter;
import com.mahmoud.dahdouh.eduapp.Adapter.SchoolsViewpagerAdapter;
import com.mahmoud.dahdouh.eduapp.Model.Activity;
import com.mahmoud.dahdouh.eduapp.Model.School;
import com.mahmoud.dahdouh.eduapp.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link //HomeFragment.OnFragmentIfnteractionListener} interface
 * to handle interaction events.
 */
public class HomeFragment extends Fragment {
    //
//    private OnFragmentInteractionListener mListener;

    private View layout;
    private RecyclerView activityRecycler;
    private ArrayList<School> schools;
    private ArrayList<Activity> activities;
    private ActivityAdapter activityAdapter;
    private ViewPager2 viewPager2;
    private SchoolsViewpagerAdapter adapter;

    DatabaseReference dataRef;
    FirebaseAuth auth;
    private ImageView school_img;
    private TextView tv_school_name, tv_school_location;

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        layout = inflater.inflate(R.layout.fragment_home, container, false);

        tv_school_name = layout.findViewById(R.id.school_name_main);
        tv_school_location = layout.findViewById(R.id.school_location_main);
        school_img = layout.findViewById(R.id.school_img_main);

        //setSchoolsViewPager();
        setActivitiesRecycler();
        setData();

        // Inflate the layout for this fragment
        return layout;


    }

    private void setData() {

        auth = FirebaseAuth.getInstance();
        // get data
        final String currentUserId = auth.getCurrentUser().getUid();
        dataRef = FirebaseDatabase.getInstance()
                .getReference().child("application/users/" + currentUserId);
        // Attach a listener to read the data at our posts reference
        dataRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                String school_name = dataSnapshot.child("school_name").getValue(String.class);
                tv_school_name.setText(school_name);

                String school_location = dataSnapshot.child("school_location").getValue(String.class);
                tv_school_location.setText(school_location);

                String school_img_url = dataSnapshot.child("school").getValue(String.class);
                Picasso.get().load(school_img_url)
                        .placeholder(R.drawable.bg_school_item)
                        .into(school_img);

                //System.out.println("email : "+email);
                System.out.println(currentUserId);
                System.out.println(dataRef.toString());
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                System.out.println("The read failed: " + databaseError.getCode());
            }
        });
    }

    private void setActivitiesRecycler() {
        activityRecycler = layout.findViewById(R.id.activities_recyclerview);

        activities = new ArrayList<>();
        activities.add(new Activity("Graduation Party", "First School", R.drawable.ic_graduation));
        activities.add(new Activity("New books", "High School", R.drawable.ic_curriculum));
        activities.add(new Activity("New Teacher", "First School", R.drawable.ic_teacher));
        activities.add(new Activity("New books", "High School", R.drawable.ic_curriculum));
        activities.add(new Activity("New Teacher", "First School", R.drawable.ic_teacher));
        activities.add(new Activity("Graduation Party", "First School", R.drawable.ic_graduation));

        activityAdapter = new ActivityAdapter(activities);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());

        activityRecycler.setAdapter(activityAdapter);
        activityRecycler.setLayoutManager(layoutManager);

    }

    private void setSchoolsViewPager() {
        viewPager2 = layout.findViewById(R.id.schools_viewpager_2);
        schools = new ArrayList<>();
        schools.add(new School(R.drawable.bg_school_item_2, "First School", "Usa"));
        schools.add(new School(R.drawable.bg_school_item, "High School", "Canada"));
        schools.add(new School(R.drawable.bg_school_item_3, "Al-Quds School", "Palestine"));


        adapter = new SchoolsViewpagerAdapter(schools);


        viewPager2.setAdapter(adapter);
    }


//    // TODO: Rename method, update argument and hook method into UI event
//    public void onButtonPressed(Uri uri) {
//        if (mListener != null) {
//            mListener.onFragmentInteraction(uri);
//        }
//    }

//    @Override
//    public void onAttach(Context context) {
//        super.onAttach(context);
//        if (context instanceof OnFragmentInteractionListener) {
//            mListener = (OnFragmentInteractionListener) context;
//        } else {
//            throw new RuntimeException(context.toString()
//                    + " must implement OnFragmentInteractionListener");
//        }
//    }
//
//    @Override
//    public void onDetach() {
//        super.onDetach();
//        mListener = null;
//    }

//    /**
//     * This interface must be implemented by activities that contain this
//     * fragment to allow an interaction in this fragment to be communicated
//     * to the activity and potentially other fragments contained in that
//     * activity.
//     * <p>
//     * See the Android Training lesson <a href=
//     * "http://developer.android.com/training/basics/fragments/communicating.html"
//     * >Communicating with Other Fragments</a> for more information.
//     */
//    public interface OnFragmentInteractionListener {
//        // TODO: Update argument type and name
//        void onFragmentInteraction(Uri uri);
//    }


}
