package lmh.tribune.community.provider;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.annotation.JsonFormat;
import lmh.tribune.community.dto.AccessTokenDTO;
import lmh.tribune.community.dto.GitHubUser;
import okhttp3.*;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * @Description: TODO
 * @author: lmh
 * @date: 2022年03月14日 16:59
 */
@Component
public class GitHubProvider {
    public String getAccessToken(AccessTokenDTO accessTokenDTO){
        MediaType mediaType= MediaType.get("application/json; charset=utf-8");
        OkHttpClient client = new OkHttpClient();
        RequestBody body = RequestBody.create(mediaType,JSON.toJSONString(accessTokenDTO));
            Request request = new Request.Builder()
                    .url("https://github.com/login/oauth/access_token")
                    .post(body)
                    .build();
            try (Response response = client.newCall(request).execute()) {
                String string =response.body().string();
                System.out.println(string);
                return string.split("&")[0].split("=")[1];//拆分access_token
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
    }
    public GitHubUser getUser(String accessToken){
        OkHttpClient client = new OkHttpClient();
    /*    Request request = new Request.Builder()
                .url("https://api.github.com/user?access_token="+accessToken)
                .build();*/
        Request request = new Request.Builder()
                .url("https://api.github.com/user")
                .header("Accept","application/vnd.github.v3+json")
                .header("Authorization","token "+accessToken)
                .build();
        try {
            Response response = client.newCall(request).execute();
            String string =response.body().string();//不能toString
            GitHubUser gitHubUser = JSON.parseObject(string, GitHubUser.class);
            return gitHubUser;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
