package Model;

import java.util.ArrayList;

public class p_editProvinces {
    private static p_editProvinces instance;
    
    private ArrayList<Country> countryList;
    private ArrayList<Province> provinceList;
    
    private p_editProvinces() {
        countryList = new ArrayList<Country>();
        provinceList = new ArrayList<Province>();
    }
    
    public static p_editProvinces getInstance() {
        if (instance == null) {
            instance = new p_editProvinces();
        }
        return instance;
    }
    
    public void setCountryList(ArrayList<Country> list) {
        countryList = list;
    }
    
    public void setProvinceList(ArrayList<Province> list) {
        provinceList = list;
    }

    public ArrayList<Country> getCountryList() {
        return countryList;
    }

    public ArrayList<Province> getProvinceList() {
        return provinceList;
    }
}
