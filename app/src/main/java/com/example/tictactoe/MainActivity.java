package com.example.tictactoe;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import java.text.MessageFormat;

public class MainActivity extends AppCompatActivity {
    Button b1,b2,b3,b4,b5,b6,b7,b8,b9,r,e,resx,resy;
MediaPlayer sound1,sound2;
    String v1,v2,v3,v4,v5,v6,v7,v8,v9;
    int flag=0,count=0,countX=0,countY=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        init();
        sound1=MediaPlayer.create(this,R.raw.exit);
        sound2= MediaPlayer.create(this,R.raw.score);
        resx = (Button)findViewById(R.id.resx);
        resy = findViewById(R.id.resy);
        e = (Button)findViewById(R.id.exit);
        e.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sound1.start();
                finish();

            }
        });

        r=(Button)findViewById(R.id.restart);
        r.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                newgame1();
                }
        });

    }
    public void init()
    {
        b1=findViewById(R.id.button1);
        b2=findViewById(R.id.button2);
        b3=findViewById(R.id.button3);
        b4=findViewById(R.id.button4);
        b5=findViewById(R.id.button5);
        b6=findViewById(R.id.button6);
        b7=findViewById(R.id.button7);
        b8=findViewById(R.id.button8);
        b9=findViewById(R.id.button9);


    }
    public void newgame1()
    {
        b1.setText("");
        b2.setText("");
        b3.setText("");
        b4.setText("");
        b5.setText("");
        b6.setText("");
        b7.setText("");
        b8.setText("");
        b9.setText("");
        count=0;
        String f=Integer.toString(countY);
        String t=Integer.toString(countX);
        resx.setText(f);
        resy.setText(t);
    }
    public void newgame()
    {
        b1.setText("");
        b2.setText("");
        b3.setText("");
        b4.setText("");
        b5.setText("");
        b6.setText("");
        b7.setText("");
        b8.setText("");
        b9.setText("");
        count=0;
        if(flag==0)
            countX++;
        else
            countY++;
        String f=Integer.toString(countY);
        String t=Integer.toString(countX);
        resx.setText(f);
       sound2.start();
        resy.setText(t);
    }
    public void check(View v)
    {

        Button btn=(Button)v;
        if((btn.getText().toString()).equals(""))
        {
            count++;
            if(flag==0)
            {
                btn.setText("X");
                flag=1;
            }
            else
            {
                btn.setText("O");
                flag=0;
            }
            if(count>4 ) {
                v1 = b1.getText().toString();
                v2 = b2.getText().toString();
                v3 = b3.getText().toString();
                v4 = b4.getText().toString();
                v5 = b5.getText().toString();
                v6 = b6.getText().toString();
                v7 = b7.getText().toString();
                v8 = b8.getText().toString();
                v9 = b9.getText().toString();

                if(v1.equals(v2) && v2.equals(v3)&& !v1.equals(""))
                {
                    Toast.makeText(this, "Winner is : "+v1, Toast.LENGTH_LONG).show();
                    newgame();
                    if(v1.equals("X"))
                        flag=0;
                    else flag=1;


                }
                else if(v4.equals(v5) && v5.equals(v6)&& !v4.equals("")){
                    Toast.makeText(this, "Winner is : "+v4, Toast.LENGTH_LONG).show();
                    newgame();
                    if(v4.equals("X")){
                        flag=0;}
                    else {
                        flag=1;}


                }
                else if(v7.equals(v8) && v8.equals(v9)&& !v7.equals(""))
                {
                    Toast.makeText(this, "Winner is : "+v7, Toast.LENGTH_LONG).show();
                   newgame();
                    if(v7.equals("X"))
                        flag=0;
                    else flag=1;

                }
                else if(v1.equals(v4) && v4.equals(v7)&& !v1.equals("")){
                    Toast.makeText(this, "Winner is : "+v1, Toast.LENGTH_LONG).show();
                   newgame();
                    if(v1.equals("X"))
                        flag=0;
                    else flag=1;


                }
                else if(v2.equals(v5) && v5.equals(v8)&& !v2.equals("")){
                    Toast.makeText(this, "Winner is : "+v2, Toast.LENGTH_SHORT).show();
                   newgame();
                    if(v2.equals("X"))
                        flag=0;
                    else flag=1;


                }
                else if(v3.equals(v6) && v6.equals(v9)&& !v3.equals("")){
                    Toast.makeText(this, "Winner is : "+v3, Toast.LENGTH_SHORT).show();
                    newgame();
                    if(v3.equals("X"))
                        flag=0;
                    else flag=1;


                }
                else if(v1.equals(v5) && v5.equals(v9)&& !v1.equals("")){

                    Toast.makeText(this, "Winner is : "+v1, Toast.LENGTH_SHORT).show();
                   newgame();
                    if(v1.equals("X"))
                        flag=0;
                    else flag=1;


                }
                else if(v3.equals(v5) && v5.equals(v7) && !v3.equals(""))
                {
                    Toast.makeText(this, "Winner is : "+v3, Toast.LENGTH_SHORT).show();
                    newgame();
                    if(v3.equals("X"))
                        flag=0;
                    else
                        flag=1;

                }
                else
                {
                    if(count==9){
                        Toast.makeText(this, "Match drawn", Toast.LENGTH_SHORT).show();
                        flag=0;
                        countX--;
                       newgame();


                    }
                }
            }

        }


    }
}