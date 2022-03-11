package kz.iitu;

import kz.iitu.model.City;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TimeZoneDao {
    private static Statement stmt;
    private static ResultSet rs;

    private static DBUtil dbUtil = new DBUtil();

    public List<City> getListCityByCode(String s) {
        List<City> ret = new ArrayList<>();
        String sql = "SELECT * FROM `timezone` z WHERE z.country_code='" + s + "';";
        Connection connection = dbUtil.getConnection();
        try {
            PreparedStatement prSt = connection.prepareStatement(sql);
            ResultSet resultSet = prSt.executeQuery();
            while (resultSet.next()) {
                City city = new City();
                String[] subStr = resultSet.getString("timezone").split("/");
                city.cityName = subStr[1];
                city.zoneName = subStr[0];
                city.countryCode = resultSet.getString("country_code");
                city.gmtOffset = resultSet.getString("gmt_offset");
                ret.add(city);
            }
        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        }
        return ret;
    }

    public List<City> getListCity() {
        List<City> ret = new ArrayList<>();
        String sql = "SELECT * FROM `timezone`";
        Connection connection = dbUtil.getConnection();
        try {
            PreparedStatement prSt = connection.prepareStatement(sql);
            ResultSet resultSet = prSt.executeQuery();
            while (resultSet.next()) {
                City city = new City();
                String[] subStr = resultSet.getString("timezone").split("/");
                city.cityName = subStr[1];
                city.zoneName = subStr[0];
                city.countryCode = resultSet.getString("country_code");
                city.gmtOffset = resultSet.getString("gmt_offset");
                ret.add(city);
            }
        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        }
        return ret;
    }

    public void checkCon() {
        List<City> ret = new ArrayList<>();
        String sql = "SELECT * FROM `timezone` z WHERE z.country_code='KZ';";
//        String sql = "SELECT * FROM `timezone`;";
        Connection connection = dbUtil.getConnection();
//        System.out.println(connection);
        try {
            PreparedStatement prSt = connection.prepareStatement(sql);
            ResultSet resultSet = prSt.executeQuery();
//            while (resultSet.next()) {
//                City city = new City();
//                String[] subStr = resultSet.getString("timezone").split("/");
//                city.cityName = subStr[1];
//                city.zoneName = subStr[0];
//                city.countryCode = resultSet.getString("country_code");
//                city.gmtOffset = resultSet.getString("gmt_offset");
////                System.out.println(city);
//                ret.add(city);
//            }
//            for (City city : ret) {
//                if (city.zoneName.equals("Asia"))
//                    System.out.println(city.toString2());
//            }
            if (resultSet.next())
                System.out.println("Есть коннект с бд!");
        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        }
//        return ret;
    }
}
