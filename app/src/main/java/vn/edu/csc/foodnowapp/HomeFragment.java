package vn.edu.csc.foodnowapp;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


public class HomeFragment extends Fragment {

    RecyclerView rv_list_restaurant;
    ArrayList<Restaurant> restaurants;
    RestaurantAdapter adapter;
    MainActivity mainActivity;



    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    public static HomeFragment newInstance(){
        return new HomeFragment();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        if(context instanceof MainActivity)
        {
            mainActivity = (MainActivity) context;
        }
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        rv_list_restaurant = view.findViewById(R.id.rv_list_restaurant);
        restaurants = new ArrayList<>();
        restaurants.add(new Restaurant(R.drawable.logo_circle_k, "Circle K","40 Hung Vuong"));
        restaurants.add(new Restaurant(R.drawable.logo_highland_cf, "Highland Coffee","30 Nguyen Van Cu"));
        restaurants.add(new Restaurant(R.drawable.logo_mini_stop, "MiniStop","70 Ly Thai To"));
        restaurants.add(new Restaurant(R.drawable.logo_7eleven, "7 Eleven","82 Nguyen Thi Minh Khai"));

        adapter = new RestaurantAdapter(getContext(),restaurants,R.layout.layout_cell);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        rv_list_restaurant.setLayoutManager(layoutManager);
        rv_list_restaurant.setAdapter(adapter);
    }
}
