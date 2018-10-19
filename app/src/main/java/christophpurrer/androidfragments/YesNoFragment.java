package christophpurrer.androidfragments;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;

public class YesNoFragment extends DialogFragment {

    private MainActivityListener mListener = null;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof MainActivityListener) {
            mListener = (MainActivityListener) context;
        } else {
            throw new IllegalStateException("parent must be MainActivityListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        return new AlertDialog.Builder(getContext())
                .setIcon(R.drawable.ic_launcher_background)
                .setTitle("Question to ask")
                .setPositiveButton(android.R.string.ok,
                        new OnClickListener() {
                            public void onClick(DialogInterface dialog, int whichButton) {
                                mListener.onSelect(getString(android.R.string.ok));
                            }
                        }
                )
                .setNegativeButton(android.R.string.cancel,
                        new OnClickListener() {
                            public void onClick(DialogInterface dialog, int whichButton) {
                                mListener.onSelect(getString(android.R.string.cancel));
                            }
                        }
                )
                .create();
    }
}