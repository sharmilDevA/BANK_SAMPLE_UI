package com.example.novodemo;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {
    /*private static final int SELECT_PICTURE = 100;
    private static final String TAG = "selected image" ;
    Button upload;
    ImageView imageView;
    private ActivityResultLauncher<Intent> startActivityResultLauncher;*/

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public HomeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_home, container, false);
        try {
           // selectprofile(view);
            ArrayList<Subject> subjectArrayList = new ArrayList<>();
            subjectArrayList.add(new Subject("A Person", R.drawable.ic_baseline_person_pin_24));
            subjectArrayList.add(new Subject("B Person", R.drawable.ic_baseline_person_pin_24));
            subjectArrayList.add(new Subject("C Person", R.drawable.ic_baseline_person_pin_24));
            subjectArrayList.add(new Subject("D Person", R.drawable.ic_baseline_person_pin_24));
            subjectArrayList.add(new Subject("E Person", R.drawable.ic_baseline_person_pin_24));
            subjectArrayList.add(new Subject("F Person", R.drawable.ic_baseline_person_pin_24));
            subjectArrayList.add(new Subject("G Person", R.drawable.ic_baseline_person_pin_24));
            subjectArrayList.add(new Subject("H Person", R.drawable.ic_baseline_person_pin_24));
            subjectArrayList.add(new Subject("I Person", R.drawable.ic_baseline_person_pin_24));
            subjectArrayList.add(new Subject("J Person", R.drawable.ic_baseline_person_pin_24));

            RecyclerView recyclerView = view.findViewById(R.id.recyclerview);
            SubjectAdapter adapter = new SubjectAdapter(subjectArrayList);
            recyclerView.setAdapter(adapter);
            recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false));
        }catch(Exception ignored){
        }
        return view;
    }

   /* private void selectprofile(View v) {
        try {
            upload = v.findViewById(R.id.upload_item);
            imageView =v.findViewById(R.id.image_view);

            upload.setOnClickListener(view -> SelectPicture());
        }catch(Exception ignored){}
    }

    private void SelectPicture() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityResultLauncher.launch(intent);
    }
    startActivityResultLauncher = registerForActivityResult(
                    new ActivityResultContracts.StartActivityForResult(),
    result -> {
        if (result.getResultCode() == Activity.RESULT_OK) {
            Intent data = result.getData();
            if (data != null && data.getData() != null) {
                Uri selectedImageUri = data.getData();
                Bitmap selectedImageBitmap = null;
                try {
                    selectedImageBitmap = MediaStore.Images.Media.getBitmap(requireContext().getContentResolver(), selectedImageUri);
                } catch (Exception ignored) {
                    // Handle exceptions, log if needed
                }
                imageView.setImageBitmap(selectedImageBitmap);  // Set the selected image to the ImageView
            }
        }
    });*/
    private class SubjectAdapter extends RecyclerView.Adapter<SubjectAdapter.ViewHolder> {
        public class ViewHolder extends RecyclerView.ViewHolder{
            public ImageView subjectImageView;
            public TextView subjectTextView;

            public ViewHolder(@NonNull View itemView) {
                super(itemView);
                subjectImageView = itemView.findViewById(R.id.subject_image_view);
                subjectTextView = itemView.findViewById(R.id.subject_text_view);
            }
        }
        ArrayList<Subject> list;
        public SubjectAdapter(ArrayList<Subject> list){
            this.list = list;
        }
        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View contactView = LayoutInflater.from(parent.getContext()).inflate(R.layout.listview, parent, false);
            ViewHolder viewHolder = new ViewHolder(contactView);
            return viewHolder;
        }
        @Override
        public void onBindViewHolder(@NonNull SubjectAdapter.ViewHolder holder, int position) {
            Subject currentItem = list.get(position);

            ImageView imageView = holder.subjectImageView;
            imageView.setImageResource(currentItem.getImageId());
            TextView subjectTextView = holder.subjectTextView;
            subjectTextView.setText(currentItem.getSubject());
        }

        @Override
        public int getItemCount() {
            return list.size();
        }
    }
}