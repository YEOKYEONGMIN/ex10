package com.example.ex10;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

public class ResultActivity2 extends AppCompatActivity {
    TextView tvtop;
    ImageView ivTop;
    float max=0;
    int idx= 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ex10_2);
        setTitle("투표 결과");

        Intent intent = getIntent();
        int[] voteResult = intent.getIntArrayExtra("VoteCount");
        String[] imageName = intent.getStringArrayExtra("ImageName");

        TextView tv[] = new TextView[imageName.length];
        RatingBar rBar[] = new RatingBar[imageName.length];
        tvtop = findViewById(R.id.tvTop);
        ivTop = findViewById(R.id.ivTop);

        Integer tvID[] ={R.id.tv1, R.id.tv2, R.id.tv3, R.id.tv4, R.id.tv5,
                R.id.tv6, R.id.tv7, R.id.tv8, R.id.tv9};
        Integer rbarID[] = {R.id.rBar1, R.id.rBar2, R.id.rBar3, R.id.rBar4, R.id.rBar5,
                R.id.rBar6, R.id.rBar7, R.id.rBar8, R.id.rBar9};
        Integer ivID[] ={R.drawable.pic1, R.drawable.pic2, R.drawable.pic3, R.drawable.pic4, R.drawable.pic5,
                R.drawable.pic6, R.drawable.pic7, R.drawable.pic8, R.drawable.pic9};

        for(int i= 0; i < voteResult.length; i++){
            tv[i] = (TextView) findViewById(tvID[i]);
            rBar[i] = (RatingBar) findViewById(rbarID[i]);
        }

        for(int i = 0; i < voteResult.length; i++){
            tv[i].setText(imageName[i]);
            rBar[i].setRating((float) voteResult[i]);
        }
        for(int i = 0; i < voteResult.length; i++ ){
            if(voteResult[i]>max){
                max =voteResult[i];
                idx = i;
            }
        }
        tvtop.setText(imageName[idx]);
        ivTop.setImageResource(ivID[idx]);

        Button btnReturn = (Button) findViewById(R.id.btnReturn);
        btnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}