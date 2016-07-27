package pl.droidsononroids.coolloginbutton.screen;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import pl.droidsononroids.coolloginbutton.R;
import pl.droidsononroids.coolloginbutton.api.LoginManager;
import pl.droidsononroids.coolloginbutton.view.LoginButton;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.toolbar) Toolbar mToolbar;
    @BindView(R.id.email_edit_text) EditText mEmailEditText;
    private LoginManager mLoginManager;
    @BindView(R.id.interactiveButton) LoginButton loginButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mLoginManager = new LoginManager();
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setSupportActionBar(mToolbar);

        loginButton.initialize();

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mLoginManager.performLogin(String.valueOf(mEmailEditText.getText()));
            }
        });



        mLoginManager.setLoginListener(new LoginManager.LoginListener() {
            @Override
            public void loginSuccess() {
               // loginButton.setProgressBar();
                loginButton.successSettings();
                loginButton.getPreviousState();
              //  loginButton.setTextView();
            }

            @Override
            public void loginFailure() {
                //loginButton.setProgressBar();
                loginButton.failureSettings();
                loginButton.getPreviousState();
                //loginButton.setTextView();
            }
        });
    }
}