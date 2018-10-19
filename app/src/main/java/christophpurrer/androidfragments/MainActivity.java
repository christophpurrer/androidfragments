package christophpurrer.androidfragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements MainActivityListener {

    private TextView mValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Setup click listener
        final OnClickListener clickListener = new OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.main_dialog:
                        new YesNoFragment().show(getSupportFragmentManager(), null);
                        break;
                    case R.id.main_settings:
                        Navigator.navigateTo(getSupportFragmentManager(), new SettingsFragment(), null);
                        break;
                    case R.id.main_master_detail:
                        Navigator.navigateTo(getSupportFragmentManager(), new MasterDetailsFragment(), MasterDetailsFragment.class.getName());
                        break;
                    default:
                        throw new IllegalStateException("view not supported");
                }
            }
        };
        findViewById(R.id.main_dialog).setOnClickListener(clickListener);
        findViewById(R.id.main_settings).setOnClickListener(clickListener);
        findViewById(R.id.main_master_detail).setOnClickListener(clickListener);

        // Setup textView
        mValue = findViewById(R.id.main_value);
    }

    @Override
    public void onSelect(String value) {
        mValue.setText(value);
    }

    @Override
    public void onBackPressed() {
        String tag = getSupportFragmentManager()
                // Get top fragment
                .getBackStackEntryAt(getSupportFragmentManager().getBackStackEntryCount() - 1)
                // Get its name
                .getName();
        // Pop child fragment's fragmentManager if size > 0
        Fragment currentFragment = getSupportFragmentManager().findFragmentByTag(tag);
        if (currentFragment != null && currentFragment.getChildFragmentManager().getBackStackEntryCount() > 0) {
            currentFragment.getChildFragmentManager().popBackStack();
        } else {
            super.onBackPressed();
        }
    }
}

/**
 * Interface for Activity <> Fragment communication
 */
interface MainActivityListener {
    void onSelect(String value);
}
