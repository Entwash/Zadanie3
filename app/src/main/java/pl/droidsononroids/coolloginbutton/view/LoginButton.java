package pl.droidsononroids.coolloginbutton.view;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;


import pl.droidsononroids.coolloginbutton.R;

public class LoginButton extends FrameLayout{

    FrameLayout baseButton;
    FrameLayout successButton;
    FrameLayout errorButton;
    TextView signIn;
    ProgressBar progressBar;
    ImageView iv;

    public LoginButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.login_button, this,  true);
        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.LoginButton);
        final String text = ta.getString(R.styleable.LoginButton_text);
        final int otherColor = ta.getColor(R.styleable.LoginButton_otherColor, 0);
        final Drawable icon = ta.getDrawable(R.styleable.LoginButton_otherIcon);

        ta.recycle();
        if(text!=null){
            ((TextView) findViewById(R.id.base_button)).setText(text);
            ((FrameLayout) findViewById(R.id.layout_base)).setBackgroundColor(otherColor);
            //((ImageView) findViewById(R.id.success_imageView)).setImageIcon(icon);//od API 23?

        }

    }

    public void initialize() {
        baseButton = (FrameLayout) findViewById(R.id.layout_base);
        successButton = (FrameLayout) findViewById(R.id.layout_success);
        errorButton = (FrameLayout) findViewById(R.id.layout_failure);
        signIn = (TextView) findViewById(R.id.base_button);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        iv = (ImageView) findViewById(R.id.success_imageView);

    }

    public void setBaseSettings() {
        successButton.setVisibility(INVISIBLE);
        baseButton.setVisibility(VISIBLE);
        errorButton.setVisibility(INVISIBLE);
    }

    public void successSettings() {
        successButton.setVisibility(VISIBLE);
        baseButton.setVisibility(INVISIBLE);
        errorButton.setVisibility(INVISIBLE);

        getPreviousState();
    }

    public void failureSettings() {
        successButton.setVisibility(INVISIBLE);
        baseButton.setVisibility(INVISIBLE);
        errorButton.setVisibility(VISIBLE);

    }

    public void setProgressBar() {
        signIn.setVisibility(INVISIBLE);
        progressBar.setVisibility(VISIBLE);
    }

    public void setTextView() {
        signIn.setVisibility(INVISIBLE);
        progressBar.setVisibility(VISIBLE);
    }

    public void getPreviousState() {
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                setBaseSettings();
            }
        }, 1000);

    }


    public LoginButton(Context context) {
        super(context);
    }
}
