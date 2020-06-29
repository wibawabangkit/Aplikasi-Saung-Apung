package wawa.developer.saungapung.Activities;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import wawa.developer.saungapung.R;

public class DetilMakanan  extends AppCompatActivity {
    ImageView imgdetailmakanan;
    TextView txtdetailnamamakanan;
    TextView txtDetalmakanan;
    TextView txthargamakanan;
    ImageView imgcall;
    ImageView washupcallcall;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detil_makanan);
        imgdetailmakanan = (ImageView) findViewById(R.id.imgdetailmakanan);
        imgcall = (ImageView) findViewById(R.id.imgcall);
        washupcallcall = (ImageView) findViewById(R.id.washupcall);
        imgcall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onCall();
            }
        });
        washupcallcall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onCallwashupcallcall();
            }
        });
        txtdetailnamamakanan = (TextView) findViewById(R.id.txtdetailnamamakanan);
        txtDetalmakanan = (TextView) findViewById(R.id.txtdetailmakanan);
        txthargamakanan = (TextView) findViewById(R.id.txtdetailhargamakanan);
        Intent terimadata = getIntent();
        txtdetailnamamakanan.setText(terimadata.getStringExtra("namaM"));
        txthargamakanan.setText(terimadata.getStringExtra("hargaM"));
        txtDetalmakanan.setText(terimadata.getIntExtra("detailM", 0));
        imgdetailmakanan.setImageResource(terimadata.getIntExtra("gbrM", 0));
    }

    public void onCall() {
        int permissionCheck = ContextCompat.checkSelfPermission(this,
                Manifest.permission.CALL_PHONE);
        if (permissionCheck != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(
                    this,
                    new String[]{Manifest.permission.CALL_PHONE}, 123);
        } else {
            startActivity(new
                    Intent(Intent.ACTION_CALL).setData(Uri.parse("tel:081297615961")));
        }
    }

    public void onCallwashupcallcall() {
        String contact = "+62 81297615961"; // use country code with your phonenumber
        String url = "https://api.whatsapp.com/send?phone=" + contact;
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(url));
        startActivity(i);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[]
            permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case 123:
                if ((grantResults.length > 0) && (grantResults[0] ==
                        PackageManager.PERMISSION_GRANTED)) {
                    onCall();
                } else {
                    Log.d("TAG", "Call Permission Not Granted");
                }
                break;
            default:
                break;
        }
    }
}