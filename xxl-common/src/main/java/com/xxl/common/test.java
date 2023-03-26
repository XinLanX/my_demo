package com.xxl.common;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.xxl.common.common.verifyParam.entity.User;

import java.io.IOException;
import java.net.URISyntaxException;

public class test {
    public static void main(String[] args) {
//        String sub = "/test/test_groip/groups";
//        String[] subs = sub.split("/");
//        String fullPath = subs[subs.length-1];
//        System.out.println(fullPath);
//        System.out.println(initialProj());
        User user = null;
        if ("null".equals(user.getIdCardNo()) ){
            System.out.println("ss");
        }
    }

    public static JSONObject initialProj(){
        JSONObject params = new JSONObject();
        params.put("path", "manage11");
        params.put("name", "管理文档");
        params.put("namespace", "/test_group/test_app");
        params.put("type", "git");
        JSONArray array = new JSONArray();
        JSONObject item = new JSONObject();
        item.put("filePath", "沟通/.gitignore");
        item.put("content", "");
        item.put("branch", "main");
        JSONObject item1 = new JSONObject();
        item1.put("filePath", "测试/.gitignore");
        item1.put("content", "");
        item1.put("branch", "main");
        JSONObject item2 = new JSONObject();
        item2.put("filePath", "需求/.gitignore");
        item2.put("content", "");
        item2.put("branch", "main");
        array.add(item);
        array.add(item1);
        array.add(item2);
        params.put("item", array);
        return params;
    }

    private static void func1(){
        String s =  "    {\n" +
                "        \"web_url\": \"http://172.20.238.157:48805/groups/test_group/test_group/FN_DOC_061042391100\",\n" +
                "        \"name\": \"开发类文档\",\n" +
                "        \"path\": \"FN_DOC_061042391100\",\n" +
                "        \"description\": \"\",\n" +
                "        \"visibility\": \"private\",\n" +
                "        \"share_with_group_lock\": false,\n" +
                "        \"require_two_factor_authentication\": false,\n" +
                "        \"two_factor_grace_period\": 48,\n" +
                "        \"project_creation_level\": \"developer\",\n" +
                "        \"auto_devops_enabled\": null,\n" +
                "        \"subgroup_creation_level\": \"maintainer\",\n" +
                "        \"emails_disabled\": null,\n" +
                "        \"mentions_disabled\": null,\n" +
                "        \"lfs_enabled\": true,\n" +
                "        \"default_branch_protection\": 2,\n" +
                "        \"avatar_url\": null,\n" +
                "        \"request_access_enabled\": true,\n" +
                "        \"full_name\": \"测试群组 / subGroup / 开发类文档\",\n" +
                "        \"full_path\": \"test_group/test_group/FN_DOC_061042391100\",\n" +
                "        \"created_at\": \"2023-02-06T10:42:35.574+08:00\",\n" +
                "        \"parent_id\": 65\n" +
                "    }\n" ;
        JSONObject obj  =  JSONObject.parseObject(s);
        String id =  obj.getString("id");
        if (id != null &&  id != ""){
            System.out.println(id);
        }else {
            System.out.println(obj.getString("parent_id"));
        }
    }
}
