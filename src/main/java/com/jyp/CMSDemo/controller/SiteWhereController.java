package com.jyp.CMSDemo.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.jyp.CMSDemo.pojo.Measurement;
import com.jyp.CMSDemo.pojo.Site;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;

/**
 * Author   : jyp
 * Date     : 2017/3/16 13:26
 * Describe :
 */
@Controller
@RequestMapping(value = "sitewhere")
public class SiteWhereController {
    @RequestMapping(value = "/sites")
    public String getSites(String page, String pageSize, HttpServletResponse response) throws IOException {
        response.setCharacterEncoding("utf-8");
        PrintWriter pw = response.getWriter();

        String parameters = "?"+ page +"&"+pageSize;
        String uri = "http://localhost:8080/sitewhere/api/sites"+parameters;

        JSONObject jsonObject = getHtmlJsonByUrl(uri );
        int total = (Integer)jsonObject.get("numResults");
        List<Site> sites = new ArrayList<>();

        JSONArray results = jsonObject.getJSONArray("results");
        JSONObject obj;
        for (int i = 0; i < results.size(); i++){
            obj = results.getJSONObject(i);
            String token = obj.get("token").toString();
            String name = obj.get("name").toString();
            Site site = new Site(token,name);
            sites.add(site);
        }

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("total", total);
        map.put("rows", sites);
        String json = JSONObject.toJSONString(map);
        //返回JSON数据
        pw.print(json);
        return null;
    }


    /**
     * 待解决问题，直接访问URL获取到的是所有measurements的信息，
     * @param page
     * @param pageSize
     * @param response
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "/measurements")
    public String getAssignmentsMeasurements(String page, String pageSize, HttpServletResponse response) throws IOException {
        response.setCharacterEncoding("utf-8");
        PrintWriter pw = response.getWriter();
        String assignmentToken  = "b8430c7c-5690-4fc7-ba13-644b66fbbe03";
//        String parameters = "?"+ page +"&"+pageSize;
        String uri = "http://localhost:8080/sitewhere/api/assignments/"
                + assignmentToken + "/measurements";
//                + parameters;

        JSONObject jsonObject = getHtmlJsonByUrl(uri );
        int total = (Integer)jsonObject.get("numResults");
        List<Measurement> measurements = new ArrayList<>();

        JSONArray results = jsonObject.getJSONArray("results");
        JSONObject result;
        JSONObject measurementObj;
        System.out.println("result数量："+results.size());
        //循环次数超过10次就不能继续
        for (int i = 0; i < results.size()-1; i++){
            result = results.getJSONObject(i);
            measurementObj = result.getJSONObject("measurements");
            double temperature = Double.valueOf(measurementObj.get("temperature").toString());
            double humidity = Double.valueOf(measurementObj.get("humidity").toString());
            System.out.println(temperature);
            System.out.println(humidity);
            Measurement measurement = new Measurement(temperature,humidity);
            measurements.add(measurement);
            System.out.println("循环了第"+i+"次");
        }
        System.out.println("数据获取完毕准备封装数据");

        Map<String, Object> map = new HashMap<>();
        map.put("total", total);
        map.put("rows", measurements);
        String json = JSONObject.toJSONString(map);
        System.out.println("json字符串："+ json);
        //返回JSON数据
        pw.print(json);
        return null;

    }




    private static JSONObject getHtmlJsonByUrl(String urlTemp){
        URL url = null;
        InputStreamReader input = null;
        HttpURLConnection conn;
        JSONObject jsonObj = null;
        try {
            url = new URL(urlTemp);
            conn = (HttpURLConnection) url.openConnection();
            //授权
            conn.setRequestProperty("Authorization", "Basic YWRtaW46cGFzc3dvcmQ=");
            //租户身份认证
            conn.setRequestProperty("X-SiteWhere-Tenant", "sitewhere1234567890");
            input = new InputStreamReader(conn.getInputStream(),"utf-8");
            Scanner inputStream = new Scanner(input);
            StringBuffer sb = new StringBuffer();
            while (inputStream.hasNext()) {
                sb.append(inputStream.nextLine());
            }
            jsonObj = JSONObject.parseObject(sb.toString());
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return jsonObj;
    }
}
