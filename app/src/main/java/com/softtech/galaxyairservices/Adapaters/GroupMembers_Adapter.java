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

public class GroupMembers_Adapter extends RecyclerView.Adapter<GroupMembers_Adapter.GroupMembers_ViewHolder> {

    private Context mContext;
    private List<GetterSetter> groupMemberList;

    public GroupMembers_Adapter(Context mContext, List<GetterSetter> groupMemberList) {
        this.mContext = mContext;
        this.groupMemberList = groupMemberList;
    }

    @NonNull
    @Override
    public GroupMembers_ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.group_list_view, parent, false);
        return new GroupMembers_ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GroupMembers_ViewHolder holder, int position) {

        GetterSetter getterSetter = groupMemberList.get(position);
        holder.txt_memberName.setText(getterSetter.getName());
        holder.txt_emailAddress.setText(getterSetter.getEmail());
        holder.txt_mobileNumber.setText(getterSetter.getMobile());
        holder.txt_organizationName.setText(getterSetter.getOrganizationName());
        holder.txt_groupName.setText(getterSetter.getGroupName());

    }

    @Override
    public int getItemCount() {
        return groupMemberList.size();
    }

    class GroupMembers_ViewHolder extends RecyclerView.ViewHolder{

        TextView txt_memberName, txt_emailAddress, txt_mobileNumber, txt_organizationName, txt_groupName;

        public GroupMembers_ViewHolder(@NonNull View itemView) {
            super(itemView);

            txt_memberName = itemView.findViewById(R.id.id_userName);
            txt_emailAddress = itemView.findViewById(R.id.id_userEmail);
            txt_mobileNumber = itemView.findViewById(R.id.id_contact);
            txt_organizationName = itemView.findViewById(R.id.id_organization);
            txt_groupName = itemView.findViewById(R.id.id_organization);
        }
    }
}
