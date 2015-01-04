package com.tencent.mm.sdk.modelbase;

import android.os.Bundle;

public abstract class BaseReq
{
  public String transaction;
  public String openId;

  public abstract int getType();

  public void toBundle(Bundle paramBundle)
  {
    paramBundle.putInt("_wxapi_command_type", getType());
    paramBundle.putString("_wxapi_basereq_transaction", this.transaction);
    paramBundle.putString("_wxapi_basereq_openid", this.openId);
  }

  public void fromBundle(Bundle paramBundle)
  {
    this.transaction = paramBundle.getString("_wxapi_basereq_transaction");
    this.openId = paramBundle.getString("_wxapi_basereq_openid");
  }

  public abstract boolean checkArgs();
}

/* Location:           /Users/wayliu/git/wechat-sdk-sample/amm_sdk_sample/libs/libammsdk 2.jar
 * Qualified Name:     com.tencent.mm.sdk.modelbase.BaseReq
 * JD-Core Version:    0.6.2
 */