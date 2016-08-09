package com.example.sivakavin.companyemployee.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.sivakavin.companyemployee.Model.Company;
import com.example.sivakavin.companyemployee.R;

import java.util.List;

/**
 * Created by sivakavin on 8/6/2016.
 */
public class ListCompaniesAdapter extends BaseAdapter {
    public static final String TAG = "ListCompnaiesAdapter";

    List<Company> mItems;
    Context context;

    public ListCompaniesAdapter(Context context, List<Company> listCompanies) {
        this.setItems(listCompanies);
        this.context=context;
    }

    public List<Company> getItems() {
        return mItems;
    }

    public void setItems(List<Company> mItems) {
        this.mItems = mItems;
    }


    @Override
    public int getCount() {
        return mItems.size();
    }

    @Override
    public Object getItem(int i) {
        return mItems.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View row=view;
        LayoutInflater inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        ViewHolder holder;
        if(row==null){
           row=inflater.inflate(R.layout.list_item_company,viewGroup,false);
           holder=new ViewHolder(row);
           row.setTag(holder);
        }else{
           holder= (ViewHolder) row.getTag();
        }

        Company currentItem= (Company) getItem(i);

           if(currentItem != null){
               holder.txtCompanyName.setText(currentItem.getmName());
               holder.txtAddress.setText(currentItem.getmAddress());
               holder.txtWebsite.setText(currentItem.getmWebsite());
               holder.txtPhoneNumber.setText(currentItem.getmPhoneNumber());
           }

        return row;
    }

    class ViewHolder {
        TextView txtCompanyName;
        TextView txtWebsite;
        TextView txtPhoneNumber;
        TextView txtAddress;
        public ViewHolder(View view){
            txtCompanyName= (TextView) view.findViewById(R.id.txt_company_name);
            txtAddress= (TextView) view.findViewById(R.id.txt_address);
            txtPhoneNumber= (TextView) view.findViewById(R.id.txt_phone_number);
            txtWebsite= (TextView) view.findViewById(R.id.txt_website);
        }
    }
}
