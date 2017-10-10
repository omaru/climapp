package com.londonappbrewery.climapm;

import org.json.JSONException;
import org.json.JSONObject;
import android.util.Log;

public class WeatherDataModel {

    // TODO: Declare the member variables here
    private String temperature;
    private int condition;
    private String city;
    private String iconName;

    public WeatherDataModel(){

    }

    public static final WeatherDataModel fromJson(JSONObject jsonObject){
        WeatherDataModel model = new WeatherDataModel();
        try{
            model.setTemperature(jsonObject.getJSONObject("main").getString("temp"));
            model.setCity(jsonObject.getString("name"));
            model.setCondition(jsonObject.getJSONArray("weather").getJSONObject(0).getInt("id"));
            model.setIconName(model.updateWeatherIcon(model.getCondition()));
        }catch(JSONException e){
            Log.w("Clima","Unable to parse clima info "+e.toString());
        }
        return model;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public int getCondition() {
        return condition;
    }

    public void setCondition(int condition) {
        this.condition = condition;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getIconName() {
        return iconName;
    }

    public void setIconName(String iconName) {
        this.iconName = iconName;
    }


    private static String updateWeatherIcon(int condition) {

        if (condition >= 0 && condition < 300) {
            return "tstorm1";
        } else if (condition >= 300 && condition < 500) {
            return "light_rain";
        } else if (condition >= 500 && condition < 600) {
            return "shower3";
        } else if (condition >= 600 && condition <= 700) {
            return "snow4";
        } else if (condition >= 701 && condition <= 771) {
            return "fog";
        } else if (condition >= 772 && condition < 800) {
            return "tstorm3";
        } else if (condition == 800) {
            return "sunny";
        } else if (condition >= 801 && condition <= 804) {
            return "cloudy2";
        } else if (condition >= 900 && condition <= 902) {
            return "tstorm3";
        } else if (condition == 903) {
            return "snow5";
        } else if (condition == 904) {
            return "sunny";
        } else if (condition >= 905 && condition <= 1000) {
            return "tstorm3";
        }

        return "dunno";
    }


}
