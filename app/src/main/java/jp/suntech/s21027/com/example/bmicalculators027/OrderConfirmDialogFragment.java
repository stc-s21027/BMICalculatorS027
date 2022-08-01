package jp.suntech.s21027.com.example.bmicalculators027;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Toast;

import androidx.fragment.app.DialogFragment;

public class OrderConfirmDialogFragment extends DialogFragment {
    @Override

    public Dialog onCreateDialog(Bundle saveInstanceState){

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        builder.setTitle(R.string.dialog_title);
        builder.setMessage("適切な肥満度を求めるには、6歳未満の場合はカウプ指数が、6歳から15際まではローレル指数が使われます、本アプリはBMIのみに対応しています。");

        builder.setPositiveButton(R.string.dialog_btn_firm, new DialogButtonClickListener());
        AlertDialog dialog = builder.create();
        return dialog;
    }


    private class DialogButtonClickListener implements DialogInterface.OnClickListener{

        @Override
        public void onClick(DialogInterface dialog, int which) {
            String msg = "";
            switch (which){
                case DialogInterface.BUTTON_POSITIVE:
                    msg = getString(R.string.dialog_ok_toast);
                    break;
            }
            Toast.makeText(getActivity(),msg,Toast.LENGTH_LONG).show();
        }
    }
}