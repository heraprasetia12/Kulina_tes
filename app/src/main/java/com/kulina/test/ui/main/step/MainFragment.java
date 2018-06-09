package com.kulina.test.ui.main.step;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.applandeo.materialcalendarview.CalendarView;
import com.applandeo.materialcalendarview.EventDay;
import com.applandeo.materialcalendarview.listeners.OnDayClickListener;
import com.applandeo.materialcalendarview.utils.DateUtils;
import com.kulina.test.ui.base.BaseFragment;
import android.support.v4.app.Fragment;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatImageButton;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.kulina.test.R;
import com.stepstone.stepper.Step;
import com.stepstone.stepper.VerificationError;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnTextChanged;

public class MainFragment extends BaseFragment implements MainFragmentMvpView, Step {

    @Inject MainFragmentPresenter presenter;

    @BindView(R.id.tv_total_box) TextView tvTotalBox;
    @BindView(R.id.ib_substract) AppCompatImageButton ibSubstract;
    @BindView(R.id.ib_add) AppCompatImageButton ibAdd;
    int counter = 1;

    @BindView(R.id.ll_lama_langganan_1) LinearLayout llLamaLangganan1;
    @BindView(R.id.tv_hari_lama_langganan_1) TextView tvHariLamaLangganan1;
    @BindView(R.id.tv_harga_lama_langganan_1) TextView tvHargaLamaLangganan1;

    @BindView(R.id.ll_lama_langganan_2) LinearLayout llLamaLangganan2;
    @BindView(R.id.tv_hari_lama_langganan_2) TextView tvHariLamaLangganan2;
    @BindView(R.id.tv_harga_lama_langganan_2) TextView tvHargaLamaLangganan2;

    @BindView(R.id.ll_lama_langganan_3) LinearLayout llLamaLangganan3;
    @BindView(R.id.tv_hari_lama_langganan_3) TextView tvHariLamaLangganan3;
    @BindView(R.id.tv_harga_lama_langganan_3) TextView tvHargaLamaLangganan3;

    @BindView(R.id.ll_lama_langganan_4) LinearLayout llLamaLangganan4;
    @BindView(R.id.tv_hari_lama_langganan_4) TextView tvHariLamaLangganan4;
    @BindView(R.id.tv_harga_lama_langganan_4) TextView tvHargaLamaLangganan4;

    int hari = 0;
    int harga = 0;
    int total = 0;

    @BindView(R.id.calendar_view) CalendarView calendarView;
    String date = new SimpleDateFormat("dd MMMM yyyy").format(Calendar.getInstance().getTime());

    @BindView(R.id.tv_total_harga_per_box) TextView tvTotalHargaPerBox;
    @BindView(R.id.tv_total_jumlah_box) TextView tvTotalJumlahBox;
    @BindView(R.id.tv_total_lama_langganan) TextView tvTotalLamaLangganan;
    @BindView(R.id.tv_date) TextView tvDate;
    @BindView(R.id.tv_total_harga) TextView tvTotalHarga;

