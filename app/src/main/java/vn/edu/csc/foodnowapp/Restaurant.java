package vn.edu.csc.foodnowapp;

import android.widget.ImageView;
import android.widget.TextView;

import java.io.Serializable;

public class Restaurant implements Serializable {

    int imgLogo;
    String nameRestaurant;
    String addressRestaurant;

    public Restaurant(int imgLogo, String nameRestaurant, String addressRestaurant) {
        this.imgLogo = imgLogo;
        this.nameRestaurant = nameRestaurant;
        this.addressRestaurant = addressRestaurant;
    }

    public int getImgLogo() {
        return imgLogo;
    }

    public String getNameRestaurant() {
        return nameRestaurant;
    }

    public String getAddressRestaurant() {
        return addressRestaurant;
    }
}
