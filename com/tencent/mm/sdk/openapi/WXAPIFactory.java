package com.tencent.mm.sdk.openapi;

import android.content.Context;
import com.tencent.mm.sdk.b.a;

public class WXAPIFactory
{
  private static final String TAG = "MicroMsg.PaySdk.WXFactory";

  public static IWXAPI createWXAPI(Context paramContext, String paramString)
  {
    return createWXAPI(paramContext, paramString, false);
  }

  public static IWXAPI createWXAPI(Context paramContext, String paramString, boolean paramBoolean)
  {
    a.c("MicroMsg.PaySdk.WXFactory", "createWXAPI, appId = " + paramString + ", checkSignature = " + paramBoolean);
    return new WXApiImplV10(paramContext, paramString, paramBoolean);
  }

  private WXAPIFactory()
  {
    throw new RuntimeException(getClass().getSimpleName() + " should not be instantiated");
  }
}

/* Location:           /Users/wayliu/git/wechat-sdk-sample/amm_sdk_sample/libs/libammsdk 2.jar
 * Qualified Name:     com.tencent.mm.sdk.openapi.WXAPIFactory
 * JD-Core Version:    0.6.2
 */