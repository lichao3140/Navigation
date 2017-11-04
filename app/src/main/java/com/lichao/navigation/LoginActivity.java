package com.lichao.navigation;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Administrator on 2017-11-04.
 */

public class LoginActivity extends Activity{

    EditText editText;
    TextInputLayout textInputLayout;
    Button button;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        editText = (EditText) findViewById(R.id.et_name);
        textInputLayout = (TextInputLayout) findViewById(R.id.tilayout1);
        textInputLayout.setErrorEnabled(true);
        button = (Button) findViewById(R.id.buttonLogin);
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                checkName(editable.toString());
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar snackbar = Snackbar.make(button, "点击啦", Snackbar.LENGTH_SHORT).setAction("确定", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(LoginActivity.this, "确定", Toast.LENGTH_SHORT).show();
                    }
                }).setCallback(new Snackbar.Callback(){
                    @Override
                    public void onDismissed(Snackbar transientBottomBar, int event) {
                        super.onDismissed(transientBottomBar, event);
                    }

                    @Override
                    public void onShown(Snackbar sb) {
                        super.onShown(sb);
                    }
                }).setActionTextColor(Color.WHITE);
                snackbar.show();
                View v=snackbar.getView();
                v.findViewById(R.id.snackbar_text);
            }
        });
    }

    private void checkName(String s) {
        if (s.length() < 4) {
            textInputLayout.setError("字符长度不够");
        }else{
            textInputLayout.setError(null);
        }
    }
}
