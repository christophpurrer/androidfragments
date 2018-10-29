package androidfragments.christophpurrer;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity implements MainActivityListener {

    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            navigateTo(new ListFragment(), null);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.addSubMenu(0, 1, 0, "Settings");
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == 1) {
            startActivity(new Intent(MainActivity.this, SettingsActivity.class));
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onItemSelected(String itemId) {
        // Show DetailsFragments
        Log.d(TAG, "onItemSelected: " + itemId);
        navigateTo(DetailsFragment.newInstance(itemId), itemId);
    }

    private void navigateTo(Fragment fragment, String backStackId) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction().replace
                (R.id.main_fragment, fragment);
        if (backStackId != null) {
            ft.addToBackStack(backStackId);
        }
        ft.commit();
    }
}

interface MainActivityListener {

    void onItemSelected(String itemId);
}
