package com.example.application.myinfo;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.application.R;
import com.example.application.bean.UserBean;
import com.example.application.utils.AnalyslsUtils;
import com.example.application.utils.DBUtils;

public class UserInfoActivity extends Activity implements View.OnClickListener {

    private TextView tv_back;
    private TextView tv_main_title;
    private RelativeLayout title_bar;
    private ImageView iv_head_icon;
    private RelativeLayout rl_head;
    private TextView tv_user_name;
    private RelativeLayout rl_account;
    private TextView tv_sex;
    private RelativeLayout rl_sex;
    private TextView tv_qq;
    private RelativeLayout rl_qq;
    private String spUserName;
    private String new_info;

    private static final int CHANGE_QQ = 3;
    private static final int CHANGE_qq = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info);
        spUserName = AnalyslsUtils.readLoginUserName(this);
        initView();
        initData();

    }

    private void initView() {
        tv_back = (TextView) findViewById(R.id.tv_back);
        tv_main_title = (TextView) findViewById(R.id.tv_main_title);
        title_bar = (RelativeLayout) findViewById(R.id.title_bar);
        iv_head_icon = (ImageView) findViewById(R.id.iv_head_icon);
        rl_head = (RelativeLayout) findViewById(R.id.rl_head);
        tv_user_name = (TextView) findViewById(R.id.tv_user_name);
        rl_account = (RelativeLayout) findViewById(R.id.rl_account);
        tv_sex = (TextView) findViewById(R.id.tv_sex);
        rl_sex = (RelativeLayout) findViewById(R.id.rl_sex);
        tv_qq = (TextView) findViewById(R.id.tv_qq);
        rl_qq = (RelativeLayout) findViewById(R.id.rl_qq);

        tv_back.setOnClickListener(this);
        tv_main_title.setText("个人资料");
        title_bar.setBackgroundColor(Color.parseColor("#30B4FF"));
        rl_head.setOnClickListener(this);
        rl_account.setOnClickListener(this);
        rl_sex.setOnClickListener(this);
        rl_qq.setOnClickListener(this);
    }

    private void initData() {
        UserBean bean = DBUtils.getInstance(this).getUserInfo(spUserName);
        //判断一下数据库是否有数据
        if(bean == null){
            bean = new UserBean();
            bean.userName = spUserName;
            bean.sex = "男";
            bean.qq = "未添加";
            DBUtils.getInstance(this).saveUserInfo(bean);
        }
        satValue(bean);
    }
    //为界面控件设置值
    private void satValue(UserBean bean){
        tv_user_name.setText(bean.userName);
        tv_sex.setText(bean.sex);
        tv_qq.setText(bean.qq);
    }
    private void sexDialog(String sex){
        int sexFlag = 0;
        if("男".equals(sex)){
            sexFlag = 0 ;
        }else if ("女".equals(sex)){
            sexFlag = 1;
        }
        final String item[]={"男","女"};
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("性别");
        builder.setSingleChoiceItems(item, sexFlag, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                Toast.makeText(UserInfoActivity.this,item[which],Toast.LENGTH_SHORT).show();
                setSex(item[which]);
            }
        });
        builder.create().show();
    }
    private void setSex(String s){
        tv_sex.setText(s);
        DBUtils.getInstance(UserInfoActivity.this).updateUserInfo("sex",s,spUserName);
    }

    public void enterActivityForResult(Class<?> to, int requestcode, Bundle b){
        Intent i = new Intent(this, to);
        i.putExtras(b);
        startActivityForResult(i, requestcode);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode){
            case  CHANGE_qq:
                if (data != null){
                    new_info = data.getStringExtra("qq");
                    if(TextUtils.isEmpty(new_info)){
                        return;
                    }
                    tv_qq.setText(new_info);
                    DBUtils.getInstance(UserInfoActivity.this).updateUserInfo("qq",new_info,spUserName);
                }
                break;
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tv_back:
                this.finish();
                break;
            case R.id.rl_sex:
                String sex = tv_sex.getText().toString();
                sexDialog(sex);
                break;
            case R.id.rl_qq:
                //QQ号
                String qq = tv_qq.getText().toString();
                Bundle bdQQ  = new Bundle();
                bdQQ.putString("content",qq);
                bdQQ.putString("title","QQ号");
                bdQQ.putInt("flag",3);
                enterActivityForResult(ChangeUserInfoActivity.class,CHANGE_QQ,bdQQ);
                break;
        }

    }
}
