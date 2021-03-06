package com.hailan.HaiLanPrint.views;

import android.content.Context;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.Toast;

import java.io.UnsupportedEncodingException;

/* 
 * 监听输入内容是否超出最大长度，并设置光标位置
 * 限制数字字符数，1汉字相当于2字母 或2数字
 * */  
public class MaxLengthWatcher implements TextWatcher {  
  
    private int mMaxLen = 0;
    private EditText mEditText = null;
    private Context mContext;
      
      
    public MaxLengthWatcher(int mMaxLen, EditText mEditText, Context context) {
        this.mMaxLen = mMaxLen;
        this.mEditText = mEditText;
        this.mContext = context;
    }  
  
    public void afterTextChanged(Editable s) {  
        // TODO Auto-generated method stub  
		if (!TextUtils.isEmpty(s.toString())) {
			String limitSubstring = getLimitSubstring(s.toString());
			if (!TextUtils.isEmpty(limitSubstring)) {
				if (!limitSubstring.equals(s.toString())) {
					mEditText.setText(limitSubstring);
					mEditText.setSelection(limitSubstring.length());
				}
			}
		}
    }  
  
    public void beforeTextChanged(CharSequence arg0, int arg1, int arg2,  
            int arg3) {  
        // TODO Auto-generated method stub  
          
    }  
  
    public void onTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {  
        // TODO Auto-generated method stub  
 
    }  
  
	private String getLimitSubstring(String inputStr) {
		int orignLen = inputStr.length();
		int resultLen = 0;
		String temp = null;
		for (int i = 0; i < orignLen; i++) {
			temp = inputStr.substring(i, i + 1);
			try {// 3 bytes to indicate chinese word,1 byte to indicate english
				// word ,in utf-8 encode
				if (temp.getBytes("utf-8").length == 3) {
					resultLen += 2;
				} else {
					resultLen++;
				}
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			if (resultLen > mMaxLen) {
				Toast.makeText(mContext, "字数超过限制", Toast.LENGTH_LONG).show();
				return inputStr.substring(0, i);
			}
		}
		return inputStr;
	}
    
}  