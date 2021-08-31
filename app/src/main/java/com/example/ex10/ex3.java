package com.example.ex10;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ex3 extends Activity {

    @Override
    protected void onCreate (Bundle saveInstanceState) {

        super.onCreate(saveInstanceState);
        setContentView(R.layout.ex10_17);

        Intent inIntent = getIntent();
        int i = inIntent.getIntExtra("Calc",0);
        int result = 0;
        if(i==1){
            result = inIntent.getIntExtra("Num1",0)
                    +inIntent.getIntExtra("Num2",0);
        }else if(i==2){
            result = inIntent.getIntExtra("Num1",0)
                    -inIntent.getIntExtra("Num2",0);
        }else if(i==3){
            result = inIntent.getIntExtra("Num1",0)
                    *inIntent.getIntExtra("Num2",0);
        }else if(i==4){
            if(inIntent.getIntExtra("Num2",0)!=0) {
                result = inIntent.getIntExtra("Num1", 0)
                        / inIntent.getIntExtra("Num2", 0);
            }
        }

        final int hapValue = result;

        Button btnReturn = (Button) findViewById(R.id.btnReturn);
        btnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent outIntent = new Intent(getApplicationContext(),MainActivity.class);
                outIntent.putExtra("Hap",hapValue);
                setResult(RESULT_OK,outIntent);
                finish();
            }
        });
    }

}
