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
public class OneFragment extends Fragment {
    View rootView;
    String _SureName ;
    private Button btnCloseOne;



    public static OneFragment newInstance(String _StrSurName){
        OneFragment oneFragment = new OneFragment();
        Bundle args = new Bundle();   // Arguments
        args.putString("SureName" , _StrSurName);
        oneFragment.setArguments(args);

        return oneFragment;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        _SureName = getArguments().getString("SureName");

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        rootView = inflater.inflate(R.layout.fragment_one , container , false );

        BindWidget();

        Toast.makeText(getActivity() , "Sure Name : " +  _SureName , Toast.LENGTH_SHORT).show();


        btnCloseOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //getFragmentManager().beginTransaction().remove(OneFragment.this).commit();
                getFragmentManager().popBackStack();
            }
        });
        return rootView;
    }

    private void BindWidget() {
        btnCloseOne = (Button)rootView.findViewById(R.id.btnCloseOne);
    }
}
