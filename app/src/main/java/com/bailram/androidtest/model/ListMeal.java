
package com.bailram.androidtest.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ListMeal implements Parcelable
{

    @SerializedName("strMeal")
    @Expose
    private String strMeal;
    @SerializedName("strMealThumb")
    @Expose
    private String strMealThumb;
    @SerializedName("idMeal")
    @Expose
    private String idMeal;
    public final static Parcelable.Creator<ListMeal> CREATOR = new Creator<ListMeal>() {


        @SuppressWarnings({
            "unchecked"
        })
        public ListMeal createFromParcel(Parcel in) {
            return new ListMeal(in);
        }

        public ListMeal[] newArray(int size) {
            return (new ListMeal[size]);
        }

    }
    ;

    protected ListMeal(Parcel in) {
        this.strMeal = ((String) in.readValue((String.class.getClassLoader())));
        this.strMealThumb = ((String) in.readValue((String.class.getClassLoader())));
        this.idMeal = ((String) in.readValue((String.class.getClassLoader())));
    }

    public ListMeal() {
    }

    public String getStrMeal() {
        return strMeal;
    }

    public void setStrMeal(String strMeal) {
        this.strMeal = strMeal;
    }

    public String getStrMealThumb() {
        return strMealThumb;
    }

    public void setStrMealThumb(String strMealThumb) {
        this.strMealThumb = strMealThumb;
    }

    public String getIdMeal() {
        return idMeal;
    }

    public void setIdMeal(String idMeal) {
        this.idMeal = idMeal;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(strMeal);
        dest.writeValue(strMealThumb);
        dest.writeValue(idMeal);
    }

    public int describeContents() {
        return  0;
    }

}
