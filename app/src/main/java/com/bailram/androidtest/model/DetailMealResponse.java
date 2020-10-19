
package com.bailram.androidtest.model;

import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DetailMealResponse implements Parcelable
{

    @SerializedName("meals")
    @Expose
    private List<DetailMeal> detailMeals = null;
    public final static Parcelable.Creator<DetailMealResponse> CREATOR = new Creator<DetailMealResponse>() {


        @SuppressWarnings({
            "unchecked"
        })
        public DetailMealResponse createFromParcel(Parcel in) {
            return new DetailMealResponse(in);
        }

        public DetailMealResponse[] newArray(int size) {
            return (new DetailMealResponse[size]);
        }

    }
    ;

    protected DetailMealResponse(Parcel in) {
        in.readList(this.detailMeals, (DetailMeal.class.getClassLoader()));
    }

    public DetailMealResponse() {
    }

    public List<DetailMeal> getDetailMeals() {
        return detailMeals;
    }

    public void setDetailMeals(List<DetailMeal> detailMeals) {
        this.detailMeals = detailMeals;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeList(detailMeals);
    }

    public int describeContents() {
        return  0;
    }

}
