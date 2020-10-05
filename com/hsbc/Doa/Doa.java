package com.hsbc.Doa;

import com.hsbc.model.Employee;
import java.util.ArrayList;
import java.util.List;

public class Doa {
    static ArrayList<Employee> list = new ArrayList();
    public void store(Employee l ){
        list.add(l);
    }
    public ArrayList<Employee> getEmployeeList(){
        ArrayList<Employee> l = new ArrayList();
        int x = 3;
        for(Employee e:list){
            l.add(e);
            x--;
            if(x<=0)
                break;
        }
        return  l;
    }

    public  ArrayList<Employee> getList() {
        return list;
    }

    public  void setList(ArrayList<Employee> list) {
        Doa.list = list;
    }
    
}
