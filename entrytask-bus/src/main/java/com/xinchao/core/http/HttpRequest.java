/**
 * Copyright (c) 2018,maipu technologies,Inc.
 * All rights reserved.
 * 文件名称： HttpRequest
 * 摘要：
 * <p>
 * 当前版本： ${version}
 * 作者： alanp
 * 完成日期： 2018/4/8
 * <p>
 * 修改历史：
 * $Log:
 * 文件名称： HttpRequest.java,v $
 */
package com.xinchao.core.http;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;

/**
 * HttpRequest〈一句话功能简述〉
 * 〈功能详细描述〉
 *
 * @author alan.pu
 * @version 1.0.0 2018/4/8
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class HttpRequest
{


    private static URLConnection connect(String url) throws IOException
    {
        URL realUrl = new URL(url);
        URLConnection connection = realUrl.openConnection();
        connection.setRequestProperty("accept", "*/*");
        connection.setRequestProperty("connection", "Keep-Alive");
        connection.setRequestProperty("Content-Type", "application/json");
        connection.setDoOutput(true);
        connection.setDoInput(true);
        connection.connect();
        return connection;
    }


    /**
     * 向指定 URL 发送POST方法的请求
     *
     * @param url 发送请求的 URL
     * @return 所代表远程资源的响应结果
     */
    public static String sendPost(String url, String json) throws IOException
    {
        PrintWriter out = null;
        BufferedReader in = null;
        String result = "";
        try
        {
            URLConnection conn = connect(url);

            out = new PrintWriter(conn.getOutputStream());
            out.write(json);
            out.flush();
            in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line;
            while ((line = in.readLine()) != null)
            {
                result += line;
            }
        }
        finally
        {
            try
            {
                if (out != null)
                {
                    out.close();
                }
                if (in != null)
                {
                    in.close();
                }
            }
            catch (IOException ex)
            {
                ex.printStackTrace();
            }
        }
        return result;
    }
}
