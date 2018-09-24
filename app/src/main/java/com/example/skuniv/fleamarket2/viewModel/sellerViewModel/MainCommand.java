package com.example.skuniv.fleamarket2.viewModel.sellerViewModel;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import android.widget.Toast;

import com.example.skuniv.fleamarket2.databinding.SignInBinding;
import com.example.skuniv.fleamarket2.databinding.SignUpBinding;
import com.example.skuniv.fleamarket2.databinding.FindIdBinding;
import com.example.skuniv.fleamarket2.model.SellerModel;
import com.example.skuniv.fleamarket2.retrofit.NetRetrofit;
import com.example.skuniv.fleamarket2.view.MainActivity;
import com.example.skuniv.fleamarket2.view.sellerView.FindIdDialog;
import com.example.skuniv.fleamarket2.view.sellerView.SignInDialog;
import com.example.skuniv.fleamarket2.view.sellerView.SignUpDialog;
import com.google.gson.Gson;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.content.Context.MODE_PRIVATE;

public class MainCommand {

    SellerModel sellerModel;
    SignInBinding signInBinding;
    SignUpBinding signUpBinding;
    FindIdBinding findIdBinding;
    MainActivity mainActivity;
    Context context;
    Gson gson = new Gson();
    SignInDialog signInDialog;
    SignUpDialog signUpDialog;
    FindIdDialog findIdDialog;
    //자동 로그인 SharedPreferences 객체 생성
    SharedPreferences loginSetting;
    SharedPreferences.Editor editor;




    public MainCommand(Context context, SellerModel sellerModel, MainActivity mainActivity) {
        this.context = context;
        this.sellerModel = sellerModel;
        this.mainActivity = mainActivity;
    }

    public void setFindIdBinding(FindIdBinding findIdBinding) {
        this.findIdBinding = findIdBinding;
    }

    public void setFindIdDialog(FindIdDialog findIdDialog) {
        this.findIdDialog = findIdDialog;
    }

    public void setSignInDialog(SignInDialog signInDialog) {
        this.signInDialog = signInDialog;
    }

    public void setSignUpDialog(SignUpDialog signUpDialog) {
        this.signUpDialog = signUpDialog;
    }

    public void setSignInBinding(SignInBinding signInBinding) {
        this.signInBinding = signInBinding;
    }

    public void setSignUpBinding(SignUpBinding signUpBinding) {
        this.signUpBinding = signUpBinding;
    }


    public void signIn(String id, String pw) {
        if (!id.equals("") && !pw.equals("")) {
            Call<SellerModel> res = NetRetrofit.getInstance().getService().getSignInRepos(id, pw);
            Log.i("signIn", "" + res);
            res.enqueue(new Callback<SellerModel>() {
                @Override
                public void onResponse(Call<SellerModel> call, Response<SellerModel> response) {
                    Log.i("Retrofit", response.toString());
                    if (response.body() != null) {
                        sellerModel = response.body();
                        Log.i("sign in", "" + gson.toJson(sellerModel));
                        if (sellerModel.getResponse().equals("success")) {
                            loginSetting = context.getSharedPreferences("loginSetting", MODE_PRIVATE);
                            editor = loginSetting.edit();
                            editor.putString("id",sellerModel.getId());
                            editor.putString("shop",sellerModel.getShop());
                            editor.putInt("role",sellerModel.getRole());
                            editor.commit();

                            signInDialog.dismiss();
                            mainActivity.result.closeDrawer();
                            singInSuccess();
                        } else {
                            Toast.makeText(signInBinding.getRoot().getContext(), "로그인 실패", Toast.LENGTH_SHORT).show();
                        }
                    }
                }

                @Override
                public void onFailure(Call<SellerModel> call, Throwable t) {
                    Log.e("에러", t.getMessage());
                }
            });
        } else {
            Log.e("getShopList", "getShopList error");
        }
    }

