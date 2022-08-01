package jp.suntech.s21027.com.example.bmicalculators027;

import androidx.appcompat.app.AppCompatActivity;

import android.app.SearchManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btCal = findViewById(R.id.btCal);
        Button btClear = findViewById(R.id.btClear);
        BmiListener listener = new BmiListener();
        BmiListener listener1 = new BmiListener();
        btCal.setOnClickListener(listener);
        btClear.setOnClickListener(listener1);

    }

    private  class BmiListener implements View.OnClickListener {

        @Override
        public void onClick(View view) {
            EditText age = findViewById(R.id.etAge);
            EditText high = findViewById(R.id.etHigh);
            EditText weight = findViewById(R.id.etWeight);
            TextView result = findViewById(R.id.tvResult);
            TextView result2 = findViewById(R.id.tvResult2);
            TextView result3 = findViewById(R.id.tvResult3);
            TextView result4 = findViewById(R.id.tvResult4);
            String weightStr = weight.getText().toString();
            String highStr = high.getText().toString();
            String ageStr = age.getText().toString();
            int ageNum = Integer.parseInt(ageStr);
            Float highNum = Float.parseFloat(highStr);
            Float weightNum = Float.parseFloat(weightStr);
            float ans;
            String Answer;


            int id=view.getId();
            switch (id){
                case R.id.btCal:
                    if(ageNum < 17){
                        OrderConfirmDialogFragment dialogFragment = new OrderConfirmDialogFragment();
                        dialogFragment.show(getSupportFragmentManager(),"OrderConfirmDialogFragment");
                    }
                    else if((weightNum/(((highNum*highNum)*100)))*1000000 < 18.6){
                        result.setText("あなたの肥満度は\n");
                        result2.setText("低体重\n");
                        result3.setText("あなたの適正体重は\n");
                        ans = ((((highNum)*(highNum))*22)/10000);
                        Answer = String.format("%.2f",ans);
                        result4.setText(Answer + "  kg");
                    }
                    else if((weightNum/(((highNum*highNum)*100)))*1000000 >= 18.5 && (weightNum/(((highNum*highNum)*100)))*1000000 < 26){
                        result.setText("あなたの肥満度は\n");
                        result2.setText("普通体重\n");
                        result3.setText("あなたの適正体重は\n");
                        ans = ((((highNum)*(highNum))*22)/10000);
                        Answer = String.format("%.2f",ans);
                        result4.setText(Answer + "  kg");
                    }
                    else if((weightNum/(((highNum*highNum)*100)))*1000000 >= 25 && (weightNum/(((highNum*highNum)*100)))*1000000 < 31){
                        result.setText("あなたの肥満度は\n");
                        result2.setText("肥満(1度)\n");
                        result3.setText("あなたの適正体重は\n");
                        ans = ((((highNum)*(highNum))*22)/10000);
                        Answer = String.format("%.2f",ans);
                        result4.setText(Answer + "  kg");
                    }
                    else if((weightNum/(((highNum*highNum)*100)))*1000000 >= 30 && (weightNum/(((highNum*highNum)*100)))*1000000 < 36){
                        result.setText("あなたの肥満度は\n");
                        result2.setText("肥満(2度)\n");
                        result3.setText("あなたの適正体重は\n");
                        ans = ((((highNum)*(highNum))*22)/10000);
                        Answer = String.format("%.2f",ans);
                        result4.setText(Answer + "  kg");
                    }
                    else if((weightNum/(((highNum*highNum)*100)))*1000000 >= 35 && (weightNum/(((highNum*highNum)*100)))*1000000 < 41){
                        result.setText("あなたの肥満度は\n");
                        result2.setText("肥満(3度)\n");
                        result3.setText("あなたの適正体重は\n");
                        ans = ((((highNum)*(highNum))*22)/10000);
                        Answer = String.format("%.2f",ans);
                        result4.setText(Answer + "  kg");
                    }
                    else{
                        result.setText("あなたの肥満度は\n");
                        result2.setText("肥満(4度)\n");
                        result3.setText("あなたの適正体重は\n");
                        ans = ((((highNum)*(highNum))*22)/10000);
                        Answer = String.format("%.2f",ans);
                        result4.setText(Answer + "  kg");
                    }
                    break;
                case R.id.btClear:
                    age.setText("");
                    high.setText("");
                    weight.setText("");
                    result.setText("");
                    break;
            }

        }
    }
}