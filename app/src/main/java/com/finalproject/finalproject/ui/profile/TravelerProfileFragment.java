package com.finalproject.finalproject.ui.profile;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import android.content.Context;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.finalproject.finalproject.R;
import com.finalproject.finalproject.collection.Traveler;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QueryDocumentSnapshot;

import java.util.List;
//import com.finalproject.finalproject.databinding.FragmentNotificationsBinding;


public class TravelerProfileFragment extends Fragment {

//    private FragmentNotificationsBinding binding;
    TextView name, mail,categories;
    Button editBtn;
    ListView listCategory;
    MyAdapter adapter;
    String [] arrCategory;
    TextView category,logout;
    final String[] categoriesArray={
            "amusement park","aquarium","art gallery","bar","casino",
            "museum","night club","park","shopping mall","spa",
            "tourist attraction","zoo", "bowling alley","cafe",
            "church","city hall","library","mosque", "synagogue"
    };
    final String[] categoriesArraySaveInMongoDb={
            "amusement_park","aquarium","art_gallery","bar","casino",
            "museum","night_club","park","shopping_mall","spa",
            "tourist_attraction","zoo", "bowling_alley","cafe",
            "church","city_hall","library","mosque", "synagogue"
    };
//    @RequiresApi(api = Build.VERSION_CODES.N)

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_traveler_profile, container, false);
//        categories = view.findViewById(R.id.traveler_profile_categories);
        editBtn = view.findViewById(R.id.traveler_profile_edit_btn);
        mail = view.findViewById(R.id.traveler_profile_email);
        name = view.findViewById(R.id.traveler_profile_name);
        listCategory=view.findViewById(R.id.traveler_profile_list_category);
//        Realm.init(getContext()); // context, usually an Activity or Application
//        App app = new App(new AppConfiguration.Builder(getString(R.string.AppId)).build());
//        User user = app.currentUser();
        logout=view.findViewById(R.id.traveler_profile_logout);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Navigation.findNavController(view).navigate(TravelerProfileFragmentDirections.actionNavProfileToLogoutActivity());
            }
        });
        FirebaseAuth auth = FirebaseAuth.getInstance();
        FirebaseUser user = auth.getCurrentUser();
        FirebaseFirestore db =FirebaseFirestore.getInstance();

//

        CollectionReference travelersRef = db.collection("Traveler");

// Query to get traveler by email
        Query query = travelersRef.whereEqualTo("travelerMail", user.getEmail());

        query.get().addOnCompleteListener(task -> {
            if (task.isSuccessful()) {
                for (QueryDocumentSnapshot document : task.getResult()) {
                    Traveler traveler = document.toObject(Traveler.class);

                    // Get favorite categories as a list
                    List<String> favoriteCategories = traveler.getFavoriteCategories();

                    // Set traveler name and mail
                    name.setText("Hello " + traveler.getTravelerName());
                    mail.setText(traveler.getTravelerMail());

                    // Convert favorite categories to an array
                    arrCategory = new String[favoriteCategories.size()];
                    favoriteCategories.toArray(arrCategory);

                    // Set up the adapter and list view
                    adapter = new MyAdapter();
                    listCategory.setAdapter(adapter);

                    // Set up edit button click listener
                    editBtn.setOnClickListener(v -> {
                        if (isNetworkConnected()) {
                            String[] arrayCategories = new String[favoriteCategories.size()];
                            favoriteCategories.toArray(arrayCategories);
//                             Navigate to edit profile fragment with traveler and favorite categories data
                            TravelerProfileFragmentDirections.ActionNavProfileToTravelerEditProfileFragment action = TravelerProfileFragmentDirections.actionNavProfileToTravelerEditProfileFragment(traveler, arrayCategories);
                             Navigation.findNavController(view).navigate(action);
                        } else {
                            Toast.makeText(getContext(), "Error! Connect to Internet", Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            } else {
                Log.d(TAG, "Error getting documents: ", task.getException());
            }
        });
//        Model.instance.getTravelerByEmailInDB(user.getProfile().getEmail(), getContext(), new Model.GetTravelerByEmailListener() {
//            @Override
//            public void onComplete(Traveler traveler, List<String> favoriteCategories) {
//                name.setText("Hello "+traveler.getTravelerName());
//                mail.setText(traveler.getTravelerMail());
//                arrCategory= new String[favoriteCategories.size()];
//                favoriteCategories.toArray(arrCategory);
//                adapter=new MyAdapter();
//                listCategory.setAdapter(adapter);
////                String c = favoriteCategories.stream()
////                                    .map(n -> String.valueOf(n))
////                                    .collect(Collectors.joining("\n", "", ""));
////                c=c.replace("_"," ");
////                categories.setText(c);
////                editBtn= view.findViewById(R.id.traveler_profile_edit_btn);
////                editBtn.setOnClickListener(new View.OnClickListener() {
////                    @Override
////                    public void onClick(View v) {
////                        if(isNetworkConnected()) {
////                            String[] arrayCategories = new String[favoriteCategories.size()];
////                            favoriteCategories.toArray(arrayCategories);
//////                            TravelerProfileFragmentDirections.ActionNavProfileToTravelerEditProfileFragment action = TravelerProfileFragmentDirections.actionNavProfileToTravelerEditProfileFragment(traveler, arrayCategories);
//////                            Navigation.findNavController(view).navigate(action);
////                        }
////                        else{
////                            Toast.makeText(getContext(), "Error! Connect to Internet", Toast.LENGTH_SHORT).show();
////                        }
////                    }
////                });
//            }
//        });

        return view;
    }
    private boolean isNetworkConnected() {
        ConnectivityManager cm = (ConnectivityManager) getContext().getSystemService(Context.CONNECTIVITY_SERVICE);

        return cm.getActiveNetworkInfo() != null && cm.getActiveNetworkInfo().isConnected();
    }
    class MyAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            if (arrCategory== null) {
                return 0;
            } else {
                return arrCategory.length;
            }
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            if (view == null) {
                LayoutInflater inflater = getLayoutInflater();
                view = inflater.inflate(R.layout.row_favorite_category, null);
            } else {

            }
            category = view.findViewById(R.id.row_favorite_category_text_view);
            String c = arrCategory[i];
            String a=c.replace('_',' ');
            category.setText(a);
            return view;
        }

    }

}
//        NotificationsViewModel notificationsViewModel =
//                new ViewModelProvider(this).get(NotificationsViewModel.class);
//
//        binding = FragmentNotificationsBinding.inflate(inflater, container, false);
//        View root = binding.getRoot();
//
//        return root;
//    }
//
//    @Override
//    public void onDestroyView() {
//        super.onDestroyView();
//        binding = null;
//    }
//}