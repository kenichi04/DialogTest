package jp.techacademy.kenichi04.ui

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AlertDialog
// レイアウトファイルをインポート、idの紐付け
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button1.setOnClickListener(this)
        button2.setOnClickListener(this)
        button3.setOnClickListener(this)
        button4.setOnClickListener(this)

    }

    override fun onClick(v: View) {
        when(v.id) {
            R.id.button1 -> textView.text = editText.text.toString()
            R.id.button2 -> showAlertDialog()
            R.id.button3 -> showTimePickerDialog()
            R.id.button4 -> showDatePickerDialog()
        }
    }

    private fun showAlertDialog() {
        // AlertDialog.Builderクラスを使ってAlertDialogの準備
        val alertDialogBuilder = AlertDialog.Builder(this)
        alertDialogBuilder.setTitle("タイトル")
        alertDialogBuilder.setMessage("メッセージ")

        alertDialogBuilder.setPositiveButton("肯定") { dialog, whitch ->
            Log.d("UI_PARTS", "肯定ボタン")
        }
        // 使わない引数の場合「 _ 」と記述するのがkotlinの慣習
        alertDialogBuilder.setNeutralButton("中立") {_, _ ->
            Log.d("UI_PARTS", "中立ボタン")
        }

        alertDialogBuilder.setNegativeButton("否定") {_, _ ->
            Log.d("UI_PARTS", "否定ボタン")
        }

        // AlertDialog作成、表示
        val alertDialog = alertDialogBuilder.create()
        alertDialog.show()
    }

    private fun showTimePickerDialog() {
        val timePickerDialog = TimePickerDialog(
            this,
            // Listener: 時刻設定時にonTimeSetメソッド（省略）呼ばれる
            TimePickerDialog.OnTimeSetListener { view, hour, minute ->
                Log.d("UI_PARTS", "$hour:$minute")
            },
            // 初期値の時間、分、24時間表記か?
            13, 0, true)
        timePickerDialog.show()
    }

    private fun showDatePickerDialog() {
        val datePickerDialog = DatePickerDialog(
            this,
            DatePickerDialog.OnDateSetListener() { view, year, month, dayOfMonth ->
                // monthのみ0スタートのため、+1
                Log.d("UI_PARTS", "$year/${month+1}/$dayOfMonth")
            },
            // 初期値
            2018,
            // monthは0スタートのため、5月になる
            4,
            1)
        datePickerDialog.show()
    }

}