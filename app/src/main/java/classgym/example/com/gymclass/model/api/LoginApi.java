package classgym.example.com.gymclass.model.api;


import classgym.example.com.gymclass.model.pojo.account.LoginRequest;
import classgym.example.com.gymclass.model.pojo.account.LoginResponse;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface LoginApi {

    @Headers("Content-Type: application/json")
    @POST("android/login.php")
    Call<LoginResponse> doLogin(@Body LoginRequest request);

}
