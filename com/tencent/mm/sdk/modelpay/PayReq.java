package com.tencent.mm.sdk.modelpay;

import android.os.Bundle;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.modelbase.BaseReq;

public class PayReq extends BaseReq
{
  private static final String TAG = "MicroMsg.PaySdk.PayReq";
  private static final int EXTDATA_MAX_LENGTH = 1024;
  public String appId;
  public String partnerId;
  public String prepayId;
  public String nonceStr;
  public String timeStamp;
  public String packageValue;
  public String sign;
  public String extData;
  public Options options;

  public boolean checkArgs()
  {
    if ((this.appId == null) || (this.appId.length() == 0))
    {
      a.a("MicroMsg.PaySdk.PayReq", "checkArgs fail, invalid appId");
      return false;
    }
    if ((this.partnerId == null) || (this.partnerId.length() == 0))
    {
      a.a("MicroMsg.PaySdk.PayReq", "checkArgs fail, invalid partnerId");
      return false;
    }
    if ((this.prepayId == null) || (this.prepayId.length() == 0))
    {
      a.a("MicroMsg.PaySdk.PayReq", "checkArgs fail, invalid prepayId");
      return false;
    }
    if ((this.nonceStr == null) || (this.nonceStr.length() == 0))
    {
      a.a("MicroMsg.PaySdk.PayReq", "checkArgs fail, invalid nonceStr");
      return false;
    }
    if ((this.timeStamp == null) || (this.timeStamp.length() == 0))
    {
      a.a("MicroMsg.PaySdk.PayReq", "checkArgs fail, invalid timeStamp");
      return false;
    }
    if ((this.packageValue == null) || (this.packageValue.length() == 0))
    {
      a.a("MicroMsg.PaySdk.PayReq", "checkArgs fail, invalid packageValue");
      return false;
    }
    if ((this.sign == null) || (this.sign.length() == 0))
    {
      a.a("MicroMsg.PaySdk.PayReq", "checkArgs fail, invalid sign");
      return false;
    }
    if ((this.extData != null) && (this.extData.length() > 1024))
    {
      a.a("MicroMsg.PaySdk.PayReq", "checkArgs fail, extData length too long");
      return false;
    }
    return true;
  }

  public void toBundle(Bundle paramBundle)
  {
    super.toBundle(paramBundle);
    paramBundle.putString("_wxapi_payreq_appid", this.appId);
    paramBundle.putString("_wxapi_payreq_partnerid", this.partnerId);
    paramBundle.putString("_wxapi_payreq_prepayid", this.prepayId);
    paramBundle.putString("_wxapi_payreq_noncestr", this.nonceStr);
    paramBundle.putString("_wxapi_payreq_timestamp", this.timeStamp);
    paramBundle.putString("_wxapi_payreq_packagevalue", this.packageValue);
    paramBundle.putString("_wxapi_payreq_sign", this.sign);
    paramBundle.putString("_wxapi_payreq_extdata", this.extData);
    if (this.options != null)
      this.options.toBundle(paramBundle);
  }

  public void fromBundle(Bundle paramBundle)
  {
    super.fromBundle(paramBundle);
    this.appId = paramBundle.getString("_wxapi_payreq_appid");
    this.partnerId = paramBundle.getString("_wxapi_payreq_partnerid");
    this.prepayId = paramBundle.getString("_wxapi_payreq_prepayid");
    this.nonceStr = paramBundle.getString("_wxapi_payreq_noncestr");
    this.timeStamp = paramBundle.getString("_wxapi_payreq_timestamp");
    this.packageValue = paramBundle.getString("_wxapi_payreq_packagevalue");
    this.sign = paramBundle.getString("_wxapi_payreq_sign");
    this.extData = paramBundle.getString("_wxapi_payreq_extdata");
    this.options = new Options();
    this.options.fromBundle(paramBundle);
  }

  public int getType()
  {
    return 5;
  }

  public static class Options
  {
    public static final int INVALID_FLAGS = -1;
    public String callbackClassName;
    public int callbackFlags = -1;

    public void toBundle(Bundle paramBundle)
    {
      paramBundle.putString("_wxapi_payoptions_callback_classname", this.callbackClassName);
      paramBundle.putInt("_wxapi_payoptions_callback_flags", this.callbackFlags);
    }

    public void fromBundle(Bundle paramBundle)
    {
      this.callbackClassName = paramBundle.getString("_wxapi_payoptions_callback_classname");
      this.callbackFlags = paramBundle.getInt("_wxapi_payoptions_callback_flags", -1);
    }
  }
}

/* Location:           /Users/wayliu/git/wechat-sdk-sample/amm_sdk_sample/libs/libammsdk 2.jar
 * Qualified Name:     com.tencent.mm.sdk.modelpay.PayReq
 * JD-Core Version:    0.6.2
 */