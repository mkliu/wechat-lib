package com.tencent.mm.sdk.b;

import android.util.Log;

final class b
  implements a.a
{
  public final void d(String paramString1, String paramString2)
  {
    if (a.a() <= 2)
      Log.i(paramString1, paramString2);
  }

  public final void e(String paramString1, String paramString2)
  {
    if (a.a() <= 1)
      Log.d(paramString1, paramString2);
  }

  public final void f(String paramString1, String paramString2)
  {
    if (a.a() <= 4)
      Log.e(paramString1, paramString2);
  }

  public final int b()
  {
    return a.a();
  }
}

/* Location:           /Users/wayliu/git/wechat-sdk-sample/amm_sdk_sample/libs/libammsdk 2.jar
 * Qualified Name:     com.tencent.mm.sdk.b.b
 * JD-Core Version:    0.6.2
 */