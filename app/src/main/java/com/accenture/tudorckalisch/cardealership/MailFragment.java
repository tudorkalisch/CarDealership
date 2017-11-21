package com.accenture.tudorckalisch.cardealership;

import android.app.Fragment;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by tudor.c.kalisch on 21-Nov-17.
 */

public class MailFragment extends Fragment {
    EditText etEmail,etSubject,etText,etCC;
    Button btSend;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_mail, container, false);

        etEmail = v.findViewById(R.id.etEmail);
        etCC = v.findViewById(R.id.etCC);
        etSubject = v.findViewById(R.id.etSubject);
        etText = v.findViewById(R.id.etText);
        btSend = v.findViewById(R.id.btSend);

        btSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = etEmail.getText().toString();
                String cc = etCC.getText().toString();
                String subject = etSubject.getText().toString();
                String text = etText.getText().toString();

                Log.i("Send email", "");
;
                Intent emailIntent = new Intent(Intent.ACTION_SEND);
                emailIntent.setData(Uri.parse("mailto:"));
                emailIntent.setType("text/plain");


                emailIntent.putExtra(Intent.EXTRA_EMAIL, email);
                emailIntent.putExtra(Intent.EXTRA_CC, cc);
                emailIntent.putExtra(Intent.EXTRA_SUBJECT, subject);
                emailIntent.putExtra(Intent.EXTRA_TEXT, text);

                try {
                    startActivity(Intent.createChooser(emailIntent, "Send mail..."));
                    Log.i("Finished sending email...", "");
                } catch (android.content.ActivityNotFoundException ex) {
                    Toast.makeText(getActivity(),
                            "There is no email client installed.", Toast.LENGTH_SHORT).show();
                }
            }
        });
        return v;


    }
}
