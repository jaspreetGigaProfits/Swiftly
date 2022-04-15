package com.example.capstone_the_developers;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.etebarian.meowbottomnavigation.MeowBottomNavigation;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;

public class MeowNavigationActivity extends AppCompatActivity {

    private MeowBottomNavigation bnv_Main;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meow_navigation);

        bnv_Main = findViewById(R.id.bnv_Main);
        bnv_Main.add(new MeowBottomNavigation.Model(1,R.drawable.home));
        bnv_Main.add(new MeowBottomNavigation.Model(2,R.drawable.moodmeter));
        bnv_Main.add(new MeowBottomNavigation.Model(3,R.drawable.chat));
        bnv_Main.add(new MeowBottomNavigation.Model(4,R.drawable.dietplans));
//        bnv_Main.add(new MeowBottomNavigation.Model(5,R.drawable.shop));
        bnv_Main.add(new MeowBottomNavigation.Model(6,R.drawable.profile));



        bnv_Main.show(1,true);
        replace(new CovidLocationFragment());
        bnv_Main.setOnClickMenuListener(new Function1<MeowBottomNavigation.Model, Unit>() {
            @Override
            public Unit invoke(MeowBottomNavigation.Model model) {
                switch (model.getId()){
                    case 1:
                        replace(new CovidLocationFragment());
                        break;

                    case 2:
                        replace(new MoodMeterFragment());
                        break;

                    case 3:
                        replace(new ChatbotFragment());
                        break;

                    case 4:
                        replace(new DietPlansFragment());
                        break;

//                    case 5:
//                        replace(new SixthFragment());
//                        break;

                    case 6:
                        replace(new ProfileFragment());
                        break;
                }
                return null;
            }
        });
    }

    private void replace(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame,fragment);
        transaction.commit();
    }
}