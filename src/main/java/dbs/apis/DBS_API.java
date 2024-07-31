package dbs.apis;


import dbs.ProductUrl;

public enum DBS_API implements ProductUrl {
    SPARK_CARD ("http://192.168.67.22:10039/card-booking-service/v1/cardbooking/api/cms-card-booking");

    private String Url;
    DBS_API(String url){
        this.Url = url;
    }

    @Override
    public String getUrl(Object... params) {
        return this.Url;
    }
}