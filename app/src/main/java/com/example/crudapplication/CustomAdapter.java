package com.example.crudapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class CustomAdapter extends BaseAdapter {

    Context context;
    Employee[] employees;
    LayoutInflater inflater;

    public CustomAdapter(Context applicationContext, Employee[] employees) {
        this.context = applicationContext;
        this.employees = employees;
        inflater = LayoutInflater.from(applicationContext);
    }

    @Override
    public int getCount() {
        return employees.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        view = inflater.inflate(R.layout.activity_list_emp, null);
        TextView id = view.findViewById(R.id.id);
        TextView name = view.findViewById(R.id.name);

        id.setText(employees[i].getId());
        name.setText(employees[i].getName());
        return view;
    }
}
