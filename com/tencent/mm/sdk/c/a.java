package com.tencent.mm.sdk.c;

import android.net.Uri;
import android.provider.BaseColumns;

public final class a
{
  public static final class b
    implements BaseColumns
  {
    public static final Uri CONTENT_URI = Uri.parse("content://com.tencent.mm.sdk.plugin.provider/sharedpref");
  }

  public static final class a
  {
    public static Object a(int paramInt, String paramString)
    {
      try
      {
        switch (paramInt)
        {
        case 1:
          return Integer.valueOf(paramString);
        case 2:
          return Long.valueOf(paramString);
        case 3:
          return paramString;
        case 4:
          return Boolean.valueOf(paramString);
        case 5:
          return Float.valueOf(paramString);
        case 6:
          return Double.valueOf(paramString);
        }
        com.tencent.mm.sdk.b.a.a("MicroMsg.SDK.PluginProvider.Resolver", "unknown type");
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
      return null;
    }
  }
}

/* Location:           /Users/wayliu/git/wechat-sdk-sample/amm_sdk_sample/libs/libammsdk 2.jar
 * Qualified Name:     com.tencent.mm.sdk.c.a
 * JD-Core Version:    0.6.2
 */