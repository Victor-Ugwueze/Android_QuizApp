package com.example.android.quizapp;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.os.Handler;
import android.os.SystemClock;
import android.widget.LinearLayout;
import android.widget.TextView;

import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;
import android.widget.ViewFlipper;


public class QuizActivity extends AppCompatActivity implements View.OnClickListener{
    private ViewFlipper viewFlipper;
    private int score=0;
    Button next;
    Button previous;
    TextView textView;
    EditText editextans;




    private TextView timerValue;
    private long startTime = 0L;
    private Handler customHandler = new Handler();
    long timeInMilliseconds = 0L;
    long timeSwapBuff = 0L;
    long updatedTime = 0L;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        getIntent().getExtras();
        viewFlipper = (ViewFlipper)findViewById(R.id.viewFlipper);
        next = (Button) findViewById(R.id.btn_next);
        previous =  (Button) findViewById(R.id.btn_previous);
        timerValue = (TextView) findViewById(R.id.txt_show_time);
        next.setOnClickListener(this);
        previous.setOnClickListener(this);

//Timer------------------------------------------------- code
        startTime = SystemClock.uptimeMillis();
        customHandler.postDelayed(updateTimerThread, 0);



    }

    @Override
    public void onClick(View v) {

        if(v==next){
            viewFlipper.showNext();
        }else if (v==previous){
            viewFlipper.showPrevious();
        }
    }

    public void questionOne(View view) {
        boolean checked= ((RadioButton) view).isChecked();
        switch (view.getId()){
            case R.id.q1_wright:
                if(checked)
                    score= score+1;
                break;
            default:
                score +=0;
                break;
        }
    }

    public void questionTwo(View view) {

        boolean checked= ((RadioButton) view).isChecked();
        switch (view.getId()){
            case R.id.q2_wright:
                if(checked)
                score= score+1;
                break;
            default:
                score +=0;
                break;
        }
    }


    public void questionThree(View view) {
        boolean checked= ((RadioButton) view).isChecked();
        switch (view.getId()){
            case R.id.q3_wright:
                if(checked)
                    score= score+1;
                break;
            default:
                score +=0;
                break;
        }
    }




    public void questionFour(View view) {

        boolean checked= ((RadioButton) view).isChecked();
        switch (view.getId()){
            case R.id.q4_wright:
                if(checked)
                    score= score+1;
                break;
            default:
                score +=0;
                break;
        }
    }

    public void questionSeven(View view) {
        boolean checked= ((RadioButton) view).isChecked();
        switch (view.getId()){
            case R.id.q7_wright:
                if(checked)
                    score= score+1;
                break;
            default:
                score +=0;
                break;
        }
    }

    public void ShowScore(View view) {
        String out;
        TextView submitbtn= (TextView) findViewById(R.id.submit_btn);

        submitbtn.setText("Submitted");
      CheckBox get1= (CheckBox) findViewById(R.id.q6_wright1);
       boolean ans1= get1.isChecked();

        CheckBox get2= (CheckBox) findViewById(R.id.q6_wright2);
        boolean ans2= get2.isChecked();

        CheckBox get3= (CheckBox) findViewById(R.id.q6_wright3);
        boolean ans3= get3.isChecked();

        if(ans1 && ans2 &&ans3){
            score++;
        }

        editextans = (EditText) findViewById(R.id.q5_ans);
        out= editextans.getText().toString();
        if(out.equals("ac")){
            score++;
        }
        textView= (TextView) findViewById(R.id.txt_show_score);
        String ShowScore= ""+score+"/"+"7";
        textView.setText(ShowScore);

        previous.setText("");
        next.setText("");
        Toast toast = Toast.makeText(QuizActivity.this, "you scored "+score +" out of 7", Toast.LENGTH_LONG);
        LinearLayout toastLayout = (LinearLayout) toast.getView();
        TextView toastTV = (TextView) toastLayout.getChildAt(0);
        toastTV.setTextSize(30);
        toast.show();
    }


    private Runnable updateTimerThread = new Runnable() {
        public void run() {
            timeInMilliseconds = SystemClock.uptimeMillis() - startTime;
            updatedTime = timeSwapBuff + timeInMilliseconds;
            int secs = (int) (updatedTime / 1000);
            int hour = secs/60/60;
            int mins = secs / 60;
            secs = secs % 60;
            int milliseconds = (int) (updatedTime % 1000);
            timerValue.setText("" + hour + ":" +"" + mins + ":"

                            + String.format("%02d", secs)); // + ":"

                           // + String.format("%03d", milliseconds));

            customHandler.postDelayed(this, 0);

        }
    };

}