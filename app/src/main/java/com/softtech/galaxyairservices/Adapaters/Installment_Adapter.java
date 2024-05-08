package com.softtech.galaxyairservices.Adapaters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.softtech.galaxyairservices.Models.GetterSetter;
import com.softtech.galaxyairservices.R;

import java.util.List;

public class Installment_Adapter extends RecyclerView.Adapter<Installment_Adapter.InstallmentViewHolder> {

    Context mContext;
    private List<GetterSetter> installmentList;

    public Installment_Adapter(Context mContext, List<GetterSetter> installmentList) {
        this.mContext = mContext;
        this.installmentList = installmentList;
    }

    @NonNull
    @Override
    public InstallmentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.installment_list_view, parent, false);

        return new InstallmentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull InstallmentViewHolder holder, int position) {

        GetterSetter user_installment = installmentList.get(position);
        holder.txt_TotalAmount.setText("Total Amount: "+user_installment.getTotal_amount());
        holder.txt_PaidAmount.setText("Paid Installment: "+user_installment.getPaid_amount());
        holder.txt_RemainingAmount.setText("Balance Due: "+user_installment.getRemaining_amount());

    }

    @Override
    public int getItemCount() {
        return installmentList.size();
    }

    class InstallmentViewHolder extends RecyclerView.ViewHolder{

        TextView txt_TotalAmount, txt_PaidAmount, txt_RemainingAmount;

        public InstallmentViewHolder(@NonNull View itemView) {
            super(itemView);

            txt_TotalAmount = itemView.findViewById(R.id.id_TotalAmount);
            txt_PaidAmount = itemView.findViewById(R.id.id_paidAmount);
            txt_RemainingAmount = itemView.findViewById(R.id.id_remainAmount);
        }
    }
}
