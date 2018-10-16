package net.practice.mvp.model;

import net.practice.bean.WeatherinfoBean;

public class WeatherInfoModel {

    /**
     * weatherinfo : {"city":"杭州","cityid":"101210101","temp":"16","WD":"北风","WS":"2级","SD":"95%","WSE":"2","time":"10:25","isRadar":"1","Radar":"JC_RADAR_AZ9571_JB","njd":"暂无实况","qy":"1006"}
     */

    private WeatherinfoBean weatherinfo;

    public WeatherinfoBean getWeatherinfo() {
        return weatherinfo;
    }

    public void setWeatherinfo(WeatherinfoBean weatherinfo) {
        this.weatherinfo = weatherinfo;
    }

    @Override
    public String toString() {
        return "WeatherInfoModel{" +
                "weatherinfo=" + weatherinfo +
                '}';
    }
}
