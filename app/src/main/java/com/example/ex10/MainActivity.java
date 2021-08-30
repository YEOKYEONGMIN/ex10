package com.example.ex10;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RatingBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    RadioButton second, third;
    Button btnInc, btnDec, btnFinish;
    ImageView image[] = new ImageView[9];
    Integer imageId[] = {R.id.iv1,R.id.iv2,R.id.iv3,R.id.iv4,R.id.iv5,
            R.id.iv6,R.id.iv7,R.id.iv8,R.id.iv9};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//        setContentView(R.layout.ex10_01);
//        setContentView(R.layout.ex10_1);
//        setContentView(R.layout.ex10_07);
        setContentView(R.layout.ex10_09);

//        ex01();
//        ex1();
//        ex07();
        ex09();
    }

    void ex01(){
        Button btnNewActivity = (Button) findViewById(R.id.btnNewActivity);
        btnNewActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),SecondActivity.class);
                startActivity(intent);
            }
        });
    }

    void ex1(){
        Button btnNewActivity = (Button) findViewById(R.id.btnNewActivity);
        second = (RadioButton) findViewById(R.id.second);
        third = (RadioButton) findViewById(R.id.third);
        btnNewActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent;
                if(second.isChecked()) {
                    intent = new Intent(getApplicationContext(), SecondActivity.class);
                }
                else{
                    intent = new Intent(getApplicationContext(),ThirdActivity.class);
                }
                startActivity(intent);
            }
        });
    }
    void ex07(){
        final RatingBar rating1, rating2, rating3;

        rating1 =(RatingBar) findViewById(R.id.ratingBar1);
        rating2 =(RatingBar) findViewById(R.id.ratingBar2);
        rating3 =(RatingBar) findViewById(R.id.ratingBar3);
        btnInc = (Button) findViewById(R.id.btnInc);
        btnDec = (Button) findViewById(R.id.btnDec);

        btnInc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rating1.setRating(rating1.getRating()+rating1.getStepSize());
                rating2.setRating(rating2.getRating()+rating2.getStepSize());
                rating3.setRating(rating3.getRating()+rating3.getStepSize());
            }
        });

        btnDec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rating1.setRating(rating1.getRating()-rating1.getStepSize());
                rating2.setRating(rating2.getRating()-rating2.getStepSize());
                rating3.setRating(rating3.getRating()-rating3.getStepSize());
            }
        });
    }
    void ex09(){
        setTitle("명화 선호도 투표");
        final int voteCount[] = new int[9];
        final String imgName[] ={"독서하는 소녀", "꽃장식 모자 소녀","부채를 든 소녀","이레느깡 단 베르앙",
                "잠자는 소녀", "테라스의 두 자매", "피아노 레슨", " 피아노 앞의 소녀들", "해변에서"};
        for(int i = 0; i < 9 ; i++){
            voteCount[i] = 0;
        }

        for(int i = 0; i < imageId.length; i++){
            final int index;
            index = i;

            image[index] = (ImageView) findViewById(imageId[index]);
            image[index].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    voteCount[index]++;
                    Toast.makeText(getApplicationContext(),imgName[index]+": 총"+ voteCount[index]+"표",
                            Toast.LENGTH_SHORT).show();
                }
            });
        }
        btnFinish = (Button) findViewById(R.id.btnResult);
        btnFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),ResultActivity2.class);
                intent.putExtra("VoteCount",voteCount);
                intent.putExtra("ImageName",imgName);

                startActivity(intent);
            }
        });
    }
}