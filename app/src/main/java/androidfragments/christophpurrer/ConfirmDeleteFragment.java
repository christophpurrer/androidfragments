package androidfragments.christophpurrer;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.util.Log;

public class ConfirmDeleteFragment extends DialogFragment {

    private static final String TAG = ConfirmDeleteFragment.class.getSimpleName();

    public static ConfirmDeleteFragment newInstance(String title) {
        ConfirmDeleteFragment frag = new ConfirmDeleteFragment();
        Bundle args = new Bundle();
        args.putString("title", title);
        frag.setArguments(args);
        return frag;
    }

    @Override
    @NonNull
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        final String title = getArguments().getString("title");
        return new AlertDialog.Builder(requireContext())
                .setTitle(title)
                .setPositiveButton(android.R.string.ok,
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int whichButton) {
                                Log.d(TAG, "ConfirmDeleteFragment: " + title + " > ok");
                            }
                        }
                )
                .setNegativeButton(android.R.string.cancel,
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int whichButton) {
                                Log.d(TAG, "ConfirmDeleteFragment" + title + " > cancel");
                            }
                        }
                )
                .create();
    }
}
