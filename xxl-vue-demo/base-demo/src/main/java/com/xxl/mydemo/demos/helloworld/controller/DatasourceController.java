package com.xxl.mydemo.demos.helloworld.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.xxl.mydemo.demos.helloworld.entity.Items;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("sql")
@CrossOrigin
public class DatasourceController {

    @PostMapping("/checkCon")
    @ResponseBody
    @ApiOperation(value = "测试连接")
    public Map<String, String> checkCon(@RequestBody String jsonParam) {
        Map<String, String> map = new HashMap<>();
        JSONObject jsonObject1 = JSON.parseObject(jsonParam);
        String url = jsonObject1.getString("url");
        String pwd = jsonObject1.getString("pwd");
        String username = jsonObject1.getString("userName");
         String driver = "com.mysql.cj.jdbc.Driver";
        if (true) {

            driver = "com.mysql.cj.jdbc.Driver";
            Connection con = null;
            try {
                Class.forName(driver);
                con = DriverManager.getConnection(url, username, pwd);
            } catch (ClassNotFoundException | SQLException e) {
                map.put("connect", e.getMessage());
            }
            if (con != null) {
                map.put("connect", "success");
            }
        }
        return map;
    }

    @PostMapping(value = "/executeSql")
    @ResponseBody
    public Items<Map<String,String >> executeSql(@RequestBody String jsonParam) throws Exception {

        JSONObject jsonObject1 = JSON.parseObject(jsonParam);
//        String sql = jsonObject1.getString("sql");
//        String url = jsonObject1.getString("url");
//        String pwd = jsonObject1.getString("pwd");
//        String userName = jsonObject1.getString("userName");
        String sql = "select * from sys_user_dept";
        String url = "jdbc:mysql://localhost:3306/tenant_uccenter?useUnicode=true&characterEncoding=UTF-8&serverTimezone=Asia/Shanghai&useSSL=false";
        String pwd = "Xxl010113**";
        String userName = "root";

        String driverName = "com.mysql.cj.jdbc.Driver";
        Long account = 0L;
        int pageSize = Integer.valueOf(jsonObject1.getString("pageSize"));
        int pageNum = Integer.valueOf(jsonObject1.getString("pageNum"));
        try {
            List list = new ArrayList<Map>();// 定义一个list，用来存放数据
            if (driverName.contains("oracle") || driverName.contains("dm.jdb")) {
            } else if (driverName.contains("mysql")){
                Class.forName(driverName);
                Connection con = DriverManager.getConnection(url, userName, pwd);
                Statement stmt = con.createStatement();
                ResultSet res = stmt.executeQuery(sql);
                ResultSetMetaData md = res.getMetaData();
                int columnCount = md.getColumnCount();
                int j = 0;
                while (res.next()) {
                    if ((pageNum-1)*pageSize <= j && j < (pageNum)*pageSize){
                        Map rowData = new HashMap();
                        for (int i = 1; i <= columnCount; i++) {
                            if (res.getObject(i) == null){
                                rowData.put(md.getColumnName(i), "");
                            }else {
                                rowData.put(md.getColumnName(i), res.getObject(i).toString());
                            }
                        }
                        list.add(rowData);
                    }
                    j++;
                    account++;
                }
                res.close();
            }
            return Items.of(list, account);
        }catch (Exception e){
            throw e;
        }
    }

    @PostMapping(value = "/executeSqlTable")
    @ResponseBody
    public List<Map> executeSqlTable(@RequestBody String jsonParam) throws Exception {
        JSONObject jsonObject1 = JSON.parseObject(jsonParam);
//        String sql = jsonObject1.getString("sql");
//        String url = jsonObject1.getString("url");
//        String pwd = jsonObject1.getString("pwd");
//        String userName = jsonObject1.getString("userName");

        String sql = "select * from sys_user_dept";
        String url = "jdbc:mysql://localhost:3306/tenant_uccenter?useUnicode=true&characterEncoding=UTF-8&serverTimezone=Asia/Shanghai&useSSL=false";
        String pwd = "Xxl010113**";
        String userName = "root";

        String driverName = "com.mysql.cj.jdbc.Driver";

        List list = new ArrayList<Map>();// 定义一个list，用来存放数据
        if (driverName.contains("oracle") || driverName.contains("dm.jdb")) {
        } else if (driverName.contains("mysql")){
            Class.forName(driverName);
            Connection con = DriverManager.getConnection(url, userName, pwd);
            Statement stmt = con.createStatement();
            ResultSet res = stmt.executeQuery(sql);
            ResultSetMetaData md = res.getMetaData();
            int columnCount = md.getColumnCount();
            for (int i = 1; i <= columnCount; i++) {
                Map rowData = new HashMap();
                rowData.put("dataItem", md.getColumnName(i));
                rowData.put("dataName", md.getColumnName(i));
                list.add(rowData);
            }
            res.close();
        }
        return list;
    }

}
