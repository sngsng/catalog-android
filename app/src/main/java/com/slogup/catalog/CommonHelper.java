package com.slogup.catalog;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.view.View;

import com.slogup.catalog.manager.AppManager;
import com.slogup.catalog.models.Product;
import com.slogup.catalog.network.APIConstants;

import java.text.NumberFormat;

public class CommonHelper {
    public static void showDialog(Context context, String msg, String actionTitle, final View.OnClickListener positiveCallback) {

        AlertDialog.Builder builder = new AlertDialog.Builder(context)
                .setMessage(msg)
                .setNegativeButton(context.getString(R.string.cancel), new AlertDialog.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });

        if (actionTitle != null && positiveCallback != null) {

            builder.setPositiveButton(actionTitle, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    positiveCallback.onClick(null);
                    dialog.dismiss();
                }
            });
        }

        builder.show();
    }

    public static String moneyFormatter(int number) {
        NumberFormat nf = NumberFormat.getInstance();
        return nf.format(Integer.valueOf(number)) + "원";
    }

    public static String urlFormatter(Product product, int tempPosition) {
        return APIConstants.ROOT_URL_DEVELOPMENT + AppManager.meta.getRootUrl() + product.getProductImageArrayList().get(tempPosition).getImageUrl();
    }
}
