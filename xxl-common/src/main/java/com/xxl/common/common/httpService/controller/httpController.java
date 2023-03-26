package com.xxl.common.common.httpService.controller;

import com.alibaba.fastjson.JSONObject;
import com.xxl.common.common.httpService.entity.User;
import org.apache.http.NameValuePair;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("http")
public class httpController {

    @RequestMapping("user")
    @ResponseBody
    public String postService(@RequestBody User user) throws IOException, URISyntaxException {
        String mysex = "男";
        String content = null;
        String url = "http://localhost:18081/hello/user";
        //参数列表
        List<NameValuePair> pairs = new ArrayList<>();
        pairs.add(new BasicNameValuePair("sex", mysex));
        //提交信息
        URI uri = new URIBuilder(url)
                .setParameters(pairs)
                //带入参数
                .build();
        //创建一个HttpClient对象 = 打开浏览器
        CloseableHttpClient httpClient = HttpClients.createDefault();
        //创建HttpPost请求 = 在浏览器输入地址
        HttpPost httpPost = new HttpPost(uri);
        String s =  JSONObject.toJSONString(user);
        StringEntity stringEntity = new StringEntity(s, "UTF-8");
        httpPost.addHeader("Content-Type", "application/json");
        httpPost.setEntity(stringEntity);
        CloseableHttpResponse response = null;
        try {
            //执行请求 = 按下回车
            response = httpClient.execute(httpPost);
            //解析响应，获取数据
            content = EntityUtils.toString(response.getEntity(), "UTF-8");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (response != null) {
                // 关闭资源
                response.close();
            }
            // 关闭浏览器
            httpClient.close();
        }
        return content;
    }
}
