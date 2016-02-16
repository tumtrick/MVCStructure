package com.tumtrick.mvcstructure.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.tumtrick.mvcstructure.R;
import com.tumtrick.mvcstructure.fragment.MainFragment;
import com.tumtrick.mvcstructure.fragment.SecondFragment;
import com.tumtrick.mvcstructure.util.ScreenUtils;

public class MainActivity extends AppCompatActivity {


    private String someVarA;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int screenWidth = ScreenUtils.getInstance().getScreenWidrh();
        int screenHegiht = ScreenUtils.getInstance().getScreenHeight();

       // Toast.makeText(getApplicationContext() , "Width : " + screenWidth + " , Height : " + screenHegiht  , Toast.LENGTH_SHORT).show();
        //TUM

        if (savedInstanceState == null ) {
            // First Created
            // Place Fragment here  | Add Fragment
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.contentContainer,
                            MainFragment.newInstance(123, "tumtrick") , "MainFragment")
                    .commit();

            SecondFragment secondFragment = SecondFragment.newInstance();
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.contentContainer,
                            secondFragment ,
                            "SecondFragment")
                    .detach(secondFragment)
                    .commit();

        }


    }


    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);

        if (savedInstanceState == null) {
            MainFragment fragment = (MainFragment)
                    getSupportFragmentManager().findFragmentByTag("MainFragment");
            fragment.setHellowText("Woo Hooooooooo\nWoo Hooooooooo\nWoo Hooooooooo\nWoo Hooooooooo\nWoo Hooooooooo\nWoo Hooooooooo\nWoo Hooooooooo\nWoo Hooooooooo\nWoo Hooooooooo\nWoo Hooooooooo\nWoo Hooooooooo\nWoo Hooooooooo\nWoo Hooooooooo\nWoo Hooooooooo\nWoo Hooooooooo\nWoo Hooooooooo\nWoo Hooooooooo\nWoo Hooooooooo\nWoo Hooooooooo\nWoo Hooooooooo\nWoo Hooooooooo\nWoo Hooooooooo\nWoo Hooooooooo\nWoo Hooooooooo\nWoo Hooooooooo\nWoo Hooooooooo\nWoo Hooooooooo\nWoo Hooooooooo\n");
            // getSupportFragmentManager().findFragmentById(R.id.contentContainer);
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.main_menu , menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.action_frist_tab :
                MainFragment mainFragment = (MainFragment)
                        getSupportFragmentManager().findFragmentByTag("MainFragment");
                SecondFragment  secondFragment = (SecondFragment)
                        getSupportFragmentManager().findFragmentByTag("SecondFragment");




                getSupportFragmentManager().beginTransaction()
                        .attach(mainFragment)
                        .detach(secondFragment)
                        .commit();
                return true;
            case R.id.action_second_tab :
                mainFragment = (MainFragment)
                        getSupportFragmentManager().findFragmentByTag("MainFragment");
                secondFragment = (SecondFragment)
                        getSupportFragmentManager().findFragmentByTag("SecondFragment");

                getSupportFragmentManager().beginTransaction()
                        .attach(secondFragment)
                        .detach(mainFragment)
                        .commit();
                return true;
            case R.id.menu_secondfragment:



                Fragment fragment = getSupportFragmentManager()
                        .findFragmentById(R.id.contentContainer);


                getSupportFragmentManager().beginTransaction()
                        // .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)   Standard
                        .setCustomAnimations(
                                R.anim.from_right, R.anim.to_left ,
                                R.anim.from_left , R.anim.to_right
                        )
                        .replace(R.id.contentContainer, SecondFragment.newInstance())
                        .addToBackStack(null)
                        .commit();
            



                //Toast.makeText(getApplicationContext() , "To Second Fragment" , Toast.LENGTH_SHORT).show();
                return  true;
             default:
               return super.onOptionsItemSelected(item);
        }

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("someVarA", "tumtrick");

    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        //TUM
        someVarA = savedInstanceState.getString("someVarA");



    }
}
