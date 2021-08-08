package com.example.quizmasters;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Random;
import java.util.logging.Handler;

public class quiz extends AppCompatActivity {
    private TextView quesat,tvques;
    private Button op1,op2,op3,op4;
    private ArrayList<QuizModal> arrlist;
    Random random;
    int sc=0,qat=1,curpos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        quesat=findViewById(R.id.quesat);
        tvques=findViewById(R.id.tvques);

        op1=findViewById(R.id.op1);
        op2=findViewById(R.id.op2);
        op3=findViewById(R.id.op3);
        op4=findViewById(R.id.op4);
        arrlist=new ArrayList<>();//arraylist for questions
        random=new Random();
        getques(arrlist);
        curpos=random.nextInt(arrlist.size());
        setdatatoviews(curpos);

        op1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(arrlist.get(curpos).getAns().trim().toLowerCase().equals(op1.getText().toString().trim().toLowerCase())){
                    sc++;

                }

                qat++;//question attempted increases
                curpos=random.nextInt(arrlist.size());
                setdatatoviews(curpos);//moves to next question and displays it
            }
        });
        op2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(arrlist.get(curpos).getAns().trim().toLowerCase().equals(op2.getText().toString().trim().toLowerCase())){
                    sc++;

                }

                qat++;
                curpos=random.nextInt(arrlist.size());
                setdatatoviews(curpos);
            }
        });
        op3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(arrlist.get(curpos).getAns().trim().toLowerCase().equals(op3.getText().toString().trim().toLowerCase())){
                    sc++;

                }

                qat++;
                curpos=random.nextInt(arrlist.size());
                setdatatoviews(curpos);
            }
        });
        op4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(arrlist.get(curpos).getAns().trim().toLowerCase().equals(op4.getText().toString().trim().toLowerCase())){
                    sc++;

                }

                qat++;
                curpos=random.nextInt(arrlist.size());
                setdatatoviews(curpos);
            }
        });




    }
    /*private void btn1state(){
        op1.setEnabled(true);
    }
    private void btn2state(){
        op2.setEnabled(true);
    }
    private void btn3state(){
        op3.setEnabled(true);
    }
    private void btn4state(){
        op4.setEnabled(true);
    }*/

    private void showbot(){
        BottomSheetDialog bottomSheetDialog=new BottomSheetDialog(quiz.this);//for displaying score sheet at bottom
        View bottomview= LayoutInflater.from(getApplicationContext()).inflate(R.layout.score_bottom,(LinearLayout)findViewById(R.id.idll));//inflating the bottomsheet
        TextView scoretv=bottomview.findViewById(R.id.scoretv);
        Button reset=bottomview.findViewById(R.id.btnreset);
        scoretv.setText("Your have scored\n"+(sc+1)+"/10");
        reset.setOnClickListener(new View.OnClickListener() {   //reset the quiz
            @Override
            public void onClick(View v) {
                curpos=random.nextInt(arrlist.size());
                setdatatoviews(curpos);
                qat=1;
                sc=0;
                bottomSheetDialog.dismiss();
            }
        });
        bottomSheetDialog.setCancelable(false);//not to close dialog on clicking something
        //bottomSheetDialog.setCanceledOnTouchOutside(false);
        bottomSheetDialog.setContentView(bottomview);//to display bottom layout inside bottom sheet dialog
        bottomSheetDialog.show();//to show bottom sheet

    }

    private void setdatatoviews(int curpos) {
        quesat.setText("Questions Attempted : "+qat+"/10");
        if(qat==10){
            showbot();
        }else {

            tvques.setText(arrlist.get(curpos).getQues());//gets questions and its options from arrlist
            op1.setText(arrlist.get(curpos).getOp1());
            op2.setText(arrlist.get(curpos).getOp2());
            op3.setText(arrlist.get(curpos).getOp3());
            op4.setText(arrlist.get(curpos).getOp4());
        }


    }

    //questions list
    private void getques(ArrayList<QuizModal> arrlist) {
        arrlist.add(new QuizModal("The academic centre of the Indian Space Research Organisation is set up in which state?","Kerala","Karnataka","Tamil Nadu","Maharashtra","Karnataka"));
        arrlist.add(new QuizModal("Nephron is the basic structural and functional unit of which among the following organs?","Brain","Pancreas","Liver","Kidneys","Kidneys"));
        arrlist.add(new QuizModal("Which among the following fishes does not have Central Nervous System?","Jelly Fish","Dog Fish","Cuttle Fish","Star Fish","Jelly Fish"));
        arrlist.add(new QuizModal("Which among the following is the largest and broadest river of south India?","Krishna","Narmada","Godavari","Tapti","Godavari"));
        arrlist.add(new QuizModal("Who has the most no. of centuries in cricket?","Sachin Tendulkar","Don Bradman","Brian Lara","Virat Kohli","Sachin Tendulkar"));
        arrlist.add(new QuizModal("Who has the most no. of Ballon'dOr Awards in Football?","Kaka","Ronaldo","Lionel Messi","Cristiano Ronaldo","Lionel Messi"));
        arrlist.add(new QuizModal("Who was the founder of Kadamba dynasty in Karnataka?","Kangavarma","Bhageerath","Mayurasharma","Kakusthavarma","Mayurasharma"));
        arrlist.add(new QuizModal("Who was the founder of Yoga philosophy?","Jaimini","Kapila","Patanjali","Akshapada Gautam","Patanjali"));
        arrlist.add(new QuizModal("The Puna grassland ecoregion is found in which of the following continents?","Asia","South America","Africa","North America","South America"));
        arrlist.add(new QuizModal("Who wrote the book 'India Wins Freedom'?","APJ Abdul Kalam","Raghuram Rajan","A.B Vajpayee","Abdul Kalam Azad","Abdul Kalam Azad"));
    }
}