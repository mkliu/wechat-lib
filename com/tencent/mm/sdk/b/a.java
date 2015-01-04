package com.tencent.mm.sdk.b;

import android.os.Build;
import android.os.Build.VERSION;
import android.os.Looper;
import android.os.Process;

public final class a
{
  private static int level = 6;
  private static a n;
  private static a o = a.n = new b();
  private static final String p = localStringBuilder.toString();

  public static void a(String paramString1, String paramString2)
  {
    a(paramString1, paramString2, null);
  }

  public static void b(String paramString1, String paramString2)
  {
    if ((o != null) && (o.b() <= 2))
    {
      if ((paramString2 = paramString2) == null)
        paramString2 = "";
      Process.myPid();
      Thread.currentThread().getId();
      Looper.getMainLooper().getThread().getId();
      o.d(paramString1, paramString2);
    }
  }

  public static void c(String paramString1, String paramString2)
  {
    if ((o != null) && (o.b() <= 1))
    {
      if ((paramString2 = paramString2) == null)
        paramString2 = "";
      Process.myPid();
      Thread.currentThread().getId();
      Looper.getMainLooper().getThread().getId();
      o.e(paramString1, paramString2);
    }
  }

  public static void a(String paramString1, String paramString2, Object[] paramArrayOfObject)
  {
    if ((o != null) && (o.b() <= 4))
    {
      if ((paramString2 = paramArrayOfObject == null ? paramString2 : String.format(paramString2, paramArrayOfObject)) == null)
        paramString2 = "";
      Process.myPid();
      Thread.currentThread().getId();
      Looper.getMainLooper().getThread().getId();
      o.f(paramString1, paramString2);
    }
  }

  static
  {
    StringBuilder localStringBuilder;
    (localStringBuilder = new StringBuilder()).append("VERSION.RELEASE:[" + Build.VERSION.RELEASE);
    localStringBuilder.append("] VERSION.CODENAME:[" + Build.VERSION.CODENAME);
    localStringBuilder.append("] VERSION.INCREMENTAL:[" + Build.VERSION.INCREMENTAL);
    localStringBuilder.append("] BOARD:[" + Build.BOARD);
    localStringBuilder.append("] DEVICE:[" + Build.DEVICE);
    localStringBuilder.append("] DISPLAY:[" + Build.DISPLAY);
    localStringBuilder.append("] FINGERPRINT:[" + Build.FINGERPRINT);
    localStringBuilder.append("] HOST:[" + Build.HOST);
    localStringBuilder.append("] MANUFACTURER:[" + Build.MANUFACTURER);
    localStringBuilder.append("] MODEL:[" + Build.MODEL);
    localStringBuilder.append("] PRODUCT:[" + Build.PRODUCT);
    localStringBuilder.append("] TAGS:[" + Build.TAGS);
    localStringBuilder.append("] TYPE:[" + Build.TYPE);
    localStringBuilder.append("] USER:[" + Build.USER + "]");
  }

  public static abstract interface a
  {
    public abstract void d(String paramString1, String paramString2);

    public abstract void e(String paramString1, String paramString2);

    public abstract void f(String paramString1, String paramString2);

    public abstract int b();
  }
}

/* Location:           /Users/wayliu/git/wechat-sdk-sample/amm_sdk_sample/libs/libammsdk 2.jar
 * Qualified Name:     com.tencent.mm.sdk.b.a
 * JD-Core Version:    0.6.2
 */