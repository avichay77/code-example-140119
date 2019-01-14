import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Request.Builder;
import okhttp3.Response;
import org.json.JSONObject;

import java.io.IOException;

public class Example1 {




    public MockDataItem getDataFromApi(String id) throws IOException {

        MockDataItem result = null;
        String url = "http://api.any.com/get/"+id;

        Request request = new Request.Builder().url(url).build();
        OkHttpClient client = new OkHttpClient();
        Response response = client.newCall(request).execute();
        String source = response.body().string();
        JSONObject jsonObject = new JSONObject(source);
        if (jsonObject.has("data")) {
            JSONObject dataJson = jsonObject.getJSONObject("data");
            int count = dataJson.getInt("count");
            String name = dataJson.getString("name");
            result = new MockDataItem("",0);
        }


        return result;
    }

}
