package com.jyp.CMSDemo.pojo;

/**
 * Author   : jyp
 * Date     : 2017/3/16 15:14
 * Describe : 设备测量数据实体类
 */
public class Measurement {
    private double temperature;
    private double humidity;

    public Measurement() {
    }

    public Measurement(double temperature, double humidity) {
        this.temperature = temperature;
        this.humidity = humidity;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public double getHumidity() {
        return humidity;
    }

    public void setHumidity(double humidity) {
        this.humidity = humidity;
    }

    @Override
    public String toString() {
        return "Measurement{" +
                "temperature=" + temperature +
                ", humidity=" + humidity +
                '}';
    }
}
