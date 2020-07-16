package br.com.adley.wtest.ui.home;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import br.com.adley.wtest.R;

public class HomeFragment extends Fragment {

    private EditText mEmail;
    private Spinner mOptions;
    private Button mValidateBtn;


    public View onCreateView(@NonNull LayoutInflater inflater,
            ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        mOptions = root.findViewById(R.id.spinner_options);
        mEmail = root.findViewById(R.id.text_email);
        mValidateBtn = root.findViewById(R.id.button_validate);

        // Set options for the spinner
        String[] items = new String[]{"Mau", "Satisfatorio", "Bom", "Muito Bom", "Excelente"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String> (getContext(), android.R.layout.simple_spinner_item, items);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mOptions.setAdapter(adapter);

        //TODO
        // Add date picker to date input

        mValidateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hideKeyboard(getActivity());
                if(!ValidateEmail(mEmail.getText().toString())){
                    Toast.makeText(getContext(), "INVALID EMAIL", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getContext(), "VALID EMAIL", Toast.LENGTH_SHORT).show();
                }
            }
        });

        return root;
    }


    private boolean ValidateEmail(String email) {
        Pattern pattern = Patterns.EMAIL_ADDRESS;
        return pattern.matcher(email).matches();
    }

    public static void hideKeyboard(Activity activity) {
        InputMethodManager imm = (InputMethodManager) activity.getSystemService(Activity.INPUT_METHOD_SERVICE);
        //Find the currently focused view, so we can grab the correct window token from it.
        View view = activity.getCurrentFocus();
        //If no view currently has focus, create a new one, just so we can grab a window token from it
        if (view == null) {
            view = new View(activity);
        }
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    @Override
    public void onResume() {
        super.onResume();

    }
}