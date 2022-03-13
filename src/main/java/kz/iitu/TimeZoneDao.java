package kz.iitu;

import kz.iitu.model.City;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
        String sql = "SELECT * FROM `timezone` ORDER BY `timezone`";
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

    public List<String> getListOfCountryCode() {
        List<String> ret = new ArrayList<>();
        String sql = "SELECT DISTINCT `country_code` FROM `timezone`;";
        Connection connection = dbUtil.getConnection();
        try {
            PreparedStatement prSt = connection.prepareStatement(sql);
            ResultSet resultSet = prSt.executeQuery();
            while (resultSet.next()) {
                ret.add(resultSet.getString("country_code"));
            }
        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        }
        return ret.stream().distinct().collect(Collectors.toList());
    }

    public List<String> getListOfTimezone() {
        List<String> ret = new ArrayList<>();
        String sql = "SELECT DISTINCT `timezone` FROM `timezone`;";
        Connection connection = dbUtil.getConnection();
        try {
            PreparedStatement prSt = connection.prepareStatement(sql);
            ResultSet resultSet = prSt.executeQuery();
            while (resultSet.next()) {
                String[] subStr = resultSet.getString("timezone").split("/");
                ret.add(subStr[0]);
            }
        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        }
        return ret.stream().distinct().collect(Collectors.toList());
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
