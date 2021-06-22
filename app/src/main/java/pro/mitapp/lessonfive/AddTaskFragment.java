package pro.mitapp.lessonfive;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentResultListener;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddTaskFragment extends Fragment {

    EditText etText;
    Button btnAddTask;

    private static final String ARG_PARAM1 = "param1";

    private String mParam1;

    public AddTaskFragment() {
    }

    public static AddTaskFragment newInstance(String title) {
        AddTaskFragment fragment = new AddTaskFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, title);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.add_new_task_fragment, container, false);
        etText = view.findViewById(R.id.et_send);
        btnAddTask = view.findViewById(R.id.btn_send);
       btnAddTask.setOnClickListener(new View.OnClickListener() {
           @Override
            public void onClick(View v) {
               Bundle bundle = new Bundle();
               bundle.putString("title", etText.getText().toString());
                getActivity().getSupportFragmentManager().setFragmentResult("title", bundle);
                getActivity().getSupportFragmentManager().popBackStack();
           }
        });
        return view;
    }
}