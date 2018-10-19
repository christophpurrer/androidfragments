package christophpurrer.androidfragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class DetailsFragment extends Fragment {

    public static final String KEY_CONTENT = "content";

    public static Fragment newInstance(String content) {
        Fragment fragment = new DetailsFragment();
        Bundle bundle = new Bundle();
        bundle.putString(KEY_CONTENT, content);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater,
            @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_details, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        String content = getArguments() != null ? getArguments().getString(KEY_CONTENT) : null;
        ((TextView) view.findViewById(R.id.details_text)).setText(content);
    }
}