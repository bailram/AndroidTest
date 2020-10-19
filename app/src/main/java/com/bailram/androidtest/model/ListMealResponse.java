
package com.bailram.androidtest.model;

import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ListMealResponse implements Parcelable
{

    @SerializedName("meals")
    @Expose
    private List<ListMeal> listMeals = null;
    public final static Parcelable.Creator<ListMealResponse> CREATOR = new Creator<ListMealResponse>() {


        @SuppressWarnings({
            "unchecked"
        })
        public ListMealResponse createFromParcel(Parcel in) {
            return new ListMealResponse(in);
        }

        public ListMealResponse[] newArray(int size) {
            return (new ListMealResponse[size]);
        }

    }
    ;

    protected ListMealResponse(Parcel in) {
        in.readList(this.listMeals, (ListMeal.class.getClassLoader()));
    }

    public ListMealResponse() {
    }

    public List<ListMeal> getListMeals() {
        return listMeals;
    }

    public void setListMeals(List<ListMeal> listMeals) {
        this.listMeals = listMeals;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeList(listMeals);
    }

    public int describeContents() {
        return  0;
    }

}
