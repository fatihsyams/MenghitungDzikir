package com.fatihsyams.menghitungdzikir.view;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.fatihsyams.menghitungdzikir.R;
import com.fatihsyams.menghitungdzikir.model.MainInteractor;
import com.fatihsyams.menghitungdzikir.presenter.MainInterface;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements MainInterface.View {

    @BindView(R.id.tv_output)
    TextView tvOutput;
    @BindView(R.id.btn_klik)
    Button btnKlik;
    @BindView(R.id.btn_reset)
    Button btnReset;
    private ProgressDialog progressDialog;
    private int zikir;
    private int resett;

    private MainInteractor mainInteractor = new MainInteractor(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @Override
    public void showProgress() {
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Tunggu Sebentar");
        progressDialog.setCancelable(false);
        progressDialog.show();
    }

    @Override
    public void hideProgress() {
        progressDialog.dismiss();
    }

    @Override
    public void berhasildiTambah(int hasil) {
        zikir = hasil;
        String sumStr = tvOutput.getText().toString();
        int sum = Integer.valueOf(sumStr);
        sum += 1;
        sumStr = String.valueOf(sum);
        tvOutput.setText(sumStr);
    }

    @Override
    public void resetDzikir(int reset) {
        resett = reset;
        tvOutput.setText("0");

    }

    @OnClick({R.id.btn_klik, R.id.btn_reset})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_klik:
                mainInteractor.penambahDzikir(zikir);
                break;
            case R.id.btn_reset:
                mainInteractor.hapusDzikir(resett);
                break;
        }
    }
}
