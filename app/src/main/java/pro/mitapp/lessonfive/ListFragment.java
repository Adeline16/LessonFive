package pro.mitapp.lessonfive;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentResultListener;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class ListFragment extends Fragment {

    FragmentAdapter fragmentAdapter;
    FloatingActionButton btnOpenAdd;
    RecyclerView rvTask;
    FragmentAdapter adapter;
    EditText et_title;
    Button btn_add;


    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;
    private FloatingActionButton fab;

    public ListFragment() {
    }



    public static ListFragment newInstance(String param1, String param2) {
        ListFragment fragment = new ListFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        adapter = new FragmentAdapter(requireContext());
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });



    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list, container,false);
        rvTask = view.findViewById(R.id.rv_task);
        btnOpenAdd = view.findViewById(R.id.btn_open_add_task);

        rvTask.setLayoutManager(new LinearLayoutManager(requireContext()));
        getActivity().getSupportFragmentManager().setFragmentResultListener("title", this, new FragmentResultListener() {
            @Override
            public void onFragmentResult(@NonNull String requestKey, @NonNull Bundle result) {
                adapter.addTask(result.getString("title"));
                Toast.makeText(requireContext(), result.getString("title"), Toast.LENGTH_SHORT).show();
            }
        });
        btnOpenAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().beginTransaction().addToBackStack( "AddTaskFragment").replace(R.id.fragment_container , new AddTaskFragment()).commit();

            }
        });
        rvTask.setAdapter(adapter);
        return view;


    }
}