package com.example.ex10;

import androidx.appcompat.app.AppCompatActivity;

import android.app.SearchManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RatingBar;
import android.widget.Toast;

import java.io.File;
import java.net.URI;

public class MainActivity extends AppCompatActivity {
    RadioButton second, third, rdoSum, rdoSub, rdoMul, rdoDiv;
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
//        setContentView(R.layout.ex10_09);
//        setContentView(R.layout.ex10_16);
//        setContentView(R.layout.ex10_3);
//        setContentView(R.layout.ex10_20);
        setContentView(R.layout.ex10_22);


//        ex01();
//        ex1();
//        ex07();
//        ex09();
//        ex16();
//        ex3();
//        ex21();
        ex23();
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

    void ex16(){
        Button btnNewActivity = (Button) findViewById(R.id.btnNewActivity);
        btnNewActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText edtNum1 = (EditText) findViewById(R.id.edtNum1);
                EditText edtNum2 = (EditText) findViewById(R.id.edtNum2);
                Intent intent = new Intent(getApplicationContext(), SecondActivity2.class);
                intent.putExtra("Num1", Integer.parseInt(edtNum1.getText().toString()));
                intent.putExtra("Num2", Integer.parseInt(edtNum2.getText().toString()));
                startActivityForResult(intent,0);
            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            int hap = data.getIntExtra("Hap", 0);
            Toast.makeText(getApplicationContext(), "합계 : " + hap, Toast.LENGTH_SHORT).show();
        }

    }
    void ex3(){
        Button btnCalc = (Button) findViewById(R.id.btnCalc);
        btnCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText edtNum1 = (EditText) findViewById(R.id.edtNum1);
                EditText edtNum2 = (EditText) findViewById(R.id.edtNum2);
                rdoSum = (RadioButton) findViewById(R.id.rdoSum);
                rdoSub = (RadioButton) findViewById(R.id.rdoSub);
                rdoMul = (RadioButton) findViewById(R.id.rdoMul);
                rdoDiv = (RadioButton) findViewById(R.id.rdoDiv);
                int i =0;
                if(rdoSum.isChecked()){
                    i = 1;
                } else if(rdoSub.isChecked()){
                    i = 2;
                } else if (rdoMul.isChecked()){
                    i = 3;
                } else if(rdoDiv.isChecked()){
                    i = 4;
                }
                Intent intent = new Intent(getApplicationContext(), ex3.class);
                intent.putExtra("Num1", Integer.parseInt(edtNum1.getText().toString()));
                intent.putExtra("Num2", Integer.parseInt(edtNum2.getText().toString()));
                intent.putExtra("Calc",i);
                startActivityForResult(intent,0);
            }
        });
    }
    void ex21(){
        Button btnDial = (Button) findViewById(R.id.btnDial);
        Button btnWeb = (Button) findViewById(R.id.btnWeb);
        Button btnGoogle = (Button) findViewById(R.id.btnGoogle);
        Button btnSearch = (Button) findViewById(R.id.btnSearch);
        Button btnSms = (Button) findViewById(R.id.btnSms);
        Button btnPhoto = (Button) findViewById(R.id.btnPhoto);


        btnDial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse("tel:01012345678");
                Intent intent = new Intent(Intent.ACTION_DIAL, uri);
                startActivity(intent);
            }
        });

        btnWeb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse("http://www.hanbit.co.kr");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
        btnGoogle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse("http://maps.google.com/maps?q="+37.554264+","+126.913598);
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_WEB_SEARCH);
                intent.putExtra(SearchManager.QUERY, "안드로이드");
                startActivity(intent);
            }
        });

        btnSms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_SENDTO);
                intent.putExtra("sms_body", "안녕하세요?");
                intent.setData(Uri.parse("smsto:" + Uri.encode("010-1234-4567")));
                startActivity(intent);
            }
        });

        btnPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                Uri uri = Uri.fromFile((new File(Environment.
                        getExternalStorageDirectory().getPath()+"/jeju13.jpg")));
                intent.setDataAndType(uri,"image/jpeg");
                startActivity(intent);
            }
        });
    }
    void ex23(){
        android.util.Log.i("액티비티 테스트", "onCreate()");

        Button btnDial = (Button) findViewById(R.id.btnDial);
        Button btnFinish = (Button) findViewById(R.id.btnFinish);

        btnDial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse("tel:01012345678");
                Intent intent = new Intent(Intent.ACTION_DIAL, uri);
                startActivity(intent);
            }
        });
        btnFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}