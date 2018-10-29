package androidfragments.christophpurrer;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class DetailsFragment extends Fragment {

    static DetailsFragment newInstance(String itemId) {
        Bundle bundle = new Bundle();
        bundle.putString("ITEM_ID", itemId);
        DetailsFragment fragment = new DetailsFragment();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup
            container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_details, container, false);
        ((TextView) view.findViewById(R.id.details_text)).setText(getArguments().getString
                ("ITEM_ID"));
        return view;
    }
}
