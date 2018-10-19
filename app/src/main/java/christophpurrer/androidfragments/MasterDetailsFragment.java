package christophpurrer.androidfragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;

public class MasterDetailsFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_master_detail, container, false);

        // Handle button clicks
        OnClickListener onClickListener =
                new OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        switch (v.getId()) {
                            case R.id.master_detail_composer:
                                Navigator.navigateTo(getChildFragmentManager(), new ComposerFragment(), "Composer");
                                break;
                            case R.id.master_detail_email1:
                                Navigator.navigateTo(getChildFragmentManager(), DetailsFragment.newInstance("Email 1"), "Email 1");
                                break;
                            case R.id.master_detail_email2:
                                Navigator.navigateTo(getChildFragmentManager(), DetailsFragment.newInstance("Email 2"), "Email 2");
                                break;
                            default:
                                break;
                        }
                    }
                };
        view.findViewById(R.id.master_detail_composer).setOnClickListener(onClickListener);
        view.findViewById(R.id.master_detail_email1).setOnClickListener(onClickListener);
        view.findViewById(R.id.master_detail_email2).setOnClickListener(onClickListener);
        return view;
    }
}
