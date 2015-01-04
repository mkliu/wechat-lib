package com.tencent.mm.sdk.openapi;

import android.content.Intent;
import com.tencent.mm.sdk.modelbase.BaseReq;
import com.tencent.mm.sdk.modelbase.BaseResp;

public abstract interface IWXAPI
{
  public abstract boolean registerApp(String paramString);

  public abstract void unregisterApp();

  public abstract boolean handleIntent(Intent paramIntent, IWXAPIEventHandler paramIWXAPIEventHandler);

  public abstract boolean isWXAppInstalled();

  public abstract boolean isWXAppSupportAPI();

  public abstract int getWXAppSupportAPI();

  public abstract boolean openWXApp();

  public abstract boolean sendReq(BaseReq paramBaseReq);

  public abstract boolean sendResp(BaseResp paramBaseResp);

  public abstract void detach();
}

/* Location:           /Users/wayliu/git/wechat-sdk-sample/amm_sdk_sample/libs/libammsdk 2.jar
 * Qualified Name:     com.tencent.mm.sdk.openapi.IWXAPI
 * JD-Core Version:    0.6.2
 */