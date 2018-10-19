package christophpurrer.androidfragments;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

class Navigator {

    static void navigateTo(FragmentManager fragmentManager, Fragment fragment, String backStackName) {
        // Begin the transaction
        fragmentManager.beginTransaction()
                // Replace the contents of the container with the new fragment
                .replace(R.id.main_fragment, fragment, backStackName)
                // Add to parent (activity or fragment) backstack
                .addToBackStack(backStackName)
                // Commit
                .commit();
    }
}