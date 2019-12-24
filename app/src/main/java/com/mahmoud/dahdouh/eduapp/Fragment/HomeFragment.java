package com.mahmoud.dahdouh.eduapp.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import com.mahmoud.dahdouh.eduapp.Adapter.ActivityAdapter;
import com.mahmoud.dahdouh.eduapp.Adapter.SchoolsAdapter;
import com.mahmoud.dahdouh.eduapp.Adapter.Viewpager2_Adapter;
import com.mahmoud.dahdouh.eduapp.Model.Activity;
import com.mahmoud.dahdouh.eduapp.Model.School;
import com.mahmoud.dahdouh.eduapp.R;

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
    private RecyclerView schoolsRecycler, activityRecycler;
    private ArrayList<School> schools;
    private ArrayList<Activity> activities;
    private SchoolsAdapter schoolsAdapter;
    private ActivityAdapter activityAdapter;
    private ViewPager2 viewPager2;
    private ArrayList<String> arrayList = new ArrayList<>();
    private Viewpager2_Adapter adapter;
    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        layout = inflater.inflate(R.layout.fragment_home, container, false);
        setSchoolsViewPager();
        //setSchoolsRecycler();
        setActivitiesRecycler();

        // Inflate the layout for this fragment
        return layout;


    }
/*
    private void setViewPager2() {
        viewPager2 = layout.findViewById(R.id.schools_recyclerview);
        schools = new ArrayList<>();
        schools.add(new School(R.drawable.bg_school_item_2, "First School", "Usa"));
        schools.add(new School(R.drawable.bg_school_item, "High School", "Canada"));
        schools.add(new School(R.drawable.bg_school_item_3, "Al-Quds School", "Palestine"));

        schoolsAdapter = new SchoolsAdapter(schools);
        viewPager2.setAdapter(schoolsAdapter);



    }
*/
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


    private void setSchoolsRecycler() {
        //schoolsRecycler = layout.findViewById(R.id.schools_recyclerview);
        schools = new ArrayList<>();
        schools.add(new School(R.drawable.bg_school_item_2, "First School", "Usa"));
        schools.add(new School(R.drawable.bg_school_item, "High School", "Canada"));
        schools.add(new School(R.drawable.bg_school_item_3, "Al-Quds School", "Palestine"));

        schoolsAdapter = new SchoolsAdapter(schools);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false);

        schoolsRecycler.setAdapter(schoolsAdapter);
        schoolsRecycler.setLayoutManager(layoutManager);
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
        arrayList.add("Item 1");
        arrayList.add("Item 2");
        arrayList.add("Item 3");
        arrayList.add("Item 4");
        arrayList.add("Item 5");
        adapter = new Viewpager2_Adapter(getContext(), arrayList);


        viewPager2.setAdapter(adapter);
    }


}
