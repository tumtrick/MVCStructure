package com.tumtrick.mvcstructure.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.tumtrick.mvcstructure.R;

/**
 * Created by Thipphakone on 25/01/2016.
 */
public class MainFragment extends Fragment {

    Bundle savedState;
    private Button btnNext;
    int someVar ;
    String _Name ;
    private Button btnTwo;
    private TextView tvHellow;

    int x , y;
    String someVarA ,  someVarB;
    String _str;
    // Step 1 Create Bundle put argument
    public  static MainFragment newInstance(int someVar , String StrName) {
        MainFragment fragment = new MainFragment();
        Bundle args = new Bundle();   // Arguments
        args.putInt("someVar", someVar);
        args.putString("Name", StrName);
        fragment.setArguments(args);
        return fragment;
    }


    // Read data in Bundle
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        someVar = getArguments().getInt("someVar");
        _Name = getArguments().getString("Name");
        x =10;
        y =11;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);



        BindWidget(rootView);

       // Toast.makeText(getActivity() , "Variable : " + x + " , Name : " + y , Toast.LENGTH_SHORT).show();

        setEventListioner();


        return rootView;
    }


    private void setEventListioner() {
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*FragmentManager.beginTransaction()
                        .add(R.id.contentContainer, new OneFragment())
                        .commit(); */

                OneFragment oneFragment = new OneFragment();
                // FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                // transaction.add(R.id.contentContainer, oneFragment.newInstance("MANIVONG"));
                transaction.replace(R.id.contentContainer, oneFragment.newInstance("MANIVONG"));
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });

        btnTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TwoFragment twoFragment = new TwoFragment();
                // FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.add(R.id.contentContainer, twoFragment.newInstance("THIPPHAKONE"));
                //transaction.replace(R.id.contentContainer, twoFragment.newInstance("THIPPHAKONE"));
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });
    }


    private void BindWidget(View rootView) {
        tvHellow = (TextView)rootView.findViewById(R.id.tvHellow);
        btnNext = (Button)rootView.findViewById(R.id.btnNext);
        btnTwo = (Button)rootView.findViewById(R.id.btnTwo);
    }

    public void setHellowText (String text ) {
        tvHellow .setText(text);
    }


    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        // Save state here
        // ==>
        outState.putString("a", x + " and " + y);
       // outState.putString("someVarA", _Name);
    }



    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        // Restore State here
        // ==>
        if (savedInstanceState != null) {
            _str = savedInstanceState.getString("a");
            Toast.makeText(getActivity() , "Variable : " + _str , Toast.LENGTH_SHORT).show();
        }

    }


}
