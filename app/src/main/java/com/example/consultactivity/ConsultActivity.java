package com.example.consultactivity;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.example.consultactivity.adapter.ConsultAdapter;
import com.example.consultactivity.bean.Question;
import com.example.consultactivity.util.GetService;

import java.util.List;

public class ConsultActivity extends AppCompatActivity {
    private ListView questionListView;
    private Button submit,search;
    private String questionString;
    private EditText contentView;
    private EditText keywordView;
    private List<Question> questionList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        questionListView = (ListView) findViewById(R.id.questionList);
        contentView = (EditText) findViewById(R.id.content);
        submit = (Button) findViewById(R.id.submit);
        search = (Button) findViewById(R.id.search);
        keywordView = (EditText) findViewById(R.id.keyword);

        GetService getService = new GetService();
        questionList = getService.setQuestionList();
        ConsultAdapter consultAdapter = new ConsultAdapter(
                ConsultActivity.this,questionList
        );
        questionListView.setAdapter(consultAdapter);


        questionListView.setOnItemLongClickListener(new
        AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                updateQuestion();
                return false;
            }
        }
        );
    }


    public void updateQuestion(){
        AlertDialog.Builder builder = new
    AlertDialog.Builder(ConsultActivity.this);
        builder.setTitle("我来回答");
        final EditText answerText = new EditText(ConsultActivity.this);
        builder.setView(answerText);
        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        builder.create().show();
    }

}