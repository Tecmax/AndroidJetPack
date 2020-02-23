package com.maersk.androidmng.dbinding;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.maersk.androidmng.R;
import com.maersk.androidmng.databinding.ActivityDataBBinding;

public class DataBActivity extends AppCompatActivity {

    private Student studentD;
    MyClickHandlers myClickHandlers;
    ActivityDataBBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,
                        R.layout.activity_data_b);
        myClickHandlers = new
                MyClickHandlers(DataBActivity.this);
        binding.setHandlers(myClickHandlers);


    }

    public class MyClickHandlers {

        Context context;

        public MyClickHandlers(Context context) {
            this.context = context;
        }

        public void onFabClicked(View view) {
            Toast.makeText(context, "FAB clicked!", Toast.LENGTH_SHORT).show();
        }

        public void onButtonClick(View view) {
            studentD = new Student();
            studentD.setName("Karthik");
            studentD.setEmail("Nikhil");
            binding.setStudentDetails(studentD);
        }

        public void onButtonClickWithParam(View view, Student user) {
            Toast.makeText(context, "Button clicked! Name: " + user.getName(), Toast.LENGTH_SHORT).show();
        }

        public boolean onButtonLongPressed(View view) {
            Toast.makeText(context, "Button long pressed!",
                    Toast.LENGTH_SHORT).show();
            return false;
        }
    }
}
