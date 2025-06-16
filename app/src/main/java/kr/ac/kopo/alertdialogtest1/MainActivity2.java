package kr.ac.kopo.alertdialogtest1;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity2 extends AppCompatActivity {

    TextView textUserName, textEmail;//MainActivity
    Button btn;//MainActivity

    EditText editUserName,editEmail;//AlertDiglog

    TextView toastText;//Toast

    View dialogView, toastView;//대화상자와 토스트 레이아웃에 대한 참조변수



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        textUserName= findViewById(R.id.text_userInfo);
        textEmail= findViewById(R.id.text_email);
        btn = findViewById(R.id.btn2);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity2.this);
                dialogView = View.inflate(MainActivity2.this,R.layout.dialog1, null);
                dlg.setTitle("사용자 정보 입력");
                dlg.setIcon(R.drawable.sword5);
                dlg.setView(dialogView);
                dlg.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        editUserName = dialogView.findViewById(R.id.input_user);
                        editEmail = dialogView.findViewById(R.id.input_email);

                        textUserName.setText(editUserName.getText().toString());
                        textEmail.setText(editEmail.getText().toString());
                    }
                });
                dlg.setNegativeButton("취소", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        toastView = View.inflate(MainActivity2.this,R.layout.toast1, null);
                        toastText = toastView.findViewById(R.id.text_toast);

                        Toast toast = new Toast(MainActivity2.this);
                        toast.setText("Canceled");
                        toast.setView(toastView);
                        toast.show();

                    }
                });
                dlg.show();



            }
        });
    }
}