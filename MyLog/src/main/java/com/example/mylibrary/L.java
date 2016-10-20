package com.example.mylibrary;


import android.text.TextUtils;
import android.util.Log;

/**
 * Created by Administrator on 16-9-12.
 */
public class L {

    private static boolean isDebug = true;  //是否显示Log
    private static String mTag = "tag";


    public static void init(boolean isDebug, String mTag) {
        L.isDebug = isDebug;
        L.mTag = mTag;
    }

    public static void e(String msg){
        e(null,msg);
    }

    public static void e(String tag,String msg) {
        if (!isDebug) return;
        mTag = getTargetTag(tag);
        String stackInfo = "";
        StackTraceElement stackTraceElement = getTargetStackTrace();
        stackInfo = "("+stackTraceElement.getFileName()+":"+stackTraceElement.getLineNumber()+")";
        StringBuffer buf = new StringBuffer();
        for(int i=0;i<stackInfo.length()*2;i++)
        {
           buf.append("-");
        }
        Log.e(mTag,buf.toString());
        Log.e(mTag,stackInfo);
        Log.e(mTag, msg);
        Log.e(mTag,buf.toString());
    }

    private static StackTraceElement getTargetStackTrace(){
        StackTraceElement targetStackTrace=null;
        StackTraceElement[] elements = Thread.currentThread().getStackTrace();
        boolean shouldTrace = false;
        for(StackTraceElement element:elements)
        {
          //  Log.i("tags","element = "+element);
            /*
            根据入栈顺序，调用处位于栈底，即OnCreate()方法位于栈底
            我们得到L.class的栈信息时，属于栈底之上的某些，所以如果遇到L
            定义shouldTrace为true，即开始追踪信息,如果当前不再是L.class
            栈信息时，说明L的信息已经完全出栈，然后就会弹出调用处的栈信息
            即OnCreate处的栈信息
            */
            boolean isTarget = element.getClassName().equals(L.class.getName());
            if(shouldTrace && !isTarget)
            {
                targetStackTrace = element;
                break;
            }
            shouldTrace = isTarget;
        }
        return targetStackTrace;
    }

    public static String getTargetTag(String tag) {
        if(!TextUtils.isEmpty(tag))
            return tag;
        return mTag;
    }
}
