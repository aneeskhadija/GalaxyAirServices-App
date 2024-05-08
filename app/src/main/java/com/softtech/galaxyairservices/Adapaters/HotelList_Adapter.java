package com.softtech.galaxyairservices.Adapaters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.softtech.galaxyairservices.Models.GetterSetter;
import com.softtech.galaxyairservices.R;

import java.util.List;

public class HotelList_Adapter extends RecyclerView.Adapter<HotelList_Adapter.HotelListViewHolder> {

    private Context mContext;
    private List<GetterSetter> listHotel;
    String strImage;

   // List<GetterSetter> listHotel = new ArrayList<>();

    public HotelList_Adapter(Context mContext, List<GetterSetter> listHotel) {
        this.mContext = mContext;
        this.listHotel = listHotel;
    }

    @NonNull
    @Override
    public HotelListViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.hotel_list_view, viewGroup, false);

        return new HotelListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HotelListViewHolder hotelListViewHolder, int position) {

        GetterSetter hotel = listHotel.get(position);

        hotelListViewHolder.txt_HotelName.setText(hotel.getHotel_name());
        hotelListViewHolder.txt_CityName.setText(hotel.getCity_name());
        hotelListViewHolder.txt_Kelometers.setText(hotel.getKilometers());
       // hotelListViewHolder.txt_Kelometers.setText(hotel.getHotel_pic());

        strImage = hotel.getHotel_pic();
        String string_image = "http://galaxyairservices.com/public/uploads/"+strImage;

        if ( strImage == null) {
            Glide.with(mContext).load(R.mipmap.ic_launcher_round).into(hotelListViewHolder.imageView);
            Log.d("Adapter Data Is Null", "");
        } else {

            Glide.with(mContext)
                    .load(string_image)
                    //.load("http://via.placeholder.com/300.png")
                    .into(hotelListViewHolder.imageView);
            Log.d("Showing Images", hotel.getHotel_pic());
        }



    }

    @Override
    public int getItemCount() {
        return listHotel.size();
    }

    class HotelListViewHolder extends RecyclerView.ViewHolder{

        ImageView imageView;
        TextView txt_HotelName, txt_CityName, txt_Kelometers;

        public HotelListViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.id_image_hotel);
            txt_HotelName = itemView.findViewById(R.id.id_hotel_name);
            txt_CityName = itemView.findViewById(R.id.id_city_name);
            txt_Kelometers = itemView.findViewById(R.id.id_kelometers);
        }
    }

}
