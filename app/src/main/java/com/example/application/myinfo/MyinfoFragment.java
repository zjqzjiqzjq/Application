package com.example.application.myinfo;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.view.View;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.application.R;
import com.example.application.utils.AnalyslsUtils;


public class MyinfoFragment extends Fragment implements View.OnClickListener  {


    private ImageView iv_head_icon;
    private TextView tv_user_name;
    private LinearLayout ll_head;
    private ImageView iv_userinfo_icon;
    private RelativeLayout rl_setting;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_myinfo, null);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ll_head = (LinearLayout) view.findViewById(R.id.ll_head);
        iv_head_icon = (ImageView) view.findViewById(R.id.iv_head_icon);
        tv_user_name = (TextView) view.findViewById(R.id.tv_user_name);
        rl_setting = (RelativeLayout) view.findViewById(R.id.rl_setting);
        iv_userinfo_icon = (ImageView) view.findViewById(R.id.iv_userinfo_icon);

        if (AnalyslsUtils.readLoginStatus(getActivity())){
            tv_user_name.setText(AnalyslsUtils.readLoginUserName(getActivity()));
        }else {
            tv_user_name.setText("点击登录");
        }

        ll_head.setOnClickListener(this);
        rl_setting.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.ll_head:
                if (AnalyslsUtils.readLoginStatus(getActivity())){
                    //跳转到个人资料界面
                    Intent intent = new Intent(getActivity(), UserInfoActivity.class);
                    getActivity().startActivity(intent);

                }else {
                    //跳转到登录界面
                    Intent intent = new Intent(getActivity(), LoginActivity.class);
                    getActivity().startActivityForResult(intent,1);
                }
                break;
            case R.id.rl_setting:
                if (AnalyslsUtils.readLoginStatus(getActivity())){
                    //跳转到设置界面
                    Intent intent = new Intent(getActivity(), SettingActivity.class);
                    getActivity().startActivityForResult(intent,1);
                }else {
                    Toast.makeText(getActivity(),"您未登录，请先登录",Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }
}
