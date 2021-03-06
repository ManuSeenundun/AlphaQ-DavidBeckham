package dev.edmt.androidcamerarecognitiontext;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public class EmployeesAdapter extends RecyclerView.Adapter<EmployeesAdapter.ViewHolder> {

    private List<Employee> mEmployees;

    // Pass in the contact array into the constructor
    public EmployeesAdapter(List<Employee> employees) {
        mEmployees = employees;
    }

    // Provide a direct reference to each of the views within a data item
    // Used to cache the views within the item layout for fast access
    public class ViewHolder extends RecyclerView.ViewHolder {
        // Your holder should contain a member variable
        // for any view that will be set as you render a row
        public TextView nameTextView;
        public Button messageButton;

        // We also create a constructor that accepts the entire item row
        // and does the view lookups to find each subview
        public ViewHolder(View itemView) {
            // Stores the itemView in a public final member variable that can be used
            // to access the context from any ViewHolder instance.
            super(itemView);

            nameTextView = (TextView) itemView.findViewById(R.id.employee_name);
            messageButton = (Button) itemView.findViewById(R.id.message_button);
        }
    }

    // Usually involves inflating a layout from XML and returning the holder
    @Override
    public EmployeesAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View contactView = inflater.inflate(R.layout.item_employee, parent, false);

        // Return a new holder instance
        ViewHolder viewHolder = new ViewHolder(contactView);
        return viewHolder;
    }

    // Involves populating data into the item through holder
    @Override
    public void onBindViewHolder(EmployeesAdapter.ViewHolder viewHolder, int position) {
        // Get the data model based on position
        Employee employee = mEmployees.get(position);

        // Set item views based on your views and data model
        TextView textView = viewHolder.nameTextView;
        textView.setText(employee.getName());
        Button button = viewHolder.messageButton;
        button.setText(employee.getEmployeeId());
        button.setEnabled(true);
    }

    // Returns the total count of items in the list
    @Override
    public int getItemCount() {
        return mEmployees.size();
    }
}
