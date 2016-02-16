package com.tumtrick.mvcstructure.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.tumtrick.mvcstructure.R;

/**
 * Created by Thipphakone on 25/01/2016.
 */
public class TwoFragment extends Fragment {
    View rootView;
    String _FirstName ;
    private Button btnCloseTwo;


    public static TwoFragment newInstance(String StrFirstname) {
        TwoFragment twoFragment = new TwoFragment();
        Bundle args = new Bundle();
        args.putString("FirstName" , StrFirstname);
        twoFragment.setArguments(args);
        return twoFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        _FirstName = getArguments().getString("FirstName");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        rootView = inflater.inflate(R.layout.fragment_two , container , false );

        BindWidget();

        Toast.makeText(getActivity() , "First Name : " + _FirstName , Toast.LENGTH_SHORT).show();

        btnCloseTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //getFragmentManager().beginTransaction().remove(OneFragment.this).commit();
                getFragmentManager().popBackStack();
            }
        });
        return rootView;
    }

    private void BindWidget() {
        btnCloseTwo = (Button)rootView.findViewById(R.id.btnCloseTwo);
    }
}
