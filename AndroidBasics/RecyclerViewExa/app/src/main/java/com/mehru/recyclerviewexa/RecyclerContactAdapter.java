package com.mehru.recyclerviewexa;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class RecyclerContactAdapter extends RecyclerView.Adapter<RecyclerContactAdapter.ViewHolder> {
    Context context;
    ArrayList<contactModel>arrContacts;
    RecyclerContactAdapter(Context applicationContext, ArrayList<contactModel> arrContacts){
        this.context = context;
        this.arrContacts = arrContacts;

    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.contact_card, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {


        holder.imgContact.setImageResource(arrContacts.get(position).img);
        holder.txtNumber.setText(arrContacts.get(position).number);
        holder.txtName.setText(arrContacts.get(position).name);

//        To Update an contact👇

        holder.ABCrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Dialog dialog = new Dialog(context);
                dialog.setContentView(R.layout.add_update_lay);

                EditText edtName =dialog.findViewById(R.id.txtName);
                EditText edtNumber = dialog.findViewById(R.id.txtNumber);
                Button btnAction = dialog.findViewById(R.id.btnAction);
                EditText txtTitle = dialog.findViewById(R.id.txtTitle);

                btnAction.setText("Update");
                txtTitle.setText("Update Contact");

                edtName.setText(arrContacts.get(position).name);
                edtNumber.setText(arrContacts.get(position).number);



                btnAction.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                          String name = "",number= "";
                        if (!edtName.getText().toString().equals("")){
                             name = edtName.getText().toString();
                        }else {
                            Toast.makeText(context, "Enter name", Toast.LENGTH_SHORT).show();
                        }
                        if (!edtNumber.getText().toString().equals("")) {
                             number=edtNumber.getText().toString();
                        } else {
                            Toast.makeText(context, "Enter Number", Toast.LENGTH_SHORT).show();
                        }

                        arrContacts.set(position,new contactModel(name,number));
                        notifyItemChanged(position);
                        dialog.dismiss();
                    }
                }); dialog.show();
            }
        });
//                     To delete an contact👇
        holder.ABCrow.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(context)
                        .setTitle("Delete Contact")
                        .setMessage("Are sure to delete ")
                        .setIcon(R.drawable.delete)
                        .setPositiveButton("yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                arrContacts.remove(position);
                                notifyItemRemoved(position);

                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        });builder.show();

                return true;

            }
        });
    }

    @Override
    public int getItemCount() {
        return arrContacts.size();
    }

    public  class ViewHolder extends RecyclerView.ViewHolder {

        TextView txtName , txtNumber;
        ImageView imgContact;
        LinearLayout ABCrow;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtName = itemView.findViewById(R.id.txtName);
            txtNumber = itemView.findViewById(R.id.txtNumber);
            imgContact = itemView.findViewById(R.id.imgContact);
            ABCrow = itemView.findViewById(R.id.ABCrow);
        }

    }
}