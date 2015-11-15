package bu.jirayut.student.butraffic;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class ExerciseActivity extends AppCompatActivity {

    //Explicit
    private TextView questionTextView;
    private ImageView trafficImageView;
    private RadioGroup choiceRadioGroup;
    private RadioButton choice1RadioButton, choice2RadioButton, choice3RadioButton, choice4RadioButton;

    private int timeInt = 0, score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise);

        bindWidget();

        setUpMyChoice();

    }   //Main Method

    private void setUpMyChoice() {

        String[] stringChoice = getResources().getStringArray(R.array.times1);
        choice1RadioButton.setText(stringChoice[0]);
        choice2RadioButton.setText(stringChoice[1]);
        choice3RadioButton.setText(stringChoice[2]);
        choice4RadioButton.setText(stringChoice[3]);

    }

    public void clickAnswer(View v) {

        String[] strQuestion = new String[5];
        strQuestion[0] = "1. What is this?";
        strQuestion[1] = "2. What is this?";
        strQuestion[2] = "3. What is this?";
        strQuestion[3] = "4. What is this?";
        strQuestion[4] = "5. What is this?";

        int[] intImg = new int[5];
        intImg[0] = R.drawable.traffic_14;
        intImg[1] = R.drawable.traffic_15;
        intImg[2] = R.drawable.traffic_16;
        intImg[3] = R.drawable.traffic_17;
        intImg[4] = R.drawable.traffic_18;

        int[] intChoice = new int[5];
        intChoice[0] = R.array.times1;
        intChoice[1] = R.array.times2;
        intChoice[2] = R.array.times3;
        intChoice[3] = R.array.times4;
        intChoice[4] = R.array.times5;

        checkScore();

        timeInt++;

        if(timeInt < 5){
            questionTextView.setText(strQuestion[timeInt]);
            trafficImageView.setImageResource(intImg[timeInt]);
            String[] stringChoice = getResources().getStringArray(intChoice[timeInt]);
            choice1RadioButton.setText(stringChoice[0]);
            choice2RadioButton.setText(stringChoice[1]);
            choice3RadioButton.setText(stringChoice[2]);
            choice4RadioButton.setText(stringChoice[3]);
        }else{
            Intent objIntent = (new Intent(ExerciseActivity.this, ScoreActivity.class));
            objIntent.putExtra("Score", score);
            startActivity(objIntent);
        }

    }   //Click Answer

    private void checkScore() {

        final int[] intUserChoose = {1,2,3,4,1};
        choiceRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                int intRadio = 0;
                switch (checkedId){
                    case R.id.radioButton : intRadio = 1;
                                            break;
                    case R.id.radioButton2 : intRadio = 2;
                                            break;
                    case R.id.radioButton3 : intRadio = 3;
                                            break;
                    case R.id.radioButton4 : intRadio = 4;
                                            break;
                }

                if(intUserChoose[timeInt] == intRadio){
                    score++;
                    Log.d("test", "score ===>" + Integer.toString(score));
                }

            }
        });

    }

    private void bindWidget() {
        questionTextView = (TextView) findViewById(R.id.textView5);
        trafficImageView = (ImageView) findViewById(R.id.imageView3);
        choiceRadioGroup = (RadioGroup) findViewById(R.id.radChoice);
        choice1RadioButton = (RadioButton) findViewById(R.id.radioButton);
        choice2RadioButton = (RadioButton) findViewById(R.id.radioButton2);
        choice3RadioButton = (RadioButton) findViewById(R.id.radioButton3);
        choice4RadioButton = (RadioButton) findViewById(R.id.radioButton4);
    }
}   //Main Class
