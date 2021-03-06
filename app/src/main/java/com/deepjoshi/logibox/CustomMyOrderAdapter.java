package com.deepjoshi.logibox;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Hp on 2/16/2017.
 */

public class CustomMyOrderAdapter extends BaseAdapter {
    Context context ;
     ArrayList<MyorderModel> myorderModels ;



    public CustomMyOrderAdapter (Context context, ArrayList<MyorderModel> myorderModels) {
        //super(context , android.R.layout.single_row_myorder,ordername);
        this.context = context;
       // inflater = LayoutInflater.from(context);
        this.myorderModels =myorderModels ;

    }



    @Override
    public int getCount() {
        return myorderModels.size() ;
    }

    @Override
    public Object getItem(int position) {
        return myorderModels .get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
        static class ViewHolder
        {
            TextView textordername;
            TextView textfrom;
            TextView textto;
            TextView textprice;
         //   MaterialLetterIcon icon;

        }



    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
       // return null;
         ViewHolder holder ;
        if(convertView ==null ) {
            holder = new ViewHolder();
            convertView = LayoutInflater.from(context).inflate(R.layout.single_row_myorder, parent, false);
            holder.textordername = (TextView) convertView.findViewById(R.id.my_order_name1 );
            holder.textfrom = (TextView) convertView.findViewById(R.id.my_order_from1 );
            holder.textto = (TextView) convertView.findViewById(R.id.my_order_to1);
            holder.textprice = (TextView) convertView.findViewById(R.id.my_order_price1);
           // holder.icon=(MaterialLetterIcon)convertView.findViewById(R.id.row_schedule_image);
            convertView .setTag(holder) ;
        }
        else
         {
            holder=(ViewHolder)convertView .getTag() ;
        }
       // String subject=arrayList.get(Position).getOrder();
       // holder.icon.setLetter(String.valueOf(subject))
        holder .textordername .setText(myorderModels.get(position).getOrdername());
        holder .textfrom  .setText(myorderModels.get(position).getFrom());
        holder .textto .setText(myorderModels.get(position).getTo());
        holder .textprice  .setText(myorderModels.get(position).getPrice());
        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent;
                intent = new Intent(context ,myorderdetail.class );
                intent .putExtra("position",position );
                context.startActivity(intent );
            }
        });
        return convertView;
    }

}