    public void signUp(String id, String pw, String name, String sex, String email) {
        Call<String> res = NetRetrofit.getInstance().getService().getSignUnRepos(id, pw, name, sex, email);
        Log.i("signUp", "" + res);
        res.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                Log.i("Retrofit", response.toString());
                if (response.body() != null) {
                    String result = response.body();
                    Log.i("sign up", "" + gson.toJson(result));
                    if (result.equals("success")) {
                        signUpDialog.dismiss();
                        signInDialog.show();
                    } else {
                        Toast.makeText(signInBinding.getRoot().getContext(), "회원가입 실패", Toast.LENGTH_SHORT).show();
                    }
                }
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Log.e("에러", t.getMessage());
            }
        });
    }

    public void findId(String name, String email){
        Call<SellerModel> res = NetRetrofit.getInstance().getService().findIdRepos(name, email);
        Log.i("find Id", "" + res);
        res.enqueue(new Callback<SellerModel>() {
            @Override
            public void onResponse(Call<SellerModel> call, Response<SellerModel> response) {
                Log.i("Retrofit", response.toString());
                if (response.body() != null) {
                    sellerModel = response.body();
                    Log.i("find id", "" + gson.toJson(sellerModel));
                    if (sellerModel.getResponse().equals("success")) {
                        findIdBinding.findText.setText("아이디는 " + sellerModel.getId() + " 입니다.");
                    } else {
                        findIdBinding.findText.setText("아이디 찾기 실패");
                    }
                }
            }
            @Override
            public void onFailure(Call<SellerModel> call, Throwable t) {
                Log.e("에러", t.getMessage());
            }
        });
    }

    public void autoLogin(){
        loginSetting = context.getSharedPreferences("loginSetting", MODE_PRIVATE);
        sellerModel.setId(loginSetting.getString("id",""));
        sellerModel.setShop(loginSetting.getString("shop",""));
        sellerModel.setRole(loginSetting.getInt("role",-1));

        singInSuccess();
    }

    public void signOut(){
        loginSetting = context.getSharedPreferences("loginSetting", MODE_PRIVATE);
        editor = loginSetting.edit();

        editor.clear();
        editor.clear();

        mainActivity.result.removeAllItems();
        mainActivity.result.addItem(mainActivity.signInItem);
        mainActivity.result.closeDrawer();

        Toast.makeText(mainActivity,"로그아웃", Toast.LENGTH_SHORT).show();
    }

    public void signInTest(){
        sellerModel.setId("test");
        sellerModel.setShop("a01");
        sellerModel.setRole(2);
        sellerModel.setResponse("success");

        loginSetting = context.getSharedPreferences("loginSetting", MODE_PRIVATE);
        editor = loginSetting.edit();
        editor.putString("id",sellerModel.getId());
        editor.putString("shop",sellerModel.getShop());
        editor.putInt("role",sellerModel.getRole());
        editor.commit();

        signInDialog.dismiss();
        mainActivity.result.closeDrawer();
        singInSuccess();
    }

    public void signUptest(){
        signUpDialog.dismiss();
        signInDialog.show();
    }

    public void findIdTest(){
        sellerModel.setResponse("success");
        sellerModel.setId("kim");
        if (sellerModel.getResponse().equals("success")) {
            findIdBinding.findText.setText("아이디는 " + sellerModel.getId() + " 입니다.");
        } else {
            findIdBinding.findText.setText("아이디 찾기 실패");
        }
    }

    public void singInSuccess() {
        mainActivity.result.removeAllItems();
        if (sellerModel.getRole() == 0) { // 관리자 로그인
            mainActivity.result.addItem(mainActivity.currentApplyItem);
            Toast.makeText(mainActivity,"관리자 로그인", Toast.LENGTH_SHORT).show();
        }
        else if (sellerModel.getRole() == 1) { // 신청서 작성 안한 판매자
            mainActivity.result.addItem(mainActivity.applyItem);
            Toast.makeText(mainActivity,"판매자 로그인", Toast.LENGTH_SHORT).show();
        }
        else if (sellerModel.getRole() == 2) { // 승인된 판매자
            mainActivity.result.addItem(mainActivity.goodsSearchItem);
            Toast.makeText(mainActivity,"판매자 로그인", Toast.LENGTH_SHORT).show();
        }
        else if (sellerModel.getRole() == 3) { // 승인 안된 판매자
            Toast.makeText(mainActivity,"판매자 로그인", Toast.LENGTH_SHORT).show();
        }
        mainActivity.result.addItem(mainActivity.signout);
    }
}
