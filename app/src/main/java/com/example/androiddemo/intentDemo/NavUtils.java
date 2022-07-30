package com.example.androiddemo.intentDemo;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.text.TextUtils;

public class NavUtils {

    public static boolean startPage(Context context, String uri) {
        if (context == null || TextUtils.isEmpty(uri)) {
            return false;
        }
        // 创建Intent
        Intent intent = new Intent();

        // 将路由地址设置到intent的data中
        intent.setData(Uri.parse(uri));

        // 设置App包名
        intent.setPackage(context.getPackageName());

        PackageManager packageManager = context.getPackageManager();
        if (packageManager == null) {
            return false;
        }
        // 从ApplicationPackageManager中匹配出intent对应的resolveInfo
        ResolveInfo resolveInfo = packageManager.resolveActivity(intent, PackageManager.MATCH_DEFAULT_ONLY);
        if (resolveInfo == null || resolveInfo.activityInfo == null) {
            return false;
        }
        // 在Intent中设置包名和要启动的Activity的全限定名
        intent.setClassName(resolveInfo.activityInfo.packageName, resolveInfo.activityInfo.name);

        if (!(context instanceof Activity)) {
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        }
        try {
            context.startActivity(intent);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
