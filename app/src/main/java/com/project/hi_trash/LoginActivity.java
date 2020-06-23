package com.project.hi_trash;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.textfield.TextInputLayout;
import com.project.hi_trash.SessionManager.SessionManager;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class LoginActivity extends AppCompatActivity {

    EditText nama_penggunav, kata_sandiv;
    SessionManager sessionManager;

    private RequestQueue queue;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        queue = Volley.newRequestQueue(LoginActivity.this);
        sessionManager = new SessionManager(LoginActivity.this);
        String id = sessionManager.getNamaPengguna();
        if (id != null) {
            Intent main = new Intent(LoginActivity.this, HomeActivity.class);
            startActivity(main);
            finish();
        }


        TextView daftar = findViewById(R.id.buat);
        daftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this, DaftarActivity.class));

            }
        });


        nama_penggunav = findViewById(R.id.nama);
        kata_sandiv = findViewById(R.id.password);

        Button masuk = findViewById(R.id.masuk);
        masuk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                confirmInputLogin();
            }
        });

    }


    private boolean validateEmail() {
        String emailInput = nama_penggunav.getText().toString().trim();

        if (emailInput.isEmpty()) {
            nama_penggunav.setError("Email harus diisi");
            return false;
        } else {
            nama_penggunav.setError(null);
            return true;
        }
    }

    private boolean validatePassword() {
        String passwordInput = kata_sandiv.getText().toString().trim();

        if (passwordInput.isEmpty()) {
            kata_sandiv.setError("Password harus diisi");
            return false;
        } else {
            kata_sandiv.setError(null);
            return true;
        }
    }

    private void Login() {

        StringRequest stringRequest = new StringRequest(Request.Method.POST, Url.API_LOGIN,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            String status = jsonObject.getString("status");
                            String message = jsonObject.getString("message");

                            if (status.equals("false")) {
                                Toast.makeText(LoginActivity.this, "Login gagal" + message.toString(), Toast.LENGTH_SHORT).show();
                            } else {
                                JSONObject data = jsonObject.getJSONObject("data");

                                String nama_pengguna = data.getString("nama_pengguna");
                                String statusv = data.getString("status");

                                sessionManager.createSession(nama_pengguna,statusv);

                                Toast.makeText(LoginActivity.this, "Login berhasil", Toast.LENGTH_SHORT).show();
                                Intent main = new Intent(LoginActivity.this, HomeActivity.class);
                                startActivity(main);
                                finish();


                            }
                        } catch (Exception e) {
                            Toast.makeText(LoginActivity.this, "Error\n" + e.toString(), Toast.LENGTH_SHORT).show();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(LoginActivity.this, "Login eror ?\n" + error.toString(), Toast.LENGTH_SHORT).show();
            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("nama_pengguna", nama_penggunav.getText().toString().trim());
                params.put("kata_sandi", kata_sandiv.getText().toString().trim());
                return params;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }

    public void confirmInputLogin() {
        if (validateEmail() && validatePassword()) {
            Login();
        }
    }
}
