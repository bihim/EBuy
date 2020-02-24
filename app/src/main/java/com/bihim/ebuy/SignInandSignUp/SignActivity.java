package com.bihim.ebuy.SignInandSignUp;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.LayoutTransition;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.bihim.ebuy.MainActivity;
import com.bihim.ebuy.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import es.dmoral.toasty.Toasty;
import life.sabujak.roundedbutton.RoundedButton;
import ss.anoop.awesometextinputlayout.AwesomeTextInputLayout;

public class SignActivity extends AppCompatActivity
{
    private boolean notAMemberSignUp = false; //sign up is not activated

    @BindView(R.id.sign_in_up)
    RoundedButton signInUpButton;

    @BindView(R.id.not_a_member_already_a_member)
    Button alreadyAMember_notAMemberButton;

    @BindView(R.id.edit_text_enter_name)
    EditText editTextName;

    @BindView(R.id.edit_text_enter_email)
    EditText editTextEmail;

    @BindView(R.id.edit_text_enter_password)
    EditText editTextPassword;

    @BindView(R.id.text_view_sign_in)
    TextView textViewSignInUp;

    @BindView(R.id.edit_text_enter_name_layout)
    AwesomeTextInputLayout awesomeTextInputLayouteditTextName;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign);

        ButterKnife.bind(this);

        buttonPress();

    }

    private void buttonPress()
    {
        alreadyAMember_notAMemberButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                if(!notAMemberSignUp)
                {
                    signUpView();
                }

                else
                {
                    signInView();
                }
            }
        });

        signInUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                if (!notAMemberSignUp)
                {
                    signUp();
                }
                else
                {
                    signIn();
                }
            }
        });
    }

    private void signInView()
    {
        ((ViewGroup) findViewById(R.id.layout_change)).getLayoutTransition().enableTransitionType(LayoutTransition.CHANGING);
        notAMemberSignUp = false;
        editTextName.setVisibility(View.VISIBLE);
        awesomeTextInputLayouteditTextName.setVisibility(View.VISIBLE);
        signInUpButton.setText("SIGN UP");
        textViewSignInUp.setText("Sign Up");
        alreadyAMember_notAMemberButton.setText("Not a member? Click here to sign in");
    }

    private void signUpView()
    {
        ((ViewGroup) findViewById(R.id.layout_change)).getLayoutTransition().enableTransitionType(LayoutTransition.CHANGING);
        notAMemberSignUp = true;
        editTextName.setVisibility(View.GONE);
        awesomeTextInputLayouteditTextName.setVisibility(View.GONE);
        signInUpButton.setText("SIGN IN");
        textViewSignInUp.setText("Sign In");
        alreadyAMember_notAMemberButton.setText("Already a member? Click here to sign up");
    }

    private void signUp()
    {
        String name = editTextName.getText().toString();
        String email = editTextEmail.getText().toString();
        String password = editTextPassword.getText().toString();

        if (!name.isEmpty() && !email.isEmpty() && !password.isEmpty())
        {
            Toasty.success(this, "Successfully logged in",Toasty.LENGTH_SHORT).show();
            startActivity(new Intent(this, MainActivity.class));
        }
        else
        {
            editTextName.setError("Empty Name");
            editTextPassword.setError("Empty Password");
            editTextEmail.setError("Empty Email");
        }
    }

    private void signIn()
    {
        String email = editTextEmail.getText().toString();
        String password = editTextPassword.getText().toString();

        if (!email.isEmpty() && !password.isEmpty())
        {
            if (email.equals("admin") && password.equals("password"))
            {
                Toasty.success(this, "Successfully logged in",Toasty.LENGTH_SHORT).show();
                startActivity(new Intent(this, MainActivity.class));
            }

            else
            {
                Toasty.error(this,"Username: admin and Password: password",Toasty.LENGTH_SHORT).show();
            }

        }
        else
        {
            editTextPassword.setError("Empty Password");
            editTextEmail.setError("Empty Email");
        }
    }

}
