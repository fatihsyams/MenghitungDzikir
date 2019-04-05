package com.fatihsyams.menghitungdzikir.model;

import com.fatihsyams.menghitungdzikir.presenter.MainInterface;

public class MainInteractor implements MainInterface.presenter {

    private final MainInterface.View view;

    public MainInteractor(MainInterface.View view) {
        this.view = view;
    }

    @Override
    public void logicCoding() {

    }

    @Override
    public void penambahDzikir(int zikir) {
        view.berhasildiTambah(zikir);

    }

    @Override
    public void hapusDzikir(int hapus) {
        view.resetDzikir(hapus);
    }

}
