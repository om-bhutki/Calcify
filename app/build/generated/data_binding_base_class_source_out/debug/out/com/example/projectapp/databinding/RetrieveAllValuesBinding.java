// Generated by view binder compiler. Do not edit!
package com.example.projectapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.widget.NestedScrollView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.projectapp.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class RetrieveAllValuesBinding implements ViewBinding {
  @NonNull
  private final NestedScrollView rootView;

  @NonNull
  public final EditText attendancePercent;

  @NonNull
  public final EditText avgTest;

  @NonNull
  public final Button clearBtn;

  @NonNull
  public final Button dataBtn;

  @NonNull
  public final EditText enrollmentNo;

  @NonNull
  public final ImageView imageView;

  @NonNull
  public final EditText month;

  @NonNull
  public final EditText presentDays;

  @NonNull
  public final EditText totalTermWork1;

  private RetrieveAllValuesBinding(@NonNull NestedScrollView rootView,
      @NonNull EditText attendancePercent, @NonNull EditText avgTest, @NonNull Button clearBtn,
      @NonNull Button dataBtn, @NonNull EditText enrollmentNo, @NonNull ImageView imageView,
      @NonNull EditText month, @NonNull EditText presentDays, @NonNull EditText totalTermWork1) {
    this.rootView = rootView;
    this.attendancePercent = attendancePercent;
    this.avgTest = avgTest;
    this.clearBtn = clearBtn;
    this.dataBtn = dataBtn;
    this.enrollmentNo = enrollmentNo;
    this.imageView = imageView;
    this.month = month;
    this.presentDays = presentDays;
    this.totalTermWork1 = totalTermWork1;
  }

  @Override
  @NonNull
  public NestedScrollView getRoot() {
    return rootView;
  }

  @NonNull
  public static RetrieveAllValuesBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static RetrieveAllValuesBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.retrieve_all_values, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static RetrieveAllValuesBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.attendance_percent;
      EditText attendancePercent = ViewBindings.findChildViewById(rootView, id);
      if (attendancePercent == null) {
        break missingId;
      }

      id = R.id.avgTest;
      EditText avgTest = ViewBindings.findChildViewById(rootView, id);
      if (avgTest == null) {
        break missingId;
      }

      id = R.id.clearBtn;
      Button clearBtn = ViewBindings.findChildViewById(rootView, id);
      if (clearBtn == null) {
        break missingId;
      }

      id = R.id.dataBtn;
      Button dataBtn = ViewBindings.findChildViewById(rootView, id);
      if (dataBtn == null) {
        break missingId;
      }

      id = R.id.enrollment_no;
      EditText enrollmentNo = ViewBindings.findChildViewById(rootView, id);
      if (enrollmentNo == null) {
        break missingId;
      }

      id = R.id.imageView;
      ImageView imageView = ViewBindings.findChildViewById(rootView, id);
      if (imageView == null) {
        break missingId;
      }

      id = R.id.month;
      EditText month = ViewBindings.findChildViewById(rootView, id);
      if (month == null) {
        break missingId;
      }

      id = R.id.presentDays;
      EditText presentDays = ViewBindings.findChildViewById(rootView, id);
      if (presentDays == null) {
        break missingId;
      }

      id = R.id.totalTermWork1;
      EditText totalTermWork1 = ViewBindings.findChildViewById(rootView, id);
      if (totalTermWork1 == null) {
        break missingId;
      }

      return new RetrieveAllValuesBinding((NestedScrollView) rootView, attendancePercent, avgTest,
          clearBtn, dataBtn, enrollmentNo, imageView, month, presentDays, totalTermWork1);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
