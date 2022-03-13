package kz.iitu;

import kz.iitu.model.City;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        TimeZoneDao timeZoneDao = new TimeZoneDao();
        timeZoneDao.checkCon();
        WebServiceTest webService = new WebServiceTest();
        List<City> city = webService.getListCityByCode("KZ");
        System.out.println(city.get(2).toString2());
        try {
            System.out.println(webService.getCityByCityName("London").toString2());

        } catch (Exception e) {
            System.out.println("miss");
        }
        System.out.println("===============");
        List<City> cities = webService.getListCityByZoneName("Asia");
        for (City city1 : cities) {
            System.out.println(city1.toString());
        }
        System.out.println("===============");
        List<City> cities2 = webService.getListCityByZoneNameAndByCode("Asia", "kz");
        for (City city2 : cities2) {
            System.out.println(city2.toString());
        }
        System.out.println("===============");
        List<String> list = webService.getListOfTimezone();
        for (String s : list){
            System.out.println(s);
        }
        // write your code here
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");
//        System.out.println(sdf.format(496803600));
    }
}
