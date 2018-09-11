package dev.edmt.androidcamerarecognitiontext;

import android.util.Log;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class ValidateUser {

    public String post(String url,String[] data)
    {
        String textResult = null;
        try
        {
            HttpClient httpclient = new DefaultHttpClient();
            HttpPost post = new HttpPost(url);

            List<NameValuePair> itemsPost = new ArrayList<NameValuePair>();
            itemsPost.add(new BasicNameValuePair("employeeId", data[0]));
            itemsPost.add(new BasicNameValuePair("password", data[1]));

            post.setEntity(new UrlEncodedFormEntity(itemsPost));

            HttpResponse response = httpclient.execute(post);
            HttpEntity ent = response.getEntity();

            textResult = EntityUtils.toString(ent);
        }
        catch(Exception e)
        {

        }

        return textResult;
    }
}
