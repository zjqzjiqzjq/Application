package com.example.application.myinfo;

import android.app.Activity;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.application.R;
import com.example.application.utils.AnalyslsUtils;
import com.example.application.utils.MD5Utils;

public class FindPswActivity extends Activity implements View.OnClickListener  {

    private TextView tv_back;
    private TextView tv_main_title;
    private RelativeLayout title_bar;
    private TextView tv_user_name;
    private EditText et_user_name;
    private EditText et_validate_name;
    private EditText et_reset_psw;
    private TextView tv_reset_psw;
    private Button btn_set;
    private Button btn_validate;

    private String from;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_psw);
        from = getIntent().getStringExtra("from");
        initView();
    }

    private void initView() {
        tv_back = (TextView) findViewById(R.id.tv_back);
        tv_main_title = (TextView) findViewById(R.id.tv_main_title);
        title_bar = (RelativeLayout) findViewById(R.id.title_bar);
        tv_user_name = (TextView) findViewById(R.id.tv_user_name);
        et_user_name = (EditText) findViewById(R.id.et_user_name);
        et_validate_name = (EditText) findViewById(R.id.et_validate_name);
        et_reset_psw = (EditText) findViewById(R.id.et_reset_psw);
        tv_reset_psw = (TextView) findViewById(R.id.tv_reset_psw);
        btn_set = (Button) findViewById(R.id.btn_set);
        btn_validate = (Button) findViewById(R.id.btn_validate);

        if ("security".equals(from)){
            tv_main_title.setText("设置密保");
            btn_set.setVisibility(View.VISIBLE);
        }else {
            tv_main_title.setText("找回密码");
            tv_user_name.setVisibility(View.VISIBLE);
            et_user_name.setVisibility(View.VISIBLE);
            btn_validate.setVisibility(View.VISIBLE);
        }

        tv_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FindPswActivity.this.finish();
            }
        });

        btn_validate.setOnClickListener(this);
        btn_set.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_validate:
                submit();
                break;

            case R.id.btn_set:
                submit();
                break;
        }
    }

    private void submit() {
        String validateName = et_validate_name.getText().toString().trim();

        if ("security".equals(from)){
            if (TextUtils.isEmpty(validateName)) {
                Toast.makeText(this, "请输入要验证的姓名", Toast.LENGTH_SHORT).show();
                return;
            }else {
                Toast.makeText(this, "密保设置成功", Toast.LENGTH_SHORT).show();
                saveSecurity(validateName);
                FindPswActivity.this.finish();
            }
        }else {
            String name = et_user_name.getText().toString().trim();
            String sp_security = readSecurity(name);
            if (TextUtils.isEmpty(name)) {
                Toast.makeText(this, "请输入您的用户名", Toast.LENGTH_SHORT).show();
                return;
            }else if (!isExistUserName(name)){
                Toast.makeText(this, "您输入的用户名不存在", Toast.LENGTH_SHORT).show();
                return;
            }else if (TextUtils.isEmpty(validateName)){
                Toast.makeText(this, "请输入要验证的姓名", Toast.LENGTH_SHORT).show();
                return;
            }else if (!validateName.equals(sp_security)){
                Toast.makeText(this, "输入的密保不正确", Toast.LENGTH_SHORT).show();
                return;
            }else {
                et_reset_psw.setVisibility(View.VISIBLE);
                tv_reset_psw.setVisibility(View.VISIBLE);
                btn_validate.setVisibility(View.GONE);
                btn_set.setVisibility(View.VISIBLE);
                String resetPsw = et_reset_psw.getText().toString().trim();
                if (TextUtils.isEmpty(resetPsw)) {
                    return;
                }else {
                    Toast.makeText(this, "密码找回成功，下次登录请使用新密码", Toast.LENGTH_SHORT).show();
                    FindPswActivity.this.finish();
                    savePsw(name);
                }

            }
        }

        // TODO validate success, do something

    }

    private void savePsw(String name) {
        String resetPsw = et_reset_psw.getText().toString().trim();
        String md5Psw = MD5Utils.md5(resetPsw);
        SharedPreferences sp = getSharedPreferences("loginInfo",MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString(name,md5Psw);
        editor.commit();
    }

    private boolean isExistUserName(String name) {
        boolean hasUserName = false;
        SharedPreferences sp = getSharedPreferences("loginInfo",MODE_PRIVATE);
        String spPsw = sp.getString(name,"");
        if (!TextUtils.isEmpty(spPsw)){
            hasUserName = true;
        }
        return hasUserName;
    }

    private String readSecurity(String name) {
        SharedPreferences sp = getSharedPreferences("loginInfo",MODE_PRIVATE);
        String security = sp.getString(name+"_security","");
        return security;
    }

    private void saveSecurity(String validateName) {
        SharedPreferences sp = getSharedPreferences("loginInfo",MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString(AnalyslsUtils.readLoginUserName(this)+"_security",validateName);
        editor.commit();
    }
}
