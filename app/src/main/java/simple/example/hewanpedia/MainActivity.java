package simple.example.hewanpedia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    ImageButton btnHarimau,btnKumbang,btnTikus;
    Button btnTentangKami;
    public static final String JENIS_GALERI_KEY = "JENIS_GALERI";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inisialisasiView();
    }

    private void inisialisasiView() {
        btnHarimau = findViewById(R.id.btn_buka_ras_harimau);
        btnKumbang = findViewById(R.id.btn_buka_ras_kumbang);
        btnTikus = findViewById(R.id.btn_buka_ras_tikus);
        btnTentangKami = findViewById(R.id.btn_tentang_kami);
        btnHarimau.setOnClickListener(view -> bukaGaleri("Harimau"));
        btnKumbang.setOnClickListener(view -> bukaGaleri("Kumbang"));
        btnTikus.setOnClickListener(view -> bukaGaleri("Tikus"));
        btnTentangKami.setOnClickListener(view -> onClick(btnTentangKami));
    }

    private void bukaGaleri(String jenisHewan) {
        Log.d("MAIN","Buka activity harimau");
        Intent intent = new Intent(this, DaftarHewanActivity.class);
        intent.putExtra(JENIS_GALERI_KEY, jenisHewan);
        startActivity(intent);
    }

    public void onClick(View v) {
        Intent intent = new Intent(MainActivity.this, TentangActivity.class);
        startActivity(intent);
    }

}