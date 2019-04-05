package com.fatihsyams.menghitungdzikir.presenter;

public interface MainInterface {
    interface View {
       void showProgress();
       void hideProgress();
       void berhasildiTambah(int hasil);
        void resetDzikir(int reset);

    }
    interface presenter {
        void logicCoding();
        void penambahDzikir(int zikir);
        void hapusDzikir(int hapus);
    }
}
