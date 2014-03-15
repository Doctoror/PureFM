package com.docd.purefm.ui.dialogs;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.docd.purefm.R;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class ProgressAlertDialogBuilder {

    private ProgressAlertDialogBuilder() {
        //empty
    }

    /**
     * Creates a non-cancelable {@link AlertDialog} with progress bar and Cancel button
     *
     * @param context Current Context
     * @param messageResId Message text res id
     * @param cancelListener Cancel button listener
     * @return non-cancelable {@link AlertDialog} with progress bar and Cancel button
     */
    public static Dialog create(@NotNull final Context context,
                                final int messageResId,
                                @Nullable final DialogInterface.OnClickListener cancelListener) {
        return create(context, messageResId <= 0 ? null :
                context.getText(messageResId),cancelListener);
    }

    /**
     * Creates a non-cancelable {@link AlertDialog} with progress bar and Cancel button
     *
     * @param context Current Context
     * @param message Message text
     * @param cancelListener Cancel button listener
     * @return non-cancelable {@link AlertDialog} with progress bar and Cancel button
     */
    public static Dialog create(@NotNull final Context context,
                                @Nullable final CharSequence message,
                                @Nullable final DialogInterface.OnClickListener cancelListener) {
        final AlertDialog.Builder b = new AlertDialog.Builder(context);
        b.setCancelable(false);
        final View view = LayoutInflater.from(context).inflate(R.layout.dialog_progress, null);
        if (message != null) {
            final TextView messageView = (TextView) view.findViewById(android.R.id.message);
            messageView.setText(message);
            messageView.setVisibility(View.VISIBLE);
        }
        b.setView(view);
        b.setNegativeButton(android.R.string.cancel, cancelListener);
        return b.create();
    }

}
