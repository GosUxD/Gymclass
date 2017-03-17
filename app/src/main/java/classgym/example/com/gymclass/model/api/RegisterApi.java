package classgym.example.com.gymclass.model.api;

import classgym.example.com.gymclass.model.pojo.account.RegisterRequest;
import classgym.example.com.gymclass.model.pojo.account.RegisterResponse;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;


public interface RegisterApi {


    @Headers("Content-Type: application/json")
    @POST("android/register.php")
    Call<RegisterResponse> doRegister(@Body RegisterRequest registerRequest);


}
