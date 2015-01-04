package com.tencent.mm.sdk.b;

import java.util.TimeZone;

public final class c
{
  private static final long[] q = { 300L, 200L, 300L, 200L };
  private static final TimeZone GMT = TimeZone.getTimeZone("GMT");
  private static final char[] r = { '<', '>', '"', '\'', '&' };
  private static final String[] s = { "&lt;", "&gt;", "&quot;", "&apos;", "&amp;" };

  public static boolean a(String paramString)
  {
    return (paramString == null) || (paramString.length() <= 0);
  }
}

/* Location:           /Users/wayliu/git/wechat-sdk-sample/amm_sdk_sample/libs/libammsdk 2.jar
 * Qualified Name:     com.tencent.mm.sdk.b.c
 * JD-Core Version:    0.6.2
 */