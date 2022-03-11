package kz.iitu.model;

public class City {
    public String countryCode;
    public String zoneName;
    public String cityName;
    public String gmtOffset;

    @Override
    public String toString() {
        return "City{" +
                "countryCode='" + countryCode + '\'' +
                ", zoneName='" + zoneName + '\'' +
                ", city='" + cityName + '\'' +
                ", gmtOffset='" + gmtOffset + '\'' +
                '}';
    }

    public String toString2() {
        if (Double.parseDouble(gmtOffset) > 0)
            return "City " + cityName + ":" +
                    "\n zone name: " + zoneName +
                    "\n country code: " + countryCode +
                    "\n UTC: + " + gmtOffset;
        else
            return "City " + cityName + ":" +
                    "\n zone name: " + zoneName +
                    "\n country code: " + countryCode +
                    "\n UTC: " + gmtOffset;
    }
}
