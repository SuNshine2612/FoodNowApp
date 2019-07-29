package vn.edu.csc.foodnowapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class RestaurantAdapter extends RecyclerView.Adapter<RestaurantAdapter.RestaurantViewHolder> {

    private Context context;
    ArrayList<Restaurant> restaurants;
    int layout;

    public RestaurantAdapter(Context context, ArrayList<Restaurant> restaurants, int layout) {
        this.context = context;
        this.restaurants = restaurants;
        this.layout = layout;
    }

    @NonNull
    @Override
    public RestaurantViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(this.context);
        View convertView = layoutInflater.inflate(this.layout, viewGroup, false);
        return new RestaurantViewHolder(convertView);
    }

    @Override
    public void onBindViewHolder(@NonNull RestaurantViewHolder restaurantViewHolder, int i) {
        Restaurant restaurant = restaurants.get(i);
        restaurantViewHolder.img_logo.setImageResource(restaurant.getImgLogo());
        restaurantViewHolder.tv_address_restaurant.setText(restaurant.getAddressRestaurant());
        restaurantViewHolder.tv_name_restaurant.setText(restaurant.getNameRestaurant());
    }

    @Override
    public int getItemCount() {
        return restaurants.size();
    }

    class RestaurantViewHolder extends RecyclerView.ViewHolder{
        ImageView img_logo;
        TextView tv_name_restaurant;
        TextView tv_address_restaurant;

        public RestaurantViewHolder(@NonNull View itemView) {
            super(itemView);
            this.img_logo = itemView.findViewById(R.id.img_logo);
            this.tv_name_restaurant = itemView.findViewById(R.id.name_restaurant);
            this.tv_address_restaurant = itemView.findViewById(R.id.address_restaurant);
        }
    }
}
