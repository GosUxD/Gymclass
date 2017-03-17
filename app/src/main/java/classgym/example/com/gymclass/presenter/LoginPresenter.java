package classgym.example.com.gymclass.presenter;

import android.content.Context;
import android.util.Log;

import classgym.example.com.gymclass.model.api.RestApiManager;
import classgym.example.com.gymclass.model.pojo.account.LoginRequest;
import classgym.example.com.gymclass.model.pojo.account.LoginResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class LoginPresenter implements LoginContract.LoginPresenter {
    private static final String TAG = "LoginPresenter";
    private LoginContract.LoginView mView;
    private Context mContext;
    private RestApiManager mRestApiManager;

    public LoginPresenter(LoginContract.LoginView mView, Context context) {
        mContext = context;
        this.mView = mView;
        mRestApiManager = new RestApiManager();
    }

    @Override
    public void doLogin(String email, String password) {
        mRestApiManager.getLoginApi().doLogin(new LoginRequest(email, password)).enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                if(response.body() == null) {
                    Log.i(TAG, "onResponse: null");
                    return;
                }

                if(response.body().isError()) {
                    mView.onLoginFailure(response.body().getErrorMsg());
                } else {
                    mView.onLoginSuccess();
                }
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                Log.i(TAG, "onResponse: " + t.getMessage());

            }
        });
    }

    @Override
    public void doRegister() {
        mView.showRegister();
    }

    @Override
    public void doFacebookLogin() {

    }

    @Override
    public void doGoogleLogin() {

    }

    @Override
    public void doRetreivePass() {

    }

    boolean isEmailValid(CharSequence email) {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }
}
