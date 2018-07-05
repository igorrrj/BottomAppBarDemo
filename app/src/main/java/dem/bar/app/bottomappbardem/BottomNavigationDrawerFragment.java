package dem.bar.app.bottomappbardem;

import android.content.Context;
import android.os.Bundle;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class BottomNavigationDrawerFragment extends BottomSheetDialogFragment {

    NavigationView navigationView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_bottomsheet, container, false);

        navigationView = view.findViewById(R.id.navigation_view);

        navigationView.setNavigationItemSelectedListener(

                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                        switch (item.getItemId()){

                            case R.id.nav1:
                                toast(getContext(),"Nav 1");
                                break;

                            case R.id.nav2:
                                toast(getContext(),"Nav 2");
                                break;

                            case R.id.nav3:
                                toast(getContext(),"Nav 3");
                                break;

                        }

                        return true;

                    }

                }
        );

        return view;

    }

    public void toast(Context context, String message){

        Toast toast = Toast.makeText(context,message,Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.BOTTOM,0,600);
        toast.show();

    }

}
