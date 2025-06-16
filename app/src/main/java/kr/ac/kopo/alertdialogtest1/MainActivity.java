package kr.ac.kopo.alertdialogtest1;

import static android.view.View.VISIBLE;

import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    ImageView imageView ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

         imageView = findViewById(R.id.image_Sword);
        Button btn1 = findViewById(R.id.btn1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String[] foodItems = {"국밥🍲","치킨🍗","감자튀김🍟"};
                final int[] imgRes = {R.drawable.sword1,R.drawable.sword4,R.drawable.sword5};
                AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);
                dlg.setTitle("인공지능소프트웨어과 공지사항");
                dlg.setSingleChoiceItems(foodItems, 0, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        btn1.setText(foodItems[which]);
                        imageView.setImageResource(imgRes[which]);
                    }
                });
/*
                dlg.setItems(foodItems, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        btn1.setText(foodItems[which]);
                        imageView.setImageResource(imgRes[which]);
*/

                        /*
                        switch (which){
                            case 0:
                                imageView.setImageResource(R.drawable.sword1);
                                break;
                            case 1:
                                imageView.setImageResource(R.drawable.sword5);
                                break;
                            case 2:
                                imageView.setImageResource(R.drawable.sword4);
                                break;
                        }*/
                        imageView.setVisibility(VISIBLE);
                    }
                });
                //dlg.setMessage("513호에 타과 학생이 만약에 있다면 즉시 전원을 내리고 귀를 막은 체 교수실로 달려가 문을 두드리세요");
                dlg.setIcon(R.drawable.sword5);
                dlg.setPositiveButton("닫기",null);
/*                dlg.setPositiveButton("알겠습니다.", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        textView.setText("이 학교에는 513호는 없습니다.");
                        textView.setTextColor(Color.RED);
                        textView.setVisibility(VISIBLE);
                    }
                });
                dlg.setNegativeButton("취소", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this,"확인",Toast.LENGTH_SHORT);
                    }
                });*/
                dlg.show();
            }
        });
    }

}