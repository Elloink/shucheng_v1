package com.yanxiaobo.shucheng.v1.adapter;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.RadioButton;
import android.widget.TextView;

import com.yanxiaobo.shucheng.v1.R;
import com.yanxiaobo.shucheng.v1.entity.Address;
import com.yanxiaobo.shucheng.v1.precenter.IAddressPrecenter;

public class AddressAdapter extends BaseAdapter{
	private Context context;
	private List<Address> lists;
	private IAddressPrecenter precenter;
	
	
	public AddressAdapter(Context context, List<Address> lists,IAddressPrecenter precenter) {
		super();
		this.context = context;
		this.lists = lists;
		this.precenter = precenter;
	}

	@Override
	public int getCount() {
		return lists.size();
	}

	@Override
	public Address getItem(int position) {
		return lists.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		final Address address = lists.get(position);
		ViewHolder holder = null;
		if(convertView == null){
			LayoutInflater inflater = LayoutInflater.from(context);
			convertView = inflater.inflate(R.layout.address_list_format, null);
			holder = new ViewHolder();
			holder.tvReceiveName = (TextView) convertView.findViewById(R.id.tv_receive_name);
			holder.tvMobile = (TextView) convertView.findViewById(R.id.tv_phone);
			holder.tvFullAdd = (TextView) convertView.findViewById(R.id.tv_full_address);
			holder.rbDefault = (RadioButton) convertView.findViewById(R.id.rb_default);
			holder.rbEdit = (RadioButton) convertView.findViewById(R.id.rb_edit);
			holder.rbDelete = (RadioButton) convertView.findViewById(R.id.rb_delete);
			convertView.setTag(holder);
		}
		holder = (ViewHolder) convertView.getTag();
		holder.tvReceiveName.setText(address.getReceiveName());
		holder.tvMobile.setText(address.getMobile());
		holder.tvFullAdd.setText(address.getFull_address());
		holder.rbDefault.setChecked(address.getIs_default()==1?true:false);
		holder.rbDefault.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				precenter.setDefaultAddress(address.getId());
			}
		});
		return convertView;
	}
	
	class ViewHolder{
		TextView tvReceiveName;
		TextView tvMobile;
		TextView tvFullAdd;
		RadioButton rbDefault;
		RadioButton rbEdit;
		RadioButton rbDelete;
	}
}
