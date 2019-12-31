package ru.tenant.pass24.profileFragments;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TimePicker;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;

import java.util.Calendar;

import ru.tenant.pass24.R;
import ru.tenant.pass24.profileFragments.requests.RequestTypeFragment;
import ru.tenant.pass24.profileFragments.requests.newConfidance.RequestConfidantFragment;

public class ValidityFragment extends Fragment {
    Calendar startDataTime = Calendar.getInstance();
    Calendar expirestDataTime = Calendar.getInstance();
    DatePickerDialog.OnDateSetListener expiresDataListener = new DatePickerDialog.OnDateSetListener() {
        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
            expirestDataTime.set(Calendar.YEAR, year);
            expirestDataTime.set(Calendar.MONTH, monthOfYear);
            expirestDataTime.set(Calendar.DAY_OF_MONTH, dayOfMonth);
            String monthName = "";
            switch (monthOfYear) {
                case 0:
                    monthName = "янв";
                    break;
                case 1:
                    monthName = "фев";
                    break;
                case 2:
                    monthName = "марта";
                    break;
                case 3:
                    monthName = "апр";
                    break;
                case 4:
                    monthName = "мая";
                    break;
                case 5:
                    monthName = "июня";
                    break;
                case 6:
                    monthName = "июля";
                    break;
                case 7:
                    monthName = "авг";
                    break;
                case 8:
                    monthName = "сен";
                    break;
                case 9:
                    monthName = "окт";
                    break;
                case 10:
                    monthName = "ноя";
                    break;
                case 11:
                    monthName = "дек";
                    break;
            }
            tvDataEditExpires.setText(dayOfMonth + " " + monthName + "");
        }
    };
    TimePickerDialog.OnTimeSetListener expiresTimeListener = new TimePickerDialog.OnTimeSetListener() {
        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
            expirestDataTime.set(Calendar.HOUR_OF_DAY, hourOfDay);
            expirestDataTime.set(Calendar.MINUTE, minute);
            tvTimeEditExpires.setText(expirestDataTime.getTime().toString().substring(11, 16));
        }
    };
    TimePickerDialog.OnTimeSetListener startTimeListener = new TimePickerDialog.OnTimeSetListener() {
        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
            startDataTime.set(Calendar.HOUR_OF_DAY, hourOfDay);
            startDataTime.set(Calendar.MINUTE, minute);
            tvTimeEditStart.setText(startDataTime.getTime().toString().substring(11, 16));
        }
    };
    private TextView tvDataEditStart, tvTimeEditStart, tvTimeEditExpires, tvDataEditExpires;
    DatePickerDialog.OnDateSetListener startDataListener = new DatePickerDialog.OnDateSetListener() {
        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
            startDataTime.set(Calendar.YEAR, year);
            startDataTime.set(Calendar.MONTH, monthOfYear);
            startDataTime.set(Calendar.DAY_OF_MONTH, dayOfMonth);
            String monthName = "";
            switch (monthOfYear) {
                case 0:
                    monthName = "янв";
                    break;
                case 1:
                    monthName = "фев";
                    break;
                case 2:
                    monthName = "марта";
                    break;
                case 3:
                    monthName = "апр";
                    break;
                case 4:
                    monthName = "мая";
                    break;
                case 5:
                    monthName = "июня";
                    break;
                case 6:
                    monthName = "июля";
                    break;
                case 7:
                    monthName = "авг";
                    break;
                case 8:
                    monthName = "сен";
                    break;
                case 9:
                    monthName = "окт";
                    break;
                case 10:
                    monthName = "ноя";
                    break;
                case 11:
                    monthName = "дек";
                    break;
            }
            tvDataEditStart.setText(dayOfMonth + " " + monthName + "");
        }
    };
    private ImageView backBtn;

    public static String MillstoDateNum(long inp) {
        String out = "";
        out = new DateTime(inp, DateTimeZone.getDefault()).toString("dd.MM.yyyy HH:mm");
        return out;
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_visit_time, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        init(view);
    }

    private void init(View view) {
        tvDataEditStart = view.findViewById(R.id.tvDataEditStart);
        tvTimeEditStart = view.findViewById(R.id.tvTimeEditStart);
        tvTimeEditExpires = view.findViewById(R.id.tvTimeEditExpires);
        tvDataEditExpires = view.findViewById(R.id.tvDataEditExpires);
        backBtn = view.findViewById(R.id.backBtn);

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toRequestConfidantFragment();
            }
        });
        tvTimeEditStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setStartTime();
            }
        });

        tvDataEditStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setStartDate();
            }
        });

        tvDataEditExpires.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setExpiresDate();
            }
        });

        tvTimeEditExpires.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setExpiresTime();
            }
        });
    }

    public void setStartDate() {
        new DatePickerDialog(this.getContext(), startDataListener,
                startDataTime.get(Calendar.YEAR),
                startDataTime.get(Calendar.MONTH),
                startDataTime.get(Calendar.DAY_OF_MONTH))
                .show();
    }

    public void setStartTime() {
        new TimePickerDialog(this.getContext(), startTimeListener,
                startDataTime.get(Calendar.HOUR_OF_DAY),
                startDataTime.get(Calendar.MINUTE), true)
                .show();
    }

    public void setExpiresDate() {
        new DatePickerDialog(this.getContext(), expiresDataListener,
                expirestDataTime.get(Calendar.YEAR),
                expirestDataTime.get(Calendar.MONTH),
                expirestDataTime.get(Calendar.DAY_OF_MONTH))
                .show();
    }

    public void setExpiresTime() {
        new TimePickerDialog(this.getContext(), expiresTimeListener,
                expirestDataTime.get(Calendar.HOUR_OF_DAY),
                expirestDataTime.get(Calendar.MINUTE), true)
                .show();
    }

    public void toRequestConfidantFragment() {
        if (startDataTime != null) {
            Bundle bundle = new Bundle();
            bundle.putString("startsAt", MillstoDateNum(startDataTime.getTimeInMillis()));
            bundle.putString("expiresAt", MillstoDateNum(expirestDataTime.getTimeInMillis()));
            RequestConfidantFragment requestConfidantFragment = RequestConfidantFragment.getInstance();
            requestConfidantFragment.setArguments(bundle);
            getFragmentManager()
                    .beginTransaction()
                    .replace(R.id.flRequestsContainer, requestConfidantFragment)
                    .addToBackStack(RequestTypeFragment.TAG)
                    .commit();
        } else {
            getFragmentManager()
                    .beginTransaction()
                    .replace(R.id.flRequestsContainer, RequestConfidantFragment.getInstance())
                    .addToBackStack(RequestTypeFragment.TAG)
                    .commit();
        }
    }


}