    @BindView(R.id.bt_selanjutnya_1) AppCompatButton btSelanjutnya1;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        fragmentComponent().inject(this);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main_step_1, container, false);
        ButterKnife.bind(this, view);
        presenter.attachView(this);
        presenter.initFragment();
        initCalendar();

        return view;
    }

    @Nullable
    @Override
    public VerificationError verifyStep() {
        return null;
    }

    @Override
    public void onSelected() {

    }

    @Override
    public void onError(@NonNull VerificationError error) {

    }

    @OnClick(R.id.ib_substract)
    public void substractBox(){
        if(counter == 1){
            ibSubstract.setEnabled(false);
        }
        else{
            ibSubstract.setEnabled(true);
            counter = counter - 1;
        }

        tvTotalBox.setText(String.valueOf(counter));
        calculateTotal();
    }

    @OnClick(R.id.ib_add)
    public void addBox(){
        counter = counter + 1;
        tvTotalBox.setText(String.valueOf(counter));
        calculateTotal();
    }

    @OnClick(R.id.ll_lama_langganan_1)
    public void selectLamaLangganan1(){
        llLamaLangganan1.setEnabled(false);
        llLamaLangganan1.setBackgroundColor(getResources().getColor(R.color.main_theme));
        tvHariLamaLangganan1.setTextColor(getResources().getColor(R.color.white));
        tvHargaLamaLangganan1.setTextColor(getResources().getColor(R.color.white));

        enableLamaLangganan2();
        enableLamaLangganan3();
        enableLamaLangganan4();

        hari = 20;
        harga = 22500;

        calculateTotal();
    }

    @OnClick(R.id.ll_lama_langganan_2)
    public void selectLamaLangganan2(){
        llLamaLangganan2.setEnabled(false);
        llLamaLangganan2.setBackgroundColor(getResources().getColor(R.color.main_theme));
        tvHariLamaLangganan2.setTextColor(getResources().getColor(R.color.white));
        tvHargaLamaLangganan2.setTextColor(getResources().getColor(R.color.white));

        enableLamaLangganan1();
        enableLamaLangganan3();
        enableLamaLangganan4();

        hari = 10;
        harga = 24250;

        calculateTotal();
    }

    @OnClick(R.id.ll_lama_langganan_3)
    public void selectLamaLangganan3(){
        llLamaLangganan3.setEnabled(false);
        llLamaLangganan3.setBackgroundColor(getResources().getColor(R.color.main_theme));
        tvHariLamaLangganan3.setTextColor(getResources().getColor(R.color.white));
        tvHargaLamaLangganan3.setTextColor(getResources().getColor(R.color.white));

        enableLamaLangganan1();
        enableLamaLangganan2();
        enableLamaLangganan4();

        hari = 5;
        harga = 25000;

        calculateTotal();

    }

    @OnClick(R.id.ll_lama_langganan_4)
    public void selectLamaLangganan4(){
        llLamaLangganan4.setEnabled(false);
        llLamaLangganan4.setBackgroundColor(getResources().getColor(R.color.main_theme));
        tvHariLamaLangganan4.setTextColor(getResources().getColor(R.color.white));
        tvHargaLamaLangganan4.setTextColor(getResources().getColor(R.color.white));

        enableLamaLangganan1();
        enableLamaLangganan2();
        enableLamaLangganan3();
    }

    private void enableLamaLangganan1(){
        llLamaLangganan1.setEnabled(true);
        llLamaLangganan1.setBackground(getResources().getDrawable(R.drawable.shape_rectangle_stroke));
        llLamaLangganan1.setBackgroundColor(getResources().getColor(R.color.white));
        tvHariLamaLangganan1.setTextColor(getResources().getColor(R.color.dark_grey_theme));
        tvHargaLamaLangganan1.setTextColor(getResources().getColor(R.color.dark_grey_theme));
    }

    private void enableLamaLangganan2(){
        llLamaLangganan2.setEnabled(true);
        llLamaLangganan2.setBackground(getResources().getDrawable(R.drawable.shape_rectangle_stroke));
        llLamaLangganan2.setBackgroundColor(getResources().getColor(R.color.white));
        tvHariLamaLangganan2.setTextColor(getResources().getColor(R.color.dark_grey_theme));
        tvHargaLamaLangganan2.setTextColor(getResources().getColor(R.color.dark_grey_theme));
    }

    private void enableLamaLangganan3(){
        llLamaLangganan3.setEnabled(true);
        llLamaLangganan3.setBackground(getResources().getDrawable(R.drawable.shape_rectangle_stroke));
        llLamaLangganan3.setBackgroundColor(getResources().getColor(R.color.white));
        tvHariLamaLangganan3.setTextColor(getResources().getColor(R.color.dark_grey_theme));
        tvHargaLamaLangganan3.setTextColor(getResources().getColor(R.color.dark_grey_theme));
    }

    private void enableLamaLangganan4(){
        llLamaLangganan4.setEnabled(true);
        llLamaLangganan4.setBackground(getResources().getDrawable(R.drawable.shape_rectangle_stroke));
        llLamaLangganan4.setBackgroundColor(getResources().getColor(R.color.white));
        tvHariLamaLangganan4.setTextColor(getResources().getColor(R.color.dark_grey_theme));
        tvHargaLamaLangganan4.setTextColor(getResources().getColor(R.color.dark_grey_theme));
    }

    private void initCalendar(){
        calendarView.setDisabledDays(getDisabledDays());
    }

    private List<Calendar> getDisabledDays(){
        Calendar saturday = DateUtils.getCalendar();
        saturday.add(Calendar.DAY_OF_WEEK, 7);

        Calendar sunday = DateUtils.getCalendar();
        sunday.add(Calendar.DAY_OF_WEEK, 1);

        List<Calendar> disabledDays = new ArrayList<>();
        disabledDays.add(saturday);
        disabledDays.add(sunday);

        return disabledDays;
    }

    private void calculateTotal(){
        tvTotalJumlahBox.setText(String.valueOf(counter) + " Box");
        tvTotalHargaPerBox.setText("Rp " + harga);
        tvTotalLamaLangganan.setText(hari + " Hari");
        tvDate.setText("Mulai " + date);
        total = harga * counter * hari;
        tvTotalHarga.setText("Rp " + total);
    }

}
