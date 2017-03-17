package classgym.example.com.gymclass.presenter;

import android.util.Log;

import classgym.example.com.gymclass.model.api.RestApiManager;
import classgym.example.com.gymclass.model.pojo.account.RegisterRequest;
import classgym.example.com.gymclass.model.pojo.account.RegisterResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterPresenter implements RegisterContract.RegisterPresenter {

    private static final String TAG = "RegisterPresenter";
    RegisterContract.RegisterView mView;
    RestApiManager mRestApiManager;

    public RegisterPresenter(RegisterContract.RegisterView mView) {
        this.mView = mView;
        mRestApiManager = new RestApiManager();
    }

    @Override
    public void doRegister(String email, String password) {
        mRestApiManager.getRegisterApi().doRegister(new RegisterRequest(email,password)).enqueue(new Callback<RegisterResponse>() {
            @Override
            public void onResponse(Call<RegisterResponse> call, Response<RegisterResponse> response) {
                if(response.body() == null) {
                    return;
                }
                if(response.body().isError()) {
                    mView.onFailure();
                } else {
                    mView.onSuccess();
                }
            }

            @Override
            public void onFailure(Call<RegisterResponse> call, Throwable t) {
                Log.d(TAG, "onFailure: ", t);
            }
        });
    }
}
