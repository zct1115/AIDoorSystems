package com.ckkj.zct.door.ui.me;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.ckkj.zct.baselibrary.ui.activity.BaseAcitivity;
import com.ckkj.zct.baselibrary.ui.activity.BaseMvpActivity;
import com.ckkj.zct.door.R;
import com.ckkj.zct.door.presenter.UserPresenter_java;
import com.ckkj.zct.door.presenter.view.UserView_java;

public class RegisterJavaActivity extends BaseMvpActivity<UserPresenter_java> implements View.OnClickListener,UserView_java{

    private EditText mMobileEt;
    private EditText mVerifyCodeEt;
    private EditText mPwdEt;
    private Button mRegisterBtn;

    private UserPresenter_java userPresenter_java;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        userPresenter_java=new UserPresenter_java();
        userPresenter_java.mView=this;
        userPresenter_java.context=this;

        mMobileEt=findViewById(R.id.mMobileEt);
        mVerifyCodeEt=findViewById(R.id.mVerifyCodeEt);
        mPwdEt=findViewById(R.id.mPwdEt);
        mRegisterBtn=findViewById(R.id.mRegisterBtn);

        mRegisterBtn.setOnClickListener(this);
        mRegisterBtn.setEnabled(true);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.mRegisterBtn:
                showLoading();
                userPresenter_java.register(mMobileEt.getText().toString(),mPwdEt.getText().toString(),mVerifyCodeEt.getText().toString());
                break;
        }
    }

    @Override
    public void result(String text) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
    }
}
