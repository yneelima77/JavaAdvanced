package com.test.project;

import com.test.hib.controller.findUser_Hql;

public class App {
    public static void main(String[] args) {
        findUser_Hql userHql = new findUser_Hql();
        //userHql.findUser();
        //userHql.findUserSelect();
        //userHql.getRecordbyId();
        //userHql.getrecords();
        //userHql.getmaxSalary();
        //userHql.getcountofUsers();
        userHql.getmaxSalaryGroupBy();
        userHql.NamedQueryExample();
    }
}
