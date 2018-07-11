package dlwjddms.com.closet;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;


public class button_1 extends AppCompatActivity {

    @Override

    protected  void  onCreate(Bundle bundle){
        super .onCreate(bundle);
        setContentView(R.layout.button1);
        TextView nameText =(TextView)findViewById(R.id.nameText);
        Intent intent =getIntent();
        nameText.setText(intent.getStringExtra("nameText").toString());
        


    }
}
