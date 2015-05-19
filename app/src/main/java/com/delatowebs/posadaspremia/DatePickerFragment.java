package com.delatowebs.posadaspremia;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.widget.DatePicker;
import android.widget.EditText;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Created by santiago on 25/4/15.
 */
public class DatePickerFragment extends DialogFragment implements DatePickerDialog.OnDateSetListener {

    private EditText editTextAsociado = null;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the current date as the default date in the picker
        final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);

        // Create a new instance of DatePickerDialog and return it
        return new DatePickerDialog(getActivity(), this, year, month, day);
    }

    public void onDateSet(DatePicker view, int year, int month, int day) {

        EditText caller = (EditText) this.getEditTextAsociado();

        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

        Calendar calendar = new GregorianCalendar(year,month,day);

        String formatedDate = sdf.format(calendar.getTime());

        caller.setText(formatedDate);
    }

    public EditText getEditTextAsociado() {
        return editTextAsociado;
    }

    public void setEditTextAsociado(EditText editTextAsociado) {
        this.editTextAsociado = editTextAsociado;
    }
}