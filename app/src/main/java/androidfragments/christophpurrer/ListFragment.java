package androidfragments.christophpurrer;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;

import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ArrayAdapter;

public class ListFragment extends android.support.v4.app.ListFragment {

    private MainActivityListener mMainActivityListener;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup
            container, @Nullable Bundle savedInstanceState) {
        // Setup UI
        return inflater.inflate(R.layout.fragment_list, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        // Load data from db
        ArrayAdapter adapter = new ArrayAdapter<>(requireContext(), android.R.layout
                .simple_list_item_1, new String[]{
                "uno", "dos", "tres", "cuatro", "cinco", "seis"
        });
        setListAdapter(adapter);

        // Setup UX
        getListView().setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,
                                    long id) {
                String value = getListAdapter().getItem(position).toString();
                mMainActivityListener.onItemSelected(value);
            }
        });

        getListView().setOnItemLongClickListener(new OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int
                    position, long id) {
                String value = getListAdapter().getItem(position).toString();
                ConfirmDeleteFragment.newInstance(value).show(getChildFragmentManager()
                        , ConfirmDeleteFragment.class.getName());
                return true;
            }
        });
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mMainActivityListener = (MainActivityListener) context;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mMainActivityListener = null;
    }
}
